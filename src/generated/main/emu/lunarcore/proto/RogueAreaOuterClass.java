// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import java.io.IOException;
import us.hebi.quickbuf.FieldName;
import us.hebi.quickbuf.InvalidProtocolBufferException;
import us.hebi.quickbuf.JsonSink;
import us.hebi.quickbuf.JsonSource;
import us.hebi.quickbuf.MessageFactory;
import us.hebi.quickbuf.ProtoMessage;
import us.hebi.quickbuf.ProtoSink;
import us.hebi.quickbuf.ProtoSource;

public final class RogueAreaOuterClass {
  /**
   * Protobuf type {@code RogueArea}
   */
  public static final class RogueArea extends ProtoMessage<RogueArea> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 area_id = 2;</code>
     */
    private int areaId;

    /**
     * <code>optional uint32 rogue_status = 3;</code>
     */
    private int rogueStatus;

    /**
     * <code>optional uint32 cur_reach_room_num = 7;</code>
     */
    private int curReachRoomNum;

    /**
     * <code>optional uint32 rogue_area_status = 11;</code>
     */
    private int rogueAreaStatus;

    /**
     * <code>optional uint32 map_id = 13;</code>
     */
    private int mapId;

    /**
     * <code>optional bool has_taken_rewards = 4;</code>
     */
    private boolean hasTakenRewards;

    private RogueArea() {
    }

    /**
     * @return a new empty instance of {@code RogueArea}
     */
    public static RogueArea newInstance() {
      return new RogueArea();
    }

    /**
     * <code>optional uint32 area_id = 2;</code>
     * @return whether the areaId field is set
     */
    public boolean hasAreaId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 area_id = 2;</code>
     * @return this
     */
    public RogueArea clearAreaId() {
      bitField0_ &= ~0x00000001;
      areaId = 0;
      return this;
    }

    /**
     * <code>optional uint32 area_id = 2;</code>
     * @return the areaId
     */
    public int getAreaId() {
      return areaId;
    }

    /**
     * <code>optional uint32 area_id = 2;</code>
     * @param value the areaId to set
     * @return this
     */
    public RogueArea setAreaId(final int value) {
      bitField0_ |= 0x00000001;
      areaId = value;
      return this;
    }

    /**
     * <code>optional uint32 rogue_status = 3;</code>
     * @return whether the rogueStatus field is set
     */
    public boolean hasRogueStatus() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 rogue_status = 3;</code>
     * @return this
     */
    public RogueArea clearRogueStatus() {
      bitField0_ &= ~0x00000002;
      rogueStatus = 0;
      return this;
    }

    /**
     * <code>optional uint32 rogue_status = 3;</code>
     * @return the rogueStatus
     */
    public int getRogueStatus() {
      return rogueStatus;
    }

    /**
     * <code>optional uint32 rogue_status = 3;</code>
     * @param value the rogueStatus to set
     * @return this
     */
    public RogueArea setRogueStatus(final int value) {
      bitField0_ |= 0x00000002;
      rogueStatus = value;
      return this;
    }

    /**
     * <code>optional uint32 cur_reach_room_num = 7;</code>
     * @return whether the curReachRoomNum field is set
     */
    public boolean hasCurReachRoomNum() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 cur_reach_room_num = 7;</code>
     * @return this
     */
    public RogueArea clearCurReachRoomNum() {
      bitField0_ &= ~0x00000004;
      curReachRoomNum = 0;
      return this;
    }

    /**
     * <code>optional uint32 cur_reach_room_num = 7;</code>
     * @return the curReachRoomNum
     */
    public int getCurReachRoomNum() {
      return curReachRoomNum;
    }

    /**
     * <code>optional uint32 cur_reach_room_num = 7;</code>
     * @param value the curReachRoomNum to set
     * @return this
     */
    public RogueArea setCurReachRoomNum(final int value) {
      bitField0_ |= 0x00000004;
      curReachRoomNum = value;
      return this;
    }

    /**
     * <code>optional uint32 rogue_area_status = 11;</code>
     * @return whether the rogueAreaStatus field is set
     */
    public boolean hasRogueAreaStatus() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional uint32 rogue_area_status = 11;</code>
     * @return this
     */
    public RogueArea clearRogueAreaStatus() {
      bitField0_ &= ~0x00000008;
      rogueAreaStatus = 0;
      return this;
    }

    /**
     * <code>optional uint32 rogue_area_status = 11;</code>
     * @return the rogueAreaStatus
     */
    public int getRogueAreaStatus() {
      return rogueAreaStatus;
    }

    /**
     * <code>optional uint32 rogue_area_status = 11;</code>
     * @param value the rogueAreaStatus to set
     * @return this
     */
    public RogueArea setRogueAreaStatus(final int value) {
      bitField0_ |= 0x00000008;
      rogueAreaStatus = value;
      return this;
    }

    /**
     * <code>optional uint32 map_id = 13;</code>
     * @return whether the mapId field is set
     */
    public boolean hasMapId() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>optional uint32 map_id = 13;</code>
     * @return this
     */
    public RogueArea clearMapId() {
      bitField0_ &= ~0x00000010;
      mapId = 0;
      return this;
    }

    /**
     * <code>optional uint32 map_id = 13;</code>
     * @return the mapId
     */
    public int getMapId() {
      return mapId;
    }

    /**
     * <code>optional uint32 map_id = 13;</code>
     * @param value the mapId to set
     * @return this
     */
    public RogueArea setMapId(final int value) {
      bitField0_ |= 0x00000010;
      mapId = value;
      return this;
    }

    /**
     * <code>optional bool has_taken_rewards = 4;</code>
     * @return whether the hasTakenRewards field is set
     */
    public boolean hasHasTakenRewards() {
      return (bitField0_ & 0x00000020) != 0;
    }

    /**
     * <code>optional bool has_taken_rewards = 4;</code>
     * @return this
     */
    public RogueArea clearHasTakenRewards() {
      bitField0_ &= ~0x00000020;
      hasTakenRewards = false;
      return this;
    }

    /**
     * <code>optional bool has_taken_rewards = 4;</code>
     * @return the hasTakenRewards
     */
    public boolean getHasTakenRewards() {
      return hasTakenRewards;
    }

    /**
     * <code>optional bool has_taken_rewards = 4;</code>
     * @param value the hasTakenRewards to set
     * @return this
     */
    public RogueArea setHasTakenRewards(final boolean value) {
      bitField0_ |= 0x00000020;
      hasTakenRewards = value;
      return this;
    }

    @Override
    public RogueArea copyFrom(final RogueArea other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        areaId = other.areaId;
        rogueStatus = other.rogueStatus;
        curReachRoomNum = other.curReachRoomNum;
        rogueAreaStatus = other.rogueAreaStatus;
        mapId = other.mapId;
        hasTakenRewards = other.hasTakenRewards;
      }
      return this;
    }

    @Override
    public RogueArea mergeFrom(final RogueArea other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasAreaId()) {
        setAreaId(other.areaId);
      }
      if (other.hasRogueStatus()) {
        setRogueStatus(other.rogueStatus);
      }
      if (other.hasCurReachRoomNum()) {
        setCurReachRoomNum(other.curReachRoomNum);
      }
      if (other.hasRogueAreaStatus()) {
        setRogueAreaStatus(other.rogueAreaStatus);
      }
      if (other.hasMapId()) {
        setMapId(other.mapId);
      }
      if (other.hasHasTakenRewards()) {
        setHasTakenRewards(other.hasTakenRewards);
      }
      return this;
    }

    @Override
    public RogueArea clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      areaId = 0;
      rogueStatus = 0;
      curReachRoomNum = 0;
      rogueAreaStatus = 0;
      mapId = 0;
      hasTakenRewards = false;
      return this;
    }

    @Override
    public RogueArea clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof RogueArea)) {
        return false;
      }
      RogueArea other = (RogueArea) o;
      return bitField0_ == other.bitField0_
        && (!hasAreaId() || areaId == other.areaId)
        && (!hasRogueStatus() || rogueStatus == other.rogueStatus)
        && (!hasCurReachRoomNum() || curReachRoomNum == other.curReachRoomNum)
        && (!hasRogueAreaStatus() || rogueAreaStatus == other.rogueAreaStatus)
        && (!hasMapId() || mapId == other.mapId)
        && (!hasHasTakenRewards() || hasTakenRewards == other.hasTakenRewards);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 16);
        output.writeUInt32NoTag(areaId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 24);
        output.writeUInt32NoTag(rogueStatus);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 56);
        output.writeUInt32NoTag(curReachRoomNum);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(rogueAreaStatus);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRawByte((byte) 104);
        output.writeUInt32NoTag(mapId);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeRawByte((byte) 32);
        output.writeBoolNoTag(hasTakenRewards);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(areaId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(rogueStatus);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(curReachRoomNum);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(rogueAreaStatus);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(mapId);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        size += 2;
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RogueArea mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 16: {
            // areaId
            areaId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 24) {
              break;
            }
          }
          case 24: {
            // rogueStatus
            rogueStatus = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 56) {
              break;
            }
          }
          case 56: {
            // curReachRoomNum
            curReachRoomNum = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // rogueAreaStatus
            rogueAreaStatus = input.readUInt32();
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 104) {
              break;
            }
          }
          case 104: {
            // mapId
            mapId = input.readUInt32();
            bitField0_ |= 0x00000010;
            tag = input.readTag();
            if (tag != 32) {
              break;
            }
          }
          case 32: {
            // hasTakenRewards
            hasTakenRewards = input.readBool();
            bitField0_ |= 0x00000020;
            tag = input.readTag();
            if (tag != 0) {
              break;
            }
          }
          case 0: {
            return this;
          }
          default: {
            if (!input.skipField(tag)) {
              return this;
            }
            tag = input.readTag();
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.areaId, areaId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.rogueStatus, rogueStatus);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.curReachRoomNum, curReachRoomNum);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeUInt32(FieldNames.rogueAreaStatus, rogueAreaStatus);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeUInt32(FieldNames.mapId, mapId);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeBool(FieldNames.hasTakenRewards, hasTakenRewards);
      }
      output.endObject();
    }

    @Override
    public RogueArea mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1409553784:
          case -746472947: {
            if (input.isAtField(FieldNames.areaId)) {
              if (!input.trySkipNullValue()) {
                areaId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -836112788:
          case 1898767863: {
            if (input.isAtField(FieldNames.rogueStatus)) {
              if (!input.trySkipNullValue()) {
                rogueStatus = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 888045080:
          case 328196941: {
            if (input.isAtField(FieldNames.curReachRoomNum)) {
              if (!input.trySkipNullValue()) {
                curReachRoomNum = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -731414439:
          case -1961715457: {
            if (input.isAtField(FieldNames.rogueAreaStatus)) {
              if (!input.trySkipNullValue()) {
                rogueAreaStatus = input.readUInt32();
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 103663511:
          case -1081377058: {
            if (input.isAtField(FieldNames.mapId)) {
              if (!input.trySkipNullValue()) {
                mapId = input.readUInt32();
                bitField0_ |= 0x00000010;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 222364695:
          case -1980321081: {
            if (input.isAtField(FieldNames.hasTakenRewards)) {
              if (!input.trySkipNullValue()) {
                hasTakenRewards = input.readBool();
                bitField0_ |= 0x00000020;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          default: {
            input.skipUnknownField();
            break;
          }
        }
      }
      input.endObject();
      return this;
    }

    @Override
    public RogueArea clone() {
      return new RogueArea().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RogueArea parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RogueArea(), data).checkInitialized();
    }

    public static RogueArea parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueArea(), input).checkInitialized();
    }

    public static RogueArea parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueArea(), input).checkInitialized();
    }

    /**
     * @return factory for creating RogueArea messages
     */
    public static MessageFactory<RogueArea> getFactory() {
      return RogueAreaFactory.INSTANCE;
    }

    private enum RogueAreaFactory implements MessageFactory<RogueArea> {
      INSTANCE;

      @Override
      public RogueArea create() {
        return RogueArea.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName areaId = FieldName.forField("areaId", "area_id");

      static final FieldName rogueStatus = FieldName.forField("rogueStatus", "rogue_status");

      static final FieldName curReachRoomNum = FieldName.forField("curReachRoomNum", "cur_reach_room_num");

      static final FieldName rogueAreaStatus = FieldName.forField("rogueAreaStatus", "rogue_area_status");

      static final FieldName mapId = FieldName.forField("mapId", "map_id");

      static final FieldName hasTakenRewards = FieldName.forField("hasTakenRewards", "has_taken_rewards");
    }
  }
}
