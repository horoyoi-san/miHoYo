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

public final class SceneMonsterWaveParamOuterClass {
  /**
   * Protobuf type {@code SceneMonsterWaveParam}
   */
  public static final class SceneMonsterWaveParam extends ProtoMessage<SceneMonsterWaveParam> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 elite_group = 1;</code>
     */
    private int eliteGroup;

    /**
     * <code>optional uint32 hard_level_group = 7;</code>
     */
    private int hardLevelGroup;

    /**
     * <code>optional uint32 DNEAMPLLFME = 11;</code>
     */
    private int dNEAMPLLFME;

    /**
     * <code>optional uint32 level = 13;</code>
     */
    private int level;

    private SceneMonsterWaveParam() {
    }

    /**
     * @return a new empty instance of {@code SceneMonsterWaveParam}
     */
    public static SceneMonsterWaveParam newInstance() {
      return new SceneMonsterWaveParam();
    }

    /**
     * <code>optional uint32 elite_group = 1;</code>
     * @return whether the eliteGroup field is set
     */
    public boolean hasEliteGroup() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 elite_group = 1;</code>
     * @return this
     */
    public SceneMonsterWaveParam clearEliteGroup() {
      bitField0_ &= ~0x00000001;
      eliteGroup = 0;
      return this;
    }

    /**
     * <code>optional uint32 elite_group = 1;</code>
     * @return the eliteGroup
     */
    public int getEliteGroup() {
      return eliteGroup;
    }

    /**
     * <code>optional uint32 elite_group = 1;</code>
     * @param value the eliteGroup to set
     * @return this
     */
    public SceneMonsterWaveParam setEliteGroup(final int value) {
      bitField0_ |= 0x00000001;
      eliteGroup = value;
      return this;
    }

    /**
     * <code>optional uint32 hard_level_group = 7;</code>
     * @return whether the hardLevelGroup field is set
     */
    public boolean hasHardLevelGroup() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 hard_level_group = 7;</code>
     * @return this
     */
    public SceneMonsterWaveParam clearHardLevelGroup() {
      bitField0_ &= ~0x00000002;
      hardLevelGroup = 0;
      return this;
    }

    /**
     * <code>optional uint32 hard_level_group = 7;</code>
     * @return the hardLevelGroup
     */
    public int getHardLevelGroup() {
      return hardLevelGroup;
    }

    /**
     * <code>optional uint32 hard_level_group = 7;</code>
     * @param value the hardLevelGroup to set
     * @return this
     */
    public SceneMonsterWaveParam setHardLevelGroup(final int value) {
      bitField0_ |= 0x00000002;
      hardLevelGroup = value;
      return this;
    }

    /**
     * <code>optional uint32 DNEAMPLLFME = 11;</code>
     * @return whether the dNEAMPLLFME field is set
     */
    public boolean hasDNEAMPLLFME() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 DNEAMPLLFME = 11;</code>
     * @return this
     */
    public SceneMonsterWaveParam clearDNEAMPLLFME() {
      bitField0_ &= ~0x00000004;
      dNEAMPLLFME = 0;
      return this;
    }

    /**
     * <code>optional uint32 DNEAMPLLFME = 11;</code>
     * @return the dNEAMPLLFME
     */
    public int getDNEAMPLLFME() {
      return dNEAMPLLFME;
    }

    /**
     * <code>optional uint32 DNEAMPLLFME = 11;</code>
     * @param value the dNEAMPLLFME to set
     * @return this
     */
    public SceneMonsterWaveParam setDNEAMPLLFME(final int value) {
      bitField0_ |= 0x00000004;
      dNEAMPLLFME = value;
      return this;
    }

    /**
     * <code>optional uint32 level = 13;</code>
     * @return whether the level field is set
     */
    public boolean hasLevel() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional uint32 level = 13;</code>
     * @return this
     */
    public SceneMonsterWaveParam clearLevel() {
      bitField0_ &= ~0x00000008;
      level = 0;
      return this;
    }

    /**
     * <code>optional uint32 level = 13;</code>
     * @return the level
     */
    public int getLevel() {
      return level;
    }

    /**
     * <code>optional uint32 level = 13;</code>
     * @param value the level to set
     * @return this
     */
    public SceneMonsterWaveParam setLevel(final int value) {
      bitField0_ |= 0x00000008;
      level = value;
      return this;
    }

    @Override
    public SceneMonsterWaveParam copyFrom(final SceneMonsterWaveParam other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        eliteGroup = other.eliteGroup;
        hardLevelGroup = other.hardLevelGroup;
        dNEAMPLLFME = other.dNEAMPLLFME;
        level = other.level;
      }
      return this;
    }

    @Override
    public SceneMonsterWaveParam mergeFrom(final SceneMonsterWaveParam other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasEliteGroup()) {
        setEliteGroup(other.eliteGroup);
      }
      if (other.hasHardLevelGroup()) {
        setHardLevelGroup(other.hardLevelGroup);
      }
      if (other.hasDNEAMPLLFME()) {
        setDNEAMPLLFME(other.dNEAMPLLFME);
      }
      if (other.hasLevel()) {
        setLevel(other.level);
      }
      return this;
    }

    @Override
    public SceneMonsterWaveParam clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      eliteGroup = 0;
      hardLevelGroup = 0;
      dNEAMPLLFME = 0;
      level = 0;
      return this;
    }

    @Override
    public SceneMonsterWaveParam clearQuick() {
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
      if (!(o instanceof SceneMonsterWaveParam)) {
        return false;
      }
      SceneMonsterWaveParam other = (SceneMonsterWaveParam) o;
      return bitField0_ == other.bitField0_
        && (!hasEliteGroup() || eliteGroup == other.eliteGroup)
        && (!hasHardLevelGroup() || hardLevelGroup == other.hardLevelGroup)
        && (!hasDNEAMPLLFME() || dNEAMPLLFME == other.dNEAMPLLFME)
        && (!hasLevel() || level == other.level);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(eliteGroup);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 56);
        output.writeUInt32NoTag(hardLevelGroup);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(dNEAMPLLFME);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 104);
        output.writeUInt32NoTag(level);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(eliteGroup);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(hardLevelGroup);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(dNEAMPLLFME);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(level);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SceneMonsterWaveParam mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 8: {
            // eliteGroup
            eliteGroup = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 56) {
              break;
            }
          }
          case 56: {
            // hardLevelGroup
            hardLevelGroup = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // dNEAMPLLFME
            dNEAMPLLFME = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 104) {
              break;
            }
          }
          case 104: {
            // level
            level = input.readUInt32();
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
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.eliteGroup, eliteGroup);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.hardLevelGroup, hardLevelGroup);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.dNEAMPLLFME, dNEAMPLLFME);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeUInt32(FieldNames.level, level);
      }
      output.endObject();
    }

    @Override
    public SceneMonsterWaveParam mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 838742956:
          case 908252627: {
            if (input.isAtField(FieldNames.eliteGroup)) {
              if (!input.trySkipNullValue()) {
                eliteGroup = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 973582502:
          case -935765840: {
            if (input.isAtField(FieldNames.hardLevelGroup)) {
              if (!input.trySkipNullValue()) {
                hardLevelGroup = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -942383691: {
            if (input.isAtField(FieldNames.dNEAMPLLFME)) {
              if (!input.trySkipNullValue()) {
                dNEAMPLLFME = input.readUInt32();
                bitField0_ |= 0x00000004;
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
    public SceneMonsterWaveParam clone() {
      return new SceneMonsterWaveParam().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SceneMonsterWaveParam parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SceneMonsterWaveParam(), data).checkInitialized();
    }

    public static SceneMonsterWaveParam parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SceneMonsterWaveParam(), input).checkInitialized();
    }

    public static SceneMonsterWaveParam parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SceneMonsterWaveParam(), input).checkInitialized();
    }

    /**
     * @return factory for creating SceneMonsterWaveParam messages
     */
    public static MessageFactory<SceneMonsterWaveParam> getFactory() {
      return SceneMonsterWaveParamFactory.INSTANCE;
    }

    private enum SceneMonsterWaveParamFactory implements MessageFactory<SceneMonsterWaveParam> {
      INSTANCE;

      @Override
      public SceneMonsterWaveParam create() {
        return SceneMonsterWaveParam.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName eliteGroup = FieldName.forField("eliteGroup", "elite_group");

      static final FieldName hardLevelGroup = FieldName.forField("hardLevelGroup", "hard_level_group");

      static final FieldName dNEAMPLLFME = FieldName.forField("DNEAMPLLFME");

      static final FieldName level = FieldName.forField("level");
    }
  }
}
