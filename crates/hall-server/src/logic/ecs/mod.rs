use bevy_app::prelude::*;
use bevy_ecs::prelude::*;

use event_graph::MainCityScriptPlugin;
use hall::HallInitData;
use interaction::UpdateInteractionStatusEvent;
use scene::PlayerEnterScene;
use trigger_fileconfig::main_city_script::MainCityConfig;

use super::{
    message::{
        EnterSectionEvent, InteractWithUnitEvent, PlayerMoveEvent, RunEventGraphEvent,
        SwitchRoleEvent,
    },
    GameStateListener,
};

pub mod event_graph;
pub mod hall;
pub mod interaction;
pub mod npc_management;
pub mod player;
pub mod scene;
pub mod scene_save;
pub mod scene_unit;

#[derive(Resource, Clone)]
pub struct NapResources {
    pub main_city_config: &'static MainCityConfig,
}

pub struct NapEcs(pub App);

impl NapEcs {
    pub fn new(app: App) -> Self {
        Self(app)
    }

    pub fn listener(&mut self) -> Mut<GameStateListener> {
        self.0.world_mut().get_resource_mut().unwrap()
    }
}

pub fn create_hall_ecs(
    resources: NapResources,
    data: HallInitData,
    listener: GameStateListener,
) -> NapEcs {
    let mut app = App::new();
    app.insert_resource(data)
        .insert_resource(listener)
        .insert_resource(resources)
        .add_plugins(MainCityScriptPlugin)
        .add_event::<PlayerEnterScene>()
        .add_event::<PlayerMoveEvent>()
        .add_event::<InteractWithUnitEvent>()
        .add_event::<UpdateInteractionStatusEvent>()
        .add_event::<RunEventGraphEvent>()
        .add_event::<EnterSectionEvent>()
        .add_event::<SwitchRoleEvent>()
        .add_systems(Startup, scene::hall_init)
        .add_systems(First, scene::process_enter_section)
        .add_systems(PreUpdate, player::process_switch_role)
        .add_systems(
            PreUpdate,
            (
                scene::fire_events_on_section_switch,
                interaction::process_interact_requests,
                event_graph::advance_through_event_graph,
            )
                .chain()
                .before(event_graph::tick_emit_event_actions),
        )
        .add_systems(
            Update,
            (
                npc_management::tick_create_npc,
                interaction::tick_change_interact,
                npc_management::tick_open_ui,
                scene::tick_switch_section,
            )
                .chain(),
        )
        .add_systems(Update, scene::tick_player_movement)
        .add_systems(
            PostUpdate,
            (scene::notify_enter_scene, scene::finish_enter_section).chain(),
        )
        .add_systems(PostUpdate, event_graph::sync_event_info)
        .add_systems(Last, interaction::announce_finished_interactions)
        .add_systems(
            Last,
            scene_save::refresh_save_data.run_if(scene_save::should_save_data),
        );

    app.finish();
    app.cleanup();

    NapEcs::new(app)
}
