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
import us.hebi.quickbuf.RepeatedInt;

public final class RogueArcadeStartCsReqOuterClass {
  /**
   * Protobuf type {@code RogueArcadeStartCsReq}
   */
  public static final class RogueArcadeStartCsReq extends ProtoMessage<RogueArcadeStartCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 room_id = 14;</code>
     */
    private int roomId;

    /**
     * <code>repeated uint32 base_avatar_id_list = 2;</code>
     */
    private final RepeatedInt baseAvatarIdList = RepeatedInt.newEmptyInstance();

    private RogueArcadeStartCsReq() {
    }

    /**
     * @return a new empty instance of {@code RogueArcadeStartCsReq}
     */
    public static RogueArcadeStartCsReq newInstance() {
      return new RogueArcadeStartCsReq();
    }

    /**
     * <code>optional uint32 room_id = 14;</code>
     * @return whether the roomId field is set
     */
    public boolean hasRoomId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 room_id = 14;</code>
     * @return this
     */
    public RogueArcadeStartCsReq clearRoomId() {
      bitField0_ &= ~0x00000001;
      roomId = 0;
      return this;
    }

    /**
     * <code>optional uint32 room_id = 14;</code>
     * @return the roomId
     */
    public int getRoomId() {
      return roomId;
    }

    /**
     * <code>optional uint32 room_id = 14;</code>
     * @param value the roomId to set
     * @return this
     */
    public RogueArcadeStartCsReq setRoomId(final int value) {
      bitField0_ |= 0x00000001;
      roomId = value;
      return this;
    }

    /**
     * <code>repeated uint32 base_avatar_id_list = 2;</code>
     * @return whether the baseAvatarIdList field is set
     */
    public boolean hasBaseAvatarIdList() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>repeated uint32 base_avatar_id_list = 2;</code>
     * @return this
     */
    public RogueArcadeStartCsReq clearBaseAvatarIdList() {
      bitField0_ &= ~0x00000002;
      baseAvatarIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 base_avatar_id_list = 2;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableBaseAvatarIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getBaseAvatarIdList() {
      return baseAvatarIdList;
    }

    /**
     * <code>repeated uint32 base_avatar_id_list = 2;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableBaseAvatarIdList() {
      bitField0_ |= 0x00000002;
      return baseAvatarIdList;
    }

    /**
     * <code>repeated uint32 base_avatar_id_list = 2;</code>
     * @param value the baseAvatarIdList to add
     * @return this
     */
    public RogueArcadeStartCsReq addBaseAvatarIdList(final int value) {
      bitField0_ |= 0x00000002;
      baseAvatarIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 base_avatar_id_list = 2;</code>
     * @param values the baseAvatarIdList to add
     * @return this
     */
    public RogueArcadeStartCsReq addAllBaseAvatarIdList(final int... values) {
      bitField0_ |= 0x00000002;
      baseAvatarIdList.addAll(values);
      return this;
    }

    @Override
    public RogueArcadeStartCsReq copyFrom(final RogueArcadeStartCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        roomId = other.roomId;
        baseAvatarIdList.copyFrom(other.baseAvatarIdList);
      }
      return this;
    }

    @Override
    public RogueArcadeStartCsReq mergeFrom(final RogueArcadeStartCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRoomId()) {
        setRoomId(other.roomId);
      }
      if (other.hasBaseAvatarIdList()) {
        getMutableBaseAvatarIdList().addAll(other.baseAvatarIdList);
      }
      return this;
    }

    @Override
    public RogueArcadeStartCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      roomId = 0;
      baseAvatarIdList.clear();
      return this;
    }

    @Override
    public RogueArcadeStartCsReq clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      baseAvatarIdList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof RogueArcadeStartCsReq)) {
        return false;
      }
      RogueArcadeStartCsReq other = (RogueArcadeStartCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasRoomId() || roomId == other.roomId)
        && (!hasBaseAvatarIdList() || baseAvatarIdList.equals(other.baseAvatarIdList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 112);
        output.writeUInt32NoTag(roomId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        for (int i = 0; i < baseAvatarIdList.length(); i++) {
          output.writeRawByte((byte) 16);
          output.writeUInt32NoTag(baseAvatarIdList.array()[i]);
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(roomId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += (1 * baseAvatarIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(baseAvatarIdList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RogueArcadeStartCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 112: {
            // roomId
            roomId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 18) {
              break;
            }
          }
          case 18: {
            // baseAvatarIdList [packed=true]
            input.readPackedUInt32(baseAvatarIdList, tag);
            bitField0_ |= 0x00000002;
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
          case 16: {
            // baseAvatarIdList [packed=false]
            tag = input.readRepeatedUInt32(baseAvatarIdList, tag);
            bitField0_ |= 0x00000002;
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.roomId, roomId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRepeatedUInt32(FieldNames.baseAvatarIdList, baseAvatarIdList);
      }
      output.endObject();
    }

    @Override
    public RogueArcadeStartCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -925319338:
          case 1379892991: {
            if (input.isAtField(FieldNames.roomId)) {
              if (!input.trySkipNullValue()) {
                roomId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1212654461:
          case 914628490: {
            if (input.isAtField(FieldNames.baseAvatarIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(baseAvatarIdList);
                bitField0_ |= 0x00000002;
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
    public RogueArcadeStartCsReq clone() {
      return new RogueArcadeStartCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RogueArcadeStartCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RogueArcadeStartCsReq(), data).checkInitialized();
    }

    public static RogueArcadeStartCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueArcadeStartCsReq(), input).checkInitialized();
    }

    public static RogueArcadeStartCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueArcadeStartCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating RogueArcadeStartCsReq messages
     */
    public static MessageFactory<RogueArcadeStartCsReq> getFactory() {
      return RogueArcadeStartCsReqFactory.INSTANCE;
    }

    private enum RogueArcadeStartCsReqFactory implements MessageFactory<RogueArcadeStartCsReq> {
      INSTANCE;

      @Override
      public RogueArcadeStartCsReq create() {
        return RogueArcadeStartCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName roomId = FieldName.forField("roomId", "room_id");

      static final FieldName baseAvatarIdList = FieldName.forField("baseAvatarIdList", "base_avatar_id_list");
    }
  }
}
