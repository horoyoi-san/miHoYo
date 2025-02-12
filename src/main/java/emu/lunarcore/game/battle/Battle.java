package emu.lunarcore.game.battle;

import emu.lunarcore.data.GameData;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.BattleMonsterWave;
import emu.lunarcore.game.battle.BattleStage;
import emu.lunarcore.game.battle.MazeBuff;
import emu.lunarcore.game.inventory.GameItem;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.game.player.lineup.PlayerLineup;
import emu.lunarcore.game.scene.SceneBuff;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.proto.BattleEndStatusOuterClass;
import emu.lunarcore.proto.BattleEventBattleInfoOuterClass;
import emu.lunarcore.proto.BattleStatisticsOuterClass;
import emu.lunarcore.proto.BattleTargetListOuterClass;
import emu.lunarcore.proto.BattleTargetOuterClass;
import emu.lunarcore.proto.SceneBattleInfoOuterClass;
import emu.lunarcore.util.Utils;
import it.unimi.dsi.fastutil.ints.Int2LongMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Battle {
    private final int id;
    private final Player player;
    private final PlayerLineup lineup;
    private final List<EntityMonster> npcMonsters;
    private final List<BattleMonsterWave> waves;
    private final List<GameItem> drops;
    private final Int2ObjectMap<MazeBuff> buffs;
    private final long timestamp;
    private BattleStage stage;
    private IntList battleEvents;
    private Int2ObjectMap<BattleTargetListOuterClass.BattleTargetList> battleTargets;
    private BattleEndStatusOuterClass.BattleEndStatus result;
    private int staminaCost;
    private int roundsLimit;
    private int mappingInfoId;
    private int worldLevel;
    private int cocoonWave;
    private Consumer<BattleStatisticsOuterClass.BattleStatistics> onFinish;

    private Battle(Player player, PlayerLineup lineup) {
        this.id = player.getNextBattleId();
        this.player = player;
        this.lineup = lineup;
        this.npcMonsters = new ArrayList<EntityMonster>();
        this.buffs = new Int2ObjectLinkedOpenHashMap<MazeBuff>();
        this.waves = new ArrayList<BattleMonsterWave>();
        this.drops = new ArrayList<GameItem>();
        this.timestamp = System.currentTimeMillis();
    }

    public Battle(Player player, PlayerLineup lineup, BattleStage stage) {
        this(player, lineup, stage, true);
    }

    public Battle(Player player, PlayerLineup lineup, BattleStage stage, boolean loadStage) {
        this(player, lineup);
        this.stage = stage;
        if (loadStage) {
            this.loadStage(stage);
        }
    }

    public Battle(Player player, PlayerLineup lineup, List<? extends BattleStage> stages) {
        this(player, lineup);
        this.stage = stages.get(0);
        for (BattleStage battleStage : stages) {
            this.loadStage(battleStage);
        }
    }

    public Battle(Player player, PlayerLineup lineup, Collection<EntityMonster> npcMonsters) {
        this(player, lineup);
        for (EntityMonster npcMonster : npcMonsters) {
            BattleStage stage;
            this.npcMonsters.add(npcMonster);
            if (npcMonster.getFarmElementId() != 0) {
                this.setMappingInfoId(npcMonster.getFarmElementId());
                this.setWorldLevel(npcMonster.getWorldLevel());
                this.setStaminaCost(30);
            }
            if ((stage = npcMonster.getCustomStage()) == null && (stage = (BattleStage)GameData.getStageExcelMap().get(npcMonster.getStageId())) == null) continue;
            if (this.stage == null) {
                this.stage = stage;
            }
            this.loadStage(stage, npcMonster);
        }
    }

    private void loadStage(BattleStage stage) {
        this.loadStage(stage, null);
    }

    private void loadStage(BattleStage stage, EntityMonster npcMonster) {
        for (IntList stageMonsterWave : stage.getMonsterWaves()) {
            BattleMonsterWave wave = new BattleMonsterWave(stage);
            wave.getMonsters().addAll(stageMonsterWave);
            this.getWaves().add(wave);
            if (npcMonster == null) continue;
            wave.setCustomLevel(npcMonster.getCustomLevel());
            npcMonster.applyBuffs(this, this.getWaves().size());
        }
    }

    public IntList getBattleEvents() {
        if (this.battleEvents == null) {
            this.battleEvents = new IntArrayList();
        }
        return this.battleEvents;
    }

    public Int2ObjectMap<BattleTargetListOuterClass.BattleTargetList> getBattleTargets() {
        if (this.battleTargets == null) {
            this.battleTargets = new Int2ObjectOpenHashMap<BattleTargetListOuterClass.BattleTargetList>();
        }
        return this.battleTargets;
    }

    public void addBattleTarget(int key, int targetId, int progress) {
        BattleTargetListOuterClass.BattleTargetList list = this.getBattleTargets().computeIfAbsent(key, i -> BattleTargetListOuterClass.BattleTargetList.newInstance());
        BattleTargetOuterClass.BattleTarget battleTarget = BattleTargetOuterClass.BattleTarget.newInstance().setId(targetId).setProgress(progress);
        list.addBattleTargetList(battleTarget);
    }

    public void setCustomLevel(int level) {
        for (BattleMonsterWave wave : this.getWaves()) {
            wave.setCustomLevel(level);
        }
    }

    public MazeBuff addBuff(int buffId) {
        return this.addBuff(buffId, -1, -1);
    }

    public MazeBuff addBuff(int buffId, int ownerIndex) {
        return this.addBuff(buffId, ownerIndex, -1);
    }

    public MazeBuff addBuff(int buffId, int ownerIndex, int waveFlag) {
        MazeBuff buff = new MazeBuff(buffId, 1, ownerIndex, waveFlag);
        return this.addBuff(buff);
    }

    public MazeBuff addBuff(MazeBuff buff) {
        this.buffs.put(buff.getId(), buff);
        return buff;
    }

    public boolean hasBuff(int buffId) {
        return this.buffs.containsKey(buffId);
    }

    public void clearBuffs() {
        this.buffs.clear();
    }

    public SceneBattleInfoOuterClass.SceneBattleInfo toProto() {
        SceneBattleInfoOuterClass.SceneBattleInfo proto = SceneBattleInfoOuterClass.SceneBattleInfo.newInstance().setBattleId(this.getId()).setStageId(this.getStage().getId()).setRoundsLimit(this.getRoundsLimit()).setLogicRandomSeed(Utils.randomRange(1, Short.MAX_VALUE)).setWorldLevel(this.player.getWorldLevel());
        for (BattleMonsterWave wave : this.getWaves()) {
            proto.addMonsterWaveList(wave.toProto());
        }
        for (int i = 0; i < this.lineup.getAvatars().size(); ++i) {
            GameAvatar avatar = this.getPlayer().getAvatarById(this.lineup.getAvatars().get(i));
            if (avatar == null) continue;
            proto.addPveAvatarList(avatar.toBattleProto(this.lineup, i));
            if (avatar.getBuffs().size() <= 0) continue;
            for (Int2LongMap.Entry buffEntry : avatar.getBuffs().int2LongEntrySet()) {
                MazeBuff buff;
                if (buffEntry.getLongValue() < this.timestamp || (buff = this.addBuff(buffEntry.getIntKey(), i)) == null) continue;
                buff.addTargetIndex(i);
            }
        }
        if (this.player.getFoodBuffs().size() > 0) {
            for (Object buff : this.player.getFoodBuffs().values()) {
                this.addBuff(((SceneBuff)buff).getBuffId(), -1);
            }
        }
        for (Object buff : this.getBuffs().values()) {
            proto.addBuffList(((MazeBuff)buff).toProto());
        }
        if (this.battleEvents != null) {
            Iterator i = this.battleEvents.iterator();
            while (i.hasNext()) {
                int id = (Integer)i.next();
                BattleEventBattleInfoOuterClass.BattleEventBattleInfo event = BattleEventBattleInfoOuterClass.BattleEventBattleInfo.newInstance().setBattleEventId(id);
                event.getMutableStatus().getMutableSpBar().setCurSp(10000).setMaxSp(10000);
                proto.addEventBattleInfoList(event);
            }
        }
        if (this.battleTargets != null) {
            for (int i = 1; i <= 5; ++i) {
                BattleTargetListOuterClass.BattleTargetList battleTargetList = (BattleTargetListOuterClass.BattleTargetList)this.battleTargets.get(i);
                SceneBattleInfoOuterClass.SceneBattleInfo.BattleTargetInfoEntry battleTargetEntry = SceneBattleInfoOuterClass.SceneBattleInfo.BattleTargetInfoEntry.newInstance().setKey(i);
                if (battleTargetList == null) {
                    battleTargetEntry.getMutableValue();
                } else {
                    battleTargetEntry.setValue(battleTargetList);
                }
                proto.addBattleTargetInfo(battleTargetEntry);
            }
        }
        return proto;
    }

    public int getId() {
        return this.id;
    }

    public Player getPlayer() {
        return this.player;
    }

    public PlayerLineup getLineup() {
        return this.lineup;
    }

    public List<EntityMonster> getNpcMonsters() {
        return this.npcMonsters;
    }

    public List<BattleMonsterWave> getWaves() {
        return this.waves;
    }

    public List<GameItem> getDrops() {
        return this.drops;
    }

    public Int2ObjectMap<MazeBuff> getBuffs() {
        return this.buffs;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public BattleStage getStage() {
        return this.stage;
    }

    public BattleEndStatusOuterClass.BattleEndStatus getResult() {
        return this.result;
    }

    public int getStaminaCost() {
        return this.staminaCost;
    }

    public int getRoundsLimit() {
        return this.roundsLimit;
    }

    public int getMappingInfoId() {
        return this.mappingInfoId;
    }

    public int getWorldLevel() {
        return this.worldLevel;
    }

    public int getCocoonWave() {
        return this.cocoonWave;
    }

    public Consumer<BattleStatisticsOuterClass.BattleStatistics> getOnFinish() {
        return this.onFinish;
    }

    public void setResult(BattleEndStatusOuterClass.BattleEndStatus result2) {
        this.result = result2;
    }

    public void setStaminaCost(int staminaCost) {
        this.staminaCost = staminaCost;
    }

    public void setRoundsLimit(int roundsLimit) {
        this.roundsLimit = roundsLimit;
    }

    public void setMappingInfoId(int mappingInfoId) {
        this.mappingInfoId = mappingInfoId;
    }

    public void setWorldLevel(int worldLevel) {
        this.worldLevel = worldLevel;
    }

    public void setCocoonWave(int cocoonWave) {
        this.cocoonWave = cocoonWave;
    }

    public void setOnFinish(Consumer<BattleStatisticsOuterClass.BattleStatistics> onFinish) {
        this.onFinish = onFinish;
    }
}

