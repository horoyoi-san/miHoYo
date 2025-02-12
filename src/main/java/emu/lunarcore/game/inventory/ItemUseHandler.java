package emu.lunarcore.game.inventory;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.ItemUseExcel;
import emu.lunarcore.data.excel.RewardExcel;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.game.player.lineup.PlayerLineup;
import it.unimi.dsi.fastutil.ints.IntListIterator;

public class ItemUseHandler {
    public static boolean handleFixedRewardGift(Player player, ItemUseExcel excel, int avatarId, int count) {
        if (excel.getUseParam() == null) {
            return false;
        }
        IntListIterator intListIterator = excel.getUseParam().iterator();
        while (intListIterator.hasNext()) {
            int rewardId = (Integer)intListIterator.next();
            RewardExcel rewardExcel = (RewardExcel)GameData.getRewardExcelMap().get(rewardId);
            if (rewardExcel == null) continue;
            player.getInventory().addItemParams(rewardExcel.getRewards(), count);
        }
        return true;
    }

    public static boolean handleTeamSpecificFoodBenefit(Player player, ItemUseExcel excel, int avatarId, int count) {
        int amount;
        GameAvatar avatar;
        PlayerLineup lineup = player.getCurrentLineup();
        if (excel.getPreviewHPRecoveryPercent() != 0.0) {
            avatar = player.getAvatarById(avatarId);
            if (avatar == null) {
                return false;
            }
            amount = (int)(excel.getPreviewHPRecoveryPercent() * 10000.0);
            avatar.setCurrentHp(lineup, avatar.getCurrentHp(lineup) + amount);
            if (avatar.getCurrentHp(lineup) <= 0) {
                avatar.setCurrentHp(lineup, 100);
            }
            avatar.save();
            lineup.refreshLineup();
        }
        if (excel.getPreviewPowerPercent() != 0.0) {
            avatar = player.getAvatarById(avatarId);
            if (avatar == null) {
                return false;
            }
            amount = (int)(excel.getPreviewHPRecoveryPercent() * 10000.0);
            avatar.setCurrentSp(lineup, avatar.getCurrentHp(lineup) + amount);
            avatar.save();
            lineup.refreshLineup();
        }
        if (excel.getPreviewSkillPoint() > 0) {
            lineup.addMp(excel.getPreviewSkillPoint());
            lineup.save();
        }
        return true;
    }

    public static boolean handleExternalSystemFoodBenefit(Player player, ItemUseExcel excel, int avatarId, int count) {
        ItemUseHandler.handleTeamSpecificFoodBenefit(player, excel, avatarId, count);
        if (excel.getConsumeType() == 1 || excel.getConsumeType() == 2) {
            player.addFoodBuff(excel.getConsumeType(), excel);
        }
        return true;
    }
}

