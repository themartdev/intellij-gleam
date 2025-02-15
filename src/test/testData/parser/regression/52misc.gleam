import gleam/dict

pub type PropertyValue {
  StringValue(String)
}

pub fn create_node(
id: String,
node_type: String,
properties: List(#(String, PropertyValue))
) -> Node {
  Node(
  id: id,
  node_type: node_type,
  properties: dict.from_list(properties),
  )
}

pub type Node {
  Node(
  id: String,
  node_type: String,
  properties: dict.Dict(String, PropertyValue),
  )
}

pub fn main() {
  let node = property_graph.create_node(
"router_1",
"Router",
[#("status", property_graph.StringValue("active"))]
)
}