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

public final class MarkChestFuncInfoOuterClass {
  /**
   * Protobuf type {@code MarkChestFuncInfo}
   */
  public static final class MarkChestFuncInfo extends ProtoMessage<MarkChestFuncInfo> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional int64 GOONPNDOCIH = 13;</code>
     */
    private long gOONPNDOCIH;

    /**
     * <code>optional uint32 func_id = 5;</code>
     */
    private int funcId;

    /**
     * <code>repeated .MarkChestInfo mark_chest_info_list = 8;</code>
     */
    private final RepeatedMessage<MarkChestInfoOuterClass.MarkChestInfo> markChestInfoList = RepeatedMessage.newEmptyInstance(MarkChestInfoOuterClass.MarkChestInfo.getFactory());

    private MarkChestFuncInfo() {
    }

    /**
     * @return a new empty instance of {@code MarkChestFuncInfo}
     */
    public static MarkChestFuncInfo newInstance() {
      return new MarkChestFuncInfo();
    }

    /**
     * <code>optional int64 GOONPNDOCIH = 13;</code>
     * @return whether the gOONPNDOCIH field is set
     */
    public boolean hasGOONPNDOCIH() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional int64 GOONPNDOCIH = 13;</code>
     * @return this
     */
    public MarkChestFuncInfo clearGOONPNDOCIH() {
      bitField0_ &= ~0x00000001;
      gOONPNDOCIH = 0L;
      return this;
    }

    /**
     * <code>optional int64 GOONPNDOCIH = 13;</code>
     * @return the gOONPNDOCIH
     */
    public long getGOONPNDOCIH() {
      return gOONPNDOCIH;
    }

    /**
     * <code>optional int64 GOONPNDOCIH = 13;</code>
     * @param value the gOONPNDOCIH to set
     * @return this
     */
    public MarkChestFuncInfo setGOONPNDOCIH(final long value) {
      bitField0_ |= 0x00000001;
      gOONPNDOCIH = value;
      return this;
    }

    /**
     * <code>optional uint32 func_id = 5;</code>
     * @return whether the funcId field is set
     */
    public boolean hasFuncId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 func_id = 5;</code>
     * @return this
     */
    public MarkChestFuncInfo clearFuncId() {
      bitField0_ &= ~0x00000002;
      funcId = 0;
      return this;
    }

    /**
     * <code>optional uint32 func_id = 5;</code>
     * @return the funcId
     */
    public int getFuncId() {
      return funcId;
    }

    /**
     * <code>optional uint32 func_id = 5;</code>
     * @param value the funcId to set
     * @return this
     */
    public MarkChestFuncInfo setFuncId(final int value) {
      bitField0_ |= 0x00000002;
      funcId = value;
      return this;
    }

    /**
     * <code>repeated .MarkChestInfo mark_chest_info_list = 8;</code>
     * @return whether the markChestInfoList field is set
     */
    public boolean hasMarkChestInfoList() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>repeated .MarkChestInfo mark_chest_info_list = 8;</code>
     * @return this
     */
    public MarkChestFuncInfo clearMarkChestInfoList() {
      bitField0_ &= ~0x00000004;
      markChestInfoList.clear();
      return this;
    }

    /**
     * <code>repeated .MarkChestInfo mark_chest_info_list = 8;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableMarkChestInfoList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<MarkChestInfoOuterClass.MarkChestInfo> getMarkChestInfoList() {
      return markChestInfoList;
    }

    /**
     * <code>repeated .MarkChestInfo mark_chest_info_list = 8;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<MarkChestInfoOuterClass.MarkChestInfo> getMutableMarkChestInfoList() {
      bitField0_ |= 0x00000004;
      return markChestInfoList;
    }

    /**
     * <code>repeated .MarkChestInfo mark_chest_info_list = 8;</code>
     * @param value the markChestInfoList to add
     * @return this
     */
    public MarkChestFuncInfo addMarkChestInfoList(
        final MarkChestInfoOuterClass.MarkChestInfo value) {
      bitField0_ |= 0x00000004;
      markChestInfoList.add(value);
      return this;
    }

    /**
     * <code>repeated .MarkChestInfo mark_chest_info_list = 8;</code>
     * @param values the markChestInfoList to add
     * @return this
     */
    public MarkChestFuncInfo addAllMarkChestInfoList(
        final MarkChestInfoOuterClass.MarkChestInfo... values) {
      bitField0_ |= 0x00000004;
      markChestInfoList.addAll(values);
      return this;
    }

    @Override
    public MarkChestFuncInfo copyFrom(final MarkChestFuncInfo other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        gOONPNDOCIH = other.gOONPNDOCIH;
        funcId = other.funcId;
        markChestInfoList.copyFrom(other.markChestInfoList);
      }
      return this;
    }

    @Override
    public MarkChestFuncInfo mergeFrom(final MarkChestFuncInfo other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasGOONPNDOCIH()) {
        setGOONPNDOCIH(other.gOONPNDOCIH);
      }
      if (other.hasFuncId()) {
        setFuncId(other.funcId);
      }
      if (other.hasMarkChestInfoList()) {
        getMutableMarkChestInfoList().addAll(other.markChestInfoList);
      }
      return this;
    }

    @Override
    public MarkChestFuncInfo clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      gOONPNDOCIH = 0L;
      funcId = 0;
      markChestInfoList.clear();
      return this;
    }

    @Override
    public MarkChestFuncInfo clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      markChestInfoList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof MarkChestFuncInfo)) {
        return false;
      }
      MarkChestFuncInfo other = (MarkChestFuncInfo) o;
      return bitField0_ == other.bitField0_
        && (!hasGOONPNDOCIH() || gOONPNDOCIH == other.gOONPNDOCIH)
        && (!hasFuncId() || funcId == other.funcId)
        && (!hasMarkChestInfoList() || markChestInfoList.equals(other.markChestInfoList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 104);
        output.writeInt64NoTag(gOONPNDOCIH);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 40);
        output.writeUInt32NoTag(funcId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        for (int i = 0; i < markChestInfoList.length(); i++) {
          output.writeRawByte((byte) 66);
          output.writeMessageNoTag(markChestInfoList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeInt64SizeNoTag(gOONPNDOCIH);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(funcId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += (1 * markChestInfoList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(markChestInfoList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public MarkChestFuncInfo mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 104: {
            // gOONPNDOCIH
            gOONPNDOCIH = input.readInt64();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 40) {
              break;
            }
          }
          case 40: {
            // funcId
            funcId = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 66) {
              break;
            }
          }
          case 66: {
            // markChestInfoList
            tag = input.readRepeatedMessage(markChestInfoList, tag);
            bitField0_ |= 0x00000004;
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
        output.writeInt64(FieldNames.gOONPNDOCIH, gOONPNDOCIH);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.funcId, funcId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRepeatedMessage(FieldNames.markChestInfoList, markChestInfoList);
      }
      output.endObject();
    }

    @Override
    public MarkChestFuncInfo mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 650189394: {
            if (input.isAtField(FieldNames.gOONPNDOCIH)) {
              if (!input.trySkipNullValue()) {
                gOONPNDOCIH = input.readInt64();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1263367425:
          case -509663114: {
            if (input.isAtField(FieldNames.funcId)) {
              if (!input.trySkipNullValue()) {
                funcId = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -2128373056:
          case -79054753: {
            if (input.isAtField(FieldNames.markChestInfoList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(markChestInfoList);
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
    public MarkChestFuncInfo clone() {
      return new MarkChestFuncInfo().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static MarkChestFuncInfo parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new MarkChestFuncInfo(), data).checkInitialized();
    }

    public static MarkChestFuncInfo parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new MarkChestFuncInfo(), input).checkInitialized();
    }

    public static MarkChestFuncInfo parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new MarkChestFuncInfo(), input).checkInitialized();
    }

    /**
     * @return factory for creating MarkChestFuncInfo messages
     */
    public static MessageFactory<MarkChestFuncInfo> getFactory() {
      return MarkChestFuncInfoFactory.INSTANCE;
    }

    private enum MarkChestFuncInfoFactory implements MessageFactory<MarkChestFuncInfo> {
      INSTANCE;

      @Override
      public MarkChestFuncInfo create() {
        return MarkChestFuncInfo.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName gOONPNDOCIH = FieldName.forField("GOONPNDOCIH");

      static final FieldName funcId = FieldName.forField("funcId", "func_id");

      static final FieldName markChestInfoList = FieldName.forField("markChestInfoList", "mark_chest_info_list");
    }
  }
}
