# IntelliJ Gleam

![Build](https://github.com/themartdev/intellij-gleam/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/25254-gleam-language.svg)](https://plugins.jetbrains.com/plugin/25254-gleam-language)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/25254-gleam-language.svg)](https://plugins.jetbrains.com/plugin/25254-gleam-language)

<!-- Plugin description -->
Gleam language support for JetBrains IDEs.

Provides syntax highlighting plus code completion, navigation, hover, diagnostics, and
formatting through the Gleam language server, and run/test configurations for `gleam run`
and `gleam test`.
<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "
  intellij-gleam"</kbd> >
  <kbd>Install</kbd>

- Using JetBrains Marketplace:

  Go to [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/25254-gleam-language) and install it by clicking
  the <kbd>Install to ...</kbd> button in case your IDE is running.

  You can also download the [latest release](https://plugins.jetbrains.com/plugin/25254-gleam-language/versions) from
  JetBrains Marketplace and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

- Manually:

  Download the [latest release](https://github.com/themartdev/intellij-gleam/releases/latest) and install it manually
  using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Requirements

- A [Gleam](https://gleam.run/getting-started/installing/) install for the language server and the
  `gleam` CLI.
- [Erlang/OTP](https://gleam.run/getting-started/installing/#erlang) to run or test code on the
  Erlang target (the default).
- A JavaScript runtime (Node, Deno, or Bun) only if you build for the JavaScript target.

## Toolchain setup

Editor features (highlighting, completion, navigation) work as soon as the plugin finds `gleam`.
Run and test configurations also need to find Erlang.

The plugin auto-detects these from your `PATH`, from [asdf](https://asdf-vm.com/), and from the
usual install locations. To check or override what it found, open
<kbd>Settings</kbd> > <kbd>Languages &amp; Frameworks</kbd> > <kbd>Gleam</kbd>:

- **Gleam executable path** — the `gleam` binary.
- **Erlang path** — your Erlang/OTP install. See the note below.
- **JavaScript runtime path** — the `node`/`deno`/`bun` binary; leave empty to use `PATH`.

Settings are global by default. To use a different toolchain for one project, open
**Project Settings** under the same page and tick **Override global toolchain for this project**.

## Running and testing

- Right-click a `.gleam` file (or use the gutter icon next to a `pub fn main`) to run it, or run the
  whole suite with `gleam test`.
- Each configuration has a **target** (Default / Erlang / JavaScript). *Default* lets `gleam.toml`
  decide. Pick Erlang or JavaScript to force one and to validate only that toolchain.
- `gleam test` output is a plain console. gleeunit prints passing tests as bare dots and exposes no
  verbose mode, so there's no green/red test tree; failures are linkified back to the test function.

## Troubleshooting

**"Erlang SDK path is invalid: ... (expected a directory containing bin, lib, and releases)"**

Run/test on the Erlang target needs the OTP **install directory** — the one containing `bin/`,
`lib/`, and `releases/` — not a wrapper or shim. Pointing the **Erlang path** at a shim (an asdf
`~/.asdf/shims/erl`, or a symlink in `/usr/local/bin`) fails this check even though `erl` runs fine
in a terminal. Set it to the real install instead, for example:

- asdf: `~/.asdf/installs/erlang/<version>`
- Homebrew: `$(brew --prefix erlang)/lib/erlang`
- Linux packages: `/usr/lib/erlang`

You can point the field at the install root, its `bin/` directory, or the `erl` binary inside that
`bin/` — all three resolve to the same root. The field also accepts a value detected for you from the
dropdown.
