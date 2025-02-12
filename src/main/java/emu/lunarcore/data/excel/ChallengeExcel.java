package emu.lunarcore.data.excel;

import emu.lunarcore.data.GameResource;
import emu.lunarcore.data.ResourceType;
import emu.lunarcore.data.excel.ChallengeBossExtraExcel;
import emu.lunarcore.data.excel.ChallengeStoryExtraExcel;
import emu.lunarcore.game.enums.ChallengeType;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

@ResourceType(name={"ChallengeMazeConfig.json", "ChallengeStoryMazeConfig.json", "ChallengeBossMazeConfig.json"})
public class ChallengeExcel
extends GameResource {
    private int ID;
    private int GroupID;
    private int MapEntranceID;
    private int MapEntranceID2;
    private int StageNum;
    private int ChallengeCountDown;
    private int MazeBuffID;
    private int[] ChallengeTargetID;
    private int MazeGroupID1;
    private int[] ConfigList1;
    private int[] NpcMonsterIDList1;
    private int[] EventIDList1;
    private int MazeGroupID2;
    private int[] ConfigList2;
    private int[] NpcMonsterIDList2;
    private int[] EventIDList2;
    private transient Int2ObjectMap<ChallengeMonsterInfo> challengeMonsters1;
    private transient Int2ObjectMap<ChallengeMonsterInfo> challengeMonsters2;
    private transient ChallengeType type = ChallengeType.Memory;
    private transient ChallengeStoryExtraExcel storyExcel;
    private transient ChallengeBossExtraExcel bossExcel;

    @Override
    public int getId() {
        return this.ID;
    }

    public void setStoryExcel(ChallengeStoryExtraExcel storyExcel) {
        this.storyExcel = storyExcel;
        this.ChallengeCountDown = storyExcel.getTurnLimit();
        this.type = ChallengeType.Story;
    }

    public void setBossExcel(ChallengeBossExtraExcel bossExcel) {
        this.bossExcel = bossExcel;
        this.ChallengeCountDown = bossExcel.getTurnLimit();
        this.type = ChallengeType.Boss;
    }

    @Override
    public void onLoad() {
        ChallengeMonsterInfo monster;
        int i;
        this.challengeMonsters1 = new Int2ObjectOpenHashMap<ChallengeMonsterInfo>();
        for (i = 0; i < this.ConfigList1.length && this.ConfigList1[i] != 0; ++i) {
            monster = new ChallengeMonsterInfo(this.ConfigList1[i], this.NpcMonsterIDList1[i], this.EventIDList1[i]);
            this.challengeMonsters1.put(monster.getConfigId(), monster);
        }
        this.challengeMonsters2 = new Int2ObjectOpenHashMap<ChallengeMonsterInfo>();
        for (i = 0; i < this.ConfigList2.length && this.ConfigList2[i] != 0; ++i) {
            monster = new ChallengeMonsterInfo(this.ConfigList2[i], this.NpcMonsterIDList2[i], this.EventIDList2[i]);
            this.challengeMonsters2.put(monster.getConfigId(), monster);
        }
        this.ConfigList1 = null;
        this.NpcMonsterIDList1 = null;
        this.EventIDList1 = null;
        this.ConfigList2 = null;
        this.NpcMonsterIDList2 = null;
        this.EventIDList2 = null;
    }

    public int getGroupID() {
        return this.GroupID;
    }

    public int getMapEntranceID() {
        return this.MapEntranceID;
    }

    public int getMapEntranceID2() {
        return this.MapEntranceID2;
    }

    public int getStageNum() {
        return this.StageNum;
    }

    public int getChallengeCountDown() {
        return this.ChallengeCountDown;
    }

    public int getMazeBuffID() {
        return this.MazeBuffID;
    }

    public int[] getChallengeTargetID() {
        return this.ChallengeTargetID;
    }

    public int getMazeGroupID1() {
        return this.MazeGroupID1;
    }

    public int[] getConfigList1() {
        return this.ConfigList1;
    }

    public int[] getNpcMonsterIDList1() {
        return this.NpcMonsterIDList1;
    }

    public int[] getEventIDList1() {
        return this.EventIDList1;
    }

    public int getMazeGroupID2() {
        return this.MazeGroupID2;
    }

    public int[] getConfigList2() {
        return this.ConfigList2;
    }

    public int[] getNpcMonsterIDList2() {
        return this.NpcMonsterIDList2;
    }

    public int[] getEventIDList2() {
        return this.EventIDList2;
    }

    public Int2ObjectMap<ChallengeMonsterInfo> getChallengeMonsters1() {
        return this.challengeMonsters1;
    }

    public Int2ObjectMap<ChallengeMonsterInfo> getChallengeMonsters2() {
        return this.challengeMonsters2;
    }

    public ChallengeType getType() {
        return this.type;
    }

    public ChallengeStoryExtraExcel getStoryExcel() {
        return this.storyExcel;
    }

    public ChallengeBossExtraExcel getBossExcel() {
        return this.bossExcel;
    }

    public static class ChallengeMonsterInfo {
        private int configId;
        private int npcMonsterId;
        private int eventId;

        public ChallengeMonsterInfo(int configId, int npcMonsterId, int eventId) {
            this.configId = configId;
            this.npcMonsterId = npcMonsterId;
            this.eventId = eventId;
        }

        public int getConfigId() {
            return this.configId;
        }

        public int getNpcMonsterId() {
            return this.npcMonsterId;
        }

        public int getEventId() {
            return this.eventId;
        }
    }
}