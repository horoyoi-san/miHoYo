use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod reward_buff_module {
    pub async fn on_get_reward_buff_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetRewardBuffDataCsReq,
    ) -> GetRewardBuffDataScRsp {
        GetRewardBuffDataScRsp {
            retcode: 0,
            data: Some(RewardBuffData::default()),
        }
    }
}
