/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package emu.lunarcore.game.inventory.tabs;

import emu.lunarcore.game.inventory.GameItem;
import emu.lunarcore.game.inventory.tabs.InventoryTab;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EquipInventoryTab
extends InventoryTab {
    private final Set<GameItem> items = new HashSet<GameItem>();
    private final int maxCapacity;

    public EquipInventoryTab(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public GameItem getItemById(int id) {
        return null;
    }

    @Override
    public void onAddItem(GameItem item) {
        this.items.add(item);
    }

    @Override
    public void onRemoveItem(GameItem item) {
        this.items.remove(item);
    }

    @Override
    public int getSize() {
        return this.items.size();
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public Iterator<GameItem> iterator() {
        return this.items.iterator();
    }
}

