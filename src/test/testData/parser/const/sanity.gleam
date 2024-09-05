pub type Vec {
    Vec(x: Int, y: Int)
}

pub const a = "a\t\t\n\u{adf3}"
pub const b = 2
pub const c = <<1011>>
pub const d = #(1, 2)
const e = Vec(1, 2)
pub const f = #(#(1, 2), <<1101>>, e)
