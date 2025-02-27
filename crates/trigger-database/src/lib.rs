use std::fmt;

use migration::{Migrator, MigratorTrait};
use sea_orm::Database;
use serde::Deserialize;

pub use entity;
pub use sea_orm::DatabaseConnection;
pub use sea_orm::DbErr;
use tracing::error;

pub mod prelude {
    pub use sea_orm::entity::prelude::*;
    pub use sea_orm::entity::ActiveValue::*;
    pub use sea_orm::query::Condition;
    pub use sea_orm::TransactionTrait;
}

#[derive(Debug, Deserialize)]
pub struct DatabaseSetting {
    pub end_point: String,
    pub database: String,
    pub user: String,
    pub password: String,
}

pub async fn connect(database_setting: &DatabaseSetting) -> Result<DatabaseConnection, ()> {
    let connection = Database::connect(&database_setting.to_string()).await.map_err(|err| {
        error!("Failed to connect to PostgreSQL. Please recheck [database] section in environment configuration. Error: {err}");
    })?;

    Migrator::up(&connection, None).await.map_err(|err| {
        error!("Failed to apply pending migrations to the database. Error: {err}");
        error!("You probably just broke your database. Congratulations.");
    })?;

    Ok(connection)
}

impl fmt::Display for DatabaseSetting {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(
            f,
            "postgres://{}:{}@{}/{}",
            &self.user, &self.password, &self.end_point, &self.database
        )
    }
}
