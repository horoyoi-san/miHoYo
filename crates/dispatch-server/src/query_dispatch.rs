use axum::{extract::State, Json};

use crate::{
    data::{QueryDispatchRsp, ServerListInfo},
    AppState,
};

pub const ROUTE_ENDPOINT: &str = "/query_dispatch";

pub async fn process(State(state): State<&'static AppState>) -> Json<QueryDispatchRsp<'static>> {
    use std::borrow::Cow::Borrowed;

    Json(QueryDispatchRsp {
        retcode: 0,
        msg: String::with_capacity(0),
        region_list: state
            .config
            .regions
            .iter()
            .map(|rs| ServerListInfo {
                name: Borrowed(&rs.name),
                title: Borrowed(&rs.title),
                ping_url: Borrowed(&rs.ping_url),
                dispatch_url: Borrowed(&rs.dispatch_url),
                biz: Borrowed(&rs.biz),
                area: rs.area,
                env: rs.env,
                ..Default::default()
            })
            .collect(),
    })
}
