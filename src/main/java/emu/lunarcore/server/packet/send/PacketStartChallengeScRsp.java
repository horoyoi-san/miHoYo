package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.enums.ChallengeType;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.game.player.lineup.PlayerLineup;
import emu.lunarcore.proto.ChallengeBossInfoOuterClass;
import emu.lunarcore.proto.StartChallengeScRspOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.Retcode;
import emu.lunarcore.server.packet.CmdId;

public class PacketStartChallengeScRsp
extends BasePacket {
    public PacketStartChallengeScRsp(Retcode retcode) {
        super(CmdId.StartChallengeScRsp);
        StartChallengeScRspOuterClass.StartChallengeScRsp data = StartChallengeScRspOuterClass.StartChallengeScRsp.newInstance().setRetcode(retcode.getVal());
        this.setData(data);
    }

    public PacketStartChallengeScRsp(Player player, int challengeId) {
        super(CmdId.StartChallengeScRsp);
        StartChallengeScRspOuterClass.StartChallengeScRsp data = StartChallengeScRspOuterClass.StartChallengeScRsp.newInstance();
        if (player.getChallengeInstance() != null) {
            PlayerLineup lineup1 = player.getLineupManager().getExtraLineupByType(1);
            PlayerLineup lineup2 = player.getLineupManager().getExtraLineupByType(3);
            data.addAllLineupList(lineup1.toProto(), lineup2.toProto());
            data.setScene(player.getScene().toProto());
            data.setChallengeInfo(player.getChallengeInstance().toProto());
            if (player.getChallengeInstance().getExcel().getType() == ChallengeType.Boss) {
                ChallengeBossInfoOuterClass.ChallengeBossInfo info = data.getMutableStartInfo().getMutableBossInfo();
                info.getMutableFirstNode();
                info.getMutableSecondNode();
            }
        } else {
            data.setRetcode(1);
        }
        this.setData(data);
    }
}

