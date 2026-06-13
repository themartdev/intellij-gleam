pub type Person {
  Person(name: String, age: Int)
}

const default_person = Person(name: "unknown", age: 0)

pub const anonymous = Person(..default_person, name: "anonymous")
