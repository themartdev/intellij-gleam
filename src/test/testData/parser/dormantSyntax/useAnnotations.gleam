fn apply(f: fn(Int, Float) -> Float) -> Float {
  f(1, 2.0)
}

pub fn main() -> Float {
  use a: Int, b: Float <- apply
  case a {
    _ -> b
  }
}
