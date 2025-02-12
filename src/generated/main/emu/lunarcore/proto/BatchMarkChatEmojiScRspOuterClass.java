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

public final class BatchMarkChatEmojiScRspOuterClass {
  /**
   * Protobuf type {@code BatchMarkChatEmojiScRsp}
   */
  public static final class BatchMarkChatEmojiScRsp extends ProtoMessage<BatchMarkChatEmojiScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 15;</code>
     */
    private int retcode;

    /**
     * <code>repeated uint32 marked_emoji_id_list = 12;</code>
     */
    private final RepeatedInt markedEmojiIdList = RepeatedInt.newEmptyInstance();

    private BatchMarkChatEmojiScRsp() {
    }

    /**
     * @return a new empty instance of {@code BatchMarkChatEmojiScRsp}
     */
    public static BatchMarkChatEmojiScRsp newInstance() {
      return new BatchMarkChatEmojiScRsp();
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @return this
     */
    public BatchMarkChatEmojiScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @param value the retcode to set
     * @return this
     */
    public BatchMarkChatEmojiScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>repeated uint32 marked_emoji_id_list = 12;</code>
     * @return whether the markedEmojiIdList field is set
     */
    public boolean hasMarkedEmojiIdList() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>repeated uint32 marked_emoji_id_list = 12;</code>
     * @return this
     */
    public BatchMarkChatEmojiScRsp clearMarkedEmojiIdList() {
      bitField0_ &= ~0x00000002;
      markedEmojiIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 marked_emoji_id_list = 12;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableMarkedEmojiIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getMarkedEmojiIdList() {
      return markedEmojiIdList;
    }

    /**
     * <code>repeated uint32 marked_emoji_id_list = 12;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableMarkedEmojiIdList() {
      bitField0_ |= 0x00000002;
      return markedEmojiIdList;
    }

    /**
     * <code>repeated uint32 marked_emoji_id_list = 12;</code>
     * @param value the markedEmojiIdList to add
     * @return this
     */
    public BatchMarkChatEmojiScRsp addMarkedEmojiIdList(final int value) {
      bitField0_ |= 0x00000002;
      markedEmojiIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 marked_emoji_id_list = 12;</code>
     * @param values the markedEmojiIdList to add
     * @return this
     */
    public BatchMarkChatEmojiScRsp addAllMarkedEmojiIdList(final int... values) {
      bitField0_ |= 0x00000002;
      markedEmojiIdList.addAll(values);
      return this;
    }

    @Override
    public BatchMarkChatEmojiScRsp copyFrom(final BatchMarkChatEmojiScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        markedEmojiIdList.copyFrom(other.markedEmojiIdList);
      }
      return this;
    }

    @Override
    public BatchMarkChatEmojiScRsp mergeFrom(final BatchMarkChatEmojiScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasMarkedEmojiIdList()) {
        getMutableMarkedEmojiIdList().addAll(other.markedEmojiIdList);
      }
      return this;
    }

    @Override
    public BatchMarkChatEmojiScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      markedEmojiIdList.clear();
      return this;
    }

    @Override
    public BatchMarkChatEmojiScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      markedEmojiIdList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof BatchMarkChatEmojiScRsp)) {
        return false;
      }
      BatchMarkChatEmojiScRsp other = (BatchMarkChatEmojiScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasMarkedEmojiIdList() || markedEmojiIdList.equals(other.markedEmojiIdList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        for (int i = 0; i < markedEmojiIdList.length(); i++) {
          output.writeRawByte((byte) 96);
          output.writeUInt32NoTag(markedEmojiIdList.array()[i]);
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
        size += (1 * markedEmojiIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(markedEmojiIdList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public BatchMarkChatEmojiScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 120: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 98) {
              break;
            }
          }
          case 98: {
            // markedEmojiIdList [packed=true]
            input.readPackedUInt32(markedEmojiIdList, tag);
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
          case 96: {
            // markedEmojiIdList [packed=false]
            tag = input.readRepeatedUInt32(markedEmojiIdList, tag);
            bitField0_ |= 0x00000002;
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
        output.writeRepeatedUInt32(FieldNames.markedEmojiIdList, markedEmojiIdList);
      }
      output.endObject();
    }

    @Override
    public BatchMarkChatEmojiScRsp mergeFrom(final JsonSource input) throws IOException {
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
          case -40973197:
          case -1945731210: {
            if (input.isAtField(FieldNames.markedEmojiIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(markedEmojiIdList);
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
    public BatchMarkChatEmojiScRsp clone() {
      return new BatchMarkChatEmojiScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static BatchMarkChatEmojiScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new BatchMarkChatEmojiScRsp(), data).checkInitialized();
    }

    public static BatchMarkChatEmojiScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new BatchMarkChatEmojiScRsp(), input).checkInitialized();
    }

    public static BatchMarkChatEmojiScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new BatchMarkChatEmojiScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating BatchMarkChatEmojiScRsp messages
     */
    public static MessageFactory<BatchMarkChatEmojiScRsp> getFactory() {
      return BatchMarkChatEmojiScRspFactory.INSTANCE;
    }

    private enum BatchMarkChatEmojiScRspFactory implements MessageFactory<BatchMarkChatEmojiScRsp> {
      INSTANCE;

      @Override
      public BatchMarkChatEmojiScRsp create() {
        return BatchMarkChatEmojiScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName markedEmojiIdList = FieldName.forField("markedEmojiIdList", "marked_emoji_id_list");
    }
  }
}
