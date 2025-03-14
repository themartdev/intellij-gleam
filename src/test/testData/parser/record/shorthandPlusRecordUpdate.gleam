/// This is exported for generating your own test chain functions
pub fn update_state(state: State, last_result: Result(Nil, String)) -> State {
  case last_result {
    Ok(_) -> State(..state, last_result:)
    Error(_) -> State(..state, last_result:, worst_result: last_result)
  }
}