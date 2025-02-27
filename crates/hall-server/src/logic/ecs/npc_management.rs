use bevy_ecs::prelude::*;
use trigger_logic::action_pb;
use trigger_protocol::ActionInfo;

use super::{
    event_graph::{ActionCreateNpcCfgEvent, ActionOpenUIEvent, EventGraph},
    scene_unit::SceneUnitBundle,
};

pub fn tick_create_npc(mut events: EventReader<ActionCreateNpcCfgEvent>, mut commands: Commands) {
    for event in events.read() {
        commands.spawn(SceneUnitBundle::build_by_action(&event));
    }
}

pub fn tick_open_ui(mut events: EventReader<ActionOpenUIEvent>, mut graph: Query<&mut EventGraph>) {
    use action_pb::PbMessage;

    for event in events.read() {
        let mut graph = graph.single_mut();
        graph.actions.push(ActionInfo {
            action_type: 5,
            body: action_pb::ActionOpenUI {
                npc_id: 0,
                ui: event.ui.clone(),
                args: event.args,
                store_template_id: event.store_template_id,
            }
            .encode_to_vec(),
        });
    }
}
