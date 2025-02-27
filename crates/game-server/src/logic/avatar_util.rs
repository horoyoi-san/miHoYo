pub const MALE_AVATAR_ID: u32 = 2011;
pub const FEMALE_AVATAR_ID: u32 = 2021;

pub fn is_player_avatar(id: u32) -> bool {
    id == MALE_AVATAR_ID || id == FEMALE_AVATAR_ID
}

pub fn is_valid_talent_switch(v: &[bool]) -> bool {
    v.len() == 6
        && v[0..3]
            .iter()
            .zip(v[3..6].iter())
            .fold(true, |v, (&a, &b)| v && !(a && b))
}
