import gleam/io

pub fn main() {
  io.debug(<<3>>)
  io.debug(<<3>> == <<3:size(8)-little>>)

  // 16 bit int. In binary: 0001100000000011
  io.debug(<<6147:size(16)>>)

  // A bit array of UTF8 data
  io.debug(<<"Hello, Joe!":utf8>>)

  // Concatenation
  let first = <<4>>
  let second = <<2>>
  io.debug(<<first:bits, second:bits>>)
}

fn segments(len: Int, data: BitArray) {
  let assert <<head:size(len), mid:size(len * 8 - 1), tail:size({ len + 1 }), _:bits>> = data
  <<0:size(len), 1:size(compute(len)), 2:unit(8)-size(4)>>
}
