package emu.lunarcore.game.battle.skills;

import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.battle.skills.MazeSkillAction;
import emu.lunarcore.game.scene.SceneBuff;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.game.scene.entity.GameEntity;
import emu.lunarcore.proto.MotionInfoOuterClass;
import emu.lunarcore.server.packet.send.PacketSyncEntityBuffChangeListScNotify;
import java.util.List;

public class MazeSkillAddBuff
extends MazeSkillAction {
    private int buffId;
    private int duration;
    private boolean sendBuffPacket;

    public MazeSkillAddBuff(int buffId, int duration) {
        this.buffId = buffId;
        this.duration = duration;
    }

    @Override
    public void onCast(GameAvatar caster, MotionInfoOuterClass.MotionInfo castPosition) {
        caster.addBuff(this.buffId, this.duration);
    }

    @Override
    public void onCastHit(GameAvatar caster, List<? extends GameEntity> entities) {
        for (GameEntity gameEntity : entities) {
            EntityMonster monster;
            SceneBuff buff;
            if (!(gameEntity instanceof EntityMonster) || (buff = (monster = (EntityMonster)gameEntity).addBuff(caster.getAvatarId(), this.buffId, this.duration)) == null || !this.sendBuffPacket) continue;
            caster.getOwner().sendPacket(new PacketSyncEntityBuffChangeListScNotify(gameEntity.getEntityId(), buff));
        }
    }

    @Override
    public void onAttack(GameAvatar caster, List<? extends GameEntity> targets) {
        for (GameEntity gameEntity : targets) {
            if (!(gameEntity instanceof EntityMonster)) continue;
            EntityMonster monster = (EntityMonster)gameEntity;
            monster.addTempBuff(new SceneBuff(caster.getAvatarId(), this.buffId));
        }
    }

    public int getBuffId() {
        return this.buffId;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean isSendBuffPacket() {
        return this.sendBuffPacket;
    }

    public void setSendBuffPacket(boolean sendBuffPacket) {
        this.sendBuffPacket = sendBuffPacket;
    }
}

