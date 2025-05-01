
fn main() {
  // There should be 2 pipelines here, as `echo` behaves like a reference
  "asdf" |> echo "asdf" |> module.func
}
