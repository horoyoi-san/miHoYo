package emu.lunarcore.game.battle;

import emu.lunarcore.game.enums.StageType;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.List;

public interface BattleStage {
    public int getId();

    public StageType getStageType();

    public List<IntList> getMonsterWaves();
}

