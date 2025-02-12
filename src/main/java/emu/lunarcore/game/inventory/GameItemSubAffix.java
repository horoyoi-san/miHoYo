package emu.lunarcore.game.inventory;

import dev.morphia.annotations.Entity;
import emu.lunarcore.data.excel.RelicSubAffixExcel;
import emu.lunarcore.proto.RelicAffixOuterClass;
import emu.lunarcore.util.Utils;

@Entity(useDiscriminator=false)
public class GameItemSubAffix
implements Comparable<GameItemSubAffix> {
    private int id;
    private int count;
    private int step;

    @Deprecated
    public GameItemSubAffix() {
    }

    public GameItemSubAffix(RelicSubAffixExcel subAffix) {
        this(subAffix, 1);
    }

    public GameItemSubAffix(RelicSubAffixExcel subAffix, int count) {
        this.id = subAffix.getAffixID();
        this.count = count;
        this.step = Utils.randomRange(0, count * subAffix.getStepNum());
    }

    public void incrementCount(int stepNum) {
        ++this.count;
        this.step += Utils.randomRange(0, stepNum);
    }

    public RelicAffixOuterClass.RelicAffix toProto() {
        RelicAffixOuterClass.RelicAffix proto = RelicAffixOuterClass.RelicAffix.newInstance().setAffixId(this.id).setCnt(this.count).setStep(this.step);
        return proto;
    }

    @Override
    public int compareTo(GameItemSubAffix o) {
        return this.getId() - o.getId();
    }

    public int getId() {
        return this.id;
    }

    public int getCount() {
        return this.count;
    }

    public int getStep() {
        return this.step;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStep(int step) {
        this.step = step;
    }
}

