use super::*;

pub async fn on_rpc_get_tips_info_arg(
    _: &mut NetworkContext<'_, '_, RpcGetTipsInfoArg>,
) -> Result<RpcGetTipsInfoRet, i32> {
    Ok(RpcGetTipsInfoRet {
        retcode: 0,
        tips_info: TipsInfo::default(),
        ..Default::default()
    })
}

pub async fn on_rpc_get_client_systems_data_arg(
    _: &mut NetworkContext<'_, '_, RpcGetClientSystemsDataArg>,
) -> Result<RpcGetClientSystemsDataRet, i32> {
    Ok(RpcGetClientSystemsDataRet {
        retcode: 0,
        data: ClientSystemsData::default(),
    })
}

pub async fn on_rpc_get_private_message_data_arg(
    _: &mut NetworkContext<'_, '_, RpcGetPrivateMessageDataArg>,
) -> Result<RpcGetPrivateMessageDataRet, i32> {
    Ok(RpcGetPrivateMessageDataRet {
        retcode: 0,
        private_message_data: PrivateMessageData::default(),
    })
}

pub async fn on_rpc_get_collect_map_arg(
    _: &mut NetworkContext<'_, '_, RpcGetCollectMapArg>,
) -> Result<RpcGetCollectMapRet, i32> {
    Ok(RpcGetCollectMapRet {
        retcode: 0,
        collect_map: CollectMap::default(),
    })
}

pub async fn on_rpc_workbench_get_data_arg(
    _: &mut NetworkContext<'_, '_, RpcWorkbenchGetDataArg>,
) -> Result<RpcWorkbenchGetDataRet, i32> {
    Ok(RpcWorkbenchGetDataRet {
        retcode: 0,
        workbench_data: WorkbenchData::default(),
    })
}

pub async fn on_rpc_report_ui_layout_platform_arg(
    _: &mut NetworkContext<'_, '_, RpcReportUiLayoutPlatformArg>,
) -> Result<RpcReportUiLayoutPlatformRet, i32> {
    Ok(RpcReportUiLayoutPlatformRet::default())
}
