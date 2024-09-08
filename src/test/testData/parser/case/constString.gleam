fn main(a: String) {
  case a {
    "some value" -> io.debug("some value")
    _ -> io.debug("other")
  }
}
