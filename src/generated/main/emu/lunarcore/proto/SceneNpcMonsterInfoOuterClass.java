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

public final class SceneNpcMonsterInfoOuterClass {
  /**
   * Protobuf type {@code SceneNpcMonsterInfo}
   */
  public static final class SceneNpcMonsterInfo extends ProtoMessage<SceneNpcMonsterInfo> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 monster_id = 6;</code>
     */
    private int monsterId;

    /**
     * <code>optional uint32 world_level = 9;</code>
     */
    private int worldLevel;

    /**
     * <code>optional uint32 scene_event_id = 15;</code>
     */
    private int sceneEventId;

    /**
     * <code>optional bool MPFEDFBKKDF = 2;</code>
     */
    private boolean mPFEDFBKKDF;

    /**
     * <code>optional bool IDPJIDNLEHH = 13;</code>
     */
    private boolean iDPJIDNLEHH;

    /**
     * <code>optional .NpcMonsterExtraInfo extra_info = 1;</code>
     */
    private final NpcMonsterExtraInfoOuterClass.NpcMonsterExtraInfo extraInfo = NpcMonsterExtraInfoOuterClass.NpcMonsterExtraInfo.newInstance();

    private SceneNpcMonsterInfo() {
    }

    /**
     * @return a new empty instance of {@code SceneNpcMonsterInfo}
     */
    public static SceneNpcMonsterInfo newInstance() {
      return new SceneNpcMonsterInfo();
    }

    /**
     * <code>optional uint32 monster_id = 6;</code>
     * @return whether the monsterId field is set
     */
    public boolean hasMonsterId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 monster_id = 6;</code>
     * @return this
     */
    public SceneNpcMonsterInfo clearMonsterId() {
      bitField0_ &= ~0x00000001;
      monsterId = 0;
      return this;
    }

    /**
     * <code>optional uint32 monster_id = 6;</code>
     * @return the monsterId
     */
    public int getMonsterId() {
      return monsterId;
    }

    /**
     * <code>optional uint32 monster_id = 6;</code>
     * @param value the monsterId to set
     * @return this
     */
    public SceneNpcMonsterInfo setMonsterId(final int value) {
      bitField0_ |= 0x00000001;
      monsterId = value;
      return this;
    }

    /**
     * <code>optional uint32 world_level = 9;</code>
     * @return whether the worldLevel field is set
     */
    public boolean hasWorldLevel() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 world_level = 9;</code>
     * @return this
     */
    public SceneNpcMonsterInfo clearWorldLevel() {
      bitField0_ &= ~0x00000002;
      worldLevel = 0;
      return this;
    }

    /**
     * <code>optional uint32 world_level = 9;</code>
     * @return the worldLevel
     */
    public int getWorldLevel() {
      return worldLevel;
    }

    /**
     * <code>optional uint32 world_level = 9;</code>
     * @param value the worldLevel to set
     * @return this
     */
    public SceneNpcMonsterInfo setWorldLevel(final int value) {
      bitField0_ |= 0x00000002;
      worldLevel = value;
      return this;
    }

    /**
     * <code>optional uint32 scene_event_id = 15;</code>
     * @return whether the sceneEventId field is set
     */
    public boolean hasSceneEventId() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 scene_event_id = 15;</code>
     * @return this
     */
    public SceneNpcMonsterInfo clearSceneEventId() {
      bitField0_ &= ~0x00000004;
      sceneEventId = 0;
      return this;
    }

    /**
     * <code>optional uint32 scene_event_id = 15;</code>
     * @return the sceneEventId
     */
    public int getSceneEventId() {
      return sceneEventId;
    }

    /**
     * <code>optional uint32 scene_event_id = 15;</code>
     * @param value the sceneEventId to set
     * @return this
     */
    public SceneNpcMonsterInfo setSceneEventId(final int value) {
      bitField0_ |= 0x00000004;
      sceneEventId = value;
      return this;
    }

    /**
     * <code>optional bool MPFEDFBKKDF = 2;</code>
     * @return whether the mPFEDFBKKDF field is set
     */
    public boolean hasMPFEDFBKKDF() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional bool MPFEDFBKKDF = 2;</code>
     * @return this
     */
    public SceneNpcMonsterInfo clearMPFEDFBKKDF() {
      bitField0_ &= ~0x00000008;
      mPFEDFBKKDF = false;
      return this;
    }

    /**
     * <code>optional bool MPFEDFBKKDF = 2;</code>
     * @return the mPFEDFBKKDF
     */
    public boolean getMPFEDFBKKDF() {
      return mPFEDFBKKDF;
    }

    /**
     * <code>optional bool MPFEDFBKKDF = 2;</code>
     * @param value the mPFEDFBKKDF to set
     * @return this
     */
    public SceneNpcMonsterInfo setMPFEDFBKKDF(final boolean value) {
      bitField0_ |= 0x00000008;
      mPFEDFBKKDF = value;
      return this;
    }

    /**
     * <code>optional bool IDPJIDNLEHH = 13;</code>
     * @return whether the iDPJIDNLEHH field is set
     */
    public boolean hasIDPJIDNLEHH() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>optional bool IDPJIDNLEHH = 13;</code>
     * @return this
     */
    public SceneNpcMonsterInfo clearIDPJIDNLEHH() {
      bitField0_ &= ~0x00000010;
      iDPJIDNLEHH = false;
      return this;
    }

    /**
     * <code>optional bool IDPJIDNLEHH = 13;</code>
     * @return the iDPJIDNLEHH
     */
    public boolean getIDPJIDNLEHH() {
      return iDPJIDNLEHH;
    }

    /**
     * <code>optional bool IDPJIDNLEHH = 13;</code>
     * @param value the iDPJIDNLEHH to set
     * @return this
     */
    public SceneNpcMonsterInfo setIDPJIDNLEHH(final boolean value) {
      bitField0_ |= 0x00000010;
      iDPJIDNLEHH = value;
      return this;
    }

    /**
     * <code>optional .NpcMonsterExtraInfo extra_info = 1;</code>
     * @return whether the extraInfo field is set
     */
    public boolean hasExtraInfo() {
      return (bitField0_ & 0x00000020) != 0;
    }

    /**
     * <code>optional .NpcMonsterExtraInfo extra_info = 1;</code>
     * @return this
     */
    public SceneNpcMonsterInfo clearExtraInfo() {
      bitField0_ &= ~0x00000020;
      extraInfo.clear();
      return this;
    }

    /**
     * <code>optional .NpcMonsterExtraInfo extra_info = 1;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableExtraInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public NpcMonsterExtraInfoOuterClass.NpcMonsterExtraInfo getExtraInfo() {
      return extraInfo;
    }

    /**
     * <code>optional .NpcMonsterExtraInfo extra_info = 1;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public NpcMonsterExtraInfoOuterClass.NpcMonsterExtraInfo getMutableExtraInfo() {
      bitField0_ |= 0x00000020;
      return extraInfo;
    }

    /**
     * <code>optional .NpcMonsterExtraInfo extra_info = 1;</code>
     * @param value the extraInfo to set
     * @return this
     */
    public SceneNpcMonsterInfo setExtraInfo(
        final NpcMonsterExtraInfoOuterClass.NpcMonsterExtraInfo value) {
      bitField0_ |= 0x00000020;
      extraInfo.copyFrom(value);
      return this;
    }

    @Override
    public SceneNpcMonsterInfo copyFrom(final SceneNpcMonsterInfo other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        monsterId = other.monsterId;
        worldLevel = other.worldLevel;
        sceneEventId = other.sceneEventId;
        mPFEDFBKKDF = other.mPFEDFBKKDF;
        iDPJIDNLEHH = other.iDPJIDNLEHH;
        extraInfo.copyFrom(other.extraInfo);
      }
      return this;
    }

    @Override
    public SceneNpcMonsterInfo mergeFrom(final SceneNpcMonsterInfo other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasMonsterId()) {
        setMonsterId(other.monsterId);
      }
      if (other.hasWorldLevel()) {
        setWorldLevel(other.worldLevel);
      }
      if (other.hasSceneEventId()) {
        setSceneEventId(other.sceneEventId);
      }
      if (other.hasMPFEDFBKKDF()) {
        setMPFEDFBKKDF(other.mPFEDFBKKDF);
      }
      if (other.hasIDPJIDNLEHH()) {
        setIDPJIDNLEHH(other.iDPJIDNLEHH);
      }
      if (other.hasExtraInfo()) {
        getMutableExtraInfo().mergeFrom(other.extraInfo);
      }
      return this;
    }

    @Override
    public SceneNpcMonsterInfo clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      monsterId = 0;
      worldLevel = 0;
      sceneEventId = 0;
      mPFEDFBKKDF = false;
      iDPJIDNLEHH = false;
      extraInfo.clear();
      return this;
    }

    @Override
    public SceneNpcMonsterInfo clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      extraInfo.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof SceneNpcMonsterInfo)) {
        return false;
      }
      SceneNpcMonsterInfo other = (SceneNpcMonsterInfo) o;
      return bitField0_ == other.bitField0_
        && (!hasMonsterId() || monsterId == other.monsterId)
        && (!hasWorldLevel() || worldLevel == other.worldLevel)
        && (!hasSceneEventId() || sceneEventId == other.sceneEventId)
        && (!hasMPFEDFBKKDF() || mPFEDFBKKDF == other.mPFEDFBKKDF)
        && (!hasIDPJIDNLEHH() || iDPJIDNLEHH == other.iDPJIDNLEHH)
        && (!hasExtraInfo() || extraInfo.equals(other.extraInfo));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 48);
        output.writeUInt32NoTag(monsterId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 72);
        output.writeUInt32NoTag(worldLevel);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(sceneEventId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 16);
        output.writeBoolNoTag(mPFEDFBKKDF);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRawByte((byte) 104);
        output.writeBoolNoTag(iDPJIDNLEHH);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeRawByte((byte) 10);
        output.writeMessageNoTag(extraInfo);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(monsterId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(worldLevel);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(sceneEventId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 2;
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += 2;
      }
      if ((bitField0_ & 0x00000020) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(extraInfo);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SceneNpcMonsterInfo mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 48: {
            // monsterId
            monsterId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 72) {
              break;
            }
          }
          case 72: {
            // worldLevel
            worldLevel = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // sceneEventId
            sceneEventId = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 16) {
              break;
            }
          }
          case 16: {
            // mPFEDFBKKDF
            mPFEDFBKKDF = input.readBool();
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 104) {
              break;
            }
          }
          case 104: {
            // iDPJIDNLEHH
            iDPJIDNLEHH = input.readBool();
            bitField0_ |= 0x00000010;
            tag = input.readTag();
            if (tag != 10) {
              break;
            }
          }
          case 10: {
            // extraInfo
            input.readMessage(extraInfo);
            bitField0_ |= 0x00000020;
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
        output.writeUInt32(FieldNames.monsterId, monsterId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.worldLevel, worldLevel);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.sceneEventId, sceneEventId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeBool(FieldNames.mPFEDFBKKDF, mPFEDFBKKDF);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeBool(FieldNames.iDPJIDNLEHH, iDPJIDNLEHH);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeMessage(FieldNames.extraInfo, extraInfo);
      }
      output.endObject();
    }

    @Override
    public SceneNpcMonsterInfo mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1316830571:
          case 2127946656: {
            if (input.isAtField(FieldNames.monsterId)) {
              if (!input.trySkipNullValue()) {
                monsterId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 440007442:
          case 1305257111: {
            if (input.isAtField(FieldNames.worldLevel)) {
              if (!input.trySkipNullValue()) {
                worldLevel = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 748898089:
          case 765114163: {
            if (input.isAtField(FieldNames.sceneEventId)) {
              if (!input.trySkipNullValue()) {
                sceneEventId = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 847565312: {
            if (input.isAtField(FieldNames.mPFEDFBKKDF)) {
              if (!input.trySkipNullValue()) {
                mPFEDFBKKDF = input.readBool();
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1129439063: {
            if (input.isAtField(FieldNames.iDPJIDNLEHH)) {
              if (!input.trySkipNullValue()) {
                iDPJIDNLEHH = input.readBool();
                bitField0_ |= 0x00000010;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -253631266:
          case 747541373: {
            if (input.isAtField(FieldNames.extraInfo)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(extraInfo);
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
    public SceneNpcMonsterInfo clone() {
      return new SceneNpcMonsterInfo().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SceneNpcMonsterInfo parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SceneNpcMonsterInfo(), data).checkInitialized();
    }

    public static SceneNpcMonsterInfo parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SceneNpcMonsterInfo(), input).checkInitialized();
    }

    public static SceneNpcMonsterInfo parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SceneNpcMonsterInfo(), input).checkInitialized();
    }

    /**
     * @return factory for creating SceneNpcMonsterInfo messages
     */
    public static MessageFactory<SceneNpcMonsterInfo> getFactory() {
      return SceneNpcMonsterInfoFactory.INSTANCE;
    }

    private enum SceneNpcMonsterInfoFactory implements MessageFactory<SceneNpcMonsterInfo> {
      INSTANCE;

      @Override
      public SceneNpcMonsterInfo create() {
        return SceneNpcMonsterInfo.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName monsterId = FieldName.forField("monsterId", "monster_id");

      static final FieldName worldLevel = FieldName.forField("worldLevel", "world_level");

      static final FieldName sceneEventId = FieldName.forField("sceneEventId", "scene_event_id");

      static final FieldName mPFEDFBKKDF = FieldName.forField("MPFEDFBKKDF");

      static final FieldName iDPJIDNLEHH = FieldName.forField("IDPJIDNLEHH");

      static final FieldName extraInfo = FieldName.forField("extraInfo", "extra_info");
    }
  }
}
