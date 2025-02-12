package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.PickRogueAvatarCsReqOuterClass;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;

@Opcodes(value=1834)
public class HandlerPickRogueAvatarCsReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        PickRogueAvatarCsReqOuterClass.PickRogueAvatarCsReq proto = PickRogueAvatarCsReqOuterClass.PickRogueAvatarCsReq.parseFrom(data);
        session.getPlayer().getRogueInstance().pickAvatar(proto.getBaseAvatarIdList());
    }
}
