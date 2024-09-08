import gleam/io

pub fn main() {
  let a = 1.3
  case a {
    1.3 -> io.debug("1.3")
    _ -> io.debug("something else")
  }
}
