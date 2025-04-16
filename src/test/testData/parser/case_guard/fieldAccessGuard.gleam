fn some_func(obj: UnkownType) {
  let value = True
  case value {
    True if obj.nested.field.0 == "1" -> {
      io.println("True")
    }
    _ -> {
      io.println("False")
    }
  }
}