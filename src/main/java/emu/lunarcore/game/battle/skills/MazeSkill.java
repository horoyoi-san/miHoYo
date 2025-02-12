package emu.lunarcore.game.battle.skills;

import emu.lunarcore.data.excel.AvatarExcel;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.skills.MazeSkillAction;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.proto.MotionInfoOuterClass;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MazeSkill {
    private int id;
    private int index;
    private List<MazeSkillAction> castActions;
    private List<MazeSkillAction> attackActions;
    private Set<String> adventureModifiers;
    private boolean triggerBattle;

    public MazeSkill(AvatarExcel excel, int index) {
        this.id = excel.getAvatarID();
        this.index = index;
        this.triggerBattle = true;
        this.castActions = new ArrayList<MazeSkillAction>();
        this.attackActions = new ArrayList<MazeSkillAction>();
    }

    public void addAdventureModifier(String modifier) {
        if (modifier == null) {
            return;
        }
        if (this.adventureModifiers == null) {
            this.adventureModifiers = new ObjectOpenHashSet<String>();
        }
        this.adventureModifiers.add(modifier);
    }

    public boolean hasAdventureModifier(String modifier) {
        return this.adventureModifiers != null && this.adventureModifiers.contains(modifier);
    }

    public void onCast(GameAvatar caster, MotionInfoOuterClass.MotionInfo castPosition) {
        if (this.getCastActions().size() == 0) {
            return;
        }
        for (MazeSkillAction action : this.getCastActions()) {
            action.onCast(caster, castPosition);
        }
    }

    public void onCastHit(GameAvatar caster, List<? extends GameEntity> entities) {
        if (this.getAttackActions().size() == 0) {
            return;
        }
        for (MazeSkillAction action : this.getAttackActions()) {
            action.onCastHit(caster, entities);
        }
    }

    public void onAttack(GameAvatar caster, List<? extends GameEntity> targets) {
        if (this.getAttackActions().size() == 0) {
            return;
        }
        for (MazeSkillAction action : this.getAttackActions()) {
            action.onAttack(caster, targets);
        }
    }

    public int getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public List<MazeSkillAction> getCastActions() {
        return this.castActions;
    }

    public List<MazeSkillAction> getAttackActions() {
        return this.attackActions;
    }

    public Set<String> getAdventureModifiers() {
        return this.adventureModifiers;
    }

    public boolean isTriggerBattle() {
        return this.triggerBattle;
    }

    public void setTriggerBattle(boolean triggerBattle) {
        this.triggerBattle = triggerBattle;
    }
}

