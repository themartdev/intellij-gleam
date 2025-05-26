pub type Container {
  Container(a: String, b: Int)
}

pub fn main() {
  let a = Container(..get_container(), b: 2)
  echo a
  let updated_a = Container(..{ a }, a: "new label")
  echo updated_a
}

fn get_container() {
  Container("asdf", 1)
}
