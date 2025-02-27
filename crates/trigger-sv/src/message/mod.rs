use std::io::Cursor;

use trigger_codegen::{Decodeable, Encodeable};

mod management;
mod session;

pub use management::*;
pub use session::*;

use trigger_encoding::Decodeable;

#[derive(Debug, Encodeable, Decodeable)]
pub struct Header {
    pub sender_type: u8,
    pub sender_id: u32,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct NetworkPacket {
    pub header: Header,
    pub opcode: u16,
    pub payload: Vec<u8>,
}

impl NetworkPacket {
    pub fn get_message<M: Decodeable + WithOpcode>(&self) -> Option<M> {
        (M::OPCODE == self.opcode)
            .then(|| M::decode(&mut Cursor::new(&self.payload)).ok())
            .flatten()
    }
}

#[repr(u8)]
#[derive(num_enum::IntoPrimitive, num_enum::TryFromPrimitive)]
pub enum MessageCategory {
    Session = 0,
    Management = 1,
}

pub trait WithOpcode {
    const OPCODE: u16;

    fn opcode(&self) -> u16 {
        Self::OPCODE
    }
}

macro_rules! opcode {
    ($category:ident, $($ty:ident = $num:expr),*) => {
        $(impl super::WithOpcode for $ty {
            const OPCODE: u16 = ((super::MessageCategory::$category as u16) * 100) + $num;
        })*
    };
}

use opcode;
