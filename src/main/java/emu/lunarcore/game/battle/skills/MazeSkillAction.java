package emu.lunarcore.game.battle.skills;

import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.proto.MotionInfoOuterClass;
import java.util.List;

public abstract class MazeSkillAction {
    public void onCast(GameAvatar caster, MotionInfoOuterClass.MotionInfo castPosition) {
    }

    public void onCastHit(GameAvatar caster, List<? extends GameEntity> entities) {
    }

    public void onAttack(GameAvatar caster, List<? extends GameEntity> targets) {
    }
}

