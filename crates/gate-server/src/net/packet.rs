use std::io::{Cursor, Write};

use byteorder::{WriteBytesExt, BE};
use trigger_protobuf::PacketHead;

pub struct NetPacket {
    pub cmd_id: u16,
    pub head: Vec<u8>,
    pub body: Vec<u8>,
}

impl NetPacket {
    pub const HEAD_MAGIC: [u8; 4] = 0x01234567_u32.to_be_bytes();
    pub const TAIL_MAGIC: [u8; 4] = 0x89ABCDEF_u32.to_be_bytes();

    pub fn xor(&mut self, xorpad: &[u8]) {
        self.body
            .iter_mut()
            .enumerate()
            .for_each(|(i, b)| *b ^= xorpad[i % xorpad.len()]);
    }

    pub fn decode_head(&self) -> PacketHead {
        use ::trigger_protobuf::ProtobufMessage;

        PacketHead::decode(&*self.head).unwrap_or_default()
    }
}

impl From<NetPacket> for Vec<u8> {
    fn from(value: NetPacket) -> Self {
        let mut buf = Vec::with_capacity(16 + value.head.len() + value.body.len());
        let mut w = Cursor::new(&mut buf);

        w.write_all(&NetPacket::HEAD_MAGIC).unwrap();
        w.write_u16::<BE>(value.cmd_id).unwrap();
        w.write_u16::<BE>(value.head.len() as u16).unwrap();
        w.write_u32::<BE>(value.body.len() as u32).unwrap();
        w.write_all(&value.head).unwrap();
        w.write_all(&value.body).unwrap();
        w.write_all(&NetPacket::TAIL_MAGIC).unwrap();

        buf
    }
}
