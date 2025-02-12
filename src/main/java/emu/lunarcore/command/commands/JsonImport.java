package emu.lunarcore.command.commands;

// 导入相关类的声明
import emu.lunarcore.GameConstants;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.data.GameData;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.enums.ItemMainType;
import emu.lunarcore.game.inventory.GameItem;
import emu.lunarcore.game.inventory.GameItemSubAffix;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.server.packet.send.PacketPlayerSyncScNotify;
import emu.lunarcore.util.FileUtils;
import emu.lunarcore.util.JsonUtils;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Command(
    label = "json",
    permission = "player.json",
    requireTarget = true,
    desc = "/json 从 Various_Artists-data.json 导入数据"
)
public class JsonImport implements CommandHandler {
    @Override
    public void execute(CommandArgs args) {
        var player = args.getTarget();
        var data = JsonUtils.decode(new String(FileUtils.read("./ASL/Various_Artists-data.json"), StandardCharsets.UTF_8), JsonData.class);
        if (data == null) {
            player.sendMessage("Various_Artists-data.json 未找到或损坏。请确保您已将 JSON 文件放入“ASL”文件夹中。");
            return;
        }

        // 清空背包中的遗物和光锥
        JsonImport.clearInventory(player);

        if(Objects.equals(args.get(0), "clear")) {
            player.sendMessage("成功清空背包");
            return;
        }
        
        // 设置角色
        var changed = new LinkedList<GameAvatar>();
        
        // 添加玩家没有的角色
        for (var newAvatar: data.avatars.values()) {
            var avatar = player.getAvatarById(newAvatar.avatar_id); // 修改这一行
            if (avatar == null) {
                var excel = GameData.getAvatarExcelMap().get(newAvatar.avatar_id);
                if(excel == null) {
                    args.sendMessage("ID为 " + newAvatar.avatar_id + " 的角色在excel中未找到 ");
                    continue;
                }
                avatar = new GameAvatar(excel);
                if(avatar.getExcel() == null) continue;
                player.addAvatar(avatar);
            }
        }

        // 设置角色属性
        for (var newAvatar: data.avatars.values()) {
            var avatar = player.getAvatarById(newAvatar.avatar_id); // 修改这一行
            if (avatar == null) continue;
            avatar.setLevel(newAvatar.level);
            avatar.setRank(newAvatar.data.rank);
            avatar.setPromotion(newAvatar.promotion);
            avatar.getSkills().clear();
            for (var entry: newAvatar.data.skills.entrySet()) {
                avatar.getSkills().put(entry.getKey(), entry.getValue());
            }
            avatar.save();
            changed.push(avatar);
        }

        // 添加新的遗物
        for (var relic: data.relics) {
            var item = new GameItem(relic.relic_id);
            if(item.getExcel() == null) continue;
            item.setLevel(relic.level);
            item.setMainAffix(relic.main_affix_id);
            item.resetSubAffixes();
        
            for (var newSubAffix: relic.sub_affixes) {
                var excel = GameData.getRelicSubAffixExcel(item.getExcel().getRarityNum(), newSubAffix.sub_affix_id);
                if(excel == null) {
                    continue;
                }
                var subAffix = new GameItemSubAffix(excel);
                subAffix.setCount(newSubAffix.count);
                subAffix.setStep(newSubAffix.step);
                item.getSubAffixes().add(subAffix);
            }
        
            player.getInventory().addItem(item);
        
            var avatar = player.getAvatarById(relic.equip_avatar); // 修改这一行
            if(avatar != null) {
                avatar.equipItem(item);
            }
        }

        // 添加新的光锥
        for (var lightcone: data.lightcones ) {
            var item = new GameItem(lightcone.item_id);
            if(item.getExcel() == null) continue;
            item.setLevel(lightcone.level);
            item.setRank(lightcone.rank);
            item.setPromotion(lightcone.promotion);
            
            player.getInventory().addItem(item);
            
            var avatar = player.getAvatarById(lightcone.equip_avatar); // 修改这一行
            if(avatar != null) {
                avatar.equipItem(item);
            }
        }
        
        player.sendMessage("成功从 Various_Artists-data.json 导入数据");
    }
    
    static void clearInventory(Player player) {
        var toRemove = new LinkedList<GameItem>();
        for (var item: player.getInventory().getItems().values()) {
            if(item.getItemMainType() != ItemMainType.Equipment && item.getItemMainType() != ItemMainType.Relic) {
                continue;
            }

            if(item.isEquipped()) {
                player
                    .getAvatarById(item.getEquipAvatarId())
                    .unequipItem(item.getItemMainType() == ItemMainType.Equipment ? GameConstants.EQUIPMENT_SLOT_ID : item.getEquipSlot());
            }

            toRemove.push(item);
        }
        player.getInventory().removeItems(toRemove);
    }
}

// JsonData 类
class JsonData {
    public List<RelicJson> relics; // 遗物列表
    public List<LightconeJson> lightcones; // 光锥列表
    public Map<Integer, AvatarJson> avatars; // 角色映射
    
    // 遗物 JSON 数据类
    static class RelicJson {
        public int level;
        public int relic_id;
        public int relic_set_id;
        public int main_affix_id;
        public int internal_uid;
        public int equip_avatar;
        public List<RelicSubAffixData> sub_affixes;
        
        // 遗物子词缀数据类
        static class RelicSubAffixData {
            public int sub_affix_id;
            public int count;
            public int step;
        }
    }
    
    // 光锥 JSON 数据类
    static class LightconeJson {
        public int level;
        public int internal_uid;
        public int equip_avatar;
        public int item_id;
        public int rank;
        public int promotion;
    }
    
    // 角色 JSON 数据类
    static class AvatarJson {
        public int avatar_id;
        public int level;
        public int promotion;
        public AvatarJsonExtraData data;
        
        // 角色额外数据类
        static class AvatarJsonExtraData {
            public int rank;
            public Map<Integer, Integer> skills;
        }
    }
    
    // 获取角色的提升等级
    public static int getPromotion(int level) {
        return  level > 80 ?
            6 :
            (int) (level <= 20
                ? 0 :
                Math.ceil((double) level / 10) - 2);
    }
}
