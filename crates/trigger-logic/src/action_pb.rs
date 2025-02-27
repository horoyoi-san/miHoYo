pub use prost::Message as PbMessage;

#[derive(Clone, PartialEq, ::prost::Message)]
pub struct ActionOpenUI {
    #[prost(string, tag = "1")]
    pub ui: ::prost::alloc::string::String,
    #[prost(int32, tag = "2")]
    pub args: i32,
    #[prost(int32, tag = "4")]
    pub store_template_id: i32,
    #[prost(int32, tag = "5")]
    pub npc_id: i32,
}

#[derive(Clone, PartialEq, ::prost::Message)]
pub struct ActionSwitchSection {
    #[prost(uint32, tag = "1")]
    pub section: u32,
    #[prost(string, tag = "2")]
    pub transform_id: ::prost::alloc::string::String,
    #[prost(uint32, tag = "3")]
    pub camera_x: u32,
    #[prost(uint32, tag = "4")]
    pub camera_y: u32,
}
