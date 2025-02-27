use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod babel_tower_module {
    pub async fn on_get_babel_tower_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetBabelTowerDataCsReq,
    ) -> GetBabelTowerDataScRsp {
        GetBabelTowerDataScRsp { retcode: 0 }
    }
}
