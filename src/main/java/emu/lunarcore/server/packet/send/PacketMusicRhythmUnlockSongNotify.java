package emu.lunarcore.server.packet.send;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.MusicRhythmSongExcel;
import emu.lunarcore.proto.MusicRhythmUnlockSongNotifyOuterClass.MusicRhythmUnlockSongNotify;
import emu.lunarcore.server.packet.BasePacket;
import it.unimi.dsi.fastutil.objects.ObjectIterator;

public class PacketMusicRhythmUnlockSongNotify extends BasePacket {
   public PacketMusicRhythmUnlockSongNotify() {
      super(7573);
      MusicRhythmUnlockSongNotify data = MusicRhythmUnlockSongNotify.newInstance();
      ObjectIterator var2 = GameData.getMusicRhythmSongExcelMap().values().iterator();

      while(var2.hasNext()) {
         MusicRhythmSongExcel excel = (MusicRhythmSongExcel)var2.next();
         data.addMusicUnlockList(excel.getId());
      }

      this.setData(data);
   }
}
