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

public final class UnlockSkilltreeScRspOuterClass {
  /**
   * Protobuf type {@code UnlockSkilltreeScRsp}
   */
  public static final class UnlockSkilltreeScRsp extends ProtoMessage<UnlockSkilltreeScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 point_id = 4;</code>
     */
    private int pointId;

    /**
     * <code>optional uint32 level = 7;</code>
     */
    private int level;

    /**
     * <code>optional uint32 retcode = 13;</code>
     */
    private int retcode;

    private UnlockSkilltreeScRsp() {
    }

    /**
     * @return a new empty instance of {@code UnlockSkilltreeScRsp}
     */
    public static UnlockSkilltreeScRsp newInstance() {
      return new UnlockSkilltreeScRsp();
    }

    /**
     * <code>optional uint32 point_id = 4;</code>
     * @return whether the pointId field is set
     */
    public boolean hasPointId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 point_id = 4;</code>
     * @return this
     */
    public UnlockSkilltreeScRsp clearPointId() {
      bitField0_ &= ~0x00000001;
      pointId = 0;
      return this;
    }

    /**
     * <code>optional uint32 point_id = 4;</code>
     * @return the pointId
     */
    public int getPointId() {
      return pointId;
    }

    /**
     * <code>optional uint32 point_id = 4;</code>
     * @param value the pointId to set
     * @return this
     */
    public UnlockSkilltreeScRsp setPointId(final int value) {
      bitField0_ |= 0x00000001;
      pointId = value;
      return this;
    }

    /**
     * <code>optional uint32 level = 7;</code>
     * @return whether the level field is set
     */
    public boolean hasLevel() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 level = 7;</code>
     * @return this
     */
    public UnlockSkilltreeScRsp clearLevel() {
      bitField0_ &= ~0x00000002;
      level = 0;
      return this;
    }

    /**
     * <code>optional uint32 level = 7;</code>
     * @return the level
     */
    public int getLevel() {
      return level;
    }

    /**
     * <code>optional uint32 level = 7;</code>
     * @param value the level to set
     * @return this
     */
    public UnlockSkilltreeScRsp setLevel(final int value) {
      bitField0_ |= 0x00000002;
      level = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 13;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 retcode = 13;</code>
     * @return this
     */
    public UnlockSkilltreeScRsp clearRetcode() {
      bitField0_ &= ~0x00000004;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 13;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 13;</code>
     * @param value the retcode to set
     * @return this
     */
    public UnlockSkilltreeScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000004;
      retcode = value;
      return this;
    }

    @Override
    public UnlockSkilltreeScRsp copyFrom(final UnlockSkilltreeScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        pointId = other.pointId;
        level = other.level;
        retcode = other.retcode;
      }
      return this;
    }

    @Override
    public UnlockSkilltreeScRsp mergeFrom(final UnlockSkilltreeScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasPointId()) {
        setPointId(other.pointId);
      }
      if (other.hasLevel()) {
        setLevel(other.level);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      return this;
    }

    @Override
    public UnlockSkilltreeScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      pointId = 0;
      level = 0;
      retcode = 0;
      return this;
    }

    @Override
    public UnlockSkilltreeScRsp clearQuick() {
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
      if (!(o instanceof UnlockSkilltreeScRsp)) {
        return false;
      }
      UnlockSkilltreeScRsp other = (UnlockSkilltreeScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasPointId() || pointId == other.pointId)
        && (!hasLevel() || level == other.level)
        && (!hasRetcode() || retcode == other.retcode);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 32);
        output.writeUInt32NoTag(pointId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 56);
        output.writeUInt32NoTag(level);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 104);
        output.writeUInt32NoTag(retcode);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(pointId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(level);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public UnlockSkilltreeScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 32: {
            // pointId
            pointId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 56) {
              break;
            }
          }
          case 56: {
            // level
            level = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 104) {
              break;
            }
          }
          case 104: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000004;
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
        output.writeUInt32(FieldNames.pointId, pointId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.level, level);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      output.endObject();
    }

    @Override
    public UnlockSkilltreeScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -400606517:
          case 466121258: {
            if (input.isAtField(FieldNames.pointId)) {
              if (!input.trySkipNullValue()) {
                pointId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 102865796: {
            if (input.isAtField(FieldNames.level)) {
              if (!input.trySkipNullValue()) {
                level = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1097936398: {
            if (input.isAtField(FieldNames.retcode)) {
              if (!input.trySkipNullValue()) {
                retcode = input.readUInt32();
                bitField0_ |= 0x00000004;
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
    public UnlockSkilltreeScRsp clone() {
      return new UnlockSkilltreeScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static UnlockSkilltreeScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new UnlockSkilltreeScRsp(), data).checkInitialized();
    }

    public static UnlockSkilltreeScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UnlockSkilltreeScRsp(), input).checkInitialized();
    }

    public static UnlockSkilltreeScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UnlockSkilltreeScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating UnlockSkilltreeScRsp messages
     */
    public static MessageFactory<UnlockSkilltreeScRsp> getFactory() {
      return UnlockSkilltreeScRspFactory.INSTANCE;
    }

    private enum UnlockSkilltreeScRspFactory implements MessageFactory<UnlockSkilltreeScRsp> {
      INSTANCE;

      @Override
      public UnlockSkilltreeScRsp create() {
        return UnlockSkilltreeScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName pointId = FieldName.forField("pointId", "point_id");

      static final FieldName level = FieldName.forField("level");

      static final FieldName retcode = FieldName.forField("retcode");
    }
  }
}
