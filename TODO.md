# Lexer/Parser
- `panic as` ✔
- `todo as` ✔
- `@external`
- `@deprecated`
- tuple integer access like this: `tuple.1`
- qualified type reference like this: `bytes_builder.BytesBuilder = bytes_builder.new()`
- Multiple subject `case` expressions
- Bit array like this `io.debug(<<3>> == <<3:size(8)>>)`
- string patterns in `case` like this: `"Hello, " <> name -> name`
- Record updates like this: `Teacher(..teacher1, subject: "PE", room: 6)`

# Highlight / Annotate

- Highlight qualified module references
- Highlight types
