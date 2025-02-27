use std::collections::HashMap;

use serde::Deserialize;

#[derive(Deserialize)]
#[serde(tag = "$type")]
pub enum ConfigEventAction {
    #[serde(rename = "Share.CActionCreateNPCCfg")]
    ActionCreateNpcCfg(ActionCreateNpcCfg),
    #[serde(rename = "Share.CActionChangeInteractCfg")]
    ActionChangeInteractCfg(ActionChangeInteractCfg),
    #[serde(rename = "Share.CActionSetMainCityObjectState")]
    ActionSetMainCityObjectState(ActionSetMainCityObjectState),
    #[serde(rename = "Share.CActionSwitchSection")]
    ActionSwitchSection(ActionSwitchSection),
    #[serde(rename = "Share.CActionOpenUI")]
    ActionOpenUI(ActionOpenUI),
}

#[derive(Deserialize, Debug)]
#[serde(rename_all = "PascalCase")]
pub struct ConfigInteractScale {
    pub x: f64,
    pub y: f64,
    pub z: f64,
}

#[derive(Deserialize, Debug)]
pub struct ActionCreateNpcCfg {
    #[serde(rename = "ID")]
    pub id: i32,
    #[serde(rename = "TagID")]
    pub tag_id: i32,
}

#[derive(Deserialize, Debug)]
#[serde(rename_all = "PascalCase")]
pub struct ActionChangeInteractCfg {
    #[serde(rename = "ID")]
    pub id: u32,
    #[serde(rename = "InteractID")]
    pub interact_id: i32,
    #[serde(rename = "TagIDs")]
    pub tag_ids: Vec<i32>,
    #[serde(deserialize_with = "deserialize_participators_map")]
    pub participators: HashMap<u32, String>,
    pub interact_shape: String,
    pub interact_scale: ConfigInteractScale,
    #[serde(default)]
    pub section_listen_events: HashMap<String, String>,
}

#[derive(Deserialize, Debug)]
#[serde(rename_all = "PascalCase")]
pub struct ActionSetMainCityObjectState {
    #[serde(rename = "ID")]
    pub id: u32,
    #[serde(rename = "ObjectState")]
    #[serde(deserialize_with = "deserialize_i32_map")]
    pub object_state: HashMap<i32, i32>,
}

#[derive(Deserialize, Debug)]
#[serde(rename_all = "PascalCase")]
pub struct ActionSwitchSection {
    #[serde(rename = "SectionID")]
    pub section_id: u32,
    pub transform: String,
    pub camera_x: u32,
    pub camera_y: u32,
}

#[derive(Deserialize, Debug)]
#[serde(rename_all = "PascalCase")]
pub struct ActionOpenUI {
    #[serde(rename = "UI")]
    pub ui: String,
    pub args: i32,
    #[serde(rename = "StoreTemplateID")]
    pub store_template_id: i32,
}

#[derive(Deserialize)]
#[serde(rename_all = "PascalCase")]
pub struct ConfigEvent {
    #[serde(rename = "ID")]
    #[serde(default)]
    pub id: u32,
    pub actions: Vec<ConfigEventAction>,
}

#[derive(Deserialize)]
#[serde(rename_all = "PascalCase")]
pub struct SectionEventGraphConfig {
    #[serde(rename = "ID")]
    pub id: u32,
    pub on_add: Vec<String>,
    pub on_enter: Vec<String>,
    pub events: HashMap<String, ConfigEvent>,
}

#[derive(Deserialize)]
#[serde(rename_all = "PascalCase")]
pub struct MainCitySectionConfig {
    #[serde(rename = "ID")]
    pub id: i32,
    pub unity_scene_path: String,
    pub born_transform: String,
    pub section_progress: SectionEventGraphConfig,
}

#[derive(Deserialize)]
#[serde(rename_all = "PascalCase")]
pub struct MainCityConfig {
    #[serde(rename = "ID")]
    pub id: u32,
    #[serde(rename = "DefaultSectionID")]
    pub default_section_id: u32,
    pub sections: HashMap<i32, MainCitySectionConfig>,
}

fn deserialize_participators_map<'de, D>(deserializer: D) -> Result<HashMap<u32, String>, D::Error>
where
    D: serde::de::Deserializer<'de>,
{
    use serde::de;
    let str_map = HashMap::<&str, String>::deserialize(deserializer)?;

    Ok(str_map
        .into_iter()
        .map(|(str_key, value)| match str_key.parse() {
            Ok(int_key) => Ok((int_key, value)),
            Err(_) => Err(de::Error::invalid_value(
                de::Unexpected::Str(str_key),
                &"u32",
            )),
        })
        .collect::<Result<HashMap<_, _>, _>>()?)
}

fn deserialize_i32_map<'de, D>(deserializer: D) -> Result<HashMap<i32, i32>, D::Error>
where
    D: serde::de::Deserializer<'de>,
{
    use serde::de;
    let str_map = HashMap::<&str, i32>::deserialize(deserializer)?;

    Ok(str_map
        .into_iter()
        .map(|(str_key, value)| match str_key.parse() {
            Ok(int_key) => Ok((int_key, value)),
            Err(_) => Err(de::Error::invalid_value(
                de::Unexpected::Str(str_key),
                &"i32",
            )),
        })
        .collect::<Result<HashMap<_, _>, _>>()?)
}
