const std = @import("std");
const protocol = @import("protocol");
const CmdID = protocol.CmdID;
const Session = @import("../Session.zig");
const Packet = @import("../Packet.zig");
const Allocator = std.mem.Allocator;
const B64Decoder = std.base64.standard.Decoder;

pub fn onPlayerHeartBeat(session: *Session, packet: *const Packet, allocator: Allocator) !void {
    const req = try packet.getProto(protocol.PlayerHeartBeatCsReq, allocator);

    const downloadDataBin = "Q1MuVW5pdHlFbmdpbmUuR2FtZU9iamVjdC5GaW5kKCJVSVJvb3QvQWJvdmVEaWFsb2cvQmV0YUhpbnREaWFsb2coQ2xvbmUpIik6R2V0Q29tcG9uZW50SW5DaGlsZHJlbih0eXBlb2YoQ1MuUlBHLkNsaWVudC5Mb2NhbGl6ZWRUZXh0KSkudGV4dCA9ICI8Y29sb3I9I2M2YzZjNj7guYDguKfguK3guKPguYzguIrguLHguJnguJvguLHguIjguIjguLjguJrguLHguJnguYDguJvguYfguJnguYDguKfguK3guKPguYzguIrguLHguJnguJvguKPguLDguKrguJrguIHguLLguKPguJPguYzguKrguKPguYnguLLguIfguKrguKPguKPguITguYwg4LmA4LiZ4Li34LmJ4Lit4Lir4Liy4LiX4Lix4LmJ4LiH4Lir4Lih4LiU4Lii4Lix4LiH4Lit4Lii4Li54LmI4Lij4Liw4Lir4Lin4LmI4Liy4LiH4LiB4Liy4Lij4Lie4Lix4LiS4LiZ4LiyIOC5guC4m+C4o+C4lOC4lOC4ueC5gOC4p+C4reC4o+C5jOC4iuC4seC4meC4reC4ouC5iOC4suC4h+C5gOC4m+C5h+C4meC4l+C4suC4h+C4geC4suC4ozwvY29sb3I+Ig0KQ1MuVW5pdHlFbmdpbmUuR2FtZU9iamVjdC5GaW5kKCJWZXJzaW9uVGV4dCIpOkdldENvbXBvbmVudEluQ2hpbGRyZW4odHlwZW9mKENTLlJQRy5DbGllbnQuTG9jYWxpemVkVGV4dCkpLnRleHQgPSAiPGNvbG9yPSNjNmM2YzY+T1NDRUNSRUFUSU9OV2luIDItNi01MSAwODI3NjE3NC1BODI1NTkxMV9MODI1NjA2NiBVSUQ6ODAwNTU8L2NvbG9yPiI=";
    const size = try B64Decoder.calcSizeForSlice(downloadDataBin);
    const buf = try allocator.alloc(u8, size);
    _ = try B64Decoder.decode(buf, downloadDataBin);
    const data = try protocol.ClientDownloadData.decode(buf, allocator);

    const rsp = protocol.PlayerHeartBeatScRsp{
        .retcode = 0,
        .client_time_ms = req.client_time_ms,
        .server_time_ms = @intCast(std.time.timestamp()),
        .download_data = data,
    };

    try session.send(CmdID.CmdPlayerHeartBeatScRsp, rsp);
}
