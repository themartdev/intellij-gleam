fn main(a: List(Int)) {
  case a {
    [1, 2] -> io.debug("one two")
    _ -> io.debug("other")
  }
}
