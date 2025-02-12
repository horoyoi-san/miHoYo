package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.BlackInfoOuterClass.BlackInfo;
import emu.lunarcore.proto.PlayerKickOutScNotifyOuterClass.PlayerKickOutScNotify;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketPlayerKickOutScNotify extends BasePacket {
   public PacketPlayerKickOutScNotify(int kickType) {
      super(CmdId.PlayerKickOutScNotify);
      PlayerKickOutScNotify data = PlayerKickOutScNotify.newInstance().setBlackInfo(BlackInfo.newInstance().setBeginTime(0L).setEndTime(2147483647L).setLimitLevel(0).setBanType(0)).setKickTypeValue(kickType);
      this.setData(data);
   }
}
