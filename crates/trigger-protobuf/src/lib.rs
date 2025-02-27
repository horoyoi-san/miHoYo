use std::collections::HashMap;

pub use prost::DecodeError as ProtobufDecodeError;
pub use prost::Message as ProtobufMessage;

pub trait XorFields {
    fn xor_fields(&mut self);
}

pub trait CmdID {
    const CMD_ID: u16;

    fn get_cmd_id(&self) -> u16 {
        Self::CMD_ID
    }
}

pub trait NapMessage: prost::Message + XorFields + CmdID + Default + Sized {}
impl<T: prost::Message + XorFields + CmdID + Default + Sized> NapMessage for T {}

include!("../out/_.rs");
include!("../out/protocol_map.rs");

#[derive(trigger_protobuf_derive::CmdID)]
#[cmdid(8128)]
#[derive(trigger_protobuf_derive::XorFields, Clone, Copy, PartialEq, ::prost::Message)]
pub struct FallbackRsp {}

// "repeated bytes"
impl XorFields for Vec<Vec<u8>> {
    fn xor_fields(&mut self) {}
}

impl<T> XorFields for Vec<T>
where
    T: XorFields,
{
    fn xor_fields(&mut self) {
        for item in self.iter_mut() {
            item.xor_fields();
        }
    }
}

impl<K, V> XorFields for HashMap<K, V>
where
    V: XorFields,
{
    fn xor_fields(&mut self) {
        for value in self.values_mut() {
            value.xor_fields();
        }
    }
}

impl<T> XorFields for Option<T>
where
    T: XorFields,
{
    fn xor_fields(&mut self) {
        if let Some(value) = self.as_mut() {
            value.xor_fields();
        }
    }
}

impl<T> XorFields for Box<T>
where
    T: XorFields,
{
    fn xor_fields(&mut self) {
        T::xor_fields(&mut *self);
    }
}
