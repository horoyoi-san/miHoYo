package emu.lunarcore.server.packet.recv;

import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;

@Opcodes(value=1760)
public class HandlerRestartChallengePhaseCsReq
extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] data2) throws Exception {
        session.getPlayer().getChallengeInstance().restartChallenge();
    }
}