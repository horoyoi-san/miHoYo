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

public final class ChallengeBossBuffListOuterClass {
  /**
   * Protobuf type {@code ChallengeBossBuffList}
   */
  public static final class ChallengeBossBuffList extends ProtoMessage<ChallengeBossBuffList> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 boss_buff_id = 6;</code>
     */
    private int bossBuffId;

    /**
     * <code>repeated uint32 buff_list = 13;</code>
     */
    private final RepeatedInt buffList = RepeatedInt.newEmptyInstance();

    private ChallengeBossBuffList() {
    }

    /**
     * @return a new empty instance of {@code ChallengeBossBuffList}
     */
    public static ChallengeBossBuffList newInstance() {
      return new ChallengeBossBuffList();
    }

    /**
     * <code>optional uint32 boss_buff_id = 6;</code>
     * @return whether the bossBuffId field is set
     */
    public boolean hasBossBuffId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 boss_buff_id = 6;</code>
     * @return this
     */
    public ChallengeBossBuffList clearBossBuffId() {
      bitField0_ &= ~0x00000001;
      bossBuffId = 0;
      return this;
    }

    /**
     * <code>optional uint32 boss_buff_id = 6;</code>
     * @return the bossBuffId
     */
    public int getBossBuffId() {
      return bossBuffId;
    }

    /**
     * <code>optional uint32 boss_buff_id = 6;</code>
     * @param value the bossBuffId to set
     * @return this
     */
    public ChallengeBossBuffList setBossBuffId(final int value) {
      bitField0_ |= 0x00000001;
      bossBuffId = value;
      return this;
    }

    /**
     * <code>repeated uint32 buff_list = 13;</code>
     * @return whether the buffList field is set
     */
    public boolean hasBuffList() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>repeated uint32 buff_list = 13;</code>
     * @return this
     */
    public ChallengeBossBuffList clearBuffList() {
      bitField0_ &= ~0x00000002;
      buffList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 buff_list = 13;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableBuffList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getBuffList() {
      return buffList;
    }

    /**
     * <code>repeated uint32 buff_list = 13;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableBuffList() {
      bitField0_ |= 0x00000002;
      return buffList;
    }

    /**
     * <code>repeated uint32 buff_list = 13;</code>
     * @param value the buffList to add
     * @return this
     */
    public ChallengeBossBuffList addBuffList(final int value) {
      bitField0_ |= 0x00000002;
      buffList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 buff_list = 13;</code>
     * @param values the buffList to add
     * @return this
     */
    public ChallengeBossBuffList addAllBuffList(final int... values) {
      bitField0_ |= 0x00000002;
      buffList.addAll(values);
      return this;
    }

    @Override
    public ChallengeBossBuffList copyFrom(final ChallengeBossBuffList other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        bossBuffId = other.bossBuffId;
        buffList.copyFrom(other.buffList);
      }
      return this;
    }

    @Override
    public ChallengeBossBuffList mergeFrom(final ChallengeBossBuffList other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasBossBuffId()) {
        setBossBuffId(other.bossBuffId);
      }
      if (other.hasBuffList()) {
        getMutableBuffList().addAll(other.buffList);
      }
      return this;
    }

    @Override
    public ChallengeBossBuffList clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      bossBuffId = 0;
      buffList.clear();
      return this;
    }

    @Override
    public ChallengeBossBuffList clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      buffList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ChallengeBossBuffList)) {
        return false;
      }
      ChallengeBossBuffList other = (ChallengeBossBuffList) o;
      return bitField0_ == other.bitField0_
        && (!hasBossBuffId() || bossBuffId == other.bossBuffId)
        && (!hasBuffList() || buffList.equals(other.buffList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 48);
        output.writeUInt32NoTag(bossBuffId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        for (int i = 0; i < buffList.length(); i++) {
          output.writeRawByte((byte) 104);
          output.writeUInt32NoTag(buffList.array()[i]);
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(bossBuffId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += (1 * buffList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(buffList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ChallengeBossBuffList mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 48: {
            // bossBuffId
            bossBuffId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 106) {
              break;
            }
          }
          case 106: {
            // buffList [packed=true]
            input.readPackedUInt32(buffList, tag);
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
          case 104: {
            // buffList [packed=false]
            tag = input.readRepeatedUInt32(buffList, tag);
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
        output.writeUInt32(FieldNames.bossBuffId, bossBuffId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRepeatedUInt32(FieldNames.buffList, buffList);
      }
      output.endObject();
    }

    @Override
    public ChallengeBossBuffList mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1298287973:
          case 1930232245: {
            if (input.isAtField(FieldNames.bossBuffId)) {
              if (!input.trySkipNullValue()) {
                bossBuffId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1522789487:
          case 55792906: {
            if (input.isAtField(FieldNames.buffList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(buffList);
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
    public ChallengeBossBuffList clone() {
      return new ChallengeBossBuffList().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ChallengeBossBuffList parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ChallengeBossBuffList(), data).checkInitialized();
    }

    public static ChallengeBossBuffList parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeBossBuffList(), input).checkInitialized();
    }

    public static ChallengeBossBuffList parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeBossBuffList(), input).checkInitialized();
    }

    /**
     * @return factory for creating ChallengeBossBuffList messages
     */
    public static MessageFactory<ChallengeBossBuffList> getFactory() {
      return ChallengeBossBuffListFactory.INSTANCE;
    }

    private enum ChallengeBossBuffListFactory implements MessageFactory<ChallengeBossBuffList> {
      INSTANCE;

      @Override
      public ChallengeBossBuffList create() {
        return ChallengeBossBuffList.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName bossBuffId = FieldName.forField("bossBuffId", "boss_buff_id");

      static final FieldName buffList = FieldName.forField("buffList", "buff_list");
    }
  }
}
