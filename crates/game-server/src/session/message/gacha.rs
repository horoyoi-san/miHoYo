use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod gacha_module {
    pub async fn on_get_gacha_data(
        _context: &mut MessageContext<'_, '_>,
        request: GetGachaDataCsReq,
    ) -> GetGachaDataScRsp {
        GetGachaDataScRsp {
            retcode: 0,
            gacha_type: request.gacha_type,
        }
    }
}
