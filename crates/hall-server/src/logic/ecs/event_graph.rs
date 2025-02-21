use bevy_derive::Deref;
use bevy_ecs::prelude::*;
use tracing::debug;
use trigger_fileconfig::main_city_script::*;

define_actions! {
    ActionCreateNpcCfg,
    ActionChangeInteractCfg,
    ActionSetMainCityObjectState,
    ActionOpenUI,
    ActionSwitchSection
}

#[derive(Component)]
pub struct EventGraph {
    pub interaction: String, // ENPCInteraction
    pub actions: Vec<ActionInfo>,
}

pub fn sync_event_info(
    interacting_units: Query<(&SceneUnitTag, &InteractContainer, &EventGraph), Changed<EventGraph>>,
    mut listener: ResMut<GameStateListener>,
) {
    for (unit_tag, interact_container, event_graph) in interacting_units.iter() {
        listener.add(SyncEventInfoScNotify {
            owner_id: interact_container.cur_interaction() as u32,
            tag: **unit_tag as u32,
            owner_type: EEventGraphOwnerType::SceneUnit.into(),
            event_graph_uid: interact_container.cur_interaction() as u32,
            npc_interaction: event_graph.interaction.clone(),
            action_list: event_graph.actions.clone(),
        });
    }
}

pub fn advance_through_event_graph(
    mut commands: Commands,
    mut run_events: EventReader<RunEventGraphEvent>,
    mut listener: ResMut<GameStateListener>,
    mut interacting_units: Query<(Entity, &mut InteractContainer, &EventGraph)>,
) {
    for event in run_events.read() {
        debug!("{event:?}");

        if let Some((entity_id, mut interact_container, event_graph)) = interacting_units
            .iter_mut()
            .find(|(_, interact_container, _)| {
                interact_container.cur_interaction() == event.event_graph_uid as i32
            })
        {
            listener.add(UpdateEventGraphScNotify {
                tag: event.tag,
                event_graph_owner_uid: event.owner_id,
                owner_type: event.owner_type,
                npc_interaction: event_graph.interaction.clone(),
                is_event_success: true,
            });

            interact_container.finish_interaction();
            commands.entity(entity_id).remove::<EventGraph>();

            listener.emit_callback(GameStateCallback::ClientCmdProcessed {
                ack_request_id: event.request_id,
                response: Some(RunEventGraphScRsp { retcode: 0 }.into()),
            });
        }
    }
}

macro_rules! define_actions {
    ($($name:ident),*) => {
        paste::paste!($(
            #[derive(Event, Deref)]
            pub struct [<$name Event>](&'static $name);
        )*);

        #[derive(Event, Deref)]
        pub struct GraphEvent(pub &'static ConfigEvent);

        pub struct MainCityScriptPlugin;

        impl bevy_app::Plugin for MainCityScriptPlugin {
            fn build(&self, app: &mut bevy_app::App) {
                $(paste::paste!(app.add_event::<[<$name Event>]>());)*
                app.add_event::<GraphEvent>();
                app.add_systems(bevy_app::PreUpdate, tick_emit_event_actions);
            }
        }

        paste::paste! {
        pub fn tick_emit_event_actions(mut events: EventReader<GraphEvent>, $(mut [<$name:snake>]: EventWriter<[<$name Event>]>),*) {
            for event in events.read() {
                for action in event.actions.iter() {
                    match action {
                        $(ConfigEventAction::$name(data) => { [<$name:snake>].send([<$name Event>](data)); })*
                    }
                }
            }
        }}
    };
}

use define_actions;
use trigger_logic::scene::EEventGraphOwnerType;
use trigger_protocol::{
    ActionInfo, RunEventGraphScRsp, SyncEventInfoScNotify, UpdateEventGraphScNotify,
};
use trigger_sv::message::GameStateCallback;

use crate::logic::{message::RunEventGraphEvent, GameStateListener};

use super::scene_unit::{InteractContainer, SceneUnitTag};
