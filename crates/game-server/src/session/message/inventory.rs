use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod inventory_module {
    pub async fn on_get_weapon_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetWeaponDataCsReq,
    ) -> GetWeaponDataScRsp {
        GetWeaponDataScRsp {
            retcode: 0,
            weapon_list: context.player.equip_model.get_protocol_weapon_list(&[]),
        }
    }

    pub async fn on_get_equip_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetEquipDataCsReq,
    ) -> GetEquipDataScRsp {
        GetEquipDataScRsp {
            retcode: 0,
            equip_list: context.player.equip_model.get_protocol_equip_list(&[]),
        }
    }

    pub async fn on_get_resource_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetResourceDataCsReq,
    ) -> GetResourceDataScRsp {
        let item_model = &context.player.item_model;

        GetResourceDataScRsp {
            retcode: 0,
            material_list: item_model.get_protocol_material_list(),
            auto_recovery_info: item_model.get_protocol_auto_recovery_info(),
        }
    }

    pub async fn on_get_wishlist_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetWishlistDataCsReq,
    ) -> GetWishlistDataScRsp {
        GetWishlistDataScRsp { retcode: 0 }
    }
}
