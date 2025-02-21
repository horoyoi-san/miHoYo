use serde::Deserialize;
use trigger_sv::config::{ServerNodeConfiguration, TomlConfig};

#[derive(Deserialize)]
pub struct HallServerConfig {
    pub node: ServerNodeConfiguration,
}

impl TomlConfig for HallServerConfig {
    const DEFAULT_TOML: &str = include_str!("../hallserver.default.toml");
}
