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

public final class AvatarPresetHpOuterClass {
  /**
   * Protobuf type {@code AvatarPresetHp}
   */
  public static final class AvatarPresetHp extends ProtoMessage<AvatarPresetHp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 JLAFLDCHDGJ = 1;</code>
     */
    private int jLAFLDCHDGJ;

    /**
     * <code>optional uint32 avatar_id = 13;</code>
     */
    private int avatarId;

    private AvatarPresetHp() {
    }

    /**
     * @return a new empty instance of {@code AvatarPresetHp}
     */
    public static AvatarPresetHp newInstance() {
      return new AvatarPresetHp();
    }

    /**
     * <code>optional uint32 JLAFLDCHDGJ = 1;</code>
     * @return whether the jLAFLDCHDGJ field is set
     */
    public boolean hasJLAFLDCHDGJ() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 JLAFLDCHDGJ = 1;</code>
     * @return this
     */
    public AvatarPresetHp clearJLAFLDCHDGJ() {
      bitField0_ &= ~0x00000001;
      jLAFLDCHDGJ = 0;
      return this;
    }

    /**
     * <code>optional uint32 JLAFLDCHDGJ = 1;</code>
     * @return the jLAFLDCHDGJ
     */
    public int getJLAFLDCHDGJ() {
      return jLAFLDCHDGJ;
    }

    /**
     * <code>optional uint32 JLAFLDCHDGJ = 1;</code>
     * @param value the jLAFLDCHDGJ to set
     * @return this
     */
    public AvatarPresetHp setJLAFLDCHDGJ(final int value) {
      bitField0_ |= 0x00000001;
      jLAFLDCHDGJ = value;
      return this;
    }

    /**
     * <code>optional uint32 avatar_id = 13;</code>
     * @return whether the avatarId field is set
     */
    public boolean hasAvatarId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 avatar_id = 13;</code>
     * @return this
     */
    public AvatarPresetHp clearAvatarId() {
      bitField0_ &= ~0x00000002;
      avatarId = 0;
      return this;
    }

    /**
     * <code>optional uint32 avatar_id = 13;</code>
     * @return the avatarId
     */
    public int getAvatarId() {
      return avatarId;
    }

    /**
     * <code>optional uint32 avatar_id = 13;</code>
     * @param value the avatarId to set
     * @return this
     */
    public AvatarPresetHp setAvatarId(final int value) {
      bitField0_ |= 0x00000002;
      avatarId = value;
      return this;
    }

    @Override
    public AvatarPresetHp copyFrom(final AvatarPresetHp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        jLAFLDCHDGJ = other.jLAFLDCHDGJ;
        avatarId = other.avatarId;
      }
      return this;
    }

    @Override
    public AvatarPresetHp mergeFrom(final AvatarPresetHp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasJLAFLDCHDGJ()) {
        setJLAFLDCHDGJ(other.jLAFLDCHDGJ);
      }
      if (other.hasAvatarId()) {
        setAvatarId(other.avatarId);
      }
      return this;
    }

    @Override
    public AvatarPresetHp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      jLAFLDCHDGJ = 0;
      avatarId = 0;
      return this;
    }

    @Override
    public AvatarPresetHp clearQuick() {
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
      if (!(o instanceof AvatarPresetHp)) {
        return false;
      }
      AvatarPresetHp other = (AvatarPresetHp) o;
      return bitField0_ == other.bitField0_
        && (!hasJLAFLDCHDGJ() || jLAFLDCHDGJ == other.jLAFLDCHDGJ)
        && (!hasAvatarId() || avatarId == other.avatarId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(jLAFLDCHDGJ);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 104);
        output.writeUInt32NoTag(avatarId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(jLAFLDCHDGJ);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(avatarId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public AvatarPresetHp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 8: {
            // jLAFLDCHDGJ
            jLAFLDCHDGJ = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 104) {
              break;
            }
          }
          case 104: {
            // avatarId
            avatarId = input.readUInt32();
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
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.jLAFLDCHDGJ, jLAFLDCHDGJ);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.avatarId, avatarId);
      }
      output.endObject();
    }

    @Override
    public AvatarPresetHp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -921649053: {
            if (input.isAtField(FieldNames.jLAFLDCHDGJ)) {
              if (!input.trySkipNullValue()) {
                jLAFLDCHDGJ = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1787287636:
          case -428636735: {
            if (input.isAtField(FieldNames.avatarId)) {
              if (!input.trySkipNullValue()) {
                avatarId = input.readUInt32();
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
    public AvatarPresetHp clone() {
      return new AvatarPresetHp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static AvatarPresetHp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new AvatarPresetHp(), data).checkInitialized();
    }

    public static AvatarPresetHp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new AvatarPresetHp(), input).checkInitialized();
    }

    public static AvatarPresetHp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new AvatarPresetHp(), input).checkInitialized();
    }

    /**
     * @return factory for creating AvatarPresetHp messages
     */
    public static MessageFactory<AvatarPresetHp> getFactory() {
      return AvatarPresetHpFactory.INSTANCE;
    }

    private enum AvatarPresetHpFactory implements MessageFactory<AvatarPresetHp> {
      INSTANCE;

      @Override
      public AvatarPresetHp create() {
        return AvatarPresetHp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName jLAFLDCHDGJ = FieldName.forField("JLAFLDCHDGJ");

      static final FieldName avatarId = FieldName.forField("avatarId", "avatar_id");
    }
  }
}
