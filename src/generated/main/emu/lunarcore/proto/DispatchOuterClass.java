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
import us.hebi.quickbuf.Utf8String;

public final class DispatchOuterClass {
  /**
   * Protobuf type {@code Dispatch}
   */
  public static final class Dispatch extends ProtoMessage<Dispatch> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 1;</code>
     */
    private int retcode;

    /**
     * <code>optional string msg = 2;</code>
     */
    private final Utf8String msg = Utf8String.newEmptyInstance();

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     */
    private final Utf8String topSeverRegionName = Utf8String.newEmptyInstance();

    /**
     * <code>optional string stop_desc = 5;</code>
     */
    private final Utf8String stopDesc = Utf8String.newEmptyInstance();

    /**
     * <code>repeated .RegionInfo region_list = 4;</code>
     */
    private final RepeatedMessage<RegionInfoOuterClass.RegionInfo> regionList = RepeatedMessage.newEmptyInstance(RegionInfoOuterClass.RegionInfo.getFactory());

    private Dispatch() {
    }

    /**
     * @return a new empty instance of {@code Dispatch}
     */
    public static Dispatch newInstance() {
      return new Dispatch();
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
    public Dispatch clearRetcode() {
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
    public Dispatch setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>optional string msg = 2;</code>
     * @return whether the msg field is set
     */
    public boolean hasMsg() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional string msg = 2;</code>
     * @return this
     */
    public Dispatch clearMsg() {
      bitField0_ &= ~0x00000002;
      msg.clear();
      return this;
    }

    /**
     * <code>optional string msg = 2;</code>
     * @return the msg
     */
    public String getMsg() {
      return msg.getString();
    }

    /**
     * <code>optional string msg = 2;</code>
     * @return internal {@code Utf8String} representation of msg for reading
     */
    public Utf8String getMsgBytes() {
      return this.msg;
    }

    /**
     * <code>optional string msg = 2;</code>
     * @return internal {@code Utf8String} representation of msg for modifications
     */
    public Utf8String getMutableMsgBytes() {
      bitField0_ |= 0x00000002;
      return this.msg;
    }

    /**
     * <code>optional string msg = 2;</code>
     * @param value the msg to set
     * @return this
     */
    public Dispatch setMsg(final CharSequence value) {
      bitField0_ |= 0x00000002;
      msg.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string msg = 2;</code>
     * @param value the msg to set
     * @return this
     */
    public Dispatch setMsg(final Utf8String value) {
      bitField0_ |= 0x00000002;
      msg.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     * @return whether the topSeverRegionName field is set
     */
    public boolean hasTopSeverRegionName() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     * @return this
     */
    public Dispatch clearTopSeverRegionName() {
      bitField0_ &= ~0x00000004;
      topSeverRegionName.clear();
      return this;
    }

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     * @return the topSeverRegionName
     */
    public String getTopSeverRegionName() {
      return topSeverRegionName.getString();
    }

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     * @return internal {@code Utf8String} representation of topSeverRegionName for reading
     */
    public Utf8String getTopSeverRegionNameBytes() {
      return this.topSeverRegionName;
    }

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     * @return internal {@code Utf8String} representation of topSeverRegionName for modifications
     */
    public Utf8String getMutableTopSeverRegionNameBytes() {
      bitField0_ |= 0x00000004;
      return this.topSeverRegionName;
    }

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     * @param value the topSeverRegionName to set
     * @return this
     */
    public Dispatch setTopSeverRegionName(final CharSequence value) {
      bitField0_ |= 0x00000004;
      topSeverRegionName.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string top_sever_region_name = 3;</code>
     * @param value the topSeverRegionName to set
     * @return this
     */
    public Dispatch setTopSeverRegionName(final Utf8String value) {
      bitField0_ |= 0x00000004;
      topSeverRegionName.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string stop_desc = 5;</code>
     * @return whether the stopDesc field is set
     */
    public boolean hasStopDesc() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional string stop_desc = 5;</code>
     * @return this
     */
    public Dispatch clearStopDesc() {
      bitField0_ &= ~0x00000008;
      stopDesc.clear();
      return this;
    }

    /**
     * <code>optional string stop_desc = 5;</code>
     * @return the stopDesc
     */
    public String getStopDesc() {
      return stopDesc.getString();
    }

    /**
     * <code>optional string stop_desc = 5;</code>
     * @return internal {@code Utf8String} representation of stopDesc for reading
     */
    public Utf8String getStopDescBytes() {
      return this.stopDesc;
    }

    /**
     * <code>optional string stop_desc = 5;</code>
     * @return internal {@code Utf8String} representation of stopDesc for modifications
     */
    public Utf8String getMutableStopDescBytes() {
      bitField0_ |= 0x00000008;
      return this.stopDesc;
    }

    /**
     * <code>optional string stop_desc = 5;</code>
     * @param value the stopDesc to set
     * @return this
     */
    public Dispatch setStopDesc(final CharSequence value) {
      bitField0_ |= 0x00000008;
      stopDesc.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string stop_desc = 5;</code>
     * @param value the stopDesc to set
     * @return this
     */
    public Dispatch setStopDesc(final Utf8String value) {
      bitField0_ |= 0x00000008;
      stopDesc.copyFrom(value);
      return this;
    }

    /**
     * <code>repeated .RegionInfo region_list = 4;</code>
     * @return whether the regionList field is set
     */
    public boolean hasRegionList() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>repeated .RegionInfo region_list = 4;</code>
     * @return this
     */
    public Dispatch clearRegionList() {
      bitField0_ &= ~0x00000010;
      regionList.clear();
      return this;
    }

    /**
     * <code>repeated .RegionInfo region_list = 4;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableRegionList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<RegionInfoOuterClass.RegionInfo> getRegionList() {
      return regionList;
    }

    /**
     * <code>repeated .RegionInfo region_list = 4;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<RegionInfoOuterClass.RegionInfo> getMutableRegionList() {
      bitField0_ |= 0x00000010;
      return regionList;
    }

    /**
     * <code>repeated .RegionInfo region_list = 4;</code>
     * @param value the regionList to add
     * @return this
     */
    public Dispatch addRegionList(final RegionInfoOuterClass.RegionInfo value) {
      bitField0_ |= 0x00000010;
      regionList.add(value);
      return this;
    }

    /**
     * <code>repeated .RegionInfo region_list = 4;</code>
     * @param values the regionList to add
     * @return this
     */
    public Dispatch addAllRegionList(final RegionInfoOuterClass.RegionInfo... values) {
      bitField0_ |= 0x00000010;
      regionList.addAll(values);
      return this;
    }

    @Override
    public Dispatch copyFrom(final Dispatch other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        msg.copyFrom(other.msg);
        topSeverRegionName.copyFrom(other.topSeverRegionName);
        stopDesc.copyFrom(other.stopDesc);
        regionList.copyFrom(other.regionList);
      }
      return this;
    }

    @Override
    public Dispatch mergeFrom(final Dispatch other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasMsg()) {
        getMutableMsgBytes().copyFrom(other.msg);
      }
      if (other.hasTopSeverRegionName()) {
        getMutableTopSeverRegionNameBytes().copyFrom(other.topSeverRegionName);
      }
      if (other.hasStopDesc()) {
        getMutableStopDescBytes().copyFrom(other.stopDesc);
      }
      if (other.hasRegionList()) {
        getMutableRegionList().addAll(other.regionList);
      }
      return this;
    }

    @Override
    public Dispatch clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      msg.clear();
      topSeverRegionName.clear();
      stopDesc.clear();
      regionList.clear();
      return this;
    }

    @Override
    public Dispatch clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      msg.clear();
      topSeverRegionName.clear();
      stopDesc.clear();
      regionList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof Dispatch)) {
        return false;
      }
      Dispatch other = (Dispatch) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasMsg() || msg.equals(other.msg))
        && (!hasTopSeverRegionName() || topSeverRegionName.equals(other.topSeverRegionName))
        && (!hasStopDesc() || stopDesc.equals(other.stopDesc))
        && (!hasRegionList() || regionList.equals(other.regionList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 18);
        output.writeStringNoTag(msg);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 26);
        output.writeStringNoTag(topSeverRegionName);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 42);
        output.writeStringNoTag(stopDesc);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        for (int i = 0; i < regionList.length(); i++) {
          output.writeRawByte((byte) 34);
          output.writeMessageNoTag(regionList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeStringSizeNoTag(msg);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeStringSizeNoTag(topSeverRegionName);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeStringSizeNoTag(stopDesc);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += (1 * regionList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(regionList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public Dispatch mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 8: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 18) {
              break;
            }
          }
          case 18: {
            // msg
            input.readString(msg);
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 26) {
              break;
            }
          }
          case 26: {
            // topSeverRegionName
            input.readString(topSeverRegionName);
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 42) {
              break;
            }
          }
          case 42: {
            // stopDesc
            input.readString(stopDesc);
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 34) {
              break;
            }
          }
          case 34: {
            // regionList
            tag = input.readRepeatedMessage(regionList, tag);
            bitField0_ |= 0x00000010;
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
        output.writeString(FieldNames.msg, msg);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeString(FieldNames.topSeverRegionName, topSeverRegionName);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeString(FieldNames.stopDesc, stopDesc);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRepeatedMessage(FieldNames.regionList, regionList);
      }
      output.endObject();
    }

    @Override
    public Dispatch mergeFrom(final JsonSource input) throws IOException {
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
          case 108417: {
            if (input.isAtField(FieldNames.msg)) {
              if (!input.trySkipNullValue()) {
                input.readString(msg);
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1102313595:
          case -2020003490: {
            if (input.isAtField(FieldNames.topSeverRegionName)) {
              if (!input.trySkipNullValue()) {
                input.readString(topSeverRegionName);
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1714334131:
          case 1629642926: {
            if (input.isAtField(FieldNames.stopDesc)) {
              if (!input.trySkipNullValue()) {
                input.readString(stopDesc);
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1990741582:
          case -1565820151: {
            if (input.isAtField(FieldNames.regionList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(regionList);
                bitField0_ |= 0x00000010;
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
    public Dispatch clone() {
      return new Dispatch().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static Dispatch parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new Dispatch(), data).checkInitialized();
    }

    public static Dispatch parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new Dispatch(), input).checkInitialized();
    }

    public static Dispatch parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new Dispatch(), input).checkInitialized();
    }

    /**
     * @return factory for creating Dispatch messages
     */
    public static MessageFactory<Dispatch> getFactory() {
      return DispatchFactory.INSTANCE;
    }

    private enum DispatchFactory implements MessageFactory<Dispatch> {
      INSTANCE;

      @Override
      public Dispatch create() {
        return Dispatch.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName msg = FieldName.forField("msg");

      static final FieldName topSeverRegionName = FieldName.forField("topSeverRegionName", "top_sever_region_name");

      static final FieldName stopDesc = FieldName.forField("stopDesc", "stop_desc");

      static final FieldName regionList = FieldName.forField("regionList", "region_list");
    }
  }
}
