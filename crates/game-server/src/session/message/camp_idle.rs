use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod camp_idle_module {
    pub async fn on_get_camp_idle_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetCampIdleDataCsReq,
    ) -> GetCampIdleDataScRsp {
        GetCampIdleDataScRsp {
            retcode: 0,
            camp_idle_data: Some(CampIdleData::default()),
        }
    }
}
