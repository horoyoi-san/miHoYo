use num_enum::{FromPrimitive, IntoPrimitive, TryFromPrimitive};

#[derive(Debug, Default, Clone, PartialEq)]
pub struct Vector3f {
    pub x: f64,
    pub y: f64,
    pub z: f64,
}

#[derive(Debug, Default, Clone, PartialEq)]
pub struct Transform {
    pub position: Vector3f,
    pub rotation: Vector3f,
}

#[derive(Debug, PartialEq, Eq, Clone, Copy, IntoPrimitive, TryFromPrimitive)]
#[repr(i16)]
pub enum ESceneType {
    Hall = 1,
    Hollow = 2,
    Fight = 3,
    Fresh = 4,
    MultiFight = 5,
    Rally = 7,
}

#[derive(Debug, PartialEq, Eq, Clone, Copy, IntoPrimitive, TryFromPrimitive)]
#[repr(i16)]
pub enum EPackageType {
    Fight = 1,
    RogueLike = 2,
    Player = 3,
    DungeonAvatar = 4,
}

#[derive(Debug, PartialEq, Eq, Clone, Copy, IntoPrimitive, TryFromPrimitive)]
#[repr(i32)]
pub enum EInteractTarget {
    None = 0,
    NPC = 1,
    TriggerBox = 2,
}

#[derive(Debug, PartialEq, Eq, Clone, Copy, IntoPrimitive, TryFromPrimitive)]
#[repr(i32)]
pub enum EEventGraphOwnerType {
    None = 0,
    Scene = 1,
    Section = 2,
    SceneUnit = 3,
    Hollow = 4,
}

#[derive(Default, Debug, PartialEq, Eq, Clone, Copy, IntoPrimitive, FromPrimitive)]
#[repr(u32)]
pub enum ELocalPlayType {
    #[default]
    Unknown = 0,
    BossRushBattle = 218,
    DualElite = 208,
    RallyLongFight = 207,
    HadalZoneBosschallenge = 224,
    BossNestHardBattle = 220,
    MapChallengeBattle = 291,
    BangbooRoyale = 240,
    AvatarDemoTrial = 213,
    BossBattle = 210,
    ArchiveLongFight = 212,
    TargetShootingBattle = 294,
    CoinBrushingBattle = 231,
    ActivityCombatPause = 230,
    BossLittleBattleLongfight = 215,
    OperationBetaDemo = 216,
    BigBossBattleLongfight = 217,
    S2RogueBattle = 226,
    LevelZero = 205,
    HadalZone = 209,
    ChessBoardBattle = 202,
    TrainingRootTactics = 292,
    TrainingRoom = 290,
    PureHollowBattleLonghfight = 281,
    BabelTower = 223,
    MpBigBossBattle = 214,
    MiniScapeShortBattle = 229,
    HadalZoneAlivecount = 222,
    GuideSpecial = 203,
    OperationTeamCoop = 219,
    BigBossBattle = 211,
    ChessBoardLongfihgtBattle = 204,
    BuddyTowerdefenseBattle = 227,
    PureHollowBattleHardmode = 282,
    MiniScapeBattle = 228,
    DailyChallenge = 206,
    PureHollowBattle = 280,
    SideScrollingThegunBattle = 221,
    ArchiveBattle = 201,
    BangbooDreamRogueBattle = 293,
}

impl From<Vec<f64>> for Vector3f {
    fn from(value: Vec<f64>) -> Self {
        Self {
            x: value.get(0).copied().unwrap_or(0.0),
            y: value.get(1).copied().unwrap_or(0.0),
            z: value.get(2).copied().unwrap_or(0.0),
        }
    }
}
