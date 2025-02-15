import imaginary

fn my_fn () {
  imaginary.hof(fn () {})
  imaginary.hof(fn (_name) {})
  imaginary.hof(fn (_) {})
}