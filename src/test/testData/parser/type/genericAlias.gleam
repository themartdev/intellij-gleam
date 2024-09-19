type LabeledValue(t) =
  #(String, t)

type FnReturningLabeledValue(a, t) =
  fn(a, t, String) -> LabeledValue(t)
