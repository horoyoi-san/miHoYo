use bevy_ecs::prelude::*;
use tracing::debug;
use trigger_logic::{action_pb, scene::ESceneType};
use trigger_protocol::{ActionInfo, EnterSectionScRsp, SavePosInMainCityScRsp};
use trigger_sv::message::GameStateCallback;

use crate::logic::message::{EnterSectionEvent, PlayerMoveEvent};

use super::event_graph::*;
use super::hall::*;
use super::player::*;
use super::scene_unit::*;

use super::{GameStateListener, HallInitData, NapResources};

#[derive(Event)]
pub struct PlayerEnterScene;

pub fn hall_init(mut commands: Commands, init_data: Res<HallInitData>) {
    commands.spawn(HallBundle {
        section: MainCitySection(init_data.section_id),
        bgm: BGMusic(init_data.bgm_id),
        clock: Clock {
            time_of_day: init_data.time_of_day as u16,
            day_of_week: init_data.day_of_week as u8,
        },
    });

    commands.spawn(PlayerBundle {
        avatar: ControlledAvatar {
            player_avatar_id: init_data.player_avatar_id,
            control_avatar_id: init_data.control_avatar_id,
        },
        position: init_data.initial_position.clone(),
    });
}

pub fn process_enter_section(
    mut enter_section_events: EventReader<EnterSectionEvent>,
    mut player_enter_events: EventWriter<PlayerEnterScene>,
    mut section: Query<&mut MainCitySection>,
    mut position: Query<&mut MainCityPosition>,
) {
    for event in enter_section_events.read() {
        debug!("{event:?}");

        section.single_mut().0 = event.section_id;
        *position.single_mut() = MainCityPosition::Predefined(event.transform_id.clone());

        player_enter_events.send(PlayerEnterScene);
    }
}

pub fn finish_enter_section(
    mut enter_section_events: EventReader<EnterSectionEvent>,
    mut listener: ResMut<GameStateListener>,
) {
    for event in enter_section_events.read() {
        listener.emit_callback(GameStateCallback::ClientCmdProcessed {
            ack_request_id: event.request_id,
            response: Some(EnterSectionScRsp { retcode: 0 }.into()),
        });
    }
}

pub fn fire_events_on_section_switch(
    mut commands: Commands,
    mut events: EventWriter<GraphEvent>,
    resources: Res<NapResources>,
    changed_section: Query<&MainCitySection, Changed<MainCitySection>>,
    scene_units: Query<Entity, With<SceneUnitTag>>,
) {
    if let Some(section) = changed_section.iter().take(1).next() {
        // Remove all scene units that belong to previous section
        scene_units
            .iter()
            .for_each(|entity_id| commands.entity(entity_id).despawn());

        // Emit on_create and on_enter for new section
        if let Some(section_cfg) = resources.main_city_config.sections.get(&(section.0 as i32)) {
            section_cfg
                .section_progress
                .on_add
                .iter()
                .chain(section_cfg.section_progress.on_enter.iter())
                .map(|name| section_cfg.section_progress.events.get(name))
                .flatten()
                .for_each(|event| {
                    events.send(GraphEvent(event));
                });
        }
    }
}

pub fn notify_enter_scene(
    mut events: EventReader<PlayerEnterScene>,
    mut listener: ResMut<GameStateListener>,
    hall: Query<HallQuery>,
    player: Query<PlayerQuery>,
    scene_units: Query<SceneUnitQuery>,
) {
    use trigger_protocol::*;

    for _ in events.read() {
        let hall = hall.single();
        let player = player.single();

        let mut hall_scene_info = HallSceneInfo {
            section_id: hall.section.0,
            bgm_id: hall.bgm.0,
            day_of_week: hall.clock.day_of_week as u32,
            time_of_day: hall.clock.time_of_day as u32,
            player_avatar_id: player.avatar.player_avatar_id,
            control_avatar_id: player.avatar.control_avatar_id,
            scene_unit_list: scene_units.iter().map(|unit| unit.to_protocol()).collect(),
            ..Default::default()
        };

        match player.position {
            MainCityPosition::Predefined(id) => {
                hall_scene_info.transform_id = id.clone();
            }
            MainCityPosition::Transform(transform) => {
                hall_scene_info.position = Some(trigger_protocol::Transform {
                    position: vec![
                        transform.position.x,
                        transform.position.y,
                        transform.position.z,
                    ],
                    rotation: vec![
                        transform.rotation.x,
                        transform.rotation.y,
                        transform.rotation.z,
                    ],
                });
            }
        }

        listener.add(EnterSceneScNotify {
            scene_info: Some(SceneInfo {
                scene_type: ESceneType::Hall as u32,
                hall_scene_info: Some(hall_scene_info),
                ..Default::default()
            }),
            dungeon_info: None,
        });
    }
}

pub fn tick_player_movement(
    mut events: EventReader<PlayerMoveEvent>,
    mut position: Query<&mut MainCityPosition>,
    mut listener: ResMut<GameStateListener>,
    section: Query<&MainCitySection>,
) {
    for event in events.read() {
        debug!("{event:?}");

        if event.section_id == section.single().0 {
            *position.single_mut() = MainCityPosition::Transform(event.position.clone());
        }

        listener.emit_callback(trigger_sv::message::GameStateCallback::ClientCmdProcessed {
            ack_request_id: event.request_id,
            response: Some(SavePosInMainCityScRsp { retcode: 0 }.into()),
        });
    }
}

pub fn tick_switch_section(
    mut events: EventReader<ActionSwitchSectionEvent>,
    mut graph: Query<&mut EventGraph>,
) {
    use action_pb::PbMessage;

    for event in events.read() {
        let mut graph = graph.single_mut();

        // Only add action to the graph
        // We will do actual section switch on EnterSectionEvent
        graph.actions.push(ActionInfo {
            action_type: 6,
            body: action_pb::ActionSwitchSection {
                section: event.section_id,
                transform_id: event.transform.clone(),
                camera_x: event.camera_x,
                camera_y: event.camera_y,
            }
            .encode_to_vec(),
        });
    }
}
