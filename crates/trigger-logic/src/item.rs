use num_enum::IntoPrimitive;

#[derive(Debug, PartialEq, Eq, Clone, Copy, IntoPrimitive)]
#[repr(i32)]
pub enum ItemStatic {
    HollowGold = 1,
    FrontendGold = 10,
    GameDiamond = 100,
    RechargeDiamond = 101,
    Energy = 501,
}

impl From<ItemStatic> for u32 {
    fn from(value: ItemStatic) -> Self {
        i32::from(value) as u32
    }
}
