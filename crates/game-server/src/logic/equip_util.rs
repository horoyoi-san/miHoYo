use std::{collections::HashMap, sync::LazyLock};

use rand::RngCore;

static EQUIP_SLOT_PROPERTIES: LazyLock<HashMap<i32, Vec<u32>>> = LazyLock::new(|| {
    HashMap::from([
        (1, vec![11103]),
        (2, vec![12103]),
        (3, vec![13103]),
        (4, vec![11102, 12102, 13102, 20103, 21103, 31203, 23103]),
        (
            5,
            vec![11102, 12102, 13102, 31803, 31903, 31703, 31603, 31503],
        ),
        (6, vec![11102, 12102, 13102, 31402, 12202, 30502]),
    ])
});

pub fn random_main_property(equip_type: i32) -> i64 {
    let mut rng = rand::thread_rng();

    let prop_types = EQUIP_SLOT_PROPERTIES.get(&equip_type).unwrap();
    let key = prop_types[(rng.next_u32() as usize) % prop_types.len()] as i64;
    let val = 400 + ((rng.next_u32() as i64) % 300);

    (key << 32) | (val & 0xFFFF)
}
