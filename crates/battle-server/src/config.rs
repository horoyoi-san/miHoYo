use serde::Deserialize;
use trigger_sv::config::{ServerNodeConfiguration, TomlConfig};

#[derive(Deserialize)]
pub struct BattleServerConfig {
    pub node: ServerNodeConfiguration,
}

impl TomlConfig for BattleServerConfig {
    const DEFAULT_TOML: &str = include_str!("../battleserver.default.toml");
}
