/// There are rules for which annotation can be used where,
/// but we want to parse them regardless

// import
@target(erlang)
@external(erlang, "gleam_stdlib", "identity")
@deprecated("Some message")
import gleam/string

// type
@target(erlang)
@external(erlang, "gleam_stdlib", "identity")
@deprecated("Some message")
pub type MyType {
  MyType(
    name: String,
    age: Int,
  )
}

// const
@target(erlang)
@external(erlang, "gleam_stdlib", "identity")
@deprecated("Some message")
const asdf = 1

// function
@target(erlang)
@external(erlang, "gleam_stdlib", "identity")
@deprecated("Some message")
fn do_something() -> String {
  "hello"
}
