fn plus_one(base: fn(Int) -> Int) -> fn(Int) -> Int {
  let val = fn(x: Int) -> Int { base(x) + 1 }
  fn() { val }()
}
