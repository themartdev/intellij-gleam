import gleam/io

type SomeGen(t) {
  SomeGen(label: t, value: Int)
  None
}

type TupleType(e) =
  #(e, Int)

pub fn main() {
  let a: SomeGen(String) = SomeGen(label: "hello", value: 1)
  let b: TupleType(String) = #("Hello", 1)
  io.debug(a)
  io.debug(b)
}
