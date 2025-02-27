use serde::Deserialize;
use trigger_sv::{
    config::{ServerNodeConfiguration, TomlConfig},
    gm_command::GMCommand,
};

#[derive(Deserialize)]
pub struct GameServerConfig {
    pub node: ServerNodeConfiguration,
}

impl TomlConfig for GameServerConfig {
    const DEFAULT_TOML: &str = include_str!("../gameserver.default.toml");
}

#[derive(Debug, Deserialize)]
pub struct GMScript {
    #[serde(rename = "GMStringList")]
    pub commands: Vec<GMCommand>,
}

#[derive(Debug, Deserialize)]
pub struct BlackListItem {
    pub id: i32,
    #[expect(dead_code)]
    pub name: String,
}

#[derive(Debug, Deserialize)]
#[serde(rename_all = "camelCase")]
pub struct GMBlackList {
    pub black_item_list: Vec<BlackListItem>,
}
