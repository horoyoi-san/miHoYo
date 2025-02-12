package emu.lunarcore.command.commands;

import java.util.Comparator;
import java.util.Set;

import emu.lunarcore.LunarCore;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.config.GroupInfo;
import emu.lunarcore.data.config.MonsterInfo;
import emu.lunarcore.data.config.PropInfo;
import emu.lunarcore.data.excel.NpcMonsterExcel;
import emu.lunarcore.data.excel.PropExcel;
import emu.lunarcore.data.excel.StageExcel;
import emu.lunarcore.game.battle.BattleStage;
import emu.lunarcore.game.battle.CustomBattleStage;
import emu.lunarcore.game.enums.PropState;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.game.scene.entity.EntityProp;
import emu.lunarcore.util.Position;
import emu.lunarcore.util.Utils;

@Command(label = "spawn", aliases = {"s"}, permission = "player.spawn", requireTarget = true, desc = "/spawn [npc 怪物 id/道具 id] s[舞台 id] x[数量] lv[等级] r[半径] <战斗怪物 ids...>. 在目标玩家附近生成一个怪物或道具")
public class SpawnCommand implements CommandHandler {
    private static final Set<String> SEPARATORS = Set.of("/", "|", "\\");
    private int baseNpcMonsterId;
    private int baseStageId;
    
    @Override
    public void execute(CommandArgs args) {
        Player target = args.getTarget();
        
        if (target.getScene() == null) {
            args.sendMessage("错误：目标不在场景中");
            return;
        }
        
        
        // Set spawn id
        String spawnId = args.get(0);
        int id = 0;
        if (spawnId.equalsIgnoreCase("monster")) {
            id = this.getBaseNpcMonsterId();
        } else {
            id = Utils.parseSafeInt(spawnId);
        }
        
        // Get args
        int stageId = args.getStage();
        int amount = Math.max(args.getAmount(), 1);
        int radius = Math.max(args.getRank(), 5) * 1000;
        
        // Enforce scene max entity limit
        if (target.getScene().getEntities().size() + amount >= LunarCore.getConfig().getServerOptions().getSceneMaxEntites()) {
            args.sendMessage("错误：场景中实体数量已达上限");
            return;
        }
        
        // Spawn monster
        NpcMonsterExcel monsterExcel = GameData.getNpcMonsterExcelMap().get(id);
        if (monsterExcel != null) {
            // Calculate stage
            BattleStage stage = null;
            if (stageId > 0) {
                // Set user specified stage
                stage = GameData.getStageExcelMap().get(stageId);
            } else if (args.getList().size() <= 1) {
                // Get first stage in the excel table
                stage = GameData.getStageExcelMap().get(this.getBaseStageId());
            } else {
                // Build custom stage
                var customStage = new CustomBattleStage(this.getBaseStageId());
                boolean startNewWave = false;
                
                // Parse extra monster id args
                for (int i = 1; i < args.getList().size(); i++) {
                    String arg = args.get(i);
                    
                    if (SEPARATORS.contains(arg)) {
                        // Wave separator
                        startNewWave = true;
                    } else {
                        // Add monster to wave
                        int monster = Utils.parseSafeInt(arg);
                        
                        if (GameData.getMonsterExcelMap().containsKey(monster)) {
                            customStage.addMonster(monster, startNewWave);
                        }
                        
                        // Reset
                        startNewWave = false;
                    }
                }
                
                // Set stage
                if (customStage.getMonsterWaves().size() > 0) {
                    stage = customStage;
                }
            }
            
            if (stage == null) {
                args.sendMessage("错误：未设置舞台或怪物波次");
                return;
            }
            
            // Get first monster config from floor info that isnt a boss monster
            GroupInfo groupInfo = null;
            MonsterInfo monsterInfo = null;
            
            for (var group : target.getScene().getFloorInfo().getGroups().values()) {
                if (group.getMonsterList().size() == 0) continue;
                
                for (var m : group.getMonsterList()) {
                    if (m.getFarmElementID() == 0) {
                        groupInfo = group;
                        monsterInfo = m;
                        break;
                    }
                }
                
                if (monsterInfo != null) break;
            }
            
            if (monsterInfo == null || groupInfo == null) {
                args.sendMessage("错误：在此场景中未找到现有的怪物配置");
                return;
            }
            
            // Spawn monster
            for (int i = 0; i < amount; i++) {
                Position pos = target.getPos().clone().add(Utils.randomRange(-radius, radius), 0, Utils.randomRange(-radius, radius));
                EntityMonster monster = new EntityMonster(target.getScene(), monsterExcel, groupInfo, monsterInfo);
                monster.getPos().set(pos);
                monster.setEventId(monsterInfo.getEventID());
                monster.setCustomStage(stage);
                
                if (args.getLevel() > 0) {
                    monster.setCustomLevel(Math.min(args.getLevel(), 100));
                }
                
                target.getScene().addEntity(monster, true);
            }
            
            // Send message when done
            args.sendMessage("Spawning " + amount + " monsters");
            return;
        }
        
        PropExcel propExcel = GameData.getPropExcelMap().get(id);
        if (propExcel != null) {
            // Get first prop config from floor info
            GroupInfo groupInfo = null;
            PropInfo propInfo = null;
            
            for (var group : target.getScene().getFloorInfo().getGroups().values()) {
                if (group.getPropList().size() == 0) continue;
                
                for (var p : group.getPropList()) {
                    if (p.getFarmElementID() == 0 && p.getAnchorID() == 0 && p.getCocoonID() == 0) {
                        groupInfo = group;
                        propInfo = p;
                        break;
                    }
                }
                
                if (propInfo != null) break;
            }
            
            if (propInfo == null || groupInfo == null) {
                args.sendMessage("错误：在此场景中未找到现有的道具配置");
                return;
            }
            
            // Spawn props
            for (int i = 0; i < amount; i++) {
                Position pos = target.getPos().clone().add(Utils.randomRange(-radius, radius), 0, Utils.randomRange(-radius, radius));
                EntityProp prop = new EntityProp(target.getScene(), propExcel, groupInfo, propInfo);
                prop.getPos().set(pos);
                prop.getRot().set(0, 0, 0);
                prop.setState(PropState.Open);
                
                target.getScene().addEntity(prop, true);
            }
            
            // Send message when done
            args.sendMessage("Spawning " + amount + " props");
            return;
        }

        args.sendMessage("错误：无效的ID");
    }

    private int getBaseNpcMonsterId() {
        if (this.baseNpcMonsterId == 0) {
            var excel = GameData.getNpcMonsterExcelMap().values().stream().min(Comparator.comparing(NpcMonsterExcel::getId)).orElseGet(null);
            if (excel != null) {
                this.baseNpcMonsterId = excel.getId();
            }
        }
        
        return this.baseNpcMonsterId;
    }
    
    private int getBaseStageId() {
        if (this.baseStageId == 0) {
            var excel = GameData.getStageExcelMap().values().stream().min(Comparator.comparing(StageExcel::getId)).orElseGet(null);
            if (excel != null) {
                this.baseStageId = excel.getId();
            }
        }
        
        return this.baseStageId;
    }
}
