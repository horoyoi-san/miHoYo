package emu.lunarcore.game.battle;

import emu.lunarcore.game.battle.BattleStage;
import emu.lunarcore.game.enums.StageType;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.ArrayList;
import java.util.List;

public class CustomBattleStage
implements BattleStage {
    private int id;
    private List<IntList> monsterWaves;

    public CustomBattleStage(int id) {
        this.id = id;
        this.monsterWaves = new ArrayList<IntList>();
    }

    @Override
    public StageType getStageType() {
        return StageType.Mainline;
    }

    public void addMonster(int monsterId, boolean startNewWave) {
        if (this.monsterWaves.size() == 0 || startNewWave) {
            IntArrayList wave = new IntArrayList();
            wave.add(monsterId);
            this.monsterWaves.add(wave);
        } else {
            IntList wave = this.monsterWaves.get(this.monsterWaves.size() - 1);
            if (wave.size() < 5) {
                wave.add(monsterId);
            } else {
                this.addMonster(monsterId, true);
            }
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public List<IntList> getMonsterWaves() {
        return this.monsterWaves;
    }
}

