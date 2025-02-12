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

public final class UnlockSkilltreeCsReqOuterClass {
  /**
   * Protobuf type {@code UnlockSkilltreeCsReq}
   */
  public static final class UnlockSkilltreeCsReq extends ProtoMessage<UnlockSkilltreeCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 level = 4;</code>
     */
    private int level;

    /**
     * <code>optional uint32 point_id = 8;</code>
     */
    private int pointId;

    /**
     * <code>repeated .ItemCost item_list = 6;</code>
     */
    private final RepeatedMessage<ItemCostOuterClass.ItemCost> itemList = RepeatedMessage.newEmptyInstance(ItemCostOuterClass.ItemCost.getFactory());

    private UnlockSkilltreeCsReq() {
    }

    /**
     * @return a new empty instance of {@code UnlockSkilltreeCsReq}
     */
    public static UnlockSkilltreeCsReq newInstance() {
      return new UnlockSkilltreeCsReq();
    }

    /**
     * <code>optional uint32 level = 4;</code>
     * @return whether the level field is set
     */
    public boolean hasLevel() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 level = 4;</code>
     * @return this
     */
    public UnlockSkilltreeCsReq clearLevel() {
      bitField0_ &= ~0x00000001;
      level = 0;
      return this;
    }

    /**
     * <code>optional uint32 level = 4;</code>
     * @return the level
     */
    public int getLevel() {
      return level;
    }

    /**
     * <code>optional uint32 level = 4;</code>
     * @param value the level to set
     * @return this
     */
    public UnlockSkilltreeCsReq setLevel(final int value) {
      bitField0_ |= 0x00000001;
      level = value;
      return this;
    }

    /**
     * <code>optional uint32 point_id = 8;</code>
     * @return whether the pointId field is set
     */
    public boolean hasPointId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 point_id = 8;</code>
     * @return this
     */
    public UnlockSkilltreeCsReq clearPointId() {
      bitField0_ &= ~0x00000002;
      pointId = 0;
      return this;
    }

    /**
     * <code>optional uint32 point_id = 8;</code>
     * @return the pointId
     */
    public int getPointId() {
      return pointId;
    }

    /**
     * <code>optional uint32 point_id = 8;</code>
     * @param value the pointId to set
     * @return this
     */
    public UnlockSkilltreeCsReq setPointId(final int value) {
      bitField0_ |= 0x00000002;
      pointId = value;
      return this;
    }

    /**
     * <code>repeated .ItemCost item_list = 6;</code>
     * @return whether the itemList field is set
     */
    public boolean hasItemList() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>repeated .ItemCost item_list = 6;</code>
     * @return this
     */
    public UnlockSkilltreeCsReq clearItemList() {
      bitField0_ &= ~0x00000004;
      itemList.clear();
      return this;
    }

    /**
     * <code>repeated .ItemCost item_list = 6;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableItemList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<ItemCostOuterClass.ItemCost> getItemList() {
      return itemList;
    }

    /**
     * <code>repeated .ItemCost item_list = 6;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<ItemCostOuterClass.ItemCost> getMutableItemList() {
      bitField0_ |= 0x00000004;
      return itemList;
    }

    /**
     * <code>repeated .ItemCost item_list = 6;</code>
     * @param value the itemList to add
     * @return this
     */
    public UnlockSkilltreeCsReq addItemList(final ItemCostOuterClass.ItemCost value) {
      bitField0_ |= 0x00000004;
      itemList.add(value);
      return this;
    }

    /**
     * <code>repeated .ItemCost item_list = 6;</code>
     * @param values the itemList to add
     * @return this
     */
    public UnlockSkilltreeCsReq addAllItemList(final ItemCostOuterClass.ItemCost... values) {
      bitField0_ |= 0x00000004;
      itemList.addAll(values);
      return this;
    }

    @Override
    public UnlockSkilltreeCsReq copyFrom(final UnlockSkilltreeCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        level = other.level;
        pointId = other.pointId;
        itemList.copyFrom(other.itemList);
      }
      return this;
    }

    @Override
    public UnlockSkilltreeCsReq mergeFrom(final UnlockSkilltreeCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasLevel()) {
        setLevel(other.level);
      }
      if (other.hasPointId()) {
        setPointId(other.pointId);
      }
      if (other.hasItemList()) {
        getMutableItemList().addAll(other.itemList);
      }
      return this;
    }

    @Override
    public UnlockSkilltreeCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      level = 0;
      pointId = 0;
      itemList.clear();
      return this;
    }

    @Override
    public UnlockSkilltreeCsReq clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      itemList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof UnlockSkilltreeCsReq)) {
        return false;
      }
      UnlockSkilltreeCsReq other = (UnlockSkilltreeCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasLevel() || level == other.level)
        && (!hasPointId() || pointId == other.pointId)
        && (!hasItemList() || itemList.equals(other.itemList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 32);
        output.writeUInt32NoTag(level);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(pointId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        for (int i = 0; i < itemList.length(); i++) {
          output.writeRawByte((byte) 50);
          output.writeMessageNoTag(itemList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(level);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(pointId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += (1 * itemList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(itemList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public UnlockSkilltreeCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 32: {
            // level
            level = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 64) {
              break;
            }
          }
          case 64: {
            // pointId
            pointId = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 50) {
              break;
            }
          }
          case 50: {
            // itemList
            tag = input.readRepeatedMessage(itemList, tag);
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
        output.writeUInt32(FieldNames.level, level);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.pointId, pointId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRepeatedMessage(FieldNames.itemList, itemList);
      }
      output.endObject();
    }

    @Override
    public UnlockSkilltreeCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 102865796: {
            if (input.isAtField(FieldNames.level)) {
              if (!input.trySkipNullValue()) {
                level = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -400606517:
          case 466121258: {
            if (input.isAtField(FieldNames.pointId)) {
              if (!input.trySkipNullValue()) {
                pointId = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1177280081:
          case -2141396406: {
            if (input.isAtField(FieldNames.itemList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(itemList);
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
    public UnlockSkilltreeCsReq clone() {
      return new UnlockSkilltreeCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static UnlockSkilltreeCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new UnlockSkilltreeCsReq(), data).checkInitialized();
    }

    public static UnlockSkilltreeCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UnlockSkilltreeCsReq(), input).checkInitialized();
    }

    public static UnlockSkilltreeCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UnlockSkilltreeCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating UnlockSkilltreeCsReq messages
     */
    public static MessageFactory<UnlockSkilltreeCsReq> getFactory() {
      return UnlockSkilltreeCsReqFactory.INSTANCE;
    }

    private enum UnlockSkilltreeCsReqFactory implements MessageFactory<UnlockSkilltreeCsReq> {
      INSTANCE;

      @Override
      public UnlockSkilltreeCsReq create() {
        return UnlockSkilltreeCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName level = FieldName.forField("level");

      static final FieldName pointId = FieldName.forField("pointId", "point_id");

      static final FieldName itemList = FieldName.forField("itemList", "item_list");
    }
  }
}
