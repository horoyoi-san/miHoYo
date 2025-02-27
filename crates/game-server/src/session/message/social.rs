use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod social_module {
    pub async fn on_get_friend_list(
        _context: &mut MessageContext<'_, '_>,
        _request: GetFriendListCsReq,
    ) -> GetFriendListScRsp {
        GetFriendListScRsp { retcode: 0 }
    }

    pub async fn on_get_online_friends_list(
        _context: &mut MessageContext<'_, '_>,
        _request: GetOnlineFriendsListCsReq,
    ) -> GetOnlineFriendsListScRsp {
        GetOnlineFriendsListScRsp { retcode: 0 }
    }

    pub async fn on_get_role_card_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetRoleCardDataCsReq,
    ) -> GetRoleCardDataScRsp {
        GetRoleCardDataScRsp {
            retcode: 0,
            role_card_data: Some(RoleCardData {
                signature: String::from("discord.gg/reversedrooms"),
            }),
        }
    }

    pub async fn on_get_chat_emoji_list(
        _context: &mut MessageContext<'_, '_>,
        _request: GetChatEmojiListCsReq,
    ) -> GetChatEmojiListScRsp {
        GetChatEmojiListScRsp { retcode: 0 }
    }

    pub async fn on_get_display_case_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetDisplayCaseDataCsReq,
    ) -> GetDisplayCaseDataScRsp {
        GetDisplayCaseDataScRsp { retcode: 0 }
    }

    pub async fn on_get_player_display_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetPlayerDisplayDataCsReq,
    ) -> GetPlayerDisplayDataScRsp {
        GetPlayerDisplayDataScRsp {
            retcode: 0,
            player_display_data: Some(PlayerDisplayData {
                signature: String::from("discord.gg/reversedrooms"),
                display_item_group: Some(DisplayItemGroup::default()),
                avatar_data_package: Some(AvatarDataPackage::default()),
                photo_wall_network_data: Some(PhotoWallNetworkData::default()),
            }),
        }
    }
}
