use num_enum::{IntoPrimitive, TryFromPrimitive};

#[derive(Debug, PartialEq, Eq, Hash, Clone, Copy, IntoPrimitive, TryFromPrimitive)]
#[repr(i32)]
pub enum EQuestType {
    ArchiveFile = 1,
    HollowChallenge = 6,
    ArchiveBattle = 7,
    MainCity = 5,
    Daily = 9,
    DungeonInner = 2,
    Knowledge = 8,
    Hollow = 3,
    Manual = 4,
}

#[derive(Debug, PartialEq, Eq, Hash, Clone, Copy, IntoPrimitive, TryFromPrimitive)]
#[repr(i32)]
pub enum EHollowQuestType {
    AbyssS2Event = 25,
    DifficutyBattle = 12,
    SideQuest = 2,
    Challenge = 5,
    MainQuest = 1,
    AbyssS2RoleChallenge = 22,
    AbyssS2Story = 19,
    AvatarSide = 7,
    BossRushBattle = 14,
    MainQuestChessboard = 21,
    Common = 0,
    ChallengeChaos = 6,
    Urgent = 3,
    HackerActivity = 16,
    NormalBattle = 10,
    TheGun = 18,
    NestVeryHard = 15,
    AbyssS2Period = 20,
    PromoteBattle = 11,
    World = 8,
    EnumCount = 26,
    RallyBattle = 13,
    UrgentSupplement = 4,
    Arpeggio = 17,
}
