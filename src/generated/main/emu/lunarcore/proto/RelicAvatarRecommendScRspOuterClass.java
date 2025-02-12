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
import us.hebi.quickbuf.RepeatedInt;

public final class RelicAvatarRecommendScRspOuterClass {
  /**
   * Protobuf type {@code RelicAvatarRecommendScRsp}
   */
  public static final class RelicAvatarRecommendScRsp extends ProtoMessage<RelicAvatarRecommendScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 DHJHIBCDNBA = 4;</code>
     */
    private int dHJHIBCDNBA;

    /**
     * <code>optional uint32 retcode = 11;</code>
     */
    private int retcode;

    /**
     * <code>optional bool is_enable = 2;</code>
     */
    private boolean isEnable;

    /**
     * <code>repeated uint32 avatar_id_list = 9;</code>
     */
    private final RepeatedInt avatarIdList = RepeatedInt.newEmptyInstance();

    private RelicAvatarRecommendScRsp() {
    }

    /**
     * @return a new empty instance of {@code RelicAvatarRecommendScRsp}
     */
    public static RelicAvatarRecommendScRsp newInstance() {
      return new RelicAvatarRecommendScRsp();
    }

    /**
     * <code>optional uint32 DHJHIBCDNBA = 4;</code>
     * @return whether the dHJHIBCDNBA field is set
     */
    public boolean hasDHJHIBCDNBA() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 DHJHIBCDNBA = 4;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearDHJHIBCDNBA() {
      bitField0_ &= ~0x00000001;
      dHJHIBCDNBA = 0;
      return this;
    }

    /**
     * <code>optional uint32 DHJHIBCDNBA = 4;</code>
     * @return the dHJHIBCDNBA
     */
    public int getDHJHIBCDNBA() {
      return dHJHIBCDNBA;
    }

    /**
     * <code>optional uint32 DHJHIBCDNBA = 4;</code>
     * @param value the dHJHIBCDNBA to set
     * @return this
     */
    public RelicAvatarRecommendScRsp setDHJHIBCDNBA(final int value) {
      bitField0_ |= 0x00000001;
      dHJHIBCDNBA = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearRetcode() {
      bitField0_ &= ~0x00000002;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @param value the retcode to set
     * @return this
     */
    public RelicAvatarRecommendScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000002;
      retcode = value;
      return this;
    }

    /**
     * <code>optional bool is_enable = 2;</code>
     * @return whether the isEnable field is set
     */
    public boolean hasIsEnable() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional bool is_enable = 2;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearIsEnable() {
      bitField0_ &= ~0x00000004;
      isEnable = false;
      return this;
    }

    /**
     * <code>optional bool is_enable = 2;</code>
     * @return the isEnable
     */
    public boolean getIsEnable() {
      return isEnable;
    }

    /**
     * <code>optional bool is_enable = 2;</code>
     * @param value the isEnable to set
     * @return this
     */
    public RelicAvatarRecommendScRsp setIsEnable(final boolean value) {
      bitField0_ |= 0x00000004;
      isEnable = value;
      return this;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 9;</code>
     * @return whether the avatarIdList field is set
     */
    public boolean hasAvatarIdList() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 9;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearAvatarIdList() {
      bitField0_ &= ~0x00000008;
      avatarIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 9;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableAvatarIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getAvatarIdList() {
      return avatarIdList;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 9;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableAvatarIdList() {
      bitField0_ |= 0x00000008;
      return avatarIdList;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 9;</code>
     * @param value the avatarIdList to add
     * @return this
     */
    public RelicAvatarRecommendScRsp addAvatarIdList(final int value) {
      bitField0_ |= 0x00000008;
      avatarIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 9;</code>
     * @param values the avatarIdList to add
     * @return this
     */
    public RelicAvatarRecommendScRsp addAllAvatarIdList(final int... values) {
      bitField0_ |= 0x00000008;
      avatarIdList.addAll(values);
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp copyFrom(final RelicAvatarRecommendScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        dHJHIBCDNBA = other.dHJHIBCDNBA;
        retcode = other.retcode;
        isEnable = other.isEnable;
        avatarIdList.copyFrom(other.avatarIdList);
      }
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp mergeFrom(final RelicAvatarRecommendScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasDHJHIBCDNBA()) {
        setDHJHIBCDNBA(other.dHJHIBCDNBA);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasIsEnable()) {
        setIsEnable(other.isEnable);
      }
      if (other.hasAvatarIdList()) {
        getMutableAvatarIdList().addAll(other.avatarIdList);
      }
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      dHJHIBCDNBA = 0;
      retcode = 0;
      isEnable = false;
      avatarIdList.clear();
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      avatarIdList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof RelicAvatarRecommendScRsp)) {
        return false;
      }
      RelicAvatarRecommendScRsp other = (RelicAvatarRecommendScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasDHJHIBCDNBA() || dHJHIBCDNBA == other.dHJHIBCDNBA)
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasIsEnable() || isEnable == other.isEnable)
        && (!hasAvatarIdList() || avatarIdList.equals(other.avatarIdList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 32);
        output.writeUInt32NoTag(dHJHIBCDNBA);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 16);
        output.writeBoolNoTag(isEnable);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        for (int i = 0; i < avatarIdList.length(); i++) {
          output.writeRawByte((byte) 72);
          output.writeUInt32NoTag(avatarIdList.array()[i]);
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(dHJHIBCDNBA);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 2;
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += (1 * avatarIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(avatarIdList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RelicAvatarRecommendScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 32: {
            // dHJHIBCDNBA
            dHJHIBCDNBA = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 16) {
              break;
            }
          }
          case 16: {
            // isEnable
            isEnable = input.readBool();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 74) {
              break;
            }
          }
          case 74: {
            // avatarIdList [packed=true]
            input.readPackedUInt32(avatarIdList, tag);
            bitField0_ |= 0x00000008;
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
          case 72: {
            // avatarIdList [packed=false]
            tag = input.readRepeatedUInt32(avatarIdList, tag);
            bitField0_ |= 0x00000008;
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.dHJHIBCDNBA, dHJHIBCDNBA);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeBool(FieldNames.isEnable, isEnable);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRepeatedUInt32(FieldNames.avatarIdList, avatarIdList);
      }
      output.endObject();
    }

    @Override
    public RelicAvatarRecommendScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -560268143: {
            if (input.isAtField(FieldNames.dHJHIBCDNBA)) {
              if (!input.trySkipNullValue()) {
                dHJHIBCDNBA = input.readUInt32();
                bitField0_ |= 0x00000001;
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
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -624814259:
          case -834809288: {
            if (input.isAtField(FieldNames.isEnable)) {
              if (!input.trySkipNullValue()) {
                isEnable = input.readBool();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1214270702:
          case 1824281692: {
            if (input.isAtField(FieldNames.avatarIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(avatarIdList);
                bitField0_ |= 0x00000008;
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
    public RelicAvatarRecommendScRsp clone() {
      return new RelicAvatarRecommendScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RelicAvatarRecommendScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendScRsp(), data).checkInitialized();
    }

    public static RelicAvatarRecommendScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendScRsp(), input).checkInitialized();
    }

    public static RelicAvatarRecommendScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating RelicAvatarRecommendScRsp messages
     */
    public static MessageFactory<RelicAvatarRecommendScRsp> getFactory() {
      return RelicAvatarRecommendScRspFactory.INSTANCE;
    }

    private enum RelicAvatarRecommendScRspFactory implements MessageFactory<RelicAvatarRecommendScRsp> {
      INSTANCE;

      @Override
      public RelicAvatarRecommendScRsp create() {
        return RelicAvatarRecommendScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName dHJHIBCDNBA = FieldName.forField("DHJHIBCDNBA");

      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName isEnable = FieldName.forField("isEnable", "is_enable");

      static final FieldName avatarIdList = FieldName.forField("avatarIdList", "avatar_id_list");
    }
  }
}
