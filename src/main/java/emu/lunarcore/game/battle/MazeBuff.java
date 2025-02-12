package emu.lunarcore.game.battle;

import emu.lunarcore.data.excel.MazeBuffExcel;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.proto.BattleBuffOuterClass;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import java.util.Iterator;

public class MazeBuff {
    private int id;
    private int level;
    private int ownerIndex;
    private int waveFlag;
    private IntList targetIndex;
    private Object2DoubleMap<String> dynamicValues;
    private transient GameEntity owner;

    public MazeBuff(MazeBuffExcel excel, int ownerIndex, int waveFlag) {
        this(excel.getBuffId(), excel.getLv(), ownerIndex, waveFlag);
    }

    public MazeBuff(int id, int level, int ownerIndex, int waveFlag) {
        this.id = id;
        this.level = level;
        this.ownerIndex = ownerIndex;
        this.waveFlag = waveFlag;
    }

    public void addTargetIndex(int index) {
        if (this.targetIndex == null) {
            this.targetIndex = new IntArrayList();
        }
        this.targetIndex.add(index);
    }

    public void addDynamicValue(String key, double value) {
        if (this.dynamicValues == null) {
            this.dynamicValues = new Object2DoubleOpenHashMap<String>();
        }
        this.dynamicValues.put(key, value);
    }

    public BattleBuffOuterClass.BattleBuff toProto() {
        BattleBuffOuterClass.BattleBuff proto = BattleBuffOuterClass.BattleBuff.newInstance().setId(this.getId()).setLevel(this.getLevel()).setWaveFlag(this.getWaveFlag());
        if (this.ownerIndex != 0) {
            proto.setOwnerId(this.getOwnerIndex());
        }
        if (this.targetIndex != null) {
            Iterator<Integer> iterator2 = this.targetIndex.iterator();
            while (iterator2.hasNext()) {
                int n = (Integer)iterator2.next();
                proto.addTargetIndexList(n);
            }
        }
        if (this.dynamicValues != null) {
            for (Object2DoubleMap.Entry entry : this.dynamicValues.object2DoubleEntrySet()) {
                BattleBuffOuterClass.BattleBuff.DynamicValuesEntry dynamicValue = BattleBuffOuterClass.BattleBuff.DynamicValuesEntry.newInstance().setKey((CharSequence)entry.getKey()).setValue((float)entry.getDoubleValue());
                proto.addDynamicValues(dynamicValue);
            }
        }
        return proto;
    }

    public int getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public int getOwnerIndex() {
        return this.ownerIndex;
    }

    public int getWaveFlag() {
        return this.waveFlag;
    }

    public IntList getTargetIndex() {
        return this.targetIndex;
    }

    public GameEntity getOwner() {
        return this.owner;
    }

    public void setOwner(GameEntity owner) {
        this.owner = owner;
    }
}

