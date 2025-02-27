use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod month_card_module {
    pub async fn on_get_month_card_reward_list(
        _context: &mut MessageContext<'_, '_>,
        _request: GetMonthCardRewardListCsReq,
    ) -> GetMonthCardRewardListScRsp {
        GetMonthCardRewardListScRsp { retcode: 0 }
    }
}
