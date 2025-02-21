use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod land_revive_module {
    pub async fn on_get_main_city_revival_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetMainCityRevivalDataCsReq,
    ) -> GetMainCityRevivalDataScRsp {
        GetMainCityRevivalDataScRsp {
            retcode: 0,
            main_city_revival_data: Some(MainCityRevivalData::default()),
        }
    }
}
