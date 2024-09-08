import gleam/io


type Person {
  Person(name: String, age: Int)
}

fn something(person: Person) {
  case person {
    Person("Alice", 42) -> io.debug("Nice!")
    Person(name: "Alice", age: 43) -> io.debug("Nice!")
    Person(name, ..) -> io.debug("unexpected...")
    Person(name: "Alice", ..) -> io.debug("unexpected...")
    _ -> io.debug("unexpected...")
  }
}
