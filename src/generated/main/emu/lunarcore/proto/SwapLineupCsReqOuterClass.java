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

public final class SwapLineupCsReqOuterClass {
  /**
   * Protobuf type {@code SwapLineupCsReq}
   */
  public static final class SwapLineupCsReq extends ProtoMessage<SwapLineupCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 index = 4;</code>
     */
    private int index;

    /**
     * <code>optional uint32 plane_id = 8;</code>
     */
    private int planeId;

    /**
     * <pre>
     *  10
     * </pre>
     *
     * <code>optional uint32 dst_slot = 11;</code>
     */
    private int dstSlot;

    /**
     * <pre>
     *  1
     * </pre>
     *
     * <code>optional uint32 src_slot = 15;</code>
     */
    private int srcSlot;

    /**
     * <code>optional .ExtraLineupType extra_lineup_type = 3;</code>
     */
    private int extraLineupType;

    /**
     * <code>optional bool is_virtual = 10;</code>
     */
    private boolean isVirtual;

    private SwapLineupCsReq() {
    }

    /**
     * @return a new empty instance of {@code SwapLineupCsReq}
     */
    public static SwapLineupCsReq newInstance() {
      return new SwapLineupCsReq();
    }

    /**
     * <code>optional uint32 index = 4;</code>
     * @return whether the index field is set
     */
    public boolean hasIndex() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 index = 4;</code>
     * @return this
     */
    public SwapLineupCsReq clearIndex() {
      bitField0_ &= ~0x00000001;
      index = 0;
      return this;
    }

    /**
     * <code>optional uint32 index = 4;</code>
     * @return the index
     */
    public int getIndex() {
      return index;
    }

    /**
     * <code>optional uint32 index = 4;</code>
     * @param value the index to set
     * @return this
     */
    public SwapLineupCsReq setIndex(final int value) {
      bitField0_ |= 0x00000001;
      index = value;
      return this;
    }

    /**
     * <code>optional uint32 plane_id = 8;</code>
     * @return whether the planeId field is set
     */
    public boolean hasPlaneId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 plane_id = 8;</code>
     * @return this
     */
    public SwapLineupCsReq clearPlaneId() {
      bitField0_ &= ~0x00000002;
      planeId = 0;
      return this;
    }

    /**
     * <code>optional uint32 plane_id = 8;</code>
     * @return the planeId
     */
    public int getPlaneId() {
      return planeId;
    }

    /**
     * <code>optional uint32 plane_id = 8;</code>
     * @param value the planeId to set
     * @return this
     */
    public SwapLineupCsReq setPlaneId(final int value) {
      bitField0_ |= 0x00000002;
      planeId = value;
      return this;
    }

    /**
     * <pre>
     *  10
     * </pre>
     *
     * <code>optional uint32 dst_slot = 11;</code>
     * @return whether the dstSlot field is set
     */
    public boolean hasDstSlot() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <pre>
     *  10
     * </pre>
     *
     * <code>optional uint32 dst_slot = 11;</code>
     * @return this
     */
    public SwapLineupCsReq clearDstSlot() {
      bitField0_ &= ~0x00000004;
      dstSlot = 0;
      return this;
    }

    /**
     * <pre>
     *  10
     * </pre>
     *
     * <code>optional uint32 dst_slot = 11;</code>
     * @return the dstSlot
     */
    public int getDstSlot() {
      return dstSlot;
    }

    /**
     * <pre>
     *  10
     * </pre>
     *
     * <code>optional uint32 dst_slot = 11;</code>
     * @param value the dstSlot to set
     * @return this
     */
    public SwapLineupCsReq setDstSlot(final int value) {
      bitField0_ |= 0x00000004;
      dstSlot = value;
      return this;
    }

    /**
     * <pre>
     *  1
     * </pre>
     *
     * <code>optional uint32 src_slot = 15;</code>
     * @return whether the srcSlot field is set
     */
    public boolean hasSrcSlot() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <pre>
     *  1
     * </pre>
     *
     * <code>optional uint32 src_slot = 15;</code>
     * @return this
     */
    public SwapLineupCsReq clearSrcSlot() {
      bitField0_ &= ~0x00000008;
      srcSlot = 0;
      return this;
    }

    /**
     * <pre>
     *  1
     * </pre>
     *
     * <code>optional uint32 src_slot = 15;</code>
     * @return the srcSlot
     */
    public int getSrcSlot() {
      return srcSlot;
    }

    /**
     * <pre>
     *  1
     * </pre>
     *
     * <code>optional uint32 src_slot = 15;</code>
     * @param value the srcSlot to set
     * @return this
     */
    public SwapLineupCsReq setSrcSlot(final int value) {
      bitField0_ |= 0x00000008;
      srcSlot = value;
      return this;
    }

    /**
     * <code>optional .ExtraLineupType extra_lineup_type = 3;</code>
     * @return whether the extraLineupType field is set
     */
    public boolean hasExtraLineupType() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>optional .ExtraLineupType extra_lineup_type = 3;</code>
     * @return this
     */
    public SwapLineupCsReq clearExtraLineupType() {
      bitField0_ &= ~0x00000010;
      extraLineupType = 0;
      return this;
    }

    /**
     * <code>optional .ExtraLineupType extra_lineup_type = 3;</code>
     * @return the extraLineupType
     */
    public ExtraLineupTypeOuterClass.ExtraLineupType getExtraLineupType() {
      return ExtraLineupTypeOuterClass.ExtraLineupType.forNumber(extraLineupType);
    }

    /**
     * Gets the value of the internal enum store. The result is
     * equivalent to {@link SwapLineupCsReq#getExtraLineupType()}.getNumber().
     *
     * @return numeric wire representation
     */
    public int getExtraLineupTypeValue() {
      return extraLineupType;
    }

    /**
     * Sets the value of the internal enum store. This does not
     * do any validity checks, so be sure to use appropriate value
     * constants from {@link ExtraLineupTypeOuterClass.ExtraLineupType}. Setting an invalid value
     * can cause {@link SwapLineupCsReq#getExtraLineupType()} to return null
     *
     * @param value the numeric wire value to set
     * @return this
     */
    public SwapLineupCsReq setExtraLineupTypeValue(final int value) {
      bitField0_ |= 0x00000010;
      extraLineupType = value;
      return this;
    }

    /**
     * <code>optional .ExtraLineupType extra_lineup_type = 3;</code>
     * @param value the extraLineupType to set
     * @return this
     */
    public SwapLineupCsReq setExtraLineupType(
        final ExtraLineupTypeOuterClass.ExtraLineupType value) {
      bitField0_ |= 0x00000010;
      extraLineupType = value.getNumber();
      return this;
    }

    /**
     * <code>optional bool is_virtual = 10;</code>
     * @return whether the isVirtual field is set
     */
    public boolean hasIsVirtual() {
      return (bitField0_ & 0x00000020) != 0;
    }

    /**
     * <code>optional bool is_virtual = 10;</code>
     * @return this
     */
    public SwapLineupCsReq clearIsVirtual() {
      bitField0_ &= ~0x00000020;
      isVirtual = false;
      return this;
    }

    /**
     * <code>optional bool is_virtual = 10;</code>
     * @return the isVirtual
     */
    public boolean getIsVirtual() {
      return isVirtual;
    }

    /**
     * <code>optional bool is_virtual = 10;</code>
     * @param value the isVirtual to set
     * @return this
     */
    public SwapLineupCsReq setIsVirtual(final boolean value) {
      bitField0_ |= 0x00000020;
      isVirtual = value;
      return this;
    }

    @Override
    public SwapLineupCsReq copyFrom(final SwapLineupCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        index = other.index;
        planeId = other.planeId;
        dstSlot = other.dstSlot;
        srcSlot = other.srcSlot;
        extraLineupType = other.extraLineupType;
        isVirtual = other.isVirtual;
      }
      return this;
    }

    @Override
    public SwapLineupCsReq mergeFrom(final SwapLineupCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasIndex()) {
        setIndex(other.index);
      }
      if (other.hasPlaneId()) {
        setPlaneId(other.planeId);
      }
      if (other.hasDstSlot()) {
        setDstSlot(other.dstSlot);
      }
      if (other.hasSrcSlot()) {
        setSrcSlot(other.srcSlot);
      }
      if (other.hasExtraLineupType()) {
        setExtraLineupTypeValue(other.extraLineupType);
      }
      if (other.hasIsVirtual()) {
        setIsVirtual(other.isVirtual);
      }
      return this;
    }

    @Override
    public SwapLineupCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      index = 0;
      planeId = 0;
      dstSlot = 0;
      srcSlot = 0;
      extraLineupType = 0;
      isVirtual = false;
      return this;
    }

    @Override
    public SwapLineupCsReq clearQuick() {
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
      if (!(o instanceof SwapLineupCsReq)) {
        return false;
      }
      SwapLineupCsReq other = (SwapLineupCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasIndex() || index == other.index)
        && (!hasPlaneId() || planeId == other.planeId)
        && (!hasDstSlot() || dstSlot == other.dstSlot)
        && (!hasSrcSlot() || srcSlot == other.srcSlot)
        && (!hasExtraLineupType() || extraLineupType == other.extraLineupType)
        && (!hasIsVirtual() || isVirtual == other.isVirtual);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 32);
        output.writeUInt32NoTag(index);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(planeId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(dstSlot);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(srcSlot);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRawByte((byte) 24);
        output.writeEnumNoTag(extraLineupType);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeRawByte((byte) 80);
        output.writeBoolNoTag(isVirtual);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(index);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(planeId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(dstSlot);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(srcSlot);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += 1 + ProtoSink.computeEnumSizeNoTag(extraLineupType);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        size += 2;
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SwapLineupCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 32: {
            // index
            index = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 64) {
              break;
            }
          }
          case 64: {
            // planeId
            planeId = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // dstSlot
            dstSlot = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // srcSlot
            srcSlot = input.readUInt32();
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 24) {
              break;
            }
          }
          case 24: {
            // extraLineupType
            final int value = input.readInt32();
            if (ExtraLineupTypeOuterClass.ExtraLineupType.forNumber(value) != null) {
              extraLineupType = value;
              bitField0_ |= 0x00000010;
            }
            tag = input.readTag();
            if (tag != 80) {
              break;
            }
          }
          case 80: {
            // isVirtual
            isVirtual = input.readBool();
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
        output.writeUInt32(FieldNames.index, index);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.planeId, planeId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.dstSlot, dstSlot);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeUInt32(FieldNames.srcSlot, srcSlot);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeEnum(FieldNames.extraLineupType, extraLineupType, ExtraLineupTypeOuterClass.ExtraLineupType.converter());
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeBool(FieldNames.isVirtual, isVirtual);
      }
      output.endObject();
    }

    @Override
    public SwapLineupCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 100346066: {
            if (input.isAtField(FieldNames.index)) {
              if (!input.trySkipNullValue()) {
                index = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -493896553:
          case 1869097438: {
            if (input.isAtField(FieldNames.planeId)) {
              if (!input.trySkipNullValue()) {
                planeId = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1958115683:
          case 583331896: {
            if (input.isAtField(FieldNames.dstSlot)) {
              if (!input.trySkipNullValue()) {
                dstSlot = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1953527294:
          case -418516103: {
            if (input.isAtField(FieldNames.srcSlot)) {
              if (!input.trySkipNullValue()) {
                srcSlot = input.readUInt32();
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -468135527:
          case -1144475077: {
            if (input.isAtField(FieldNames.extraLineupType)) {
              if (!input.trySkipNullValue()) {
                final ExtraLineupTypeOuterClass.ExtraLineupType value = input.readEnum(ExtraLineupTypeOuterClass.ExtraLineupType.converter());
                if (value != null) {
                  extraLineupType = value.getNumber();
                  bitField0_ |= 0x00000010;
                } else {
                  input.skipUnknownEnumValue();
                }
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -113613183:
          case 1966475510: {
            if (input.isAtField(FieldNames.isVirtual)) {
              if (!input.trySkipNullValue()) {
                isVirtual = input.readBool();
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
    public SwapLineupCsReq clone() {
      return new SwapLineupCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SwapLineupCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SwapLineupCsReq(), data).checkInitialized();
    }

    public static SwapLineupCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SwapLineupCsReq(), input).checkInitialized();
    }

    public static SwapLineupCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SwapLineupCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating SwapLineupCsReq messages
     */
    public static MessageFactory<SwapLineupCsReq> getFactory() {
      return SwapLineupCsReqFactory.INSTANCE;
    }

    private enum SwapLineupCsReqFactory implements MessageFactory<SwapLineupCsReq> {
      INSTANCE;

      @Override
      public SwapLineupCsReq create() {
        return SwapLineupCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName index = FieldName.forField("index");

      static final FieldName planeId = FieldName.forField("planeId", "plane_id");

      static final FieldName dstSlot = FieldName.forField("dstSlot", "dst_slot");

      static final FieldName srcSlot = FieldName.forField("srcSlot", "src_slot");

      static final FieldName extraLineupType = FieldName.forField("extraLineupType", "extra_lineup_type");

      static final FieldName isVirtual = FieldName.forField("isVirtual", "is_virtual");
    }
  }
}
