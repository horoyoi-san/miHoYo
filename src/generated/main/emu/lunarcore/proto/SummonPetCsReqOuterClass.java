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

public final class SummonPetCsReqOuterClass {
  /**
   * Protobuf type {@code SummonPetCsReq}
   */
  public static final class SummonPetCsReq extends ProtoMessage<SummonPetCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 summoned_pet_id = 5;</code>
     */
    private int summonedPetId;

    private SummonPetCsReq() {
    }

    /**
     * @return a new empty instance of {@code SummonPetCsReq}
     */
    public static SummonPetCsReq newInstance() {
      return new SummonPetCsReq();
    }

    /**
     * <code>optional uint32 summoned_pet_id = 5;</code>
     * @return whether the summonedPetId field is set
     */
    public boolean hasSummonedPetId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 summoned_pet_id = 5;</code>
     * @return this
     */
    public SummonPetCsReq clearSummonedPetId() {
      bitField0_ &= ~0x00000001;
      summonedPetId = 0;
      return this;
    }

    /**
     * <code>optional uint32 summoned_pet_id = 5;</code>
     * @return the summonedPetId
     */
    public int getSummonedPetId() {
      return summonedPetId;
    }

    /**
     * <code>optional uint32 summoned_pet_id = 5;</code>
     * @param value the summonedPetId to set
     * @return this
     */
    public SummonPetCsReq setSummonedPetId(final int value) {
      bitField0_ |= 0x00000001;
      summonedPetId = value;
      return this;
    }

    @Override
    public SummonPetCsReq copyFrom(final SummonPetCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        summonedPetId = other.summonedPetId;
      }
      return this;
    }

    @Override
    public SummonPetCsReq mergeFrom(final SummonPetCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasSummonedPetId()) {
        setSummonedPetId(other.summonedPetId);
      }
      return this;
    }

    @Override
    public SummonPetCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      summonedPetId = 0;
      return this;
    }

    @Override
    public SummonPetCsReq clearQuick() {
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
      if (!(o instanceof SummonPetCsReq)) {
        return false;
      }
      SummonPetCsReq other = (SummonPetCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasSummonedPetId() || summonedPetId == other.summonedPetId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 40);
        output.writeUInt32NoTag(summonedPetId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(summonedPetId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SummonPetCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 40: {
            // summonedPetId
            summonedPetId = input.readUInt32();
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
        output.writeUInt32(FieldNames.summonedPetId, summonedPetId);
      }
      output.endObject();
    }

    @Override
    public SummonPetCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1942999750:
          case 1818014746: {
            if (input.isAtField(FieldNames.summonedPetId)) {
              if (!input.trySkipNullValue()) {
                summonedPetId = input.readUInt32();
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
    public SummonPetCsReq clone() {
      return new SummonPetCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SummonPetCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SummonPetCsReq(), data).checkInitialized();
    }

    public static SummonPetCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SummonPetCsReq(), input).checkInitialized();
    }

    public static SummonPetCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SummonPetCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating SummonPetCsReq messages
     */
    public static MessageFactory<SummonPetCsReq> getFactory() {
      return SummonPetCsReqFactory.INSTANCE;
    }

    private enum SummonPetCsReqFactory implements MessageFactory<SummonPetCsReq> {
      INSTANCE;

      @Override
      public SummonPetCsReq create() {
        return SummonPetCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName summonedPetId = FieldName.forField("summonedPetId", "summoned_pet_id");
    }
  }
}
