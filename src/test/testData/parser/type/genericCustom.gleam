type MyGeneric(e, a) {
  MyGeneric(label: e, Int)
  MyGeneric2(a)
}

pub type MyGeneric2(e) =
  MyGeneric(String, Int)

pub type MyGeneric3 =
  MyGeneric2(String)

pub type Dict(key, value)
