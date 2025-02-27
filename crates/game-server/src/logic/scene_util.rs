use trigger_logic::scene::ESceneType;
use trigger_sv::net::ServerType;

pub fn get_scene_logic_simulation_server_type(scene_type: ESceneType) -> Option<ServerType> {
    Some(match scene_type {
        ESceneType::Hall => ServerType::HallServer,
        ESceneType::Fight => ServerType::BattleServer,
        _ => return None,
    })
}

pub fn persists_on_relogin(scene_type: ESceneType) -> bool {
    matches!(scene_type, ESceneType::Hall | ESceneType::Fresh)
}
