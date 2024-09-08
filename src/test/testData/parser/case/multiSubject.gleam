fn something(a: String, b: String) {
  case a, b {
    "some value", "other value" -> io.debug("some value and other value")
    "some value", _ -> io.debug("some value and other")
    _, "other value" -> io.debug("other value and other value")
    _, _ -> io.debug("other and other")
  }
}
