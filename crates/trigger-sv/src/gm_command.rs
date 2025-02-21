use serde::{Deserialize, Deserializer};
use trigger_codegen::{Decodeable, Encodeable, GMInput};

#[derive(GMInput, Decodeable, Encodeable, Debug, PartialEq, Eq)]
#[repr(u16)]
pub enum GMCommand {
    AddAvatar {
        id: i32,
    } = 100,
    SetAvatarLevel {
        id: i32,
        level: i16,
    } = 101,
    SetAvatarRank {
        id: i32,
        rank: i16,
    } = 102,
    SetAvatarTalent {
        id: i32,
        talent: i16,
    } = 103,
    AddAllWeapon = 200,
    AddAllEquip = 201,
    AddItemByType {
        item_type: u32,
        id: i32,
        num: i32,
    } = 202,
    AddEquip {
        equip_id: i32,
        level: i16,
        star: i16,
        property_params: Vec<i32>,
    } = 203,
    AddQuest {
        quest_type: i32,
        quest_id: i32,
    } = 300,
    FinishQuest {
        quest_type: i32,
        quest_id: i32,
    } = 301,
    UnlockAllHollow = 302,
    UnlockAllHollowBuff = 400,
    UnlockAllCafeItem = 401,
}

#[derive(thiserror::Error, Debug)]
pub enum GMInputParseError {
    #[error("GM command {0} doesn't exist")]
    UnknownCommand(String),
    #[error("missing non-optional argument: {0}")]
    MissingArgument(&'static str),
    #[error("failed to parse argument of type '{1}' (name: {0})")]
    InvalidArgumentFormat(&'static str, &'static str),
}

pub trait GMInput: Sized {
    fn from_str(input: &str) -> Result<Self, GMInputParseError>;
}

impl<'de> Deserialize<'de> for GMCommand {
    fn deserialize<D>(deserializer: D) -> Result<Self, D::Error>
    where
        D: Deserializer<'de>,
    {
        let s = <String>::deserialize(deserializer)?;
        GMCommand::from_str(&s).map_err(serde::de::Error::custom)
    }
}
