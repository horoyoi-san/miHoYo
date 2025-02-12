package emu.lunarcore.server.packet.send;

import emu.lunarcore.data.excel.RogueBuffExcel;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.GetRogueBuffEnhanceInfoScRspOuterClass;
import emu.lunarcore.proto.ItemCostListOuterClass;
import emu.lunarcore.proto.ItemCostOuterClass;
import emu.lunarcore.proto.PileItemOuterClass;
import emu.lunarcore.proto.RogueBuffEnhanceInfoOuterClass;
import emu.lunarcore.proto.RogueBuffEnhanceShopInfoOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketGetRogueBuffEnhanceInfoScRsp extends BasePacket {
    public PacketGetRogueBuffEnhanceInfoScRsp(Player player) {
        super(CmdId.GetRogueBuffEnhanceInfoScRsp);
        
        var buffs = player.getRogueInstance().getBuffs();
        var proto = GetRogueBuffEnhanceInfoScRspOuterClass.GetRogueBuffEnhanceInfoScRsp.newInstance();
        var shop = RogueBuffEnhanceShopInfoOuterClass.RogueBuffEnhanceShopInfo.newInstance();
        
        for (var buff : buffs.values()) {
            if (buff.getLevel() > 1) continue;
            shop.addBuffEnhanceInfo(RogueBuffEnhanceInfoOuterClass.RogueBuffEnhanceInfo.newInstance().setBuffId(buff.getId()).setItemCostList(this.getItemCostList(buff.getExcel())).setUnkFloat(1.0f));
        }
        proto.setShopInfo(shop);
        
        this.setData(proto);
    }
    
    public ItemCostListOuterClass.ItemCostList getItemCostList(RogueBuffExcel excel) {
        int cost = 100 + (excel.getRogueBuffCategory().getVal() - 1) * 30;
        return ItemCostListOuterClass.ItemCostList.newInstance().addItemList(ItemCostOuterClass.ItemCost.newInstance().setPileItem(PileItemOuterClass.PileItem.newInstance().setItemId(31).setItemNum(cost)));
    }
}
