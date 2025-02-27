use trigger_encoding::Encodeable;
use trigger_protocol::{util::ProtocolUnit, ClientCmdID};

use super::GameSession;
use crate::AppState;
use crate::NapPlayer;

modules! {
    player,
    scene,
    avatar,
    inventory,
    quest,
    abyss,
    bangboo,
    client_systems,
    gacha,
    mail,
    ramen,
    social,
    cafe,
    reward_buff,
    arcade,
    daily_challenge,
    fairy,
    activity,
    land_revive,
    collections,
    perform,
    battle_event,
    vhs_store,
    month_card,
    battle_pass,
    hadal_zone,
    photo_wall,
    character_quest,
    shop,
    babel_tower,
    camp_idle,
    miniscape_entrust,
    fishing_contest,
    ridus_got_boo,
    qa_game
}

client_message_forwarding! {
    HallServer <- [SavePosInMainCityCsReq, InteractWithUnitCsReq, RunEventGraphCsReq, EnterSectionCsReq]
    BattleServer <- [EndBattleCsReq]
}

struct MessageContext<'s, 'pl> {
    pub state: &'static AppState,
    pub session: &'s GameSession,
    pub player: &'pl mut NapPlayer,
    pub request_id: u32,
    notify_list: Vec<ProtocolUnit>,
}

impl<'s, 'pl> MessageContext<'s, 'pl> {
    pub fn new(
        state: &'static AppState,
        session: &'s GameSession,
        player: &'pl mut NapPlayer,
        request_id: u32,
    ) -> Self {
        Self {
            state,
            session,
            player,
            request_id,
            notify_list: Vec::with_capacity(0),
        }
    }

    pub fn add_notify<Message: Encodeable + ClientCmdID>(&mut self, message: Message) {
        self.notify_list.push(message.into());
    }

    pub fn remove_notifies(&mut self) -> Vec<ProtocolUnit> {
        std::mem::take(&mut self.notify_list)
    }
}

macro_rules! modules {
    ($($name:ident),*) => {
        $(mod $name;)*

        pub async fn handle_message(state: &'static AppState, session: &GameSession, player: &mut NapPlayer, message: ::trigger_sv::message::ForwardClientProtocolMessage) -> Option<::trigger_sv::message::AvailableServerProtocolMessage> {
            let Some(message) = forward_client_message(session, message).await else {
                return None;
            };

            let cmd_id = message.message.cmd_id;

            $(
                if $name::supports_message(cmd_id) {
                    return $name::handle_message(state, session, player, message).await;
                }
            )*

            ::tracing::warn!("couldn't find handler module for message with id {cmd_id}");
            None
        }
    };
}

macro_rules! client_message_forwarding {
    ($($server_type:ident <- [$($cmd_type:ident),*])*) => {
        pub async fn forward_client_message(session: &GameSession, message: ::trigger_sv::message::ForwardClientProtocolMessage) -> Option<::trigger_sv::message::ForwardClientProtocolMessage> {
            use std::sync::LazyLock;
            use std::collections::HashMap;
            use trigger_sv::net::ServerType;

            static FORWARD_SERVER_MAP: LazyLock<HashMap<u16, ServerType>> = LazyLock::new(|| HashMap::from([$($((::trigger_protocol::$cmd_type::CMD_ID, ServerType::$server_type),)*)*]));

            if let Some(server_type) = FORWARD_SERVER_MAP.get(&message.message.cmd_id) {
                session.forward_client_message(message.message, *server_type, message.request_id).await;
                None
            }
            else {
                Some(message)
            }
        }
    };
}

use client_message_forwarding;
use modules;
