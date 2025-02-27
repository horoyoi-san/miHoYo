use std::time::{SystemTime, UNIX_EPOCH};

pub fn cur_timestamp_seconds() -> i64 {
    SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .unwrap()
        .as_secs() as i64
}
