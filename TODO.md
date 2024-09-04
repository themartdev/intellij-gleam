# Lexer/Parser

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

# Refactors

- [ ] (parser) Streamline and cleanup pattern expressions

# Editor

- [ ] Add smart indentation

# Highlight / Annotate

- [ ] Annotate: highlight type declaration
- [ ] Annotate: highlight type reference
- [ ] Highlight qualified module references
