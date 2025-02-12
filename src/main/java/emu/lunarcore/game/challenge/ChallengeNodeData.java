package emu.lunarcore.game.challenge;

import dev.morphia.annotations.Entity;
import emu.lunarcore.game.enums.ChallengeType;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.Collection;
import java.util.List;

@Entity(useDiscriminator=false)
public class ChallengeNodeData {
    private int buffId;
    private int stageScore;
    private boolean isWin;
    private boolean unkBoolean;
    private IntSet avatarIds;

    @Deprecated
    public ChallengeNodeData() {
    }

    public ChallengeNodeData(ChallengeType type2, int nodeNum, IntList buffs, int stageScore, List<Integer> avatarIds) {
        if (type2 != ChallengeType.Memory) {
            try {
                this.buffId = buffs.getInt(nodeNum - 1);
            } catch (Exception ex) {
                this.buffId = 0;
            }
        }
        this.stageScore = stageScore;
        this.isWin = true;
        this.unkBoolean = true;
        IntOpenHashSet list = new IntOpenHashSet();
        list.addAll((Collection<? extends Integer>)avatarIds);
        this.avatarIds = list;
    }

    public int getBuffId() {
        return this.buffId;
    }

    public int getStageScore() {
        return this.stageScore;
    }

    public boolean isWin() {
        return this.isWin;
    }

    public boolean isUnkBoolean() {
        return this.unkBoolean;
    }

    public IntSet getAvatarIds() {
        return this.avatarIds;
    }
}