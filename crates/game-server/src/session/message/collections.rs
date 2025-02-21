use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod collections_module {
    pub async fn on_get_collect_map(
        _context: &mut MessageContext<'_, '_>,
        _request: GetCollectMapCsReq,
    ) -> GetCollectMapScRsp {
        GetCollectMapScRsp {
            retcode: 0,
            collect_map: Some(CollectMap::default()),
        }
    }

    pub async fn on_workbench_get_data(
        _context: &mut MessageContext<'_, '_>,
        _request: WorkbenchGetDataCsReq,
    ) -> WorkbenchGetDataScRsp {
        WorkbenchGetDataScRsp {
            retcode: 0,
            workbench_data: Some(WorkbenchData::default()),
        }
    }

    pub async fn on_get_abyss_reward_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetAbyssRewardDataCsReq,
    ) -> GetAbyssRewardDataScRsp {
        GetAbyssRewardDataScRsp {
            retcode: 0,
            abyss_reward_data: Some(AbyssRewardData::default()),
        }
    }
}
