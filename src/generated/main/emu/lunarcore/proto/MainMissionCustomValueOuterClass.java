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

public final class MainMissionCustomValueOuterClass {
  /**
   * Protobuf type {@code MainMissionCustomValue}
   */
  public static final class MainMissionCustomValue extends ProtoMessage<MainMissionCustomValue> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 main_mission_id = 5;</code>
     */
    private int mainMissionId;

    /**
     * <code>optional .MissionCustomValueList custom_value_list = 10;</code>
     */
    private final MissionCustomValueListOuterClass.MissionCustomValueList customValueList = MissionCustomValueListOuterClass.MissionCustomValueList.newInstance();

    private MainMissionCustomValue() {
    }

    /**
     * @return a new empty instance of {@code MainMissionCustomValue}
     */
    public static MainMissionCustomValue newInstance() {
      return new MainMissionCustomValue();
    }

    /**
     * <code>optional uint32 main_mission_id = 5;</code>
     * @return whether the mainMissionId field is set
     */
    public boolean hasMainMissionId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 main_mission_id = 5;</code>
     * @return this
     */
    public MainMissionCustomValue clearMainMissionId() {
      bitField0_ &= ~0x00000001;
      mainMissionId = 0;
      return this;
    }

    /**
     * <code>optional uint32 main_mission_id = 5;</code>
     * @return the mainMissionId
     */
    public int getMainMissionId() {
      return mainMissionId;
    }

    /**
     * <code>optional uint32 main_mission_id = 5;</code>
     * @param value the mainMissionId to set
     * @return this
     */
    public MainMissionCustomValue setMainMissionId(final int value) {
      bitField0_ |= 0x00000001;
      mainMissionId = value;
      return this;
    }

    /**
     * <code>optional .MissionCustomValueList custom_value_list = 10;</code>
     * @return whether the customValueList field is set
     */
    public boolean hasCustomValueList() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .MissionCustomValueList custom_value_list = 10;</code>
     * @return this
     */
    public MainMissionCustomValue clearCustomValueList() {
      bitField0_ &= ~0x00000002;
      customValueList.clear();
      return this;
    }

    /**
     * <code>optional .MissionCustomValueList custom_value_list = 10;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableCustomValueList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public MissionCustomValueListOuterClass.MissionCustomValueList getCustomValueList() {
      return customValueList;
    }

    /**
     * <code>optional .MissionCustomValueList custom_value_list = 10;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public MissionCustomValueListOuterClass.MissionCustomValueList getMutableCustomValueList() {
      bitField0_ |= 0x00000002;
      return customValueList;
    }

    /**
     * <code>optional .MissionCustomValueList custom_value_list = 10;</code>
     * @param value the customValueList to set
     * @return this
     */
    public MainMissionCustomValue setCustomValueList(
        final MissionCustomValueListOuterClass.MissionCustomValueList value) {
      bitField0_ |= 0x00000002;
      customValueList.copyFrom(value);
      return this;
    }

    @Override
    public MainMissionCustomValue copyFrom(final MainMissionCustomValue other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        mainMissionId = other.mainMissionId;
        customValueList.copyFrom(other.customValueList);
      }
      return this;
    }

    @Override
    public MainMissionCustomValue mergeFrom(final MainMissionCustomValue other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasMainMissionId()) {
        setMainMissionId(other.mainMissionId);
      }
      if (other.hasCustomValueList()) {
        getMutableCustomValueList().mergeFrom(other.customValueList);
      }
      return this;
    }

    @Override
    public MainMissionCustomValue clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      mainMissionId = 0;
      customValueList.clear();
      return this;
    }

    @Override
    public MainMissionCustomValue clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      customValueList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof MainMissionCustomValue)) {
        return false;
      }
      MainMissionCustomValue other = (MainMissionCustomValue) o;
      return bitField0_ == other.bitField0_
        && (!hasMainMissionId() || mainMissionId == other.mainMissionId)
        && (!hasCustomValueList() || customValueList.equals(other.customValueList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 40);
        output.writeUInt32NoTag(mainMissionId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 82);
        output.writeMessageNoTag(customValueList);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(mainMissionId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(customValueList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public MainMissionCustomValue mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 40: {
            // mainMissionId
            mainMissionId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 82) {
              break;
            }
          }
          case 82: {
            // customValueList
            input.readMessage(customValueList);
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
        output.writeUInt32(FieldNames.mainMissionId, mainMissionId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeMessage(FieldNames.customValueList, customValueList);
      }
      output.endObject();
    }

    @Override
    public MainMissionCustomValue mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1124848142:
          case 885892852: {
            if (input.isAtField(FieldNames.mainMissionId)) {
              if (!input.trySkipNullValue()) {
                mainMissionId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 2009823550:
          case 1803812922: {
            if (input.isAtField(FieldNames.customValueList)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(customValueList);
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
    public MainMissionCustomValue clone() {
      return new MainMissionCustomValue().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static MainMissionCustomValue parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new MainMissionCustomValue(), data).checkInitialized();
    }

    public static MainMissionCustomValue parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new MainMissionCustomValue(), input).checkInitialized();
    }

    public static MainMissionCustomValue parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new MainMissionCustomValue(), input).checkInitialized();
    }

    /**
     * @return factory for creating MainMissionCustomValue messages
     */
    public static MessageFactory<MainMissionCustomValue> getFactory() {
      return MainMissionCustomValueFactory.INSTANCE;
    }

    private enum MainMissionCustomValueFactory implements MessageFactory<MainMissionCustomValue> {
      INSTANCE;

      @Override
      public MainMissionCustomValue create() {
        return MainMissionCustomValue.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName mainMissionId = FieldName.forField("mainMissionId", "main_mission_id");

      static final FieldName customValueList = FieldName.forField("customValueList", "custom_value_list");
    }
  }
}
