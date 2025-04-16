pub fn main() {
  let t1 = #(#("1", #("2", "3"), "4"))
  // nested tuple access
  io.println(t1.0.1.0)
}