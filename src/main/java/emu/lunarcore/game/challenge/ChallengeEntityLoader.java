package emu.lunarcore.game.challenge;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.config.GroupInfo;
import emu.lunarcore.data.config.MonsterInfo;
import emu.lunarcore.data.config.NpcInfo;
import emu.lunarcore.data.excel.ChallengeExcel;
import emu.lunarcore.data.excel.NpcMonsterExcel;
import emu.lunarcore.game.enums.ChallengeType;
import emu.lunarcore.game.scene.Scene;
import emu.lunarcore.game.scene.SceneEntityLoader;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.game.scene.entity.EntityNpc;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;

public class ChallengeEntityLoader extends SceneEntityLoader {
   public void onSceneLoad(Scene scene) {
      ChallengeInstance instance = scene.getPlayer().getChallengeInstance();
      if (instance != null) {
         scene.loadGroup(instance.getExcel().getMazeGroupID1());
         scene.setLeaveEntryId(instance.getExcel().getType() == ChallengeType.Story ? 102020107 : (instance.getExcel().getType() == ChallengeType.Boss ? 1030402 : 100000103));
         ObjectIterator var3 = scene.getFloorInfo().getGroups().values().iterator();

         while(var3.hasNext()) {
            GroupInfo group = (GroupInfo)var3.next();
            if (group.getLoadSide() == GroupInfo.GroupLoadSide.Server && group.getPropList().size() > 0 && group.getMonsterList().size() == 0) {
               scene.loadGroup(group);
            }
         }

      }
   }

   public EntityMonster loadMonster(Scene scene, GroupInfo group, MonsterInfo monsterInfo) {
      ChallengeInstance instance = scene.getPlayer().getChallengeInstance();
      if (instance == null) {
         return null;
      } else {
         Int2ObjectMap<ChallengeExcel.ChallengeMonsterInfo> challengeMonsters = null;
         if (instance.getCurrentStage() == 1) {
            challengeMonsters = instance.getExcel().getChallengeMonsters1();
         } else {
            if (instance.getCurrentStage() != 2) {
               return null;
            }

            challengeMonsters = instance.getExcel().getChallengeMonsters2();
         }

         ChallengeExcel.ChallengeMonsterInfo challengeMonsterInfo = (ChallengeExcel.ChallengeMonsterInfo)challengeMonsters.get(monsterInfo.getID());
         if (challengeMonsterInfo == null) {
            return null;
         } else {
            NpcMonsterExcel npcMonsterExcel = (NpcMonsterExcel)GameData.getNpcMonsterExcelMap().get(challengeMonsterInfo.getNpcMonsterId());
            if (npcMonsterExcel == null) {
               return null;
            } else {
               EntityMonster monster = new EntityMonster(scene, npcMonsterExcel, group, monsterInfo);
               monster.setEventId(challengeMonsterInfo.getEventId());
               monster.setCustomStage(challengeMonsterInfo.getEventId());
               monster.setWorldLevel(scene.getPlayer().getWorldLevel());
               return monster;
            }
         }
      }
   }

   public EntityNpc loadNpc(Scene scene, GroupInfo group, NpcInfo npcInfo) {
      return null;
   }
}
