/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package emu.lunarcore.game.inventory.tabs;

import emu.lunarcore.game.inventory.GameItem;

public abstract class InventoryTab
implements Iterable<GameItem> {
    public abstract GameItem getItemById(int var1);

    public abstract void onAddItem(GameItem var1);

    public abstract void onRemoveItem(GameItem var1);

    public abstract int getSize();

    public abstract int getMaxCapacity();

    public int getAvailableCapacity() {
        return Math.max(this.getMaxCapacity() - this.getSize(), 0);
    }
}

