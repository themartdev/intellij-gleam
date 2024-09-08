fn main() {
  let a = 1
  let b = case a {
    1 -> io.debug("one")
    2 -> io.debug("two")
    _ -> io.debug("other")
  }
}
