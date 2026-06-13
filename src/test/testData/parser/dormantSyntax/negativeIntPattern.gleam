pub fn classify(x: Int) -> String {
  case x {
    -1 -> "minus one"
    -42 -> "negative"
    0 -> "zero"
    _ -> "positive"
  }
}

pub fn classify_float(x: Float) -> String {
  case x {
    -1.5 -> "negative float"
    _ -> "other"
  }
}
