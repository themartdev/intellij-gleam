<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# intellij-gleam Changelog

## [Unreleased]

### Fixed

- `@internal` annotation no longer breaks syntax highlighting

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

[Unreleased]: https://github.com/themartdev/intellij-gleam/compare/v0.2.0...HEAD
[0.2.0]: https://github.com/themartdev/intellij-gleam/compare/v0.1.2...v0.2.0
[0.1.2]: https://github.com/themartdev/intellij-gleam/compare/v0.1.1...v0.1.2
[0.1.1]: https://github.com/themartdev/intellij-gleam/compare/v0.1.0...v0.1.1
[0.1.0]: https://github.com/themartdev/intellij-gleam/compare/v0.0.1-alpha.1...v0.1.0
[0.0.1-alpha.2]: https://github.com/themartdev/intellij-gleam/compare/v0.0.1-alpha.1...v0.0.1-alpha.2
[0.0.1-alpha.1]: https://github.com/themartdev/intellij-gleam/commits/v0.0.1-alpha.1
