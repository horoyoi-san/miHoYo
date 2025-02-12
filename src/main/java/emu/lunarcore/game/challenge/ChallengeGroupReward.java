package emu.lunarcore.game.challenge;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import emu.lunarcore.LunarCore;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.ChallengeRewardOuterClass.ChallengeReward;
import org.bson.types.ObjectId;

@Entity(
   value = "challengeReward",
   useDiscriminator = false
)
public class ChallengeGroupReward {
   @Id
   private ObjectId id;
   @Indexed
   private int ownerUid;
   private int groupId;
   private long takenStars;

   /** @deprecated */
   @Deprecated
   public ChallengeGroupReward() {
   }

   public ChallengeGroupReward(Player player, int groupId) {
      this.ownerUid = player.getUid();
      this.groupId = groupId;
   }

   public boolean hasTakenReward(int starCount) {
      return (this.takenStars & 1L << starCount) != 0L;
   }

   public void setTakenReward(int starCount) {
      this.takenStars |= 1L << starCount;
      this.save();
   }

   public ChallengeReward toProto() {
      ChallengeReward proto = ChallengeReward.newInstance().setGroupId(this.getGroupId()).setTakenChallengeReward(this.getTakenStars());
      return proto;
   }

   public void delete() {
      LunarCore.getGameDatabase().delete(this);
   }

   public void save() {
      LunarCore.getGameDatabase().save(this);
   }

   public ObjectId getId() {
      return this.id;
   }

   public int getOwnerUid() {
      return this.ownerUid;
   }

   public int getGroupId() {
      return this.groupId;
   }

   public long getTakenStars() {
      return this.takenStars;
   }
}
