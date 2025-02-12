package emu.lunarcore.server.packet.send;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.MusicRhythmGroupExcel;
import emu.lunarcore.data.excel.MusicRhythmLevelExcel;
import emu.lunarcore.data.excel.MusicRhythmPhaseExcel;
import emu.lunarcore.data.excel.MusicRhythmSongExcel;
import emu.lunarcore.data.excel.MusicRhythmTrackExcel;
import emu.lunarcore.proto.MusicRhythmDataScRspOuterClass.MusicRhythmDataScRsp;
import emu.lunarcore.proto.MusicRhythmGroupOuterClass.MusicRhythmGroup;
import emu.lunarcore.proto.MusicRhythmLevelOuterClass.MusicRhythmLevel;
import emu.lunarcore.server.packet.BasePacket;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import us.hebi.quickbuf.RepeatedMessage;

public class PacketMusicRhythmDataScRsp extends BasePacket {
   public PacketMusicRhythmDataScRsp() {
      super(7577);
      MusicRhythmDataScRsp data = MusicRhythmDataScRsp.newInstance().setShowHint(true);
      RepeatedMessage<MusicRhythmLevel> levels = data.getMutableMusicLevel();
      ObjectIterator var3 = GameData.getMusicRhythmLevelExcelMap().values().iterator();

      while(var3.hasNext()) {
         MusicRhythmLevelExcel level = (MusicRhythmLevelExcel)var3.next();
         levels.add(MusicRhythmLevel.newInstance().setLevelId(level.getId()).setIsFullCombo(true).setUnlockLevel(3));
      }

      RepeatedMessage<MusicRhythmGroup> groups = data.getMutableMusicGroup();
      ObjectIterator var7 = GameData.getMusicRhythmGroupExcelMap().values().iterator();

      while(var7.hasNext()) {
         MusicRhythmGroupExcel group = (MusicRhythmGroupExcel)var7.next();
         groups.add(MusicRhythmGroup.newInstance().setMusicGroupId(group.getId()).setMusicGroupPhase(group.getPhase()));
      }

      var7 = GameData.getMusicRhythmSongExcelMap().values().iterator();

      while(var7.hasNext()) {
         MusicRhythmSongExcel songs = (MusicRhythmSongExcel)var7.next();
         data.addUnlockSongList(songs.getId());
      }

      var7 = GameData.getMusicRhythmTrackExcelMap().values().iterator();

      while(var7.hasNext()) {
         MusicRhythmTrackExcel tracks = (MusicRhythmTrackExcel)var7.next();
         data.addUnlockTrackList(tracks.getId());
      }

      var7 = GameData.getMusicRhythmPhaseExcelMap().values().iterator();

      while(var7.hasNext()) {
         MusicRhythmPhaseExcel phases = (MusicRhythmPhaseExcel)var7.next();
         data.addUnlockPhaseList(phases.getId());
      }

      this.setData(data);
   }
}
