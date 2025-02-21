use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod avatar_module {
    pub async fn on_get_avatar_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetAvatarDataCsReq,
    ) -> GetAvatarDataScRsp {
        GetAvatarDataScRsp {
            retcode: 0,
            avatar_list: context.player.role_model.get_protocol_avatar_list(&[]),
        }
    }

    pub async fn on_get_avatar_recommend_equip(
        _context: &mut MessageContext<'_, '_>,
        _request: GetAvatarRecommendEquipCsReq,
    ) -> GetAvatarRecommendEquipScRsp {
        GetAvatarRecommendEquipScRsp { retcode: 0 }
    }

    pub async fn on_weapon_dress(
        context: &mut MessageContext<'_, '_>,
        request: WeaponDressCsReq,
    ) -> WeaponDressScRsp {
        let equip_model = &context.player.equip_model;
        let role_model = &mut context.player.role_model;

        if equip_model.weapon_exists(request.weapon_uid as i32) {
            if let Some(updated_avatars) = role_model
                .weapon_dress(request.avatar_id, request.weapon_uid as i32)
                .await
            {
                let avatar_list = role_model.get_protocol_avatar_list(&updated_avatars);
                context.add_notify(PlayerSyncScNotify {
                    avatar_sync: Some(AvatarSync { avatar_list }),
                    ..Default::default()
                });

                return WeaponDressScRsp { retcode: 0 };
            }
        }

        WeaponDressScRsp { retcode: 1 }
    }

    pub async fn on_un_weapon_dress(
        context: &mut MessageContext<'_, '_>,
        request: WeaponUnDressCsReq,
    ) -> WeaponUnDressScRsp {
        let role_model = &mut context.player.role_model;

        if let Some(updated_avatars) = role_model.weapon_dress(request.avatar_id, 0).await {
            let avatar_list = role_model.get_protocol_avatar_list(&updated_avatars);
            context.add_notify(PlayerSyncScNotify {
                avatar_sync: Some(AvatarSync { avatar_list }),
                ..Default::default()
            });

            return WeaponUnDressScRsp { retcode: 0 };
        }

        WeaponUnDressScRsp { retcode: 1 }
    }

    pub async fn on_dress_equipment(
        context: &mut MessageContext<'_, '_>,
        request: DressEquipmentCsReq,
    ) -> DressEquipmentScRsp {
        let equip_model = &context.player.equip_model;
        let role_model = &mut context.player.role_model;

        if equip_model.equipment_exists(request.equip_uid as i32) {
            if let Some(updated_avatars) = role_model
                .dress_equipment(
                    request.avatar_id,
                    &[(request.equip_uid, request.dress_index)],
                )
                .await
            {
                let avatar_list = role_model.get_protocol_avatar_list(&updated_avatars);
                context.add_notify(PlayerSyncScNotify {
                    avatar_sync: Some(AvatarSync { avatar_list }),
                    ..Default::default()
                });

                return DressEquipmentScRsp { retcode: 0 };
            }
        }

        DressEquipmentScRsp { retcode: 1 }
    }

    pub async fn on_undress_equipment(
        context: &mut MessageContext<'_, '_>,
        request: UndressEquipmentCsReq,
    ) -> UndressEquipmentScRsp {
        let role_model = &mut context.player.role_model;

        if role_model
            .undress_equipment(request.avatar_id, &request.undress_index_list)
            .await
        {
            let avatar_list = role_model.get_protocol_avatar_list(&[request.avatar_id]);
            context.add_notify(PlayerSyncScNotify {
                avatar_sync: Some(AvatarSync { avatar_list }),
                ..Default::default()
            });

            return UndressEquipmentScRsp { retcode: 0 };
        }

        UndressEquipmentScRsp { retcode: 1 }
    }

    pub async fn on_dress_equipment_suit(
        context: &mut MessageContext<'_, '_>,
        request: DressEquipmentSuitCsReq,
    ) -> DressEquipmentSuitScRsp {
        let equip_model = &context.player.equip_model;
        let role_model = &mut context.player.role_model;

        if request.param_list.iter().fold(true, |v, param| {
            v && equip_model.equipment_exists(param.equip_uid as i32)
        }) {
            if let Some(updated_avatars) = role_model
                .dress_equipment(
                    request.avatar_id,
                    &request
                        .param_list
                        .into_iter()
                        .map(|param| (param.equip_uid, param.dress_index))
                        .collect::<Vec<_>>(),
                )
                .await
            {
                let avatar_list = role_model.get_protocol_avatar_list(&updated_avatars);
                context.add_notify(PlayerSyncScNotify {
                    avatar_sync: Some(AvatarSync { avatar_list }),
                    ..Default::default()
                });

                return DressEquipmentSuitScRsp { retcode: 0 };
            }
        }

        DressEquipmentSuitScRsp { retcode: 1 }
    }

    pub async fn on_talent_switch(
        context: &mut MessageContext<'_, '_>,
        request: TalentSwitchCsReq,
    ) -> TalentSwitchScRsp {
        let role_model = &mut context.player.role_model;
        if role_model
            .talent_switch(request.avatar_id, request.talent_switch_list)
            .await
        {
            let avatar_list = role_model.get_protocol_avatar_list(&[request.avatar_id]);
            context.add_notify(PlayerSyncScNotify {
                avatar_sync: Some(AvatarSync { avatar_list }),
                ..Default::default()
            });

            return TalentSwitchScRsp { retcode: 0 };
        }

        TalentSwitchScRsp { retcode: 1 }
    }
}
