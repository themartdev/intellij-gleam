import gleam/io
import gleam/int

fn something(tup: #(Int, String)) {
  case tup {
    #(1, "hello") -> io.debug("Nice!")
    #(a, b) -> io.debug("Got " <> int.to_string(a) <> " and " <> b)
    _ -> io.debug("unexpected...")
  }
}
