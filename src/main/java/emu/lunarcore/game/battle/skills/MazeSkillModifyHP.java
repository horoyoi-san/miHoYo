package emu.lunarcore.game.battle.skills;

import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.skills.MazeSkillAction;
import emu.lunarcore.proto.MotionInfoOuterClass;

public class MazeSkillModifyHP
extends MazeSkillAction {
    private int amount;

    public MazeSkillModifyHP(int hp) {
        this.amount = hp * 100;
    }

    @Override
    public void onCast(GameAvatar caster, MotionInfoOuterClass.MotionInfo castPosition) {
        caster.getOwner().getCurrentLineup().heal(this.amount, false);
    }
}

