type Vector2D {
  Vector(Int, Int)
}

type Season {
  Spring
  Summer
  Autumn
  Winter
}

pub type SchoolPerson {
  Teacher(name: String, subject: String)
  Student(String)
}
