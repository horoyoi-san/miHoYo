use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod battle_pass_module {
    pub async fn on_get_battle_pass_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetBattlePassDataCsReq,
    ) -> GetBattlePassDataScRsp {
        GetBattlePassDataScRsp { retcode: 0 }
    }
}
