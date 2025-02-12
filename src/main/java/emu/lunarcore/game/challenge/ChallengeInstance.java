package emu.lunarcore.game.challenge;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.ChallengeExcel;
import emu.lunarcore.data.excel.ChallengeTargetExcel;
import emu.lunarcore.game.battle.Battle;
import emu.lunarcore.game.enums.ChallengeType;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.game.player.lineup.PlayerLineup;
import emu.lunarcore.game.scene.Scene;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.proto.BattleEndReasonOuterClass;
import emu.lunarcore.proto.BattleEndStatusOuterClass;
import emu.lunarcore.proto.BattleStatisticsOuterClass;
import emu.lunarcore.proto.BattleTargetOuterClass;
import emu.lunarcore.proto.ChallengeInfoOuterClass;
import emu.lunarcore.proto.ChallengeStatusOuterClass;
import emu.lunarcore.proto.ExtraLineupTypeOuterClass;
import emu.lunarcore.server.packet.send.PacketChallengeBossPhaseSettleNotify;
import emu.lunarcore.server.packet.send.PacketChallengeLineupNotify;
import emu.lunarcore.server.packet.send.PacketChallengeSettleNotify;
import emu.lunarcore.server.packet.send.PacketEnterChallengeNextPhaseScRsp;
import emu.lunarcore.server.packet.send.PacketRestartChallengePhaseScRsp;
import emu.lunarcore.server.packet.send.PacketSyncLineupNotify;
import emu.lunarcore.util.Position;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;

@Entity(useDiscriminator=false)
public class ChallengeInstance {
    private transient Player player;
    private transient ChallengeExcel excel;
    private Position startPos;
    private Position startRot;
    private int challengeId;
    private int currentStage;
    private int currentBossStage;
    private int currentExtraLineup;
    private int status;
    private boolean hasAvatarDied;
    private int savedMp;
    private int roundsLeft;
    private int stars;
    private int scoreStage1;
    private int scoreStage2;
    @Transient
    private boolean isWin = false;
    @Transient
    private Int2ObjectMap<BattleTargetOuterClass.BattleTarget> battleTarget1;
    @Transient
    private Int2ObjectMap<BattleTargetOuterClass.BattleTarget> battleTarget2;
    private IntList buffs;
    @Transient
    private boolean isPartialChallenge;

    @Deprecated
    public ChallengeInstance() {
    }

    public ChallengeInstance(Player player, ChallengeExcel excel) {
        this.player = player;
        this.excel = excel;
        this.challengeId = excel.getId();
        this.startPos = new Position();
        this.startRot = new Position();
        this.currentStage = 1;
        this.currentBossStage = 1;
        this.roundsLeft = excel.getChallengeCountDown();
        this.setStatus(ChallengeStatusOuterClass.ChallengeStatus.CHALLENGE_DOING);
        this.setCurrentExtraLineup(ExtraLineupTypeOuterClass.ExtraLineupType.LINEUP_CHALLENGE);
        this.setBuffs(new IntArrayList());
    }

    private Scene getScene() {
        return this.getPlayer().getScene();
    }

    private void setStatus(ChallengeStatusOuterClass.ChallengeStatus status) {
        this.status = status.getNumber();
    }

    public void setCurrentExtraLineup(ExtraLineupTypeOuterClass.ExtraLineupType type2) {
        this.currentExtraLineup = type2.getNumber();
    }

    private int getRoundsElapsed() {
        return this.getExcel().getChallengeCountDown() - this.roundsLeft;
    }

    public int getTotalScore() {
        return this.scoreStage1 + this.scoreStage2;
    }

    public boolean isWin() {
        return this.status == 2;
    }

    public void addBuff(int buffId) {
        if (this.getBuffs() == null) {
            this.setBuffs(new IntArrayList());
        }
        this.getBuffs().add(buffId);
    }

    public void onBattleStart(Battle battle) {
        battle.setRoundsLimit(this.player.getChallengeInstance().getRoundsLeft());
        if (this.getBuffs() != null) {
            battle.addBuff(this.getExcel().getMazeBuffID());
            int index = this.getCurrentStage() - 1;
            if (this.getBuffs().size() < 2) {
                index = 0;
            }
            try {
                int buffId = this.getBuffs().getInt(index);
                if (buffId != 0) {
                    battle.addBuff(buffId);
                }
            } catch (Exception buffId) {
                // empty catch block
            }
        }
        if (this.excel.getType() == ChallengeType.Story) {
            battle.addBattleTarget(1, 10001, this.getTotalScore());
            IntListIterator intListIterator = this.getExcel().getStoryExcel().getBattleTargetID().iterator();
            while (intListIterator.hasNext()) {
                int id = (Integer)intListIterator.next();
                battle.addBattleTarget(5, id, this.getTotalScore());
            }
        } else if (this.excel.getType() == ChallengeType.Boss) {
            battle.addBattleTarget(1, 90004, 0);
            battle.addBattleTarget(1, 90005, 0);
        }
    }

    public void onBattleFinish(Battle battle, BattleEndStatusOuterClass.BattleEndStatus result2, BattleStatisticsOuterClass.BattleStatistics stats) {
        if (this.excel.getType() == ChallengeType.Story) {
            int stageScore = stats.getBattleScore() - this.getTotalScore();
            if (this.getCurrentStage() == 1) {
                this.scoreStage1 = stageScore;
            } else {
                this.scoreStage2 = stageScore;
            }
        }
        if (this.excel.getType() == ChallengeType.Boss) {
            int score = stats.getBattleScore();
            Int2ObjectOpenHashMap<BattleTargetOuterClass.BattleTarget> battleTargets = new Int2ObjectOpenHashMap<BattleTargetOuterClass.BattleTarget>();
            BattleStatisticsOuterClass.BattleStatistics.BattleTargetInfoEntry battleTargetInfo = (BattleStatisticsOuterClass.BattleStatistics.BattleTargetInfoEntry)stats.getBattleTargetInfo().get(0);
            if (battleTargetInfo != null) {
                score = 0;
                for (BattleTargetOuterClass.BattleTarget battleTarget : battleTargetInfo.getValue().getMutableBattleTargetList()) {
                    score += battleTarget.getProgress();
                    battleTargets.put(battleTarget.getId(), battleTarget);
                }
            }
            if (this.getCurrentStage() == 1) {
                this.scoreStage1 = score;
                this.battleTarget1 = battleTargets;
            } else {
                this.scoreStage2 = score;
                this.battleTarget2 = battleTargets;
            }
        }
        switch (result2) {
            case BATTLE_END_WIN: {
                battle.getLineup().forEachAvatar(avatar -> {
                    if (avatar.getCurrentHp(battle.getLineup()) <= 0) {
                        this.hasAvatarDied = true;
                    }
                });
                long monsters = this.player.getScene().getEntities().values().stream().filter(e -> e instanceof EntityMonster).count();
                if (monsters == 0L) {
                    this.advanceStage();
                }
                if (this.excel.getType() == ChallengeType.Memory) {
                    this.roundsLeft = Math.min(Math.max(this.roundsLeft - stats.getRoundCnt(), 1), this.roundsLeft);
                }
                this.savedMp = this.player.getCurrentLineup().getMp();
                this.isWin = true;
                break;
            }
            case BATTLE_END_QUIT: {
                if (this.excel.getType() == ChallengeType.Boss) {
                    this.quitBossBattle();
                    return;
                }
                PlayerLineup lineup = this.player.getCurrentLineup();
                lineup.setMp(this.savedMp);
                this.player.moveTo(this.getStartPos(), this.getStartRot());
                this.player.sendPacket(new PacketSyncLineupNotify(lineup));
                break;
            }
            default: {
                if (this.excel.getType() != ChallengeType.Memory && stats.getEndReason() == BattleEndReasonOuterClass.BattleEndReason.BATTLE_END_REASON_TURN_LIMIT) {
                    for (EntityMonster npcMonster : battle.getNpcMonsters()) {
                        this.getScene().removeEntity(npcMonster);
                    }
                    this.advanceStage();
                    break;
                }
                this.setStatus(ChallengeStatusOuterClass.ChallengeStatus.CHALLENGE_FAILED);
                this.player.sendPacket(new PacketChallengeSettleNotify(this));
            }
        }
    }

    public void enterNextPhase() {
        this.advanceStage();
    }

    public void restartChallenge() {
        PlayerLineup lineup = this.player.getCurrentLineup();
        lineup.forEachAvatar(avatar -> {
            avatar.setCurrentHp(lineup, 10000);
            avatar.setCurrentSp(lineup, avatar.getMaxSp() / 2);
        });
        lineup.setMp(5);
        this.player.sendPacket(new PacketSyncLineupNotify(lineup));
        this.savedMp = lineup.getMp();
        if (this.currentBossStage > 1) {
            --this.currentBossStage;
        }
        if (this.isWin) {
            this.player.getScene().loadGroup(this.currentStage == 1 ? this.excel.getMazeGroupID1() : this.excel.getMazeGroupID2());
        }
        this.player.sendPacket(new PacketRestartChallengePhaseScRsp(this.getScene().toProto()));
        this.player.getScene().syncLineup();
    }

    private void quitBossBattle() {
        this.player.sendPacket(new PacketChallengeBossPhaseSettleNotify(this));
    }

    private void advanceStage() {
        if (this.isPartialChallenge) {
            ++this.currentStage;
        }
        if (this.currentStage >= this.excel.getStageNum()) {
            this.setStatus(ChallengeStatusOuterClass.ChallengeStatus.CHALLENGE_FINISH);
            this.stars = this.calculateStars();
            this.player.getChallengeManager().addHistory(this);
            if (this.excel.getType() == ChallengeType.Boss) {
                this.player.sendPacket(new PacketChallengeBossPhaseSettleNotify(this));
            } else {
                this.player.sendPacket(new PacketChallengeSettleNotify(this));
            }
            return;
        }
        if (this.excel.getType() == ChallengeType.Boss && this.currentBossStage == 1) {
            this.stars = this.calculateStars();
            ++this.currentBossStage;
            this.player.sendPacket(new PacketChallengeBossPhaseSettleNotify(this));
            return;
        }
        ++this.currentStage;
        if (this.excel.getType() == ChallengeType.Boss && this.currentBossStage == 2) {
            this.setCurrentExtraLineup(ExtraLineupTypeOuterClass.ExtraLineupType.LINEUP_CHALLENGE_2);
            this.player.getLineupManager().setCurrentExtraLineup(this.getCurrentExtraLineup(), false);
            this.player.sendPacket(new PacketChallengeLineupNotify(this.getCurrentExtraLineup()));
            this.savedMp = this.player.getCurrentLineup().getMp();
            this.player.enterScene(this.excel.getMapEntranceID2(), 0, false);
            this.getScene().getEntitiesByGroup(EntityMonster.class, this.excel.getMazeGroupID1()).forEach(e -> this.getScene().removeEntity((GameEntity)e));
            this.getScene().loadGroup(this.excel.getMazeGroupID2());
            this.player.sendPacket(new PacketEnterChallengeNextPhaseScRsp(this.player.getScene().toProto()));
            this.getScene().syncLineup();
            return;
        }
        this.getScene().loadGroup(this.excel.getMazeGroupID2());
        this.setCurrentExtraLineup(ExtraLineupTypeOuterClass.ExtraLineupType.LINEUP_CHALLENGE_2);
        this.player.getLineupManager().setCurrentExtraLineup(this.getCurrentExtraLineup(), true);
        this.player.sendPacket(new PacketChallengeLineupNotify(this.getCurrentExtraLineup()));
        this.savedMp = this.player.getCurrentLineup().getMp();
        this.player.moveTo(this.getStartPos(), this.getStartRot());
    }

    public void onUpdate() {
        if (this.status != 1) {
            this.getPlayer().setChallengeInstance(null);
        }
    }

    public int calculateStars() {
        int[] targets = this.getExcel().getChallengeTargetID();
        int stars = 0;
        block5: for (int i = 0; i < targets.length; ++i) {
            ChallengeTargetExcel target = (ChallengeTargetExcel)GameData.getChallengeTargetExcelMap().get(targets[i]);
            if (target == null) continue;
            switch (target.getChallengeTargetType()) {
                case ROUNDS_LEFT: {
                    if (this.getRoundsLeft() < target.getChallengeTargetParam1()) continue block5;
                    stars += 1 << i;
                    continue block5;
                }
                case DEAD_AVATAR: {
                    if (this.hasAvatarDied) continue block5;
                    stars += 1 << i;
                    continue block5;
                }
                case TOTAL_SCORE: {
                    if (this.getTotalScore() < target.getChallengeTargetParam1()) continue block5;
                    stars += 1 << i;
                    continue block5;
                }
            }
        }
        return Math.min(stars, 7);
    }

    public boolean validate(Player player) {
        if (this.player == null) {
            this.player = player;
            this.player.getLineupManager().setCurrentExtraLineup(this.getCurrentExtraLineup(), false);
        }
        this.excel = (ChallengeExcel)GameData.getChallengeExcelMap().get(this.challengeId);
        return this.excel != null;
    }

    public ChallengeInfoOuterClass.ChallengeInfo toProto() {
        ChallengeInfoOuterClass.ChallengeInfo proto = ChallengeInfoOuterClass.ChallengeInfo.newInstance().setChallengeId(this.getExcel().getId()).setStatusValue(this.getStatus()).setScore(this.getScoreStage1()).setScoreTwo(this.getScoreStage2()).setRoundCount(this.getRoundsElapsed()).setExtraLineupTypeValue(this.getCurrentExtraLineup());
        if (this.getBuffs() != null) {
            for (Integer buffId : this.getBuffs()) {
                if (this.excel.getType() == ChallengeType.Story) {
                    proto.getMutableExtInfo().getMutableCurStoryBuffs().addBuffList(buffId);
                    continue;
                }
                proto.getMutableExtInfo().getMutableCurBossBuffs().addBuffList(buffId).setBossBuffId(1);
            }
        }
        return proto;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ChallengeExcel getExcel() {
        return this.excel;
    }

    public Position getStartPos() {
        return this.startPos;
    }

    public Position getStartRot() {
        return this.startRot;
    }

    public int getChallengeId() {
        return this.challengeId;
    }

    public int getCurrentStage() {
        return this.currentStage;
    }

    public int getCurrentBossStage() {
        return this.currentBossStage;
    }

    public int getCurrentExtraLineup() {
        return this.currentExtraLineup;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isHasAvatarDied() {
        return this.hasAvatarDied;
    }

    public int getSavedMp() {
        return this.savedMp;
    }

    public int getRoundsLeft() {
        return this.roundsLeft;
    }

    public int getStars() {
        return this.stars;
    }

    public int getScoreStage1() {
        return this.scoreStage1;
    }

    public int getScoreStage2() {
        return this.scoreStage2;
    }

    public Int2ObjectMap<BattleTargetOuterClass.BattleTarget> getBattleTarget1() {
        return this.battleTarget1;
    }

    public Int2ObjectMap<BattleTargetOuterClass.BattleTarget> getBattleTarget2() {
        return this.battleTarget2;
    }

    public IntList getBuffs() {
        return this.buffs;
    }

    public boolean isPartialChallenge() {
        return this.isPartialChallenge;
    }

    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public void setSavedMp(int savedMp) {
        this.savedMp = savedMp;
    }

    public void setRoundsLeft(int roundsLeft) {
        this.roundsLeft = roundsLeft;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setScoreStage1(int scoreStage1) {
        this.scoreStage1 = scoreStage1;
    }

    public void setScoreStage2(int scoreStage2) {
        this.scoreStage2 = scoreStage2;
    }

    public void setBattleTarget1(Int2ObjectMap<BattleTargetOuterClass.BattleTarget> battleTarget1) {
        this.battleTarget1 = battleTarget1;
    }

    public void setBattleTarget2(Int2ObjectMap<BattleTargetOuterClass.BattleTarget> battleTarget2) {
        this.battleTarget2 = battleTarget2;
    }

    public void setBuffs(IntList buffs) {
        this.buffs = buffs;
    }

    public void setPartialChallenge(boolean isPartialChallenge) {
        this.isPartialChallenge = isPartialChallenge;
    }
}