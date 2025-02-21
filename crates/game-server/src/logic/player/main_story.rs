use std::collections::HashMap;

use trigger_database::{
    entity::{archive_data, archive_videotape_data},
    prelude::*,
};

use super::NapContext;

pub struct MainStoryModel {
    context: NapContext,
    archive_data: archive_data::Model,
    vhs: HashMap<u32, archive_videotape_data::Model>,
}

impl MainStoryModel {
    pub async fn init(context: NapContext) -> Self {
        let archive_data = Self::load_archive_data(&context).await;
        let vhs = Self::load_vhs(&context).await;

        Self {
            context,
            archive_data,
            vhs,
        }
    }

    pub async fn add_archive_files(&mut self, archive_file_id_list: &[i32]) {
        let mut hollow_archive_id_list =
            std::mem::take(&mut self.archive_data.hollow_archive_id_list);

        let models = archive_file_id_list
            .iter()
            .filter(|id| !self.vhs.contains_key(&(**id as u32)))
            .map(|id| {
                self.context
                    .filecfg
                    .archive_file_quest_template_tb
                    .data()
                    .unwrap()
                    .iter()
                    .find(|tmpl| tmpl.id() == *id)
            })
            .flatten()
            .inspect(|tmpl| {
                if !hollow_archive_id_list.contains(&tmpl.archive_id()) {
                    hollow_archive_id_list.push(tmpl.archive_id());
                }
            })
            .map(|tmpl| archive_videotape_data::Model {
                owner_player_uid: self.context.player_uid as i32,
                archive_file_id: tmpl.id(),
            })
            .collect::<Vec<_>>();

        models.iter().for_each(|videotape| {
            self.vhs
                .insert(videotape.archive_file_id as u32, videotape.clone());
        });

        archive_videotape_data::Entity::insert_many(
            models
                .into_iter()
                .map(archive_videotape_data::ActiveModel::from)
                .collect::<Vec<_>>(),
        )
        .exec(self.context.database)
        .await
        .expect("archive_videotape_data::insert_many failed");

        self.archive_data = archive_data::ActiveModel {
            owner_player_uid: Set(self.context.player_uid as i32),
            hollow_archive_id_list: Set(hollow_archive_id_list),
        }
        .update(self.context.database)
        .await
        .expect("archive_data::update failed");
    }

    pub fn get_protocol_archive_data(&self) -> trigger_protocol::ArchiveData {
        use trigger_protocol::*;

        ArchiveData {
            hollow_archive_id_list: self
                .archive_data
                .hollow_archive_id_list
                .iter()
                .map(|id| *id as u32)
                .collect(),
            videotaps_info: self
                .vhs
                .iter()
                .map(|(_, videotape)| VideotapeInfo {
                    archive_file_id: videotape.archive_file_id as u32,
                    finished: true,
                })
                .collect(),
        }
    }

    async fn load_archive_data(context: &NapContext) -> archive_data::Model {
        if let Some(data) = archive_data::Entity::find_by_id(context.player_uid as i32)
            .one(context.database)
            .await
            .expect("archive_data::find_by_id failed")
        {
            return data;
        }

        archive_data::Entity::insert(archive_data::ActiveModel {
            owner_player_uid: Set(context.player_uid as i32),
            hollow_archive_id_list: Set(Vec::new()),
        })
        .exec_with_returning(context.database)
        .await
        .expect("archive_data::insert failed")
    }

    async fn load_vhs(context: &NapContext) -> HashMap<u32, archive_videotape_data::Model> {
        archive_videotape_data::Entity::find()
            .filter(archive_videotape_data::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("archive_videotape_data::find failed")
            .into_iter()
            .map(|videotape| (videotape.archive_file_id as u32, videotape))
            .collect()
    }
}
