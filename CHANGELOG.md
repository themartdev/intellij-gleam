<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# intellij-gleam Changelog

## [Unreleased]

### Fixed

- Fixed grammar for shorthand labeled arguments in function calls

## [0.8.0] - 2025-06-03

### Fixed

- Fixed grammar for record update (`Type(..a, label: "value")`) using expressions

## [0.7.0] - 2025-05-09

### Fixed

- Restore highlighting for function calls
- Highlight `echo` as a keyword

## [0.6.0] - 2025-05-06

### Fixed

- Fixed grammar for `echo` used in pipe expressions

## [0.5.0] - 2025-04-30

### Added

- Early support for standalone `assert` (new in Gleam 1.11.0)

### Fixed

- Fixed grammar `let assert` with `as`

## [0.4.2] - 2025-04-25

### Added

- Support `echo` keyword (new in Gleam 1.9.0)
- The language server now restarts when the gleam path is changed in settings
- Added structure view for gleam files, through the language server

## [0.4.1] - 2025-04-21

### Added

- In the settings UI, allow Erlang SDK and Gleam paths to be set manually by text input
- Added parameter info (`textDocument/signatureHelp` from LSP)

### Fixed

- Fixed frequent expensive call that may cause IDE to freeze (
  see [#59](https://github.com/themartdev/intellij-gleam/issues/59))

### Changed

- Minimum version of LSP4IJ is now 0.12.0

## [0.4.0] - 2025-04-17

### Added

- Support for IntelliJ platform 2025.1

### Fixed

- Several parsing issues:
    - Function returning a function type annotation
    - Case clause guards with access operators
    - Nested tuple access
    - Generic type declaration without value
    - Use expression with pattern on the left side

## [0.3.1] - 2025-03-13

### Fixed

- Fixed grammar for:
    - Record expressions with both a record update pattern and shorthand labeled arguments
    - `use` expressions with multiple variables
    - In `case` expressions, list pattern with a double dot `..` and omitting the variable name (e.g. `["one", ..]`)
    - `todo as` and `panic as` used with an expression

## [0.3.0] - 2025-02-15

### Added

- Added "Gleam file" in the _New_ dialog
- Syntax highlighting for function parameters

### Fixed

- Fixed grammar for qualified record expressions
- Fixed grammar for dicard (`_`) names

## [0.2.1] - 2024-10-10

### Added

- Improved parsing of partial `let` expressions

### Fixed

- `@internal` annotation no longer breaks syntax highlighting
- Using a discard name in a `use` expression no longer gets marked as an error

## [0.2.0]

### Added

- Added Gleam run configuration
    - Requires setting up the Erlang SDK in <kbd>Settings/Preferences</kbd> > <kbd>Languages & Frameworks</kbd> > <kbd>
      Gleam</kbd> > <kbd>Erlang SDK</kbd>
- Added "Run" line marker for `pub fn main()` functions
- Added startup info message when LSP server is disabled
- Added startup error message when LSP4IJ version is incompatible

### Fixed

- Fixed grammar to allow `@target` annotations

## [0.1.2]

### Fixed

- Fixed parsing for generic types

## [0.1.1]

### Added

- Support for 2024.3 EAP platform version

## [0.1.0]

### Added

- Code folding for curly brace blocks
- A few live templates (snippets)
- Keyword completion in function scope

### Fixed

- Auto-indentation for `type` block

## [0.0.1-alpha.1]

### Added

- LSP client
    - Configured in <kbd>Settings/Preferences</kbd> > <kbd>Languages & Frameworks</kbd> > <kbd>Gleam</kbd>
- Syntax highlighting
- Basic IntelliJ editor features
    - Root keyword completion
    - Auto indentation, brace matching, etc.

[Unreleased]: https://github.com/themartdev/intellij-gleam/compare/v0.8.0...HEAD
[0.8.0]: https://github.com/themartdev/intellij-gleam/compare/v0.7.0...v0.8.0
[0.7.0]: https://github.com/themartdev/intellij-gleam/compare/v0.6.0...v0.7.0
[0.6.0]: https://github.com/themartdev/intellij-gleam/compare/v0.5.0...v0.6.0
[0.5.0]: https://github.com/themartdev/intellij-gleam/compare/v0.4.2...v0.5.0
[0.4.2]: https://github.com/themartdev/intellij-gleam/compare/v0.4.1...v0.4.2
[0.4.1]: https://github.com/themartdev/intellij-gleam/compare/v0.4.0...v0.4.1
[0.4.0]: https://github.com/themartdev/intellij-gleam/compare/v0.3.1...v0.4.0
[0.3.1]: https://github.com/themartdev/intellij-gleam/compare/v0.3.0...v0.3.1
[0.3.0]: https://github.com/themartdev/intellij-gleam/compare/v0.2.1...v0.3.0
[0.2.1]: https://github.com/themartdev/intellij-gleam/compare/v0.2.0...v0.2.1
[0.2.0]: https://github.com/themartdev/intellij-gleam/compare/v0.1.2...v0.2.0
[0.1.2]: https://github.com/themartdev/intellij-gleam/compare/v0.1.1...v0.1.2
[0.1.1]: https://github.com/themartdev/intellij-gleam/compare/v0.1.0...v0.1.1
[0.1.0]: https://github.com/themartdev/intellij-gleam/compare/v0.0.1-alpha.1...v0.1.0
[0.0.1-alpha.2]: https://github.com/themartdev/intellij-gleam/compare/v0.0.1-alpha.1...v0.0.1-alpha.2
[0.0.1-alpha.1]: https://github.com/themartdev/intellij-gleam/commits/v0.0.1-alpha.1
