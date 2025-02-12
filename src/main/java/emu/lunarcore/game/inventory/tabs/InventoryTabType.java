/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package emu.lunarcore.game.inventory.tabs;

public enum InventoryTabType {
    NONE(0),
    MATERIAL(1),
    EQUIPMENT(2),
    RELIC(3);

    private int val;

    private InventoryTabType(int value) {
        this.val = value;
    }

    public int getVal() {
        return this.val;
    }
}

