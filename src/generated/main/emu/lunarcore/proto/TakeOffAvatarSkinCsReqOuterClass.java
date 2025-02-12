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

public final class TakeOffAvatarSkinCsReqOuterClass {
  /**
   * Protobuf type {@code TakeOffAvatarSkinCsReq}
   */
  public static final class TakeOffAvatarSkinCsReq extends ProtoMessage<TakeOffAvatarSkinCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 avatar_id = 4;</code>
     */
    private int avatarId;

    private TakeOffAvatarSkinCsReq() {
    }

    /**
     * @return a new empty instance of {@code TakeOffAvatarSkinCsReq}
     */
    public static TakeOffAvatarSkinCsReq newInstance() {
      return new TakeOffAvatarSkinCsReq();
    }

    /**
     * <code>optional uint32 avatar_id = 4;</code>
     * @return whether the avatarId field is set
     */
    public boolean hasAvatarId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 avatar_id = 4;</code>
     * @return this
     */
    public TakeOffAvatarSkinCsReq clearAvatarId() {
      bitField0_ &= ~0x00000001;
      avatarId = 0;
      return this;
    }

    /**
     * <code>optional uint32 avatar_id = 4;</code>
     * @return the avatarId
     */
    public int getAvatarId() {
      return avatarId;
    }

    /**
     * <code>optional uint32 avatar_id = 4;</code>
     * @param value the avatarId to set
     * @return this
     */
    public TakeOffAvatarSkinCsReq setAvatarId(final int value) {
      bitField0_ |= 0x00000001;
      avatarId = value;
      return this;
    }

    @Override
    public TakeOffAvatarSkinCsReq copyFrom(final TakeOffAvatarSkinCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        avatarId = other.avatarId;
      }
      return this;
    }

    @Override
    public TakeOffAvatarSkinCsReq mergeFrom(final TakeOffAvatarSkinCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasAvatarId()) {
        setAvatarId(other.avatarId);
      }
      return this;
    }

    @Override
    public TakeOffAvatarSkinCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      avatarId = 0;
      return this;
    }

    @Override
    public TakeOffAvatarSkinCsReq clearQuick() {
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
      if (!(o instanceof TakeOffAvatarSkinCsReq)) {
        return false;
      }
      TakeOffAvatarSkinCsReq other = (TakeOffAvatarSkinCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasAvatarId() || avatarId == other.avatarId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 32);
        output.writeUInt32NoTag(avatarId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(avatarId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public TakeOffAvatarSkinCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 32: {
            // avatarId
            avatarId = input.readUInt32();
            bitField0_ |= 0x00000001;
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
        output.writeUInt32(FieldNames.avatarId, avatarId);
      }
      output.endObject();
    }

    @Override
    public TakeOffAvatarSkinCsReq mergeFrom(final JsonSource input) throws IOException {
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
    public TakeOffAvatarSkinCsReq clone() {
      return new TakeOffAvatarSkinCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static TakeOffAvatarSkinCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new TakeOffAvatarSkinCsReq(), data).checkInitialized();
    }

    public static TakeOffAvatarSkinCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new TakeOffAvatarSkinCsReq(), input).checkInitialized();
    }

    public static TakeOffAvatarSkinCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new TakeOffAvatarSkinCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating TakeOffAvatarSkinCsReq messages
     */
    public static MessageFactory<TakeOffAvatarSkinCsReq> getFactory() {
      return TakeOffAvatarSkinCsReqFactory.INSTANCE;
    }

    private enum TakeOffAvatarSkinCsReqFactory implements MessageFactory<TakeOffAvatarSkinCsReq> {
      INSTANCE;

      @Override
      public TakeOffAvatarSkinCsReq create() {
        return TakeOffAvatarSkinCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName avatarId = FieldName.forField("avatarId", "avatar_id");
    }
  }
}
