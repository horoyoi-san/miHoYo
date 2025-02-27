use std::net::SocketAddr;

use serde::Deserialize;
use trigger_sv::config::{ServerNodeConfiguration, TomlConfig};

#[derive(Deserialize)]
pub struct NetworkSetting {
    pub tcp_addr: SocketAddr,
}

#[derive(Deserialize)]
pub struct GateServerConfig {
    pub node: ServerNodeConfiguration,
    pub network: NetworkSetting,
}

impl TomlConfig for GateServerConfig {
    const DEFAULT_TOML: &str = include_str!("../gateserver.default.toml");
}
