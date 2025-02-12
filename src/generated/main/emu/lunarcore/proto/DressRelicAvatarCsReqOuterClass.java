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
import us.hebi.quickbuf.RepeatedMessage;

public final class DressRelicAvatarCsReqOuterClass {
  /**
   * Protobuf type {@code DressRelicAvatarCsReq}
   */
  public static final class DressRelicAvatarCsReq extends ProtoMessage<DressRelicAvatarCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 avatar_id = 5;</code>
     */
    private int avatarId;

    /**
     * <code>repeated .RelicParam param_list = 4;</code>
     */
    private final RepeatedMessage<RelicParamOuterClass.RelicParam> paramList = RepeatedMessage.newEmptyInstance(RelicParamOuterClass.RelicParam.getFactory());

    private DressRelicAvatarCsReq() {
    }

    /**
     * @return a new empty instance of {@code DressRelicAvatarCsReq}
     */
    public static DressRelicAvatarCsReq newInstance() {
      return new DressRelicAvatarCsReq();
    }

    /**
     * <code>optional uint32 avatar_id = 5;</code>
     * @return whether the avatarId field is set
     */
    public boolean hasAvatarId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 avatar_id = 5;</code>
     * @return this
     */
    public DressRelicAvatarCsReq clearAvatarId() {
      bitField0_ &= ~0x00000001;
      avatarId = 0;
      return this;
    }

    /**
     * <code>optional uint32 avatar_id = 5;</code>
     * @return the avatarId
     */
    public int getAvatarId() {
      return avatarId;
    }

    /**
     * <code>optional uint32 avatar_id = 5;</code>
     * @param value the avatarId to set
     * @return this
     */
    public DressRelicAvatarCsReq setAvatarId(final int value) {
      bitField0_ |= 0x00000001;
      avatarId = value;
      return this;
    }

    /**
     * <code>repeated .RelicParam param_list = 4;</code>
     * @return whether the paramList field is set
     */
    public boolean hasParamList() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>repeated .RelicParam param_list = 4;</code>
     * @return this
     */
    public DressRelicAvatarCsReq clearParamList() {
      bitField0_ &= ~0x00000002;
      paramList.clear();
      return this;
    }

    /**
     * <code>repeated .RelicParam param_list = 4;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableParamList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<RelicParamOuterClass.RelicParam> getParamList() {
      return paramList;
    }

    /**
     * <code>repeated .RelicParam param_list = 4;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<RelicParamOuterClass.RelicParam> getMutableParamList() {
      bitField0_ |= 0x00000002;
      return paramList;
    }

    /**
     * <code>repeated .RelicParam param_list = 4;</code>
     * @param value the paramList to add
     * @return this
     */
    public DressRelicAvatarCsReq addParamList(final RelicParamOuterClass.RelicParam value) {
      bitField0_ |= 0x00000002;
      paramList.add(value);
      return this;
    }

    /**
     * <code>repeated .RelicParam param_list = 4;</code>
     * @param values the paramList to add
     * @return this
     */
    public DressRelicAvatarCsReq addAllParamList(final RelicParamOuterClass.RelicParam... values) {
      bitField0_ |= 0x00000002;
      paramList.addAll(values);
      return this;
    }

    @Override
    public DressRelicAvatarCsReq copyFrom(final DressRelicAvatarCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        avatarId = other.avatarId;
        paramList.copyFrom(other.paramList);
      }
      return this;
    }

    @Override
    public DressRelicAvatarCsReq mergeFrom(final DressRelicAvatarCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasAvatarId()) {
        setAvatarId(other.avatarId);
      }
      if (other.hasParamList()) {
        getMutableParamList().addAll(other.paramList);
      }
      return this;
    }

    @Override
    public DressRelicAvatarCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      avatarId = 0;
      paramList.clear();
      return this;
    }

    @Override
    public DressRelicAvatarCsReq clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      paramList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof DressRelicAvatarCsReq)) {
        return false;
      }
      DressRelicAvatarCsReq other = (DressRelicAvatarCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasAvatarId() || avatarId == other.avatarId)
        && (!hasParamList() || paramList.equals(other.paramList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 40);
        output.writeUInt32NoTag(avatarId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        for (int i = 0; i < paramList.length(); i++) {
          output.writeRawByte((byte) 34);
          output.writeMessageNoTag(paramList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(avatarId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += (1 * paramList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(paramList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public DressRelicAvatarCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 40: {
            // avatarId
            avatarId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 34) {
              break;
            }
          }
          case 34: {
            // paramList
            tag = input.readRepeatedMessage(paramList, tag);
            bitField0_ |= 0x00000002;
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
        output.writeUInt32(FieldNames.avatarId, avatarId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRepeatedMessage(FieldNames.paramList, paramList);
      }
      output.endObject();
    }

    @Override
    public DressRelicAvatarCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1787287636:
          case -428636735: {
            if (input.isAtField(FieldNames.avatarId)) {
              if (!input.trySkipNullValue()) {
                avatarId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1953705675:
          case 452960528: {
            if (input.isAtField(FieldNames.paramList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(paramList);
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
    public DressRelicAvatarCsReq clone() {
      return new DressRelicAvatarCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static DressRelicAvatarCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new DressRelicAvatarCsReq(), data).checkInitialized();
    }

    public static DressRelicAvatarCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new DressRelicAvatarCsReq(), input).checkInitialized();
    }

    public static DressRelicAvatarCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new DressRelicAvatarCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating DressRelicAvatarCsReq messages
     */
    public static MessageFactory<DressRelicAvatarCsReq> getFactory() {
      return DressRelicAvatarCsReqFactory.INSTANCE;
    }

    private enum DressRelicAvatarCsReqFactory implements MessageFactory<DressRelicAvatarCsReq> {
      INSTANCE;

      @Override
      public DressRelicAvatarCsReq create() {
        return DressRelicAvatarCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName avatarId = FieldName.forField("avatarId", "avatar_id");

      static final FieldName paramList = FieldName.forField("paramList", "param_list");
    }
  }
}
