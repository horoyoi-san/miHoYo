package emu.lunarcore.game.inventory;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.ItemExcel;
import emu.lunarcore.game.inventory.GameItem;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ItemParamMap
extends Int2IntOpenHashMap {
    private static final long serialVersionUID = -4186524272780523459L;

    @Override
    public int addTo(int itemId, int count) {
        return super.addTo(itemId, count);
    }

    public Int2IntMap.FastEntrySet entries() {
        return this.int2IntEntrySet();
    }

    public void forEachItem(Consumer<GameItem> consumer) {
        for (Int2IntMap.Entry entry : this.entries()) {
            ItemExcel excel;
            int amount = entry.getIntValue();
            if (amount <= 0 || (excel = (ItemExcel)GameData.getItemExcelMap().get(entry.getIntKey())) == null) continue;
            if (excel.isEquippable()) {
                for (int i = 0; i < amount; ++i) {
                    consumer.accept(new GameItem(excel, 1));
                }
                continue;
            }
            consumer.accept(new GameItem(excel, amount));
        }
    }

    public List<GameItem> toItemList() {
        ArrayList<GameItem> list = new ArrayList<GameItem>();
        this.forEachItem(item -> list.add((GameItem)item));
        return list;
    }
}

