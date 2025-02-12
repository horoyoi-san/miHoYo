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

public final class ChallengeBossEquipmentOuterClass {
  /**
   * Protobuf type {@code ChallengeBossEquipment}
   */
  public static final class ChallengeBossEquipment extends ProtoMessage<ChallengeBossEquipment> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 unique_id = 2;</code>
     */
    private int uniqueId;

    /**
     * <code>optional uint32 level = 5;</code>
     */
    private int level;

    /**
     * <code>optional uint32 rank = 8;</code>
     */
    private int rank;

    /**
     * <code>optional uint32 promotion = 11;</code>
     */
    private int promotion;

    /**
     * <code>optional uint32 tid = 13;</code>
     */
    private int tid;

    private ChallengeBossEquipment() {
    }

    /**
     * @return a new empty instance of {@code ChallengeBossEquipment}
     */
    public static ChallengeBossEquipment newInstance() {
      return new ChallengeBossEquipment();
    }

    /**
     * <code>optional uint32 unique_id = 2;</code>
     * @return whether the uniqueId field is set
     */
    public boolean hasUniqueId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 unique_id = 2;</code>
     * @return this
     */
    public ChallengeBossEquipment clearUniqueId() {
      bitField0_ &= ~0x00000001;
      uniqueId = 0;
      return this;
    }

    /**
     * <code>optional uint32 unique_id = 2;</code>
     * @return the uniqueId
     */
    public int getUniqueId() {
      return uniqueId;
    }

    /**
     * <code>optional uint32 unique_id = 2;</code>
     * @param value the uniqueId to set
     * @return this
     */
    public ChallengeBossEquipment setUniqueId(final int value) {
      bitField0_ |= 0x00000001;
      uniqueId = value;
      return this;
    }

    /**
     * <code>optional uint32 level = 5;</code>
     * @return whether the level field is set
     */
    public boolean hasLevel() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 level = 5;</code>
     * @return this
     */
    public ChallengeBossEquipment clearLevel() {
      bitField0_ &= ~0x00000002;
      level = 0;
      return this;
    }

    /**
     * <code>optional uint32 level = 5;</code>
     * @return the level
     */
    public int getLevel() {
      return level;
    }

    /**
     * <code>optional uint32 level = 5;</code>
     * @param value the level to set
     * @return this
     */
    public ChallengeBossEquipment setLevel(final int value) {
      bitField0_ |= 0x00000002;
      level = value;
      return this;
    }

    /**
     * <code>optional uint32 rank = 8;</code>
     * @return whether the rank field is set
     */
    public boolean hasRank() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 rank = 8;</code>
     * @return this
     */
    public ChallengeBossEquipment clearRank() {
      bitField0_ &= ~0x00000004;
      rank = 0;
      return this;
    }

    /**
     * <code>optional uint32 rank = 8;</code>
     * @return the rank
     */
    public int getRank() {
      return rank;
    }

    /**
     * <code>optional uint32 rank = 8;</code>
     * @param value the rank to set
     * @return this
     */
    public ChallengeBossEquipment setRank(final int value) {
      bitField0_ |= 0x00000004;
      rank = value;
      return this;
    }

    /**
     * <code>optional uint32 promotion = 11;</code>
     * @return whether the promotion field is set
     */
    public boolean hasPromotion() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional uint32 promotion = 11;</code>
     * @return this
     */
    public ChallengeBossEquipment clearPromotion() {
      bitField0_ &= ~0x00000008;
      promotion = 0;
      return this;
    }

    /**
     * <code>optional uint32 promotion = 11;</code>
     * @return the promotion
     */
    public int getPromotion() {
      return promotion;
    }

    /**
     * <code>optional uint32 promotion = 11;</code>
     * @param value the promotion to set
     * @return this
     */
    public ChallengeBossEquipment setPromotion(final int value) {
      bitField0_ |= 0x00000008;
      promotion = value;
      return this;
    }

    /**
     * <code>optional uint32 tid = 13;</code>
     * @return whether the tid field is set
     */
    public boolean hasTid() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>optional uint32 tid = 13;</code>
     * @return this
     */
    public ChallengeBossEquipment clearTid() {
      bitField0_ &= ~0x00000010;
      tid = 0;
      return this;
    }

    /**
     * <code>optional uint32 tid = 13;</code>
     * @return the tid
     */
    public int getTid() {
      return tid;
    }

    /**
     * <code>optional uint32 tid = 13;</code>
     * @param value the tid to set
     * @return this
     */
    public ChallengeBossEquipment setTid(final int value) {
      bitField0_ |= 0x00000010;
      tid = value;
      return this;
    }

    @Override
    public ChallengeBossEquipment copyFrom(final ChallengeBossEquipment other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        uniqueId = other.uniqueId;
        level = other.level;
        rank = other.rank;
        promotion = other.promotion;
        tid = other.tid;
      }
      return this;
    }

    @Override
    public ChallengeBossEquipment mergeFrom(final ChallengeBossEquipment other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasUniqueId()) {
        setUniqueId(other.uniqueId);
      }
      if (other.hasLevel()) {
        setLevel(other.level);
      }
      if (other.hasRank()) {
        setRank(other.rank);
      }
      if (other.hasPromotion()) {
        setPromotion(other.promotion);
      }
      if (other.hasTid()) {
        setTid(other.tid);
      }
      return this;
    }

    @Override
    public ChallengeBossEquipment clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      uniqueId = 0;
      level = 0;
      rank = 0;
      promotion = 0;
      tid = 0;
      return this;
    }

    @Override
    public ChallengeBossEquipment clearQuick() {
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
      if (!(o instanceof ChallengeBossEquipment)) {
        return false;
      }
      ChallengeBossEquipment other = (ChallengeBossEquipment) o;
      return bitField0_ == other.bitField0_
        && (!hasUniqueId() || uniqueId == other.uniqueId)
        && (!hasLevel() || level == other.level)
        && (!hasRank() || rank == other.rank)
        && (!hasPromotion() || promotion == other.promotion)
        && (!hasTid() || tid == other.tid);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 16);
        output.writeUInt32NoTag(uniqueId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 40);
        output.writeUInt32NoTag(level);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(rank);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(promotion);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRawByte((byte) 104);
        output.writeUInt32NoTag(tid);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(uniqueId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(level);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(rank);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(promotion);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(tid);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ChallengeBossEquipment mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 16: {
            // uniqueId
            uniqueId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 40) {
              break;
            }
          }
          case 40: {
            // level
            level = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 64) {
              break;
            }
          }
          case 64: {
            // rank
            rank = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // promotion
            promotion = input.readUInt32();
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 104) {
              break;
            }
          }
          case 104: {
            // tid
            tid = input.readUInt32();
            bitField0_ |= 0x00000010;
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
        output.writeUInt32(FieldNames.uniqueId, uniqueId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.level, level);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.rank, rank);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeUInt32(FieldNames.promotion, promotion);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeUInt32(FieldNames.tid, tid);
      }
      output.endObject();
    }

    @Override
    public ChallengeBossEquipment mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -294460212:
          case -538310583: {
            if (input.isAtField(FieldNames.uniqueId)) {
              if (!input.trySkipNullValue()) {
                uniqueId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 102865796: {
            if (input.isAtField(FieldNames.level)) {
              if (!input.trySkipNullValue()) {
                level = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 3492908: {
            if (input.isAtField(FieldNames.rank)) {
              if (!input.trySkipNullValue()) {
                rank = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -799212381: {
            if (input.isAtField(FieldNames.promotion)) {
              if (!input.trySkipNullValue()) {
                promotion = input.readUInt32();
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 114831: {
            if (input.isAtField(FieldNames.tid)) {
              if (!input.trySkipNullValue()) {
                tid = input.readUInt32();
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
    public ChallengeBossEquipment clone() {
      return new ChallengeBossEquipment().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ChallengeBossEquipment parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ChallengeBossEquipment(), data).checkInitialized();
    }

    public static ChallengeBossEquipment parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeBossEquipment(), input).checkInitialized();
    }

    public static ChallengeBossEquipment parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeBossEquipment(), input).checkInitialized();
    }

    /**
     * @return factory for creating ChallengeBossEquipment messages
     */
    public static MessageFactory<ChallengeBossEquipment> getFactory() {
      return ChallengeBossEquipmentFactory.INSTANCE;
    }

    private enum ChallengeBossEquipmentFactory implements MessageFactory<ChallengeBossEquipment> {
      INSTANCE;

      @Override
      public ChallengeBossEquipment create() {
        return ChallengeBossEquipment.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName uniqueId = FieldName.forField("uniqueId", "unique_id");

      static final FieldName level = FieldName.forField("level");

      static final FieldName rank = FieldName.forField("rank");

      static final FieldName promotion = FieldName.forField("promotion");

      static final FieldName tid = FieldName.forField("tid");
    }
  }
}
