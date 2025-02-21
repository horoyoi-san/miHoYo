use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod perform_module {
    use rand::RngCore;
    use tracing::debug;

    // TODO: actual perform trigger/jump/end tracking

    pub async fn on_perform_trigger(
        _context: &mut MessageContext<'_, '_>,
        request: PerformTriggerCsReq,
    ) -> PerformTriggerScRsp {
        debug!("{request:?}");

        PerformTriggerScRsp {
            retcode: 0,
            perform_uid: ((request.perform_id as i64) << 32)
                | (rand::thread_rng().next_u32() as i64),
        }
    }

    pub async fn on_perform_jump(
        _context: &mut MessageContext<'_, '_>,
        request: PerformJumpCsReq,
    ) -> PerformJumpScRsp {
        debug!("{request:?}");

        PerformJumpScRsp { retcode: 0 }
    }

    pub async fn on_perform_end(
        _context: &mut MessageContext<'_, '_>,
        request: PerformEndCsReq,
    ) -> PerformEndScRsp {
        debug!("{request:?}");

        PerformEndScRsp { retcode: 0 }
    }
}
