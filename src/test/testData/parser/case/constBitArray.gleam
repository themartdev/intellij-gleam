import gleam/int
import gleam/io

pub fn main() {
  let a = <<1>>
  case a {
    <<0>> -> io.println("one")
    <<1>> -> io.println("one")
    <<1:size(1)>> -> io.println("two")
    _ -> io.println("unknown")
  }
}
