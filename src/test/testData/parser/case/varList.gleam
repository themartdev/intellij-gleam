import gleam/int
import gleam/io
import gleam/list

pub fn main() {
  let x = list.repeat(int.random(5), times: int.random(3))
  io.debug(x)

  let result = case x {
    [] -> "Empty list"
    [1] -> "List of just 1"
    [4, ..rest] -> "List starting with 4 followed by " <> case rest {
      [next, ..] -> next
      _ -> panic()
    }
    [_, _] -> "List of 2 elements"
    _ -> "Some other list"
  }
  io.debug(result)
}
