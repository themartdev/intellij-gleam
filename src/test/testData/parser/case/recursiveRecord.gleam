import gleam/int

type RecursiveContainer(t) {
  Node(label: String, value: RecursiveContainer(t))
  Value(t)
}

pub fn main() {
  case_recursive()
}

fn case_recursive() {
  let a =
    Node(
      label: "first",
      value: Node(label: "second", value: Node(label: "third", value: Value(1))),
    )

  case a {
    Node(
      label: "first",
      value: Node(label: "second", value: Node(_, third_value)),
    ) -> {
      let string_value = case third_value {
        Value(integer) -> int.to_string(integer)
        Node(..) -> "Node"
      }
      echo "Found " <> string_value
    }
    _ -> echo "No match"
  }
}
