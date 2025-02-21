use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod battle_event_module {
    pub async fn on_get_battle_event_info(
        _context: &mut MessageContext<'_, '_>,
        _request: GetBattleEventInfoCsReq,
    ) -> GetBattleEventInfoScRsp {
        GetBattleEventInfoScRsp {
            retcode: 0,
            event_info: Some(BattleEventInfo::default()),
        }
    }

    pub async fn on_report_battle_team(
        _context: &mut MessageContext<'_, '_>,
        _request: ReportBattleTeamCsReq,
    ) -> ReportBattleTeamScRsp {
        ReportBattleTeamScRsp { retcode: 0 }
    }
}
