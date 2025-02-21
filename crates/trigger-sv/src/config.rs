use serde::{de::DeserializeOwned, Deserialize, Deserializer};
use std::net::SocketAddr;
use tracing::error;
use trigger_database::DatabaseSetting;

use crate::{
    die,
    net::{ServerID, ServerType},
};

#[derive(Debug, thiserror::Error)]
pub enum ConfigurationLoadError {
    #[error("failed to open configuration file: {0}")]
    Io(#[from] std::io::Error),
    #[error("failed to parse configuration file: {0}")]
    Deserialize(#[from] toml::de::Error),
}

pub trait TomlConfig: serde::de::DeserializeOwned {
    const DEFAULT_TOML: &str;

    fn load_or_create(path: &str) -> Self {
        std::fs::read_to_string(path).map_or_else(
            |_| {
                std::fs::write(path, Self::DEFAULT_TOML).unwrap();
                toml::from_str(Self::DEFAULT_TOML).unwrap()
            },
            |data| toml::from_str(&data).unwrap(),
        )
    }
}

#[derive(Debug, Deserialize)]
pub struct ServerEnvironmentConfiguration {
    pub servers: Vec<ServerConfigurationEntry>,
    pub database: DatabaseSetting,
    pub security: SecuritySetting,
}

#[derive(Debug, Deserialize)]
pub struct SecuritySetting {
    pub rsa_versions: Vec<RsaSetting>,
    pub static_key: ScrambledKey,
}

#[derive(Debug)]
pub struct ScrambledKey {
    pub seed_buf: Vec<u8>,
    pub xorpad: Vec<u8>,
}

#[derive(Debug, Deserialize)]
pub struct RsaSetting {
    pub version: u32,
    #[serde(deserialize_with = "from_base64")]
    pub client_public_key: Vec<u8>,
    #[serde(deserialize_with = "from_base64")]
    pub server_private_key: Vec<u8>,
}

#[derive(Debug, Deserialize)]
pub struct ServerConfigurationEntry {
    pub addr: SocketAddr,
    pub server_type: ServerType,
    pub server_id: ServerID,
}

#[derive(Debug, Deserialize)]
pub struct ServerNodeConfiguration {
    pub server_id: ServerID,
}

impl ServerEnvironmentConfiguration {
    pub fn load_from_toml(path: &str) -> Result<Self, ConfigurationLoadError> {
        Ok(toml::from_str(&std::fs::read_to_string(path)?)?)
    }
}

impl SecuritySetting {
    pub fn get_rsa_setting_by_version(&self, version: u32) -> Option<&RsaSetting> {
        self.rsa_versions.iter().find(|r| r.version == version)
    }
}

impl<'de> Deserialize<'de> for ScrambledKey {
    fn deserialize<D>(deserializer: D) -> Result<Self, D::Error>
    where
        D: Deserializer<'de>,
    {
        use base64::Engine;
        use trigger_cryptography::mhy::Ec2b;

        let s = <String>::deserialize(deserializer)?;
        let ec2b_buf = base64::engine::general_purpose::STANDARD
            .decode(s)
            .map_err(serde::de::Error::custom)?;

        let ec2b =
            Ec2b::read(&mut std::io::Cursor::new(&ec2b_buf)).map_err(serde::de::Error::custom)?;

        let mut xorpad = vec![0u8; 4096];
        ec2b.fill_buffer(&mut xorpad);

        Ok(Self {
            seed_buf: ec2b_buf,
            xorpad,
        })
    }
}

pub fn from_base64<'de, D>(deserializer: D) -> Result<Vec<u8>, D::Error>
where
    D: Deserializer<'de>,
{
    use base64::Engine;

    let s = <String>::deserialize(deserializer)?;
    base64::engine::general_purpose::STANDARD
        .decode(s)
        .map_err(serde::de::Error::custom)
}

pub fn load_json_config<T: DeserializeOwned>(path: &str, error_name: &str) -> T {
    serde_json::from_str(&std::fs::read_to_string(path).unwrap_or_else(|err| {
        error!("failed to open {error_name} file: {err}");
        die();
    }))
    .unwrap_or_else(|err| {
        error!("failed to parse {error_name}: {err}");
        die();
    })
}
