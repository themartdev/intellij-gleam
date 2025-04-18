
fn main() {
  use #(a, b) <- return_tuple()
  use [a, b] <- return_list()
}

fn return_tuple() {
  Ok(#(1, 2))
}

fn return_list() {
  Ok([1, 2])
}
