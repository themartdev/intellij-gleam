pub fn main() {
  let value = True
  let obj = #(#("1", #("2", "3"), "4"))
  case value {
    True if obj.0.1.0 == "1" -> {
      io.println("True")
    }
    False if obj.0.1.0 == "2" -> {
      io.println("False")
    }
  }
}