use trigger_database::entity::*;
use trigger_database::prelude::*;
use trigger_database::DatabaseConnection;

pub async fn load_player_basic_info(
    db: &DatabaseConnection,
    player_uid: u32,
    create_if_not_exists: bool,
) -> Option<(player_basic_info::Model, bool)> {
    let player_uid = player_uid as i32;

    match player_basic_info::Entity::find_by_id(player_uid)
        .one(db)
        .await
        .expect("player_basic_info::find_by_id failed")
    {
        Some(info) => Some((info, false)),
        None if create_if_not_exists => Some((
            create_default_player_basic_info(player_uid)
                .insert(db)
                .await
                .expect("player_basic_info::insert failed"),
            true,
        )),
        None => None,
    }
}

fn create_default_player_basic_info(player_uid: i32) -> player_basic_info::ActiveModel {
    player_basic_info::Model {
        player_uid,
        nick_name: String::from("ReversedRooms"),
        level: 60,
        exp: 0,
        avatar_id: 2021,
        player_avatar_id: 2021,
        control_avatar_id: 1361,
    }
    .into()
}
