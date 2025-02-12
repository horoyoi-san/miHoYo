package emu.lunarcore.game.challenge;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import emu.lunarcore.LunarCore;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.challenge.ChallengeNodeData;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.ChallengeBossInfoOuterClass;
import emu.lunarcore.proto.ChallengeOuterClass;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.bson.types.ObjectId;

@Entity(value="challenge", useDiscriminator=false)
public class ChallengeHistory {
    @Id
    private ObjectId id;
    @Indexed
    private int ownerUid;
    private int challengeId;
    private int groupId;
    private int takenReward;
    private int stars;
    private IntList scores;
    private ChallengeNodeData firstNodeData;
    private ChallengeNodeData secondNodeData;

    @Deprecated
    public ChallengeHistory() {
    }

    public ChallengeHistory(Player player, int challengeId) {
        this.ownerUid = player.getUid();
        this.challengeId = challengeId;
    }

    public void setStars(int stars) {
        this.stars = Math.max(this.stars, stars);
    }

    public int getTotalStars() {
        int total = 0;
        for (int i = 0; i < 3; ++i) {
            total += (this.stars & 1 << i) != 0 ? 1 : 0;
        }
        return total;
    }

    public void setScore(int score1, int score2) {
        if (this.scores == null) {
            this.scores = new IntArrayList();
        }
        this.scores.clear();
        this.scores.add(score1);
        this.scores.add(score2);
    }

    private int getScoreSafe(int index) {
        try {
            return this.getScores().getInt(index);
        } catch (Exception ex) {
            return 0;
        }
    }

    public ChallengeOuterClass.Challenge toProto(Player player) {
        ChallengeOuterClass.Challenge proto = ChallengeOuterClass.Challenge.newInstance().setChallengeId(this.getChallengeId()).setTakenReward(this.getTakenReward()).setScore(this.getScoreSafe(0)).setScoreTwo(this.getScoreSafe(1)).setStars(this.getStars());
        ChallengeBossInfoOuterClass.ChallengeBossInfo info = proto.getMutableExtInfo().getMutableBossInfo();
        if (this.getFirstNodeData() != null && this.getSecondNodeData() != null) {
            GameAvatar avatar;
            info.setCPNMHNAFDJM(true);
            for (Integer avatarId : this.getFirstNodeData().getAvatarIds()) {
                avatar = player.getAvatarById(avatarId);
                if (avatar == null) continue;
                info.addLineup1(avatar.getAvatarId());
                info.addAllRelics(ChallengeBossInfoOuterClass.ChallengeBossInfo.RelicsEntry.newInstance().setKey(avatar.getAvatarId()));
                info.addEquipments(ChallengeBossInfoOuterClass.ChallengeBossInfo.EquipmentsEntry.newInstance().setKey(avatar.getAvatarId()));
            }
            for (Integer avatarId : this.getSecondNodeData().getAvatarIds()) {
                avatar = player.getAvatarById(avatarId);
                if (avatar == null) continue;
                info.addLineup2(avatar.getAvatarId());
                info.addAllRelics(ChallengeBossInfoOuterClass.ChallengeBossInfo.RelicsEntry.newInstance().setKey(avatar.getAvatarId()));
                info.addEquipments(ChallengeBossInfoOuterClass.ChallengeBossInfo.EquipmentsEntry.newInstance().setKey(avatar.getAvatarId()));
            }
            info.getMutableFirstNode().setBuffId(this.getFirstNodeData().getBuffId()).setHGIDJHFNCMA(true).setIsWin(true).setStageScore(this.getFirstNodeData().getStageScore());
            info.getMutableSecondNode().setBuffId(this.getSecondNodeData().getBuffId()).setHGIDJHFNCMA(true).setIsWin(true).setStageScore(this.getSecondNodeData().getStageScore());
        } else {
            info.getMutableFirstNode();
            info.getMutableSecondNode();
        }
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

    public int getChallengeId() {
        return this.challengeId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getTakenReward() {
        return this.takenReward;
    }

    public int getStars() {
        return this.stars;
    }

    public IntList getScores() {
        return this.scores;
    }

    public ChallengeNodeData getFirstNodeData() {
        return this.firstNodeData;
    }

    public ChallengeNodeData getSecondNodeData() {
        return this.secondNodeData;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setOwnerUid(int ownerUid) {
        this.ownerUid = ownerUid;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public void setTakenReward(int takenReward) {
        this.takenReward = takenReward;
    }

    public void setScores(IntList scores) {
        this.scores = scores;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setFirstNodeData(ChallengeNodeData firstNodeData) {
        this.firstNodeData = firstNodeData;
    }

    public void setSecondNodeData(ChallengeNodeData secondNodeData) {
        this.secondNodeData = secondNodeData;
    }
}