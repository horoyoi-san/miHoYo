package emu.lunarcore.game.challenge;

import emu.lunarcore.LunarCore;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.GameDepot;
import emu.lunarcore.data.common.ItemParam;
import emu.lunarcore.data.excel.ChallengeExcel;
import emu.lunarcore.data.excel.ChallengeGroupExcel;
import emu.lunarcore.data.excel.ChallengeRewardExcel;
import emu.lunarcore.data.excel.RewardExcel;
import emu.lunarcore.game.challenge.ChallengeGroupReward;
import emu.lunarcore.game.challenge.ChallengeHistory;
import emu.lunarcore.game.challenge.ChallengeInstance;
import emu.lunarcore.game.challenge.ChallengeNodeData;
import emu.lunarcore.game.enums.ChallengeType;
import emu.lunarcore.game.player.BasePlayerManager;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.game.player.lineup.PlayerLineup;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.proto.ExtraLineupTypeOuterClass;
import emu.lunarcore.proto.StartChallengeBossBuffInfoOuterClass;
import emu.lunarcore.proto.StartChallengeStoryBuffInfoOuterClass;
import emu.lunarcore.proto.TakenChallengeRewardInfoOuterClass;
import emu.lunarcore.server.packet.Retcode;
import emu.lunarcore.server.packet.send.PacketStartChallengeScRsp;
import emu.lunarcore.server.packet.send.PacketStartPartialChallengeScRsp;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ChallengeManager
extends BasePlayerManager {
    private Int2ObjectMap<ChallengeHistory> history = new Int2ObjectOpenHashMap<ChallengeHistory>();
    private Int2ObjectMap<ChallengeGroupReward> takenRewards = new Int2ObjectOpenHashMap<ChallengeGroupReward>();

    public ChallengeManager(Player player) {
        super(player);
    }

    public void startPartialChallenge(int challengeId, int buffId, boolean isFirstHalf) {
    int subGroupId;
    ChallengeHistory challengeHistory = (ChallengeHistory)this.history.get(challengeId);
    ChallengeExcel excel = (ChallengeExcel)GameData.getChallengeExcelMap().get(challengeId);
    if (challengeHistory == null || excel == null) {
        this.getPlayer().sendPacket(new PacketStartPartialChallengeScRsp());
        return;
    }
    IntSet avatars = isFirstHalf ? challengeHistory.getFirstNodeData().getAvatarIds() : challengeHistory.getSecondNodeData().getAvatarIds();
    ExtraLineupTypeOuterClass.ExtraLineupType extraLineupType = isFirstHalf ? ExtraLineupTypeOuterClass.ExtraLineupType.LINEUP_CHALLENGE : ExtraLineupTypeOuterClass.ExtraLineupType.LINEUP_CHALLENGE_2;
    int mapEntranceId = isFirstHalf ? excel.getMapEntranceID() : excel.getMapEntranceID2();
    int groupId = isFirstHalf ? excel.getMazeGroupID1() : excel.getMazeGroupID2();
    int n = subGroupId = isFirstHalf ? excel.getMazeGroupID2() : excel.getMazeGroupID1();
    if (avatars.isEmpty()) {
        this.getPlayer().sendPacket(new PacketStartPartialChallengeScRsp());
        return;
    }
    this.getPlayer().getLineupManager().replaceLineup(0, extraLineupType.getNumber(), avatars.stream().toList());
    final PlayerLineup lineup = this.getPlayer().getLineupManager().getExtraLineupByType(extraLineupType.getNumber());
    this.getPlayer().getLineupManager().setCurrentExtraLineup(extraLineupType, false);
    lineup.forEachAvatar(avatar -> {
        avatar.setCurrentHp(lineup, 10000);
        avatar.setCurrentSp(lineup, avatar.getMaxSp() / 2);
    });
    lineup.setMp(5);
    ChallengeInstance instance = new ChallengeInstance(this.getPlayer(), excel);
    this.getPlayer().setChallengeInstance(instance);
    instance.setPartialChallenge(true);
    instance.setCurrentExtraLineup(extraLineupType);
    boolean success = this.getPlayer().enterScene(mapEntranceId, 0, false);
    if (!success) {
        this.getPlayer().getLineupManager().setCurrentExtraLineup(0, false);
        this.getPlayer().setChallengeInstance(null);
        this.getPlayer().sendPacket(new PacketStartPartialChallengeScRsp());
        return;
    }
    this.getPlayer().getScene().getEntitiesByGroup(EntityMonster.class, subGroupId).forEach(e -> this.getPlayer().getScene().removeEntity((GameEntity)e));
    instance.setCurrentStage(isFirstHalf ? 1 : 2);
    this.getPlayer().getScene().loadGroup(groupId);
    instance.getStartPos().set(this.getPlayer().getPos());
    instance.getStartRot().set(this.getPlayer().getRot());
    instance.setSavedMp(this.getPlayer().getCurrentLineup().getMp());
    instance.addBuff(buffId);
    this.getPlayer().sendPacket(new PacketStartPartialChallengeScRsp(instance, lineup, this.getPlayer().getScene()));
}

public void startChallenge(int challengeId, StartChallengeStoryBuffInfoOuterClass.StartChallengeStoryBuffInfo storyBuffs, StartChallengeBossBuffInfoOuterClass.StartChallengeBossBuffInfo bossBuffs, List<Integer> firstLineups, List<Integer> secondLineups) {
    PlayerLineup lineup;
    ChallengeExcel excel = (ChallengeExcel)GameData.getChallengeExcelMap().get(challengeId);
    if (excel == null) {
        this.getPlayer().sendPacket(new PacketStartChallengeScRsp(Retcode.CHALLENGE_NOT_EXIST));
        return;
    }
    this.getPlayer().getLineupManager().replaceLineup(0, 1, firstLineups);
    this.getPlayer().getLineupManager().replaceLineup(0, 3, secondLineups);
    if (excel.getStageNum() >= 1) {
        final PlayerLineup lineup1 = this.getPlayer().getLineupManager().getExtraLineupByType(1);
        if (lineup1.getAvatars().size() == 0) {
            this.getPlayer().sendPacket(new PacketStartChallengeScRsp(Retcode.CHALLENGE_LINEUP_EMPTY));
            return;
        }
        lineup1.forEachAvatar(avatar -> {
            avatar.setCurrentHp(lineup1, 10000);
            avatar.setCurrentSp(lineup1, avatar.getMaxSp() / 2);
        });
        lineup1.setMp(5);
    }
    if (excel.getStageNum() >= 2) {
        final PlayerLineup lineup2 = this.getPlayer().getLineupManager().getExtraLineupByType(3);
        if (lineup2.getAvatars().size() == 0) {
            this.getPlayer().sendPacket(new PacketStartChallengeScRsp(Retcode.CHALLENGE_LINEUP_EMPTY));
            return;
        }
        lineup2.forEachAvatar(avatar -> {
            avatar.setCurrentHp(lineup2, 10000);
            avatar.setCurrentSp(lineup2, avatar.getMaxSp() / 2);
        });
        lineup2.setMp(5);
    }
    ChallengeInstance instance = new ChallengeInstance(this.getPlayer(), excel);
    this.getPlayer().setChallengeInstance(instance);
    this.getPlayer().getLineupManager().setCurrentExtraLineup(instance.getCurrentExtraLineup(), false);
    boolean success = this.getPlayer().enterScene(excel.getMapEntranceID(), 0, false);
    if (!success) {
        this.getPlayer().getLineupManager().setCurrentExtraLineup(0, false);
        this.getPlayer().setChallengeInstance(null);
        this.getPlayer().sendPacket(new PacketStartChallengeScRsp(Retcode.CHALLENGE_NOT_EXIST));
        return;
    }
    instance.getStartPos().set(this.getPlayer().getPos());
    instance.getStartRot().set(this.getPlayer().getRot());
    instance.setSavedMp(this.getPlayer().getCurrentLineup().getMp());
    if (excel.getType() == ChallengeType.Story && storyBuffs != null) {
        instance.addBuff(storyBuffs.getBuffOne());
        instance.addBuff(storyBuffs.getBuffTwo());
    }
    if (bossBuffs != null) {
        instance.addBuff(bossBuffs.getBuffOne());
        instance.addBuff(bossBuffs.getBuffTwo());
    }
    this.getPlayer().sendPacket(new PacketStartChallengeScRsp(this.getPlayer(), challengeId));
}


    public synchronized void addHistory(ChallengeInstance instance) {
        if (instance.isPartialChallenge()) {
            return;
        }
        int challengeId = instance.getExcel().getId();
        int stars = instance.getStars();
        int score1 = instance.getScoreStage1();
        int score2 = instance.getScoreStage2();
        List<Integer> firstLineup = this.getPlayer().getLineupManager().getExtraLineupByType(1).getAvatars();
        List<Integer> secondLineup = this.getPlayer().getLineupManager().getExtraLineupByType(3).getAvatars();
        if (stars <= 0) {
            return;
        }
        ChallengeHistory info = this.getHistory().computeIfAbsent(challengeId, id -> new ChallengeHistory(this.getPlayer(), id));
        info.setStars(stars);
        info.setScore(score1, score2);
        info.setGroupId(instance.getExcel().getGroupID());
        info.setFirstNodeData(new ChallengeNodeData(instance.getExcel().getType(), 1, instance.getBuffs(), instance.getScoreStage1(), firstLineup));
        info.setSecondNodeData(new ChallengeNodeData(instance.getExcel().getType(), 2, instance.getBuffs(), instance.getScoreStage2(), secondLineup));
        info.save();
    }

    public synchronized List<TakenChallengeRewardInfoOuterClass.TakenChallengeRewardInfo> takeRewards(int groupId) {
    ChallengeGroupExcel challengeGroup = (ChallengeGroupExcel)GameData.getChallengeGroupExcelMap().get(groupId);
    if (challengeGroup == null) {
        return null;
    }
    List<ChallengeRewardExcel> challengeRewardLine = (List<ChallengeRewardExcel>)GameDepot.getChallengeRewardLines().get(challengeGroup.getRewardLineGroupID());
    if (challengeRewardLine == null) {
        return null;
    }
    int totalStars = 0;
    for (ChallengeHistory ch : this.getHistory().values()) {
        if (ch.getGroupId() == 0) {
            ChallengeExcel challengeExcel = (ChallengeExcel)GameData.getChallengeExcelMap().get(ch.getChallengeId());
            if (challengeExcel == null) continue;
            ch.setGroupId(challengeExcel.getGroupID());
            ch.save();
        }
        if (ch.getGroupId() != groupId) continue;
        totalStars += ch.getTotalStars();
    }
    ArrayList<TakenChallengeRewardInfoOuterClass.TakenChallengeRewardInfo> rewardInfos = new ArrayList<TakenChallengeRewardInfoOuterClass.TakenChallengeRewardInfo>();
    ArrayList<ItemParam> rewardItems = new ArrayList<ItemParam>();
    for (ChallengeRewardExcel challengeReward : challengeRewardLine) {
        ChallengeGroupReward reward;
        if (totalStars < challengeReward.getStarCount() || (reward = this.getTakenRewards().computeIfAbsent(groupId, id -> new ChallengeGroupReward(this.getPlayer(), groupId))).hasTakenReward(challengeReward.getStarCount())) continue;
        reward.setTakenReward(challengeReward.getStarCount());
        RewardExcel rewardExcel = (RewardExcel)GameData.getRewardExcelMap().get(challengeReward.getRewardID());
        if (rewardExcel == null) continue;
        TakenChallengeRewardInfoOuterClass.TakenChallengeRewardInfo proto = TakenChallengeRewardInfoOuterClass.TakenChallengeRewardInfo.newInstance().setStarCount(challengeReward.getStarCount());
        for (ItemParam itemParam : rewardExcel.getRewards()) {
            proto.getMutableReward().addItemList(itemParam.toProto());
            rewardItems.add(itemParam);
        }
        rewardInfos.add(proto);
    }
    this.getPlayer().getInventory().addItemParams(rewardItems);
    return rewardInfos;
    }


    public void loadFromDatabase() {
        Stream<ChallengeHistory> stream = LunarCore.getGameDatabase().getObjects(ChallengeHistory.class, "ownerUid", this.getPlayer().getUid());
        stream.forEach(info -> this.getHistory().put(info.getChallengeId(), (ChallengeHistory)info));
        Stream<ChallengeGroupReward> stream2 = LunarCore.getGameDatabase().getObjects(ChallengeGroupReward.class, "ownerUid", this.getPlayer().getUid());
        stream2.forEach(info -> this.getTakenRewards().put(info.getGroupId(), (ChallengeGroupReward)info));
    }

    public Int2ObjectMap<ChallengeHistory> getHistory() {
        return this.history;
    }

    public Int2ObjectMap<ChallengeGroupReward> getTakenRewards() {
        return this.takenRewards;
    }
}