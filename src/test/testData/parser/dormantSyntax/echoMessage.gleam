fn length(x: List(Int)) -> Int {
  case x {
    [] -> 0
    [_, ..rest] -> 1 + length(rest)
  }
}

pub fn main() -> Int {
  echo 1 as "a message"
  [1, 2]
  |> echo as "pipeline message"
  |> length
}
