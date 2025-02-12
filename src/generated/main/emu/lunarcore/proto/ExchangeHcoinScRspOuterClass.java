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

public final class ExchangeHcoinScRspOuterClass {
  /**
   * Protobuf type {@code ExchangeHcoinScRsp}
   */
  public static final class ExchangeHcoinScRsp extends ProtoMessage<ExchangeHcoinScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 1;</code>
     */
    private int retcode;

    /**
     * <code>optional uint32 num = 11;</code>
     */
    private int num;

    private ExchangeHcoinScRsp() {
    }

    /**
     * @return a new empty instance of {@code ExchangeHcoinScRsp}
     */
    public static ExchangeHcoinScRsp newInstance() {
      return new ExchangeHcoinScRsp();
    }

    /**
     * <code>optional uint32 retcode = 1;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 1;</code>
     * @return this
     */
    public ExchangeHcoinScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 1;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 1;</code>
     * @param value the retcode to set
     * @return this
     */
    public ExchangeHcoinScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>optional uint32 num = 11;</code>
     * @return whether the num field is set
     */
    public boolean hasNum() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 num = 11;</code>
     * @return this
     */
    public ExchangeHcoinScRsp clearNum() {
      bitField0_ &= ~0x00000002;
      num = 0;
      return this;
    }

    /**
     * <code>optional uint32 num = 11;</code>
     * @return the num
     */
    public int getNum() {
      return num;
    }

    /**
     * <code>optional uint32 num = 11;</code>
     * @param value the num to set
     * @return this
     */
    public ExchangeHcoinScRsp setNum(final int value) {
      bitField0_ |= 0x00000002;
      num = value;
      return this;
    }

    @Override
    public ExchangeHcoinScRsp copyFrom(final ExchangeHcoinScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        num = other.num;
      }
      return this;
    }

    @Override
    public ExchangeHcoinScRsp mergeFrom(final ExchangeHcoinScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasNum()) {
        setNum(other.num);
      }
      return this;
    }

    @Override
    public ExchangeHcoinScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      num = 0;
      return this;
    }

    @Override
    public ExchangeHcoinScRsp clearQuick() {
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
      if (!(o instanceof ExchangeHcoinScRsp)) {
        return false;
      }
      ExchangeHcoinScRsp other = (ExchangeHcoinScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasNum() || num == other.num);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(num);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(num);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ExchangeHcoinScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 8: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // num
            num = input.readUInt32();
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
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.num, num);
      }
      output.endObject();
    }

    @Override
    public ExchangeHcoinScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1097936398: {
            if (input.isAtField(FieldNames.retcode)) {
              if (!input.trySkipNullValue()) {
                retcode = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 109446: {
            if (input.isAtField(FieldNames.num)) {
              if (!input.trySkipNullValue()) {
                num = input.readUInt32();
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
    public ExchangeHcoinScRsp clone() {
      return new ExchangeHcoinScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ExchangeHcoinScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ExchangeHcoinScRsp(), data).checkInitialized();
    }

    public static ExchangeHcoinScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ExchangeHcoinScRsp(), input).checkInitialized();
    }

    public static ExchangeHcoinScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ExchangeHcoinScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating ExchangeHcoinScRsp messages
     */
    public static MessageFactory<ExchangeHcoinScRsp> getFactory() {
      return ExchangeHcoinScRspFactory.INSTANCE;
    }

    private enum ExchangeHcoinScRspFactory implements MessageFactory<ExchangeHcoinScRsp> {
      INSTANCE;

      @Override
      public ExchangeHcoinScRsp create() {
        return ExchangeHcoinScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName num = FieldName.forField("num");
    }
  }
}
