package emu.lunarcore.game.battle.skills;

import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.skills.MazeSkillAction;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.proto.MotionInfoOuterClass;
import java.util.List;

public class MazeSkillModifySP
extends MazeSkillAction {
    private int amount;

    public MazeSkillModifySP(int sp) {
        this.amount = sp * 100;
    }

    @Override
    public void onCast(GameAvatar caster, MotionInfoOuterClass.MotionInfo castPosition) {
        caster.setCurrentSp(caster.getOwner().getCurrentLineup(), this.amount + caster.getCurrentSp(caster.getOwner().getCurrentLineup()));
    }

    @Override
    public void onCastHit(GameAvatar caster, List<? extends GameEntity> entities) {
    }
}

