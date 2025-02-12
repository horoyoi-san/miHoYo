package emu.lunarcore.game.battle.skills;

import emu.lunarcore.data.excel.SummonUnitExcel;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.skills.MazeSkillAction;
import emu.lunarcore.proto.MotionInfoOuterClass;
import emu.lunarcore.util.Position;

public class MazeSkillSummonUnit
extends MazeSkillAction {
    private SummonUnitExcel excel;
    private int duration;

    public MazeSkillSummonUnit(SummonUnitExcel excel, int duration) {
        this.excel = excel;
        this.duration = duration;
    }

    @Override
    public void onCast(GameAvatar caster, MotionInfoOuterClass.MotionInfo castPosition) {
        caster.getScene().summonUnit(caster, this.excel, new Position(castPosition.getPos()), new Position(castPosition.getRot()), this.duration);
    }

    public SummonUnitExcel getExcel() {
        return this.excel;
    }

    public int getDuration() {
        return this.duration;
    }
}

