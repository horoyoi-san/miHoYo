package emu.lunarcore.server.packet.send;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.MusicRhythmTrackExcel;
import emu.lunarcore.proto.MusicRhythmUnlockTrackScNotifyOuterClass.MusicRhythmUnlockTrackScNotify;
import emu.lunarcore.server.packet.BasePacket;
import it.unimi.dsi.fastutil.objects.ObjectIterator;

public class PacketMusicRhythmUnlockTrackScNotify extends BasePacket {
   public PacketMusicRhythmUnlockTrackScNotify() {
      super(7598);
      MusicRhythmUnlockTrackScNotify data = MusicRhythmUnlockTrackScNotify.newInstance();
      ObjectIterator var2 = GameData.getMusicRhythmTrackExcelMap().values().iterator();

      while(var2.hasNext()) {
         MusicRhythmTrackExcel excel = (MusicRhythmTrackExcel)var2.next();
         data.addTrackUnlockList(excel.getId());
      }

      this.setData(data);
   }
}
