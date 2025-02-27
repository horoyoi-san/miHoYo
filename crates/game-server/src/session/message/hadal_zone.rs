use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod hadal_zone_module {
    pub async fn on_get_hadal_zone_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetHadalZoneDataCsReq,
    ) -> GetHadalZoneDataScRsp {
        GetHadalZoneDataScRsp { retcode: 0 }
    }
}
