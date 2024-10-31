const std = @import("std");
const protocol = @import("protocol");
const CmdID = protocol.CmdID;
const Session = @import("../Session.zig");
const Packet = @import("../Packet.zig");
const Allocator = std.mem.Allocator;

const log = std.log.scoped(.scene_service);

pub fn onGetCurSceneInfo(session: *Session, _: *const Packet, allocator: Allocator) !void {
    var scene_info = protocol.SceneInfo.init(allocator);
    //scene_info.KBBLJPLPLBC = 1;
    //scene_info.leader_entity_id = 1;
    scene_info.game_mode_type = 2;
    scene_info.plane_id = 20242;
    scene_info.floor_id = 20242001;
    scene_info.entry_id = 2024201;

    { // Character
        var scene_group = protocol.SceneGroupInfo.init(allocator);
        scene_group.state = 1;

        try scene_group.entity_list.append(.{
            .actor = .{
                .base_avatar_id = 1313,
                .avatar_type = .AVATAR_FORMAL_TYPE,
                .uid = 1337,
                .map_layer = 0,
            },
            .motion = .{ .pos = .{ .x = -837, .y = -26069, .z = 13246 }, .rot = .{} },
        });

        try scene_info.scene_group_list.append(scene_group);

    }

    { // Calyx prop
        var scene_group = protocol.SceneGroupInfo.init(allocator);
        scene_group.state = 1;
        scene_group.group_id = 199;

        var prop = protocol.ScenePropInfo.init(allocator);
		//calyx prop 808 = yellow 801 = red 113 = boss 702 = stagnant shadow
        prop.prop_id = 113;
        prop.prop_state = 1;

        try scene_group.entity_list.append(.{
            .group_id = 199,
            .inst_id = 300001,
            .entity_id = 1337,
            .prop = prop,
            .motion = .{ .pos = .{ .x = -895, .y = -26069, .z = 23865 }, .rot = .{ .x = 0, .y = 176943, .z = 0 } },
        });

        try scene_info.scene_group_list.append(scene_group);
    }

    // { // NPC
    //     var scene_group = protocol.SceneEntityGroupInfo.init(allocator);
    //     scene_group.state = 1;
    //
    //     var npc = protocol.SceneNpcInfo.init(allocator);
    //     npc.npc_id = 0;
    //
    //     try scene_group.entity_list.append(.{
    //         .Npc = npc,
    //     });
    //
    //     try scene_info.entity_group_list.append(scene_group);
    // }

    try session.send(CmdID.CmdGetCurSceneInfoScRsp, protocol.GetCurSceneInfoScRsp{
        .scene = scene_info,
        .retcode = 0,
    });
}

pub fn onSceneEntityMove(session: *Session, packet: *const Packet, allocator: Allocator) !void {
    const req = try packet.getProto(protocol.SceneEntityMoveCsReq, allocator);

    for (req.entity_motion_list.items) |entity_motion| {
        if (entity_motion.motion) |motion| {
            log.debug("[POSITION] entity_id: {}, motion: {}", .{ entity_motion.entity_id, motion });
        }
    }

    try session.send(CmdID.CmdSceneEntityMoveScRsp, protocol.SceneEntityMoveScRsp{
        .retcode = 0,
        .entity_motion_list = req.entity_motion_list,
        .download_data = null,
    });
}
