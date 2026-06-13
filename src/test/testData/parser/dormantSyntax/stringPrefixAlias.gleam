pub fn greet(x: String) -> String {
  case x {
    "Hello, " as greeting <> name -> greeting <> name
    "Bye, " as farewell <> _rest -> farewell
    _ -> "?"
  }
}
