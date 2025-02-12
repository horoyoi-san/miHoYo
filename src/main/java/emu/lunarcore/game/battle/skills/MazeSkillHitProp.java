package emu.lunarcore.game.battle.skills;

import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.skills.MazeSkillAction;
import emu.lunarcore.game.scene.entity.EntityProp;
import emu.lunarcore.game.scene.entity.GameEntity;
import java.util.List;

public class MazeSkillHitProp
extends MazeSkillAction {
    @Override
    public void onCastHit(GameAvatar caster, List<? extends GameEntity> entities) {
        for (GameEntity gameEntity : entities) {
            if (!(gameEntity instanceof EntityProp)) continue;
            EntityProp prop = (EntityProp)gameEntity;
            caster.getScene().destroyProp(prop);
        }
    }
}

