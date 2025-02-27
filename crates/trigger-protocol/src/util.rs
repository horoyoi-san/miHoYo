use trigger_codegen::{Decodeable, Encodeable};

#[derive(Debug, Encodeable, Decodeable)]
pub struct ProtocolUnit {
    pub cmd_id: u16,
    pub blob: Vec<u8>,
}
