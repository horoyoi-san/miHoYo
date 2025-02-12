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

public final class IGFLEJNLOMMOuterClass {
  /**
   * Protobuf type {@code IGFLEJNLOMM}
   */
  public static final class IGFLEJNLOMM extends ProtoMessage<IGFLEJNLOMM> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 num = 12;</code>
     */
    private int num;

    /**
     * <code>optional uint32 JIJIEKNBNPE = 15;</code>
     */
    private int jIJIEKNBNPE;

    private IGFLEJNLOMM() {
    }

    /**
     * @return a new empty instance of {@code IGFLEJNLOMM}
     */
    public static IGFLEJNLOMM newInstance() {
      return new IGFLEJNLOMM();
    }

    /**
     * <code>optional uint32 num = 12;</code>
     * @return whether the num field is set
     */
    public boolean hasNum() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 num = 12;</code>
     * @return this
     */
    public IGFLEJNLOMM clearNum() {
      bitField0_ &= ~0x00000001;
      num = 0;
      return this;
    }

    /**
     * <code>optional uint32 num = 12;</code>
     * @return the num
     */
    public int getNum() {
      return num;
    }

    /**
     * <code>optional uint32 num = 12;</code>
     * @param value the num to set
     * @return this
     */
    public IGFLEJNLOMM setNum(final int value) {
      bitField0_ |= 0x00000001;
      num = value;
      return this;
    }

    /**
     * <code>optional uint32 JIJIEKNBNPE = 15;</code>
     * @return whether the jIJIEKNBNPE field is set
     */
    public boolean hasJIJIEKNBNPE() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 JIJIEKNBNPE = 15;</code>
     * @return this
     */
    public IGFLEJNLOMM clearJIJIEKNBNPE() {
      bitField0_ &= ~0x00000002;
      jIJIEKNBNPE = 0;
      return this;
    }

    /**
     * <code>optional uint32 JIJIEKNBNPE = 15;</code>
     * @return the jIJIEKNBNPE
     */
    public int getJIJIEKNBNPE() {
      return jIJIEKNBNPE;
    }

    /**
     * <code>optional uint32 JIJIEKNBNPE = 15;</code>
     * @param value the jIJIEKNBNPE to set
     * @return this
     */
    public IGFLEJNLOMM setJIJIEKNBNPE(final int value) {
      bitField0_ |= 0x00000002;
      jIJIEKNBNPE = value;
      return this;
    }

    @Override
    public IGFLEJNLOMM copyFrom(final IGFLEJNLOMM other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        num = other.num;
        jIJIEKNBNPE = other.jIJIEKNBNPE;
      }
      return this;
    }

    @Override
    public IGFLEJNLOMM mergeFrom(final IGFLEJNLOMM other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasNum()) {
        setNum(other.num);
      }
      if (other.hasJIJIEKNBNPE()) {
        setJIJIEKNBNPE(other.jIJIEKNBNPE);
      }
      return this;
    }

    @Override
    public IGFLEJNLOMM clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      num = 0;
      jIJIEKNBNPE = 0;
      return this;
    }

    @Override
    public IGFLEJNLOMM clearQuick() {
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
      if (!(o instanceof IGFLEJNLOMM)) {
        return false;
      }
      IGFLEJNLOMM other = (IGFLEJNLOMM) o;
      return bitField0_ == other.bitField0_
        && (!hasNum() || num == other.num)
        && (!hasJIJIEKNBNPE() || jIJIEKNBNPE == other.jIJIEKNBNPE);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 96);
        output.writeUInt32NoTag(num);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(jIJIEKNBNPE);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(num);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(jIJIEKNBNPE);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public IGFLEJNLOMM mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 96: {
            // num
            num = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // jIJIEKNBNPE
            jIJIEKNBNPE = input.readUInt32();
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
        output.writeUInt32(FieldNames.num, num);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.jIJIEKNBNPE, jIJIEKNBNPE);
      }
      output.endObject();
    }

    @Override
    public IGFLEJNLOMM mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 109446: {
            if (input.isAtField(FieldNames.num)) {
              if (!input.trySkipNullValue()) {
                num = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -193030357: {
            if (input.isAtField(FieldNames.jIJIEKNBNPE)) {
              if (!input.trySkipNullValue()) {
                jIJIEKNBNPE = input.readUInt32();
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
    public IGFLEJNLOMM clone() {
      return new IGFLEJNLOMM().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static IGFLEJNLOMM parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new IGFLEJNLOMM(), data).checkInitialized();
    }

    public static IGFLEJNLOMM parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new IGFLEJNLOMM(), input).checkInitialized();
    }

    public static IGFLEJNLOMM parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new IGFLEJNLOMM(), input).checkInitialized();
    }

    /**
     * @return factory for creating IGFLEJNLOMM messages
     */
    public static MessageFactory<IGFLEJNLOMM> getFactory() {
      return IGFLEJNLOMMFactory.INSTANCE;
    }

    private enum IGFLEJNLOMMFactory implements MessageFactory<IGFLEJNLOMM> {
      INSTANCE;

      @Override
      public IGFLEJNLOMM create() {
        return IGFLEJNLOMM.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName num = FieldName.forField("num");

      static final FieldName jIJIEKNBNPE = FieldName.forField("JIJIEKNBNPE");
    }
  }
}
