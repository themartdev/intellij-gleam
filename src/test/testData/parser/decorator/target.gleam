@target(erlang)
import gleam/int

@target(erlang)
fn main() {
int.add(1, 2)
}

@target(javascript)
import some/module

@target(javascript)
fn main2() {
module.add(1, 2)
}

