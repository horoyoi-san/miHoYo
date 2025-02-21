pub trait BitSetExt {
    fn is_bit_set(self, idx: usize) -> bool;
    fn from_vec(v: Vec<bool>) -> Self;
    fn to_vec(self, n: usize) -> Vec<bool>;
}

impl BitSetExt for i16 {
    fn is_bit_set(self, idx: usize) -> bool {
        (self as u16) & (1 << (idx as u16)) != 0
    }

    fn from_vec(v: Vec<bool>) -> Self {
        v.into_iter()
            .take(15)
            .enumerate()
            .fold(0i16, |v, (i, b)| v | (i16::from(b) << (i as i16)))
    }

    fn to_vec(self, n: usize) -> Vec<bool> {
        (0..std::cmp::min(15, n))
            .map(|idx| self.is_bit_set(idx))
            .collect()
    }
}
