import gleam/io

fn something(tup: #(Int, String)) {
  case tup {
    #(1, "hello") -> io.debug("Nice!")
    _ -> io.debug("unexpected...")
  }
}
