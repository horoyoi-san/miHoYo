use trigger_protocol::*;

use super::NapPlayer;

pub fn build_dungeon_equip_info(player: &NapPlayer, avatar_id_list: &[u32]) -> DungeonEquipInfo {
    let avatar_list = player.role_model.get_protocol_avatar_list(avatar_id_list);

    let weapon_uid_list = avatar_list
        .iter()
        .map(|avatar| avatar.cur_weapon_uid as i32)
        .filter(|uid| *uid != 0)
        .collect::<Vec<i32>>();

    let equip_uid_list = avatar_list
        .iter()
        .flat_map(|avatar| {
            avatar
                .dressed_equip_list
                .iter()
                .map(|equip| equip.equip_uid as i32)
        })
        .collect::<Vec<i32>>();

    let weapon_list = (!weapon_uid_list.is_empty())
        .then(|| {
            player
                .equip_model
                .get_protocol_weapon_list(&weapon_uid_list)
        })
        .unwrap_or_default();

    let equip_list = (!equip_uid_list.is_empty())
        .then(|| player.equip_model.get_protocol_equip_list(&equip_uid_list))
        .unwrap_or_default();

    DungeonEquipInfo {
        avatar_list,
        weapon_list,
        equip_list,
        ..Default::default()
    }
}
