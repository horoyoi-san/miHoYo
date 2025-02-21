use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod abyss_module {
    pub async fn on_abyss_get_data(
        _context: &mut MessageContext<'_, '_>,
        _request: AbyssGetDataCsReq,
    ) -> AbyssGetDataScRsp {
        AbyssGetDataScRsp {
            retcode: 0,
            abyss_data: Some(AbyssData::default()),
            abyss_group_list: Vec::new(),
            abyss_dungeon_list: Vec::new(),
        }
    }

    pub async fn on_abyss_arpeggio_get_data(
        _context: &mut MessageContext<'_, '_>,
        _request: AbyssArpeggioGetDataCsReq,
    ) -> AbyssArpeggioGetDataScRsp {
        AbyssArpeggioGetDataScRsp { retcode: 0 }
    }
}
