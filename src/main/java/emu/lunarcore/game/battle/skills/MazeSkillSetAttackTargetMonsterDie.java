package emu.lunarcore.game.battle.skills;

import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.skills.MazeSkillAction;
import emu.lunarcore.game.enums.MonsterRank;
import emu.lunarcore.game.inventory.ItemParamMap;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.util.Utils;
import java.util.List;

public class MazeSkillSetAttackTargetMonsterDie
extends MazeSkillAction {
    @Override
    public void onAttack(GameAvatar caster, List<? extends GameEntity> entities) {
        for (GameEntity gameEntity : entities) {
            EntityMonster monster;
            if (!(gameEntity instanceof EntityMonster) || (monster = (EntityMonster)gameEntity).getExcel().getRank().getVal() >= MonsterRank.Elite.getVal()) continue;
            monster.getScene().removeEntity(monster);
            ItemParamMap drops = new ItemParamMap();
            monster.calculateDrops(drops);
            caster.getOwner().getInventory().addItems(drops.toItemList(), true);
            if (caster.getOwner().getRogueInstance() == null) continue;
            caster.getOwner().getRogueInstance().createBuffSelect(1);
            caster.getOwner().getRogueInstance().addCoin(Utils.randomRange(20, 40));
        }
    }
}

