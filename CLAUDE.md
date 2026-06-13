# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

An IntelliJ Platform plugin (Kotlin + generated Java) that adds Gleam language support to JetBrains IDEs. The guiding principle is to **delegate language intelligence to the Gleam language server** (`gleam lsp`) via the LSP4IJ plugin, and to only implement natively the editor features that need a local lexer/PSI (syntax highlighting, folding, brace matching, completion context, formatting structure, run configurations).

## Commands

Use the Gradle wrapper (`./gradlew`). JVM toolchain is Java 17.

- `./gradlew build` — compile + assemble
- `./gradlew test` (or `./gradlew check`) — run all tests
- `./gradlew test --tests '*FunctionTest'` — run a single test class (wildcards allowed; classes are not package-qualified by convention, so `*ClassName` works)
- `./gradlew test --tests '*FunctionTest.testPipelines'` — run a single test method
- `./gradlew runIde` — launch a sandbox IDE with the plugin (debug logging for `com.redhat.devtools` LSP is enabled). A bundled `one-dark-theme` from `bin/` is added to the sandbox.
- `./gradlew verifyPlugin` — run the IntelliJ Plugin Verifier (also run in CI)
- `./gradlew buildPlugin` — produce the distributable zip

Pre-made IDE run configurations live in `.run/`.

## Architecture

### Two layers: native PSI vs. LSP

1. **Native parsing layer** (`src/main/grammars/`, `gen/`, `lang/`): a JFlex lexer + Grammar-Kit parser produce a token stream and PSI tree. This exists to power editor features that need local structure — not to do semantic analysis.
2. **LSP layer** (`ide/lsp/`): everything semantic (completion, navigation, hover, diagnostics, rename, formatting) is forwarded to `gleam lsp` through LSP4IJ. When adding a feature, prefer wiring it through LSP4IJ rather than implementing it against the PSI.

`plugin.xml` is the map of which features are native vs. delegated: extensions under `com.redhat.devtools.lsp4ij` and `implementationClass`es referencing `com.redhat.devtools.lsp4ij.*` (e.g. `LSPParameterInfoHandler`, `LSPDocumentSymbolStructureViewFactory`) are LSP-backed; the rest are native.

### Generated lexer & parser — `gen/` is committed source

`gen/` is on the **main source set** (`sourceSets["main"].java.srcDir("gen")`) and is checked into git. There are **no Gradle tasks** that regenerate it — generation is manual and the result must be committed:

- **Lexer**: edit `src/main/grammars/Gleam.flex`, then regenerate `gen/.../lang/parser/_GleamLexer.java` with JFlex. The repo vendors `jflex-1.9.1.jar` and the IntelliJ `idea-flex.skeleton` at the project root for this. `_GleamLexer.java~` (a `~` backup) appearing in `gen/` is JFlex output residue and can be ignored/deleted.
- **Parser/PSI**: edit `src/main/grammars/Gleam.bnf`, then run Grammar-Kit "Generate Parser Code" (in-IDE) to regenerate `GleamParser`, `GleamTypes`, and the `psi/`+`psi/impl/` interfaces and `*Impl` classes under `gen/`.

The `.flex`/`.bnf` files are the source of truth; never hand-edit `gen/`. The lexer is wrapped for the platform by `lang/lexer/GleamLexer.kt` (a `FlexAdapter` over `_GleamLexer`), and the whole parsing pipeline is registered through `lang/parser/GleamParserDefinition.kt`.

The Gleam grammar mirrors the upstream compiler's lexer/parser. Comments in `Gleam.flex`/`Gleam.bnf` cite the corresponding `gleam-lang/gleam` source (e.g. `compiler-core/src/parse/lexer.rs`); keep behavior aligned with upstream when editing.

### Source layout (`src/main/kotlin/.../intellijgleam/`)

- `lang/` — `GleamLanguage`, `GleamFileType`, lexer wrapper, parser definition, PSI utilities, token/element types.
- `ide/lsp/` — language server launch (`GleamLanguageServer` runs `gleam lsp`), `GleamLanguageServerFactory`, per-project toolchain settings (`GleamToolchainSettings`/`GleamServiceSettings`, with `GleamLspMode` enable/disable), and `GleamLSPFormatFeature`.
- `ide/common/` — toolchain discovery (`GleamExecutableFinder`, `ErlangSdkFinder`, FS helpers).
- `ide/editor/`, `ide/highlighting/`, `ide/completion/`, `ide/formatter/` — native editor features.
- `ide/runconf/run/` — Gleam run configurations + gutter run markers. The `GleamRunConfigurationType` hosts two factories: `gleam run -m <module>` (`GleamConfiguration*`) and `gleam test` (`GleamTest*`). Erlang SDK resolution/validation and the `PATH`-with-Erlang environment are shared via `GleamToolchain`.
- `ide/ui/` — settings UI (`GleamSettingsConfigurable`) and path pickers.

### `gleam test` and gleeunit output

The test run configuration deliberately uses a **plain console, not a test tree**. gleeunit (the default test runner, invoked by `gleam test`) hardcodes its reporter and exposes **no verbose mode** — no env var, no CLI arg (`gleeunit.main()` takes no args; the EUnit `Verbose` option is overridden by its custom progress reporter). On both the Erlang and JavaScript targets it prints **passing tests as bare dots with no names**, so per-test start/finish events can't be reconstructed and a green/red tree is impossible without replacing the user's test entry point.

The one navigable signal is the failure block, whose second line is ` test: <module>.<function>` (the `panic … should.gleam:line` line points into gleeunit's assertion helper, not the user's test). `GleamTestOutputFilter` linkifies that line back to the test function. If you revisit this after a gleeunit release, re-verify the output format with a throwaway `gleam new` project (passing + failing test) on both targets before assuming a tree is feasible.

## Tests

### Parser snapshot tests (the bulk of the suite)

`src/test/kotlin/.../parser/*Test.kt` extend `GleamParsingTestCase` (IntelliJ's `ParsingTestCase`). Each test method maps to a fixture pair under `src/test/testData/parser/<category>/`:

- `name.gleam` — input source
- `name.txt` — expected serialized PSI tree

`testFooBar()` → `fooBar.gleam`/`fooBar.txt`. `assertParsedCorrectly()` expects a clean parse; `assertParsedWithErrors()` asserts at least one `PsiErrorElement`.

When you change the grammar and snapshots need updating: `scripts/regenerate-parsing-test-snapshots.sh` deletes `.txt` files that have a sibling fixture so the next test run rewrites them from current parser output. **Review the regenerated `.txt` diffs** — they encode the expected tree, so a regression looks like a "passing" regeneration.

### External corpus validation (grammar vs. real Gleam)

`GleamExternalCorpusTest` parses every `.gleam` file in a corpus and fails on any `PsiErrorElement`. It is a **no-op** unless `-Pgleam.corpus.dir=...` is set, so normal `./gradlew test` is unaffected. Use it to check the parser against a Gleam release:

```
scripts/validate-gleam-release.sh                       # latest stable Gleam release
scripts/validate-gleam-release.sh v1.14.0 --with-stdlib # specific tag + stdlib
scripts/validate-gleam-release.sh v1.14.0 --skip-fetch  # reuse build/gleam-corpus
```

It fetches `test/language` (and optionally stdlib) via `scripts/fetch-gleam-corpus.sh` and runs the test with `-Pgleam.corpus.*` properties (forwarded to the test JVM in `build.gradle.kts`). `scripts/corpus-exclusions.txt` lists files intentionally skipped. CI runs the equivalent on new Gleam releases (`.github/workflows/gleam-release-watch.yml`).

## Releasing

Version lives in `gradle.properties` (`pluginVersion`, currently a `-SNAPSHOT`). Changelog is managed by the Gradle Changelog plugin (`CHANGELOG.md`); `publishPlugin` depends on `patchChangelog`, and the published Marketplace release channel is derived from any pre-release label on the version. `scripts/set_release_version.sh` and `scripts/ci_new_snapshot.sh` handle version bumps. Signing/publishing read `CERTIFICATE_CHAIN`/`PRIVATE_KEY`/`PRIVATE_KEY_PASSWORD`/`PUBLISH_TOKEN` from the environment (falling back to `secrets/`).
