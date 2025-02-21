use sea_orm::Schema;
use sea_orm_migration::prelude::*;

#[derive(DeriveMigrationName)]
pub struct Migration;

#[async_trait::async_trait]
impl MigrationTrait for Migration {
    async fn up(&self, manager: &SchemaManager) -> Result<(), DbErr> {
        let builder = manager.get_database_backend();
        let schema = Schema::new(builder);

        tables! {
            (manager, schema)
            account_uid;
            player_basic_info;
            player_world_info;
            player_item_uid;
            quest_collection;
            quest_info;
            archive_data;
            archive_videotape_data;
            hollow_data;
            hollow_info;
            avatar;
            material;
            weapon;
            equipment;
            auto_recovery_data;
            scene_info;
            ramen_data;
            cafe_data;
        }

        Ok(())
    }

    async fn down(&self, _manager: &SchemaManager) -> Result<(), DbErr> {
        todo!()
    }
}

macro_rules! tables {
    (($manager:expr, $schema:expr) $($name:ident;)*) => {
        $($manager
            .create_table($schema.create_table_from_entity(entity::$name::Entity))
            .await?;)*
    };
}

use tables;
