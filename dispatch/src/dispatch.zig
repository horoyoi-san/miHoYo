const std = @import("std");
const httpz = @import("httpz");
const protocol = @import("protocol");
const Base64Encoder = @import("std").base64.standard.Encoder;

pub fn onQueryDispatch(_: *httpz.Request, res: *httpz.Response) !void {
    std.log.debug("onQueryDispatch", .{});

    var proto = protocol.GlobalDispatchData.init(res.arena);

    proto.retcode = 0;
    try proto.server_list.append(.{
        .name = .{ .Const = "HoroyoiSR" },
        .display_name = .{ .Const = "HoroyoiSR" },
        .env_type = .{ .Const = "2" },
        .title = .{ .Const = "HoroyoiSR" },
        .dispatch_url = .{ .Const = "http://127.0.0.1:21000/query_gateway" },
    });

    const data = try proto.encode(res.arena);
    const size = Base64Encoder.calcSize(data.len);
    const output = try res.arena.alloc(u8, size);
    _ = Base64Encoder.encode(output, data);

    res.body = output;
}

pub fn onQueryGateway(_: *httpz.Request, res: *httpz.Response) !void {
    std.log.debug("onQueryGateway", .{});

    var proto = protocol.Gateserver.init(res.arena);

    proto.retcode = 0;
    proto.port = 23301;
    proto.ip = .{ .Const = "127.0.0.1" };
    proto.lua_version = .{ .Const = "8449174" }; // lua_version
    proto.lua_url = .{ .Const = "https://autopatchcn.bhsr.com/asb/BetaLive/output_8448286_c2eb6137cc64" };
    proto.asset_bundle_url = .{ .Const = "https://autopatchcn.bhsr.com/lua/BetaLive/output_8449174_c5fe4343f9f8" };
    proto.ex_resource_url = .{ .Const = "https://autopatchcn.bhsr.com/design_data/BetaLive/output_8448286_10002cf1a8a3" };
    proto.unk1 = true;
    proto.unk2 = true;
    proto.unk3 = true;
    proto.unk4 = true;
    proto.unk5 = true;
    proto.unk6 = true;
    proto.unk7 = true;
    proto.unk8 = true;
    proto.unk10 = true;
    proto.DEPJHGIBFIE = true;
    proto.LKKCKCCEEMJ = true;
    proto.NHEHAJGMJNJ = true;
    proto.BDKOGPCLHIN = true;
    proto.MKEHGPIEPGF = true;
    proto.IOPMOLBOHKL = true;


    const data = try proto.encode(res.arena);
    const size = Base64Encoder.calcSize(data.len);
    const output = try res.arena.alloc(u8, size);
    _ = Base64Encoder.encode(output, data);

    res.body = output;
}
