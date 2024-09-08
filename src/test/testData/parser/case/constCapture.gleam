fn main(a: String) {
  case a {
    "some value" -> io.debug("some value")
    other -> io.debug("unexpected: " <> other)
  }
}
