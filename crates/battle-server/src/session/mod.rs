use crate::logic::GameState;

pub mod message;

pub struct BattleSession {
    pub id: u64,
    pub player_uid: u32,
    pub game_state: Option<GameState>,
}
