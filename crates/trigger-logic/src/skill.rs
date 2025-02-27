use num_enum::{IntoPrimitive, TryFromPrimitive};

#[derive(Debug, PartialEq, Eq, Hash, Clone, Copy, IntoPrimitive, TryFromPrimitive)]
#[repr(i32)]
pub enum EAvatarSkillType {
    SpecialAttack = 1,
    UniqueSkill = 4,
    CommonAttack = 0,
    CooperateSkill = 3,
    AssistSkill = 6,
    Evade = 2,
    CoreSkill = 5,
    EnumCount = 7,
}
