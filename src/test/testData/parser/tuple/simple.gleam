import gleam/io

fn func() {
  let myTup: #(Int, Int) = #(1, 2)
  let myTup2: #(Int, String) = #(1, "hello")
  io.println(myTup2.2)
}