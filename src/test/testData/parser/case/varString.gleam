fn main(a: String) {
  case a {
    "some value " <> tail -> io.debug(tail)
    unexpected -> io.debug("what is this?")
  }
}
