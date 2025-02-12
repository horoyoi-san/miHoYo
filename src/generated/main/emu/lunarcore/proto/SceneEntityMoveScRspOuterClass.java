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

public final class SceneEntityMoveScRspOuterClass {
  /**
   * Protobuf type {@code SceneEntityMoveScRsp}
   */
  public static final class SceneEntityMoveScRsp extends ProtoMessage<SceneEntityMoveScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 8;</code>
     */
    private int retcode;

    /**
     * <code>optional .ClientDownloadData download_data = 14;</code>
     */
    private final ClientDownloadDataOuterClass.ClientDownloadData downloadData = ClientDownloadDataOuterClass.ClientDownloadData.newInstance();

    /**
     * <code>repeated .EntityMotion entity_motion_list = 2;</code>
     */
    private final RepeatedMessage<EntityMotionOuterClass.EntityMotion> entityMotionList = RepeatedMessage.newEmptyInstance(EntityMotionOuterClass.EntityMotion.getFactory());

    private SceneEntityMoveScRsp() {
    }

    /**
     * @return a new empty instance of {@code SceneEntityMoveScRsp}
     */
    public static SceneEntityMoveScRsp newInstance() {
      return new SceneEntityMoveScRsp();
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @return this
     */
    public SceneEntityMoveScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @param value the retcode to set
     * @return this
     */
    public SceneEntityMoveScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>optional .ClientDownloadData download_data = 14;</code>
     * @return whether the downloadData field is set
     */
    public boolean hasDownloadData() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .ClientDownloadData download_data = 14;</code>
     * @return this
     */
    public SceneEntityMoveScRsp clearDownloadData() {
      bitField0_ &= ~0x00000002;
      downloadData.clear();
      return this;
    }

    /**
     * <code>optional .ClientDownloadData download_data = 14;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableDownloadData()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public ClientDownloadDataOuterClass.ClientDownloadData getDownloadData() {
      return downloadData;
    }

    /**
     * <code>optional .ClientDownloadData download_data = 14;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public ClientDownloadDataOuterClass.ClientDownloadData getMutableDownloadData() {
      bitField0_ |= 0x00000002;
      return downloadData;
    }

    /**
     * <code>optional .ClientDownloadData download_data = 14;</code>
     * @param value the downloadData to set
     * @return this
     */
    public SceneEntityMoveScRsp setDownloadData(
        final ClientDownloadDataOuterClass.ClientDownloadData value) {
      bitField0_ |= 0x00000002;
      downloadData.copyFrom(value);
      return this;
    }

    /**
     * <code>repeated .EntityMotion entity_motion_list = 2;</code>
     * @return whether the entityMotionList field is set
     */
    public boolean hasEntityMotionList() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>repeated .EntityMotion entity_motion_list = 2;</code>
     * @return this
     */
    public SceneEntityMoveScRsp clearEntityMotionList() {
      bitField0_ &= ~0x00000004;
      entityMotionList.clear();
      return this;
    }

    /**
     * <code>repeated .EntityMotion entity_motion_list = 2;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableEntityMotionList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<EntityMotionOuterClass.EntityMotion> getEntityMotionList() {
      return entityMotionList;
    }

    /**
     * <code>repeated .EntityMotion entity_motion_list = 2;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<EntityMotionOuterClass.EntityMotion> getMutableEntityMotionList() {
      bitField0_ |= 0x00000004;
      return entityMotionList;
    }

    /**
     * <code>repeated .EntityMotion entity_motion_list = 2;</code>
     * @param value the entityMotionList to add
     * @return this
     */
    public SceneEntityMoveScRsp addEntityMotionList(
        final EntityMotionOuterClass.EntityMotion value) {
      bitField0_ |= 0x00000004;
      entityMotionList.add(value);
      return this;
    }

    /**
     * <code>repeated .EntityMotion entity_motion_list = 2;</code>
     * @param values the entityMotionList to add
     * @return this
     */
    public SceneEntityMoveScRsp addAllEntityMotionList(
        final EntityMotionOuterClass.EntityMotion... values) {
      bitField0_ |= 0x00000004;
      entityMotionList.addAll(values);
      return this;
    }

    @Override
    public SceneEntityMoveScRsp copyFrom(final SceneEntityMoveScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        downloadData.copyFrom(other.downloadData);
        entityMotionList.copyFrom(other.entityMotionList);
      }
      return this;
    }

    @Override
    public SceneEntityMoveScRsp mergeFrom(final SceneEntityMoveScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasDownloadData()) {
        getMutableDownloadData().mergeFrom(other.downloadData);
      }
      if (other.hasEntityMotionList()) {
        getMutableEntityMotionList().addAll(other.entityMotionList);
      }
      return this;
    }

    @Override
    public SceneEntityMoveScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      downloadData.clear();
      entityMotionList.clear();
      return this;
    }

    @Override
    public SceneEntityMoveScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      downloadData.clearQuick();
      entityMotionList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof SceneEntityMoveScRsp)) {
        return false;
      }
      SceneEntityMoveScRsp other = (SceneEntityMoveScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasDownloadData() || downloadData.equals(other.downloadData))
        && (!hasEntityMotionList() || entityMotionList.equals(other.entityMotionList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 114);
        output.writeMessageNoTag(downloadData);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        for (int i = 0; i < entityMotionList.length(); i++) {
          output.writeRawByte((byte) 18);
          output.writeMessageNoTag(entityMotionList.get(i));
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
        size += 1 + ProtoSink.computeMessageSizeNoTag(downloadData);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += (1 * entityMotionList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(entityMotionList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SceneEntityMoveScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 64: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 114) {
              break;
            }
          }
          case 114: {
            // downloadData
            input.readMessage(downloadData);
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 18) {
              break;
            }
          }
          case 18: {
            // entityMotionList
            tag = input.readRepeatedMessage(entityMotionList, tag);
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
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeMessage(FieldNames.downloadData, downloadData);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRepeatedMessage(FieldNames.entityMotionList, entityMotionList);
      }
      output.endObject();
    }

    @Override
    public SceneEntityMoveScRsp mergeFrom(final JsonSource input) throws IOException {
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
          case 1108584530:
          case 31388929: {
            if (input.isAtField(FieldNames.downloadData)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(downloadData);
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -276915785:
          case 59281707: {
            if (input.isAtField(FieldNames.entityMotionList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(entityMotionList);
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
    public SceneEntityMoveScRsp clone() {
      return new SceneEntityMoveScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SceneEntityMoveScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SceneEntityMoveScRsp(), data).checkInitialized();
    }

    public static SceneEntityMoveScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SceneEntityMoveScRsp(), input).checkInitialized();
    }

    public static SceneEntityMoveScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SceneEntityMoveScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating SceneEntityMoveScRsp messages
     */
    public static MessageFactory<SceneEntityMoveScRsp> getFactory() {
      return SceneEntityMoveScRspFactory.INSTANCE;
    }

    private enum SceneEntityMoveScRspFactory implements MessageFactory<SceneEntityMoveScRsp> {
      INSTANCE;

      @Override
      public SceneEntityMoveScRsp create() {
        return SceneEntityMoveScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName downloadData = FieldName.forField("downloadData", "download_data");

      static final FieldName entityMotionList = FieldName.forField("entityMotionList", "entity_motion_list");
    }
  }
}
