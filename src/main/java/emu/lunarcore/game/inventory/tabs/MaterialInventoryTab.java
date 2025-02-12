/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package emu.lunarcore.game.inventory.tabs;

import emu.lunarcore.game.inventory.GameItem;
import emu.lunarcore.game.inventory.tabs.InventoryTab;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Iterator;

public class MaterialInventoryTab
extends InventoryTab {
    private final Int2ObjectMap<GameItem> items = new Int2ObjectOpenHashMap<GameItem>();
    private final int maxCapacity;

    public MaterialInventoryTab(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public GameItem getItemById(int id) {
        return (GameItem)this.items.get(id);
    }

    @Override
    public void onAddItem(GameItem item) {
        this.items.put(item.getItemId(), item);
    }

    @Override
    public void onRemoveItem(GameItem item) {
        this.items.remove(item.getItemId());
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
        return this.items.values().iterator();
    }
}

