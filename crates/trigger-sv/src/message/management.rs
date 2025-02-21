use crate::{gm_command::GMCommand, message::opcode};
use trigger_codegen::{Decodeable, Encodeable};

#[derive(Debug, Encodeable, Decodeable)]
pub struct PlayerGmCommandMessage {
    pub player_uid: u32,
    pub command: GMCommand,
}

opcode! {
    Management,
    PlayerGmCommandMessage = 1
}
