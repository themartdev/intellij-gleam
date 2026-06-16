pub type Wibble {
  @deprecated("Use Wibble2 instead")
  Wibble1

  Wibble2(name: String, age: Int)

  @deprecated("Legacy variant")
  Wobble(value: Int)
}