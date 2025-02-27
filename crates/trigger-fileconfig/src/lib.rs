#[allow(dead_code, unused_imports, unsafe_op_in_unsafe_fn)]
#[path = "../gen_flatbuffers/tables_generated.rs"]
mod data;
pub mod main_city_script;

pub use blockfile::ArchiveFile;
pub use data::*;

macro_rules! file_cfg {
    ($($name:ident;)*) => {
        ::paste::paste!{
            pub struct NapFileCfg<'file> {
                $(pub [<$name:snake>]: $name<'file>,)*
        }}

        impl<'file> NapFileCfg<'file> {
            ::paste::paste!{
                pub fn new(archive_file: &'file ArchiveFile) -> Self {
                    Self {
                        $(
                            [<$name:snake>]: {
                                ::flatbuffers::root::<$name>(archive_file.open(::const_format::formatcp!("{}", ::xxhash_rust::const_xxh64::xxh64(stringify!([<$name:lower>]).as_bytes(), 0))).unwrap()).unwrap()
                            },
                        )*
                    }
                }
            }
        }
    };
}

file_cfg! {
    AvatarBaseTemplateTb;
    WeaponTemplateTb;
    EquipmentTemplateTb;
    EquipmentSuitTemplateTb;
    UnlockConfigTemplateTb;
    PostGirlConfigTemplateTb;
    ArchiveFileQuestTemplateTb;
    ArchiveBattleQuestTemplateTb;
    SectionConfigTemplateTb;
    MainCityBGMConfigTemplateTb;
    HollowBuffTemplateTb;
    CafeConfigTemplateTb;
    HollowConfigTemplateTb;
    HollowQuestTemplateTb;
    BattleGroupConfigTemplateTb;
    MusicPlayerConfigTemplateTb;
}

pub fn read_archive_file<R: std::io::Read>(buf: R) -> std::io::Result<ArchiveFile> {
    let raw_data = blockfile::unpack_blk_raw(buf)?;
    ArchiveFile::from_raw(raw_data)
}
