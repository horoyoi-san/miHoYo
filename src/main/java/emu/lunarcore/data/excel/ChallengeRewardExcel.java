package emu.lunarcore.data.excel;

import emu.lunarcore.data.GameDepot;
import emu.lunarcore.data.GameResource;
import emu.lunarcore.data.ResourceType;
import java.util.ArrayList;
import java.util.List;

@ResourceType(
   name = {"ChallengeMazeRewardLine.json", "ChallengeStoryRewardLine.json"},
   loadPriority = ResourceType.LoadPriority.LOW
)
public class ChallengeRewardExcel extends GameResource {
   private int GroupID;
   private int StarCount;
   private int RewardID;

   public int getId() {
      return (this.GroupID << 16) + this.StarCount;
   }

   public void onLoad() {
      List<ChallengeRewardExcel> rewardLine = (List)GameDepot.getChallengeRewardLines().computeIfAbsent(this.GroupID, (id) -> {
         return new ArrayList();
      });
      rewardLine.add(this);
   }

   public int getGroupID() {
      return this.GroupID;
   }

   public int getStarCount() {
      return this.StarCount;
   }

   public int getRewardID() {
      return this.RewardID;
   }
}
