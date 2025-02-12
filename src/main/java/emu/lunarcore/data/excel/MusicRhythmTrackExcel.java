package emu.lunarcore.data.excel;

import emu.lunarcore.data.GameResource;
import emu.lunarcore.data.ResourceType;

@ResourceType(
   name = {"MusicRhythmTrack.json"}
)
public class MusicRhythmTrackExcel extends GameResource {
   private int ID;

   public int getId() {
      return this.ID;
   }
}
