package emu.lunarcore.game.battle;

import emu.lunarcore.game.battle.BattleStage;
import emu.lunarcore.proto.SceneMonsterOuterClass;
import emu.lunarcore.proto.SceneMonsterWaveOuterClass;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;

public class BattleMonsterWave {
    private final BattleStage stage;
    private IntList monsters;
    private int customLevel;

    public BattleMonsterWave(BattleStage stage) {
        this.stage = stage;
        this.monsters = new IntArrayList();
    }

    public SceneMonsterWaveOuterClass.SceneMonsterWave toProto() {
        SceneMonsterWaveOuterClass.SceneMonsterWave proto = SceneMonsterWaveOuterClass.SceneMonsterWave.newInstance().setWaveId(1).setMonsterStageId(this.stage.getId());
        proto.getMutableWaveParam();
        if (this.customLevel > 0) {
            proto.getMutableWaveParam().setLevel(this.customLevel);
        }
        IntListIterator intListIterator = this.monsters.iterator();
        while (intListIterator.hasNext()) {
            int monsterId = (Integer)intListIterator.next();
            SceneMonsterOuterClass.SceneMonster monster = SceneMonsterOuterClass.SceneMonster.newInstance().setMonsterId(monsterId);
            proto.addMonsterList(monster);
        }
        return proto;
    }

    public BattleStage getStage() {
        return this.stage;
    }

    public IntList getMonsters() {
        return this.monsters;
    }

    public int getCustomLevel() {
        return this.customLevel;
    }

    public void setCustomLevel(int customLevel) {
        this.customLevel = customLevel;
    }
}

