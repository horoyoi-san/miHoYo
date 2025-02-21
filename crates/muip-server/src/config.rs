use std::{collections::HashSet, net::SocketAddr};

use serde::Deserialize;
use trigger_sv::config::{ServerNodeConfiguration, TomlConfig};

#[derive(Deserialize)]
pub struct MuipServerConfig {
    pub node: ServerNodeConfiguration,
    pub http_addr: SocketAddr,
    pub tokens: HashSet<String>,
}

impl TomlConfig for MuipServerConfig {
    const DEFAULT_TOML: &str = include_str!("../muipserver.default.toml");
}
