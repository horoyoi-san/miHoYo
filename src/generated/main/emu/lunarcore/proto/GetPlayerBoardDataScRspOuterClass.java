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
import us.hebi.quickbuf.RepeatedMessage;
import us.hebi.quickbuf.Utf8String;

public final class GetPlayerBoardDataScRspOuterClass {
  /**
   * Protobuf type {@code GetPlayerBoardDataScRsp}
   */
  public static final class GetPlayerBoardDataScRsp extends ProtoMessage<GetPlayerBoardDataScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 current_head_icon_id = 8;</code>
     */
    private int currentHeadIconId;

    /**
     * <code>optional uint32 retcode = 12;</code>
     */
    private int retcode;

    /**
     * <code>optional .DisplayAvatarVec display_avatar_vec = 15;</code>
     */
    private final DisplayAvatarVecOuterClass.DisplayAvatarVec displayAvatarVec = DisplayAvatarVecOuterClass.DisplayAvatarVec.newInstance();

    /**
     * <code>optional string signature = 1;</code>
     */
    private final Utf8String signature = Utf8String.newEmptyInstance();

    /**
     * <code>repeated uint32 display_support_avatar_vec = 6;</code>
     */
    private final RepeatedInt displaySupportAvatarVec = RepeatedInt.newEmptyInstance();

    /**
     * <code>repeated .HeadIcon unlocked_head_icon_list = 5;</code>
     */
    private final RepeatedMessage<HeadIconOuterClass.HeadIcon> unlockedHeadIconList = RepeatedMessage.newEmptyInstance(HeadIconOuterClass.HeadIcon.getFactory());

    private GetPlayerBoardDataScRsp() {
    }

    /**
     * @return a new empty instance of {@code GetPlayerBoardDataScRsp}
     */
    public static GetPlayerBoardDataScRsp newInstance() {
      return new GetPlayerBoardDataScRsp();
    }

    /**
     * <code>optional uint32 current_head_icon_id = 8;</code>
     * @return whether the currentHeadIconId field is set
     */
    public boolean hasCurrentHeadIconId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 current_head_icon_id = 8;</code>
     * @return this
     */
    public GetPlayerBoardDataScRsp clearCurrentHeadIconId() {
      bitField0_ &= ~0x00000001;
      currentHeadIconId = 0;
      return this;
    }

    /**
     * <code>optional uint32 current_head_icon_id = 8;</code>
     * @return the currentHeadIconId
     */
    public int getCurrentHeadIconId() {
      return currentHeadIconId;
    }

    /**
     * <code>optional uint32 current_head_icon_id = 8;</code>
     * @param value the currentHeadIconId to set
     * @return this
     */
    public GetPlayerBoardDataScRsp setCurrentHeadIconId(final int value) {
      bitField0_ |= 0x00000001;
      currentHeadIconId = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return this
     */
    public GetPlayerBoardDataScRsp clearRetcode() {
      bitField0_ &= ~0x00000002;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @param value the retcode to set
     * @return this
     */
    public GetPlayerBoardDataScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000002;
      retcode = value;
      return this;
    }

    /**
     * <code>optional .DisplayAvatarVec display_avatar_vec = 15;</code>
     * @return whether the displayAvatarVec field is set
     */
    public boolean hasDisplayAvatarVec() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional .DisplayAvatarVec display_avatar_vec = 15;</code>
     * @return this
     */
    public GetPlayerBoardDataScRsp clearDisplayAvatarVec() {
      bitField0_ &= ~0x00000004;
      displayAvatarVec.clear();
      return this;
    }

    /**
     * <code>optional .DisplayAvatarVec display_avatar_vec = 15;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableDisplayAvatarVec()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public DisplayAvatarVecOuterClass.DisplayAvatarVec getDisplayAvatarVec() {
      return displayAvatarVec;
    }

    /**
     * <code>optional .DisplayAvatarVec display_avatar_vec = 15;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public DisplayAvatarVecOuterClass.DisplayAvatarVec getMutableDisplayAvatarVec() {
      bitField0_ |= 0x00000004;
      return displayAvatarVec;
    }

    /**
     * <code>optional .DisplayAvatarVec display_avatar_vec = 15;</code>
     * @param value the displayAvatarVec to set
     * @return this
     */
    public GetPlayerBoardDataScRsp setDisplayAvatarVec(
        final DisplayAvatarVecOuterClass.DisplayAvatarVec value) {
      bitField0_ |= 0x00000004;
      displayAvatarVec.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string signature = 1;</code>
     * @return whether the signature field is set
     */
    public boolean hasSignature() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional string signature = 1;</code>
     * @return this
     */
    public GetPlayerBoardDataScRsp clearSignature() {
      bitField0_ &= ~0x00000008;
      signature.clear();
      return this;
    }

    /**
     * <code>optional string signature = 1;</code>
     * @return the signature
     */
    public String getSignature() {
      return signature.getString();
    }

    /**
     * <code>optional string signature = 1;</code>
     * @return internal {@code Utf8String} representation of signature for reading
     */
    public Utf8String getSignatureBytes() {
      return this.signature;
    }

    /**
     * <code>optional string signature = 1;</code>
     * @return internal {@code Utf8String} representation of signature for modifications
     */
    public Utf8String getMutableSignatureBytes() {
      bitField0_ |= 0x00000008;
      return this.signature;
    }

    /**
     * <code>optional string signature = 1;</code>
     * @param value the signature to set
     * @return this
     */
    public GetPlayerBoardDataScRsp setSignature(final CharSequence value) {
      bitField0_ |= 0x00000008;
      signature.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string signature = 1;</code>
     * @param value the signature to set
     * @return this
     */
    public GetPlayerBoardDataScRsp setSignature(final Utf8String value) {
      bitField0_ |= 0x00000008;
      signature.copyFrom(value);
      return this;
    }

    /**
     * <code>repeated uint32 display_support_avatar_vec = 6;</code>
     * @return whether the displaySupportAvatarVec field is set
     */
    public boolean hasDisplaySupportAvatarVec() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>repeated uint32 display_support_avatar_vec = 6;</code>
     * @return this
     */
    public GetPlayerBoardDataScRsp clearDisplaySupportAvatarVec() {
      bitField0_ &= ~0x00000010;
      displaySupportAvatarVec.clear();
      return this;
    }

    /**
     * <code>repeated uint32 display_support_avatar_vec = 6;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableDisplaySupportAvatarVec()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getDisplaySupportAvatarVec() {
      return displaySupportAvatarVec;
    }

    /**
     * <code>repeated uint32 display_support_avatar_vec = 6;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableDisplaySupportAvatarVec() {
      bitField0_ |= 0x00000010;
      return displaySupportAvatarVec;
    }

    /**
     * <code>repeated uint32 display_support_avatar_vec = 6;</code>
     * @param value the displaySupportAvatarVec to add
     * @return this
     */
    public GetPlayerBoardDataScRsp addDisplaySupportAvatarVec(final int value) {
      bitField0_ |= 0x00000010;
      displaySupportAvatarVec.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 display_support_avatar_vec = 6;</code>
     * @param values the displaySupportAvatarVec to add
     * @return this
     */
    public GetPlayerBoardDataScRsp addAllDisplaySupportAvatarVec(final int... values) {
      bitField0_ |= 0x00000010;
      displaySupportAvatarVec.addAll(values);
      return this;
    }

    /**
     * <code>repeated .HeadIcon unlocked_head_icon_list = 5;</code>
     * @return whether the unlockedHeadIconList field is set
     */
    public boolean hasUnlockedHeadIconList() {
      return (bitField0_ & 0x00000020) != 0;
    }

    /**
     * <code>repeated .HeadIcon unlocked_head_icon_list = 5;</code>
     * @return this
     */
    public GetPlayerBoardDataScRsp clearUnlockedHeadIconList() {
      bitField0_ &= ~0x00000020;
      unlockedHeadIconList.clear();
      return this;
    }

    /**
     * <code>repeated .HeadIcon unlocked_head_icon_list = 5;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableUnlockedHeadIconList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<HeadIconOuterClass.HeadIcon> getUnlockedHeadIconList() {
      return unlockedHeadIconList;
    }

    /**
     * <code>repeated .HeadIcon unlocked_head_icon_list = 5;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<HeadIconOuterClass.HeadIcon> getMutableUnlockedHeadIconList() {
      bitField0_ |= 0x00000020;
      return unlockedHeadIconList;
    }

    /**
     * <code>repeated .HeadIcon unlocked_head_icon_list = 5;</code>
     * @param value the unlockedHeadIconList to add
     * @return this
     */
    public GetPlayerBoardDataScRsp addUnlockedHeadIconList(
        final HeadIconOuterClass.HeadIcon value) {
      bitField0_ |= 0x00000020;
      unlockedHeadIconList.add(value);
      return this;
    }

    /**
     * <code>repeated .HeadIcon unlocked_head_icon_list = 5;</code>
     * @param values the unlockedHeadIconList to add
     * @return this
     */
    public GetPlayerBoardDataScRsp addAllUnlockedHeadIconList(
        final HeadIconOuterClass.HeadIcon... values) {
      bitField0_ |= 0x00000020;
      unlockedHeadIconList.addAll(values);
      return this;
    }

    @Override
    public GetPlayerBoardDataScRsp copyFrom(final GetPlayerBoardDataScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        currentHeadIconId = other.currentHeadIconId;
        retcode = other.retcode;
        displayAvatarVec.copyFrom(other.displayAvatarVec);
        signature.copyFrom(other.signature);
        displaySupportAvatarVec.copyFrom(other.displaySupportAvatarVec);
        unlockedHeadIconList.copyFrom(other.unlockedHeadIconList);
      }
      return this;
    }

    @Override
    public GetPlayerBoardDataScRsp mergeFrom(final GetPlayerBoardDataScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasCurrentHeadIconId()) {
        setCurrentHeadIconId(other.currentHeadIconId);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasDisplayAvatarVec()) {
        getMutableDisplayAvatarVec().mergeFrom(other.displayAvatarVec);
      }
      if (other.hasSignature()) {
        getMutableSignatureBytes().copyFrom(other.signature);
      }
      if (other.hasDisplaySupportAvatarVec()) {
        getMutableDisplaySupportAvatarVec().addAll(other.displaySupportAvatarVec);
      }
      if (other.hasUnlockedHeadIconList()) {
        getMutableUnlockedHeadIconList().addAll(other.unlockedHeadIconList);
      }
      return this;
    }

    @Override
    public GetPlayerBoardDataScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      currentHeadIconId = 0;
      retcode = 0;
      displayAvatarVec.clear();
      signature.clear();
      displaySupportAvatarVec.clear();
      unlockedHeadIconList.clear();
      return this;
    }

    @Override
    public GetPlayerBoardDataScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      displayAvatarVec.clearQuick();
      signature.clear();
      displaySupportAvatarVec.clear();
      unlockedHeadIconList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof GetPlayerBoardDataScRsp)) {
        return false;
      }
      GetPlayerBoardDataScRsp other = (GetPlayerBoardDataScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasCurrentHeadIconId() || currentHeadIconId == other.currentHeadIconId)
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasDisplayAvatarVec() || displayAvatarVec.equals(other.displayAvatarVec))
        && (!hasSignature() || signature.equals(other.signature))
        && (!hasDisplaySupportAvatarVec() || displaySupportAvatarVec.equals(other.displaySupportAvatarVec))
        && (!hasUnlockedHeadIconList() || unlockedHeadIconList.equals(other.unlockedHeadIconList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(currentHeadIconId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 96);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 122);
        output.writeMessageNoTag(displayAvatarVec);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 10);
        output.writeStringNoTag(signature);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        for (int i = 0; i < displaySupportAvatarVec.length(); i++) {
          output.writeRawByte((byte) 48);
          output.writeUInt32NoTag(displaySupportAvatarVec.array()[i]);
        }
      }
      if ((bitField0_ & 0x00000020) != 0) {
        for (int i = 0; i < unlockedHeadIconList.length(); i++) {
          output.writeRawByte((byte) 42);
          output.writeMessageNoTag(unlockedHeadIconList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(currentHeadIconId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(displayAvatarVec);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeStringSizeNoTag(signature);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += (1 * displaySupportAvatarVec.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(displaySupportAvatarVec);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        size += (1 * unlockedHeadIconList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(unlockedHeadIconList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public GetPlayerBoardDataScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 64: {
            // currentHeadIconId
            currentHeadIconId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 96) {
              break;
            }
          }
          case 96: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 122) {
              break;
            }
          }
          case 122: {
            // displayAvatarVec
            input.readMessage(displayAvatarVec);
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 10) {
              break;
            }
          }
          case 10: {
            // signature
            input.readString(signature);
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 50) {
              break;
            }
          }
          case 50: {
            // displaySupportAvatarVec [packed=true]
            input.readPackedUInt32(displaySupportAvatarVec, tag);
            bitField0_ |= 0x00000010;
            tag = input.readTag();
            if (tag != 42) {
              break;
            }
          }
          case 42: {
            // unlockedHeadIconList
            tag = input.readRepeatedMessage(unlockedHeadIconList, tag);
            bitField0_ |= 0x00000020;
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
          case 48: {
            // displaySupportAvatarVec [packed=false]
            tag = input.readRepeatedUInt32(displaySupportAvatarVec, tag);
            bitField0_ |= 0x00000010;
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.currentHeadIconId, currentHeadIconId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeMessage(FieldNames.displayAvatarVec, displayAvatarVec);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeString(FieldNames.signature, signature);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRepeatedUInt32(FieldNames.displaySupportAvatarVec, displaySupportAvatarVec);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeRepeatedMessage(FieldNames.unlockedHeadIconList, unlockedHeadIconList);
      }
      output.endObject();
    }

    @Override
    public GetPlayerBoardDataScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 2107487181:
          case -1003133880: {
            if (input.isAtField(FieldNames.currentHeadIconId)) {
              if (!input.trySkipNullValue()) {
                currentHeadIconId = input.readUInt32();
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
          case 1176708313:
          case -130616501: {
            if (input.isAtField(FieldNames.displayAvatarVec)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(displayAvatarVec);
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1073584312: {
            if (input.isAtField(FieldNames.signature)) {
              if (!input.trySkipNullValue()) {
                input.readString(signature);
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1742211762:
          case -452250437: {
            if (input.isAtField(FieldNames.displaySupportAvatarVec)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(displaySupportAvatarVec);
                bitField0_ |= 0x00000010;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1875382586:
          case -1276395039: {
            if (input.isAtField(FieldNames.unlockedHeadIconList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(unlockedHeadIconList);
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
    public GetPlayerBoardDataScRsp clone() {
      return new GetPlayerBoardDataScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static GetPlayerBoardDataScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new GetPlayerBoardDataScRsp(), data).checkInitialized();
    }

    public static GetPlayerBoardDataScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetPlayerBoardDataScRsp(), input).checkInitialized();
    }

    public static GetPlayerBoardDataScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetPlayerBoardDataScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating GetPlayerBoardDataScRsp messages
     */
    public static MessageFactory<GetPlayerBoardDataScRsp> getFactory() {
      return GetPlayerBoardDataScRspFactory.INSTANCE;
    }

    private enum GetPlayerBoardDataScRspFactory implements MessageFactory<GetPlayerBoardDataScRsp> {
      INSTANCE;

      @Override
      public GetPlayerBoardDataScRsp create() {
        return GetPlayerBoardDataScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName currentHeadIconId = FieldName.forField("currentHeadIconId", "current_head_icon_id");

      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName displayAvatarVec = FieldName.forField("displayAvatarVec", "display_avatar_vec");

      static final FieldName signature = FieldName.forField("signature");

      static final FieldName displaySupportAvatarVec = FieldName.forField("displaySupportAvatarVec", "display_support_avatar_vec");

      static final FieldName unlockedHeadIconList = FieldName.forField("unlockedHeadIconList", "unlocked_head_icon_list");
    }
  }
}
