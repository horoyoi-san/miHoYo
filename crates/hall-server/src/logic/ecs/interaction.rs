use bevy_ecs::prelude::*;
use tracing::{debug, warn};
use trigger_protocol::InteractWithUnitScRsp;
use trigger_sv::message::GameStateCallback;

use crate::logic::{message::InteractWithUnitEvent, GameStateListener};

use super::{
    event_graph::{ActionChangeInteractCfgEvent, EventGraph, GraphEvent},
    hall::MainCitySection,
    scene_unit::{InteractContainer, SceneUnitTag},
    NapResources,
};

pub fn tick_change_interact(
    mut events: EventReader<ActionChangeInteractCfgEvent>,
    mut npcs: Query<(&SceneUnitTag, &mut InteractContainer)>,
) {
    for event in events.read() {
        npcs.iter_mut()
            .filter(|(tag, _)| event.tag_ids.contains(&*tag))
            .for_each(|(_, mut container)| container.attach_by_action(&event))
    }
}

#[derive(Event)]
pub struct UpdateInteractionStatusEvent {
    pub request_id: u32,
    pub retcode: i32,
}

pub fn process_interact_requests(
    mut commands: Commands,
    mut req_events: EventReader<InteractWithUnitEvent>,
    mut status_update_events: EventWriter<UpdateInteractionStatusEvent>,
    mut graph_events: EventWriter<GraphEvent>,
    resources: Res<NapResources>,
    section: Query<&MainCitySection>,
    mut interactables: Query<(Entity, &SceneUnitTag, &mut InteractContainer)>,
) {
    let section_id = section.single().0 as i32;

    for event in req_events.read() {
        debug!("{event:?}");

        if let Some((entity_id, _, mut interact_container)) = interactables
            .iter_mut()
            .find(|(_, tag, _)| ***tag == event.npc_tag_id)
        {
            if interact_container.is_interaction_allowed_in_current_state(event.interact_id) {
                if let Some(execute_event) = interact_container.try_interact(event.interact_id) {
                    if let Some(section_cfg) = resources.main_city_config.sections.get(&section_id)
                    {
                        if let Some(event) = section_cfg.section_progress.events.get(execute_event)
                        {
                            commands.entity(entity_id).insert(EventGraph {
                                interaction: String::from("OnInteract"),
                                actions: Vec::new(),
                            });

                            graph_events.send(GraphEvent(event));
                        }
                    }
                }

                status_update_events.send(UpdateInteractionStatusEvent {
                    request_id: event.request_id,
                    retcode: 0,
                });
            } else {
                warn!(
                    "interaction is not allowed: {}::{} (type: {})",
                    event.npc_tag_id, event.interact_id, event.trigger_type
                );
                status_update_events.send(UpdateInteractionStatusEvent {
                    request_id: event.request_id,
                    retcode: 1,
                });
            }
        }
    }
}

pub fn announce_finished_interactions(
    mut status_update_events: EventReader<UpdateInteractionStatusEvent>,
    mut listener: ResMut<GameStateListener>,
) {
    for event in status_update_events.read() {
        listener.emit_callback(GameStateCallback::ClientCmdProcessed {
            ack_request_id: event.request_id,
            response: Some(
                InteractWithUnitScRsp {
                    retcode: event.retcode,
                }
                .into(),
            ),
        });
    }
}
