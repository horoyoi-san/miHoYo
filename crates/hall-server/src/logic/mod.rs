use std::{collections::HashMap, sync::mpsc, thread};

use ecs::{scene::PlayerEnterScene, NapEcs};
use message::ProtocolEventHandler;
use tracing::debug;
use trigger_protocol::util::ProtocolUnit;
use trigger_sv::message::GameStateCallback;

mod ecs;
mod listener;
mod message;

pub mod save;
pub use ecs::hall::HallInitData;
pub use ecs::NapResources;
pub use listener::GameStateListener;

#[derive(Clone)]
pub struct GameRunner(mpsc::Sender<RunnerCommand>);

enum RunnerCommand {
    CreateScene {
        player_uid: u32,
        init_data: HallInitData,
        listener: GameStateListener,
    },
    DestroyScene {
        player_uid: u32,
    },
    ClientInput {
        player_uid: u32,
        request_id: u32,
        protocol_unit: ProtocolUnit,
    },
}

#[derive(Default)]
struct GameRunnerLocalState {
    ecs_map: HashMap<u32, NapEcs>,
}

impl GameRunner {
    pub fn spawn(resources: NapResources) -> Self {
        let (tx, rx) = mpsc::channel();

        thread::spawn(|| Self::runner_loop(rx, resources));
        Self(tx)
    }

    pub fn create_scene(
        &self,
        player_uid: u32,
        init_data: HallInitData,
        listener: GameStateListener,
    ) {
        self.0
            .send(RunnerCommand::CreateScene {
                player_uid,
                init_data,
                listener,
            })
            .unwrap();
    }

    pub fn destroy_scene(&self, player_uid: u32) {
        self.0
            .send(RunnerCommand::DestroyScene { player_uid })
            .unwrap();
    }

    pub fn client_input(&self, player_uid: u32, request_id: u32, protocol_unit: ProtocolUnit) {
        self.0
            .send(RunnerCommand::ClientInput {
                player_uid,
                request_id,
                protocol_unit,
            })
            .unwrap();
    }

    fn runner_loop(rx: mpsc::Receiver<RunnerCommand>, resources: NapResources) {
        use RunnerCommand::*;

        let mut state = GameRunnerLocalState::default();

        while let Ok(cmd) = rx.recv() {
            match cmd {
                CreateScene {
                    player_uid,
                    init_data,
                    listener,
                } => {
                    let mut ecs = ecs::create_hall_ecs(resources.clone(), init_data, listener);
                    ecs.0.world_mut().send_event(PlayerEnterScene).unwrap();
                    ecs.0.update();

                    ecs.listener().emit_callback(GameStateCallback::Loaded);
                    state.ecs_map.insert(player_uid, ecs);

                    debug!("created scene for player with uid {player_uid}");
                }
                DestroyScene { player_uid } => {
                    state.ecs_map.remove(&player_uid);
                    debug!("destroyed scene of player with uid {player_uid}");
                }
                ClientInput {
                    player_uid,
                    request_id,
                    protocol_unit,
                } => {
                    if let Some(ecs) = state.ecs_map.get_mut(&player_uid) {
                        ecs.push_protocol_event(request_id, protocol_unit);
                        ecs.0.update();
                    }
                }
            }
        }
    }
}
