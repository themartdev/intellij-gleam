import gleam/string

fn main() {
  case asdf {
    1 -> io.println("one")
    2 -> io.println("two")
    _ -> panic as string.concat(["I", " am ", "panicking"])
  }
}