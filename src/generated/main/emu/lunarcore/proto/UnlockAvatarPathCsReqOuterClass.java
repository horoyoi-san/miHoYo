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

public final class UnlockAvatarPathCsReqOuterClass {
  /**
   * Protobuf type {@code UnlockAvatarPathCsReq}
   */
  public static final class UnlockAvatarPathCsReq extends ProtoMessage<UnlockAvatarPathCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional .MultiPathAvatarType avatar_id = 13;</code>
     */
    private int avatarId;

    private UnlockAvatarPathCsReq() {
    }

    /**
     * @return a new empty instance of {@code UnlockAvatarPathCsReq}
     */
    public static UnlockAvatarPathCsReq newInstance() {
      return new UnlockAvatarPathCsReq();
    }

    /**
     * <code>optional .MultiPathAvatarType avatar_id = 13;</code>
     * @return whether the avatarId field is set
     */
    public boolean hasAvatarId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional .MultiPathAvatarType avatar_id = 13;</code>
     * @return this
     */
    public UnlockAvatarPathCsReq clearAvatarId() {
      bitField0_ &= ~0x00000001;
      avatarId = 0;
      return this;
    }

    /**
     * <code>optional .MultiPathAvatarType avatar_id = 13;</code>
     * @return the avatarId
     */
    public MultiPathAvatarTypeOuterClass.MultiPathAvatarType getAvatarId() {
      return MultiPathAvatarTypeOuterClass.MultiPathAvatarType.forNumber(avatarId);
    }

    /**
     * Gets the value of the internal enum store. The result is
     * equivalent to {@link UnlockAvatarPathCsReq#getAvatarId()}.getNumber().
     *
     * @return numeric wire representation
     */
    public int getAvatarIdValue() {
      return avatarId;
    }

    /**
     * Sets the value of the internal enum store. This does not
     * do any validity checks, so be sure to use appropriate value
     * constants from {@link MultiPathAvatarTypeOuterClass.MultiPathAvatarType}. Setting an invalid value
     * can cause {@link UnlockAvatarPathCsReq#getAvatarId()} to return null
     *
     * @param value the numeric wire value to set
     * @return this
     */
    public UnlockAvatarPathCsReq setAvatarIdValue(final int value) {
      bitField0_ |= 0x00000001;
      avatarId = value;
      return this;
    }

    /**
     * <code>optional .MultiPathAvatarType avatar_id = 13;</code>
     * @param value the avatarId to set
     * @return this
     */
    public UnlockAvatarPathCsReq setAvatarId(
        final MultiPathAvatarTypeOuterClass.MultiPathAvatarType value) {
      bitField0_ |= 0x00000001;
      avatarId = value.getNumber();
      return this;
    }

    @Override
    public UnlockAvatarPathCsReq copyFrom(final UnlockAvatarPathCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        avatarId = other.avatarId;
      }
      return this;
    }

    @Override
    public UnlockAvatarPathCsReq mergeFrom(final UnlockAvatarPathCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasAvatarId()) {
        setAvatarIdValue(other.avatarId);
      }
      return this;
    }

    @Override
    public UnlockAvatarPathCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      avatarId = 0;
      return this;
    }

    @Override
    public UnlockAvatarPathCsReq clearQuick() {
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
      if (!(o instanceof UnlockAvatarPathCsReq)) {
        return false;
      }
      UnlockAvatarPathCsReq other = (UnlockAvatarPathCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasAvatarId() || avatarId == other.avatarId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 104);
        output.writeEnumNoTag(avatarId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeEnumSizeNoTag(avatarId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public UnlockAvatarPathCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 104: {
            // avatarId
            final int value = input.readInt32();
            if (MultiPathAvatarTypeOuterClass.MultiPathAvatarType.forNumber(value) != null) {
              avatarId = value;
              bitField0_ |= 0x00000001;
            }
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
        output.writeEnum(FieldNames.avatarId, avatarId, MultiPathAvatarTypeOuterClass.MultiPathAvatarType.converter());
      }
      output.endObject();
    }

    @Override
    public UnlockAvatarPathCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1787287636:
          case -428636735: {
            if (input.isAtField(FieldNames.avatarId)) {
              if (!input.trySkipNullValue()) {
                final MultiPathAvatarTypeOuterClass.MultiPathAvatarType value = input.readEnum(MultiPathAvatarTypeOuterClass.MultiPathAvatarType.converter());
                if (value != null) {
                  avatarId = value.getNumber();
                  bitField0_ |= 0x00000001;
                } else {
                  input.skipUnknownEnumValue();
                }
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
    public UnlockAvatarPathCsReq clone() {
      return new UnlockAvatarPathCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static UnlockAvatarPathCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new UnlockAvatarPathCsReq(), data).checkInitialized();
    }

    public static UnlockAvatarPathCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UnlockAvatarPathCsReq(), input).checkInitialized();
    }

    public static UnlockAvatarPathCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UnlockAvatarPathCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating UnlockAvatarPathCsReq messages
     */
    public static MessageFactory<UnlockAvatarPathCsReq> getFactory() {
      return UnlockAvatarPathCsReqFactory.INSTANCE;
    }

    private enum UnlockAvatarPathCsReqFactory implements MessageFactory<UnlockAvatarPathCsReq> {
      INSTANCE;

      @Override
      public UnlockAvatarPathCsReq create() {
        return UnlockAvatarPathCsReq.newInstance();
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
