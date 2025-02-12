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

public final class InteractChargerScRspOuterClass {
  /**
   * Protobuf type {@code InteractChargerScRsp}
   */
  public static final class InteractChargerScRsp extends ProtoMessage<InteractChargerScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 10;</code>
     */
    private int retcode;

    /**
     * <code>optional .ChargerInfo charger_info = 11;</code>
     */
    private final ChargerInfoOuterClass.ChargerInfo chargerInfo = ChargerInfoOuterClass.ChargerInfo.newInstance();

    /**
     * <code>optional .RotatorEnergyInfo energy_info = 14;</code>
     */
    private final RotatorEnergyInfoOuterClass.RotatorEnergyInfo energyInfo = RotatorEnergyInfoOuterClass.RotatorEnergyInfo.newInstance();

    private InteractChargerScRsp() {
    }

    /**
     * @return a new empty instance of {@code InteractChargerScRsp}
     */
    public static InteractChargerScRsp newInstance() {
      return new InteractChargerScRsp();
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return this
     */
    public InteractChargerScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @param value the retcode to set
     * @return this
     */
    public InteractChargerScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>optional .ChargerInfo charger_info = 11;</code>
     * @return whether the chargerInfo field is set
     */
    public boolean hasChargerInfo() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .ChargerInfo charger_info = 11;</code>
     * @return this
     */
    public InteractChargerScRsp clearChargerInfo() {
      bitField0_ &= ~0x00000002;
      chargerInfo.clear();
      return this;
    }

    /**
     * <code>optional .ChargerInfo charger_info = 11;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableChargerInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public ChargerInfoOuterClass.ChargerInfo getChargerInfo() {
      return chargerInfo;
    }

    /**
     * <code>optional .ChargerInfo charger_info = 11;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public ChargerInfoOuterClass.ChargerInfo getMutableChargerInfo() {
      bitField0_ |= 0x00000002;
      return chargerInfo;
    }

    /**
     * <code>optional .ChargerInfo charger_info = 11;</code>
     * @param value the chargerInfo to set
     * @return this
     */
    public InteractChargerScRsp setChargerInfo(final ChargerInfoOuterClass.ChargerInfo value) {
      bitField0_ |= 0x00000002;
      chargerInfo.copyFrom(value);
      return this;
    }

    /**
     * <code>optional .RotatorEnergyInfo energy_info = 14;</code>
     * @return whether the energyInfo field is set
     */
    public boolean hasEnergyInfo() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional .RotatorEnergyInfo energy_info = 14;</code>
     * @return this
     */
    public InteractChargerScRsp clearEnergyInfo() {
      bitField0_ &= ~0x00000004;
      energyInfo.clear();
      return this;
    }

    /**
     * <code>optional .RotatorEnergyInfo energy_info = 14;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableEnergyInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RotatorEnergyInfoOuterClass.RotatorEnergyInfo getEnergyInfo() {
      return energyInfo;
    }

    /**
     * <code>optional .RotatorEnergyInfo energy_info = 14;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RotatorEnergyInfoOuterClass.RotatorEnergyInfo getMutableEnergyInfo() {
      bitField0_ |= 0x00000004;
      return energyInfo;
    }

    /**
     * <code>optional .RotatorEnergyInfo energy_info = 14;</code>
     * @param value the energyInfo to set
     * @return this
     */
    public InteractChargerScRsp setEnergyInfo(
        final RotatorEnergyInfoOuterClass.RotatorEnergyInfo value) {
      bitField0_ |= 0x00000004;
      energyInfo.copyFrom(value);
      return this;
    }

    @Override
    public InteractChargerScRsp copyFrom(final InteractChargerScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        chargerInfo.copyFrom(other.chargerInfo);
        energyInfo.copyFrom(other.energyInfo);
      }
      return this;
    }

    @Override
    public InteractChargerScRsp mergeFrom(final InteractChargerScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasChargerInfo()) {
        getMutableChargerInfo().mergeFrom(other.chargerInfo);
      }
      if (other.hasEnergyInfo()) {
        getMutableEnergyInfo().mergeFrom(other.energyInfo);
      }
      return this;
    }

    @Override
    public InteractChargerScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      chargerInfo.clear();
      energyInfo.clear();
      return this;
    }

    @Override
    public InteractChargerScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      chargerInfo.clearQuick();
      energyInfo.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof InteractChargerScRsp)) {
        return false;
      }
      InteractChargerScRsp other = (InteractChargerScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasChargerInfo() || chargerInfo.equals(other.chargerInfo))
        && (!hasEnergyInfo() || energyInfo.equals(other.energyInfo));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 80);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 90);
        output.writeMessageNoTag(chargerInfo);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 114);
        output.writeMessageNoTag(energyInfo);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(chargerInfo);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(energyInfo);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public InteractChargerScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 80: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 90) {
              break;
            }
          }
          case 90: {
            // chargerInfo
            input.readMessage(chargerInfo);
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 114) {
              break;
            }
          }
          case 114: {
            // energyInfo
            input.readMessage(energyInfo);
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
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeMessage(FieldNames.chargerInfo, chargerInfo);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeMessage(FieldNames.energyInfo, energyInfo);
      }
      output.endObject();
    }

    @Override
    public InteractChargerScRsp mergeFrom(final JsonSource input) throws IOException {
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
          case 1038073356:
          case 2135678991: {
            if (input.isAtField(FieldNames.chargerInfo)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(chargerInfo);
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1464698710:
          case -1818804219: {
            if (input.isAtField(FieldNames.energyInfo)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(energyInfo);
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
    public InteractChargerScRsp clone() {
      return new InteractChargerScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static InteractChargerScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new InteractChargerScRsp(), data).checkInitialized();
    }

    public static InteractChargerScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new InteractChargerScRsp(), input).checkInitialized();
    }

    public static InteractChargerScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new InteractChargerScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating InteractChargerScRsp messages
     */
    public static MessageFactory<InteractChargerScRsp> getFactory() {
      return InteractChargerScRspFactory.INSTANCE;
    }

    private enum InteractChargerScRspFactory implements MessageFactory<InteractChargerScRsp> {
      INSTANCE;

      @Override
      public InteractChargerScRsp create() {
        return InteractChargerScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName chargerInfo = FieldName.forField("chargerInfo", "charger_info");

      static final FieldName energyInfo = FieldName.forField("energyInfo", "energy_info");
    }
  }
}
