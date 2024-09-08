pub fn main() {
  io.debug(calculate(1, 2, 3))
  io.debug(calculate(1, add: 2, multiply: 3))
  io.debug(calculate(1, multiply: 3, add: 2))
}

fn calculate(value: Int, add addend: Int, multiply multiplier: Int) {
  value * multiplier + addend
}