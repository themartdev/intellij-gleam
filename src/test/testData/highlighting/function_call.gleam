import gleam/io

fn func() {
  echo "Hello"
}

type Value {
  Value(func: fn() -> String)
}

type Container {
  Container(value: Value)
}

pub fn main() {
  // Qualified function call
  io.<info textAttributesKey="GLEAM_FUNCTION_CALL">print</info>("hello")

  // Unqualified function call
  <info textAttributesKey="GLEAM_FUNCTION_CALL">func</info>()

  // Record access
  let a = Container(Value(fn() { echo "Hello" }))
  a.value.<info textAttributesKey="GLEAM_FUNCTION_CALL">func</info>()
}
