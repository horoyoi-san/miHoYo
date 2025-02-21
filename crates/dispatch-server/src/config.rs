use std::net::SocketAddr;

use serde::Deserialize;
use trigger_sv::config::TomlConfig;

#[derive(Deserialize)]
pub struct NetworkSetting {
    pub http_addr: SocketAddr,
}

#[derive(Deserialize)]
pub struct RegionSetting {
    pub name: String,
    pub title: String,
    pub ping_url: String,
    pub dispatch_url: String,
    pub biz: String,
    pub env: u8,
    pub area: u8,
}

#[derive(Deserialize)]
pub struct BoundRegionSetting {
    pub name: String,
    pub title: String,
    pub addr: String,
    pub port: u16,
    pub is_kcp: bool,
    pub seed: String,
}

#[derive(Deserialize)]
pub struct DispatchConfig {
    pub network: NetworkSetting,
    #[serde(rename = "region")]
    pub regions: Vec<RegionSetting>,
    pub bound_server: BoundRegionSetting,
}

impl TomlConfig for DispatchConfig {
    const DEFAULT_TOML: &str = include_str!("../dispatch.default.toml");
}
