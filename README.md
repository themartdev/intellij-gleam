# intellij-gleam

![Build](https://github.com/themartdev/intellij-gleam/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/25254-gleam-language.svg)](https://plugins.jetbrains.com/plugin/25254-gleam-language)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/25254-gleam-language.svg)](https://plugins.jetbrains.com/plugin/25254-gleam-language)

<!-- Plugin description -->
Gleam language support for JetBrains IDEs.

Provides syntax highlighting and LSP-provided features like code completion, navigation, and more.
<!-- Plugin description end -->

## TODO

### Lexer/Parser

- [x] `panic as`
- [x] `todo as`
- [x] `@external`
- [x] `@deprecated`
- [x] tuple integer access like this: `tuple.1`
- [x] qualified type reference like this: `bytes_builder.BytesBuilder = bytes_builder.new()`
- [x] Multiple subject `case` expressions
- [x] Bit array like this `io.debug(<<3>> == <<3:size(8)>>)`
- [x] string patterns in `case` like this: `"Hello, " <> name -> name`
- [x] Record updates like this: `Teacher(..teacher1, subject: "PE", room: 6)`
- [x] Type without constructor
- [ ] Shorthand property reference: `SomeRecord(:name)`
- [ ] (parser) Add `NamedElement` to PSI
- [ ] (parser) Add `getReference()`/`getReferences` to PSI

### LSP

- [ ] Move to [lsp4ij](https://github.com/redhat-developer/lsp4ij)
- [ ] Gleam bin location config

### Refactors and reworks (bnf/psi)

- [x] Refactor const declarations
- [ ] Refactor type declarations
- [ ] Refactor function declarations
- [ ] Refactor record declarations
- [ ] Refactor expressions (pin, recover, etc.)

### Editor

- [ ] Add smart indentation

### Highlight / Annotate

- [x] Annotate: highlight type declaration
- [x] Annotate: highlight type reference
- [ ] Highlight qualified module references

### JB/Deployment

- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate)
  related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set
  the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).

## Installation

- Using the IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "
  intellij-gleam"</kbd> >
  <kbd>Install</kbd>

- Using JetBrains Marketplace:

  Go to [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID) and install it by clicking
  the <kbd>Install to ...</kbd> button in case your IDE is running.

  You can also download the [latest release](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID/versions) from
  JetBrains Marketplace and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

- Manually:

  Download the [latest release](https://github.com/themartdev/intellij-gleam/releases/latest) and install it manually
  using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>
