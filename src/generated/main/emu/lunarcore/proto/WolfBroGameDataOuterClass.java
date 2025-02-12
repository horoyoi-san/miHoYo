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
import us.hebi.quickbuf.Utf8String;

public final class WolfBroGameDataOuterClass {
  /**
   * Protobuf type {@code WolfBroGameData}
   */
  public static final class WolfBroGameData extends ProtoMessage<WolfBroGameData> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 PPINPEHJFAB = 1;</code>
     */
    private int pPINPEHJFAB;

    /**
     * <code>optional uint32 id = 4;</code>
     */
    private int id;

    /**
     * <code>optional bool HFNEKMMMFHO = 9;</code>
     */
    private boolean hFNEKMMMFHO;

    /**
     * <code>optional .WolfBroGameInfo KPPEHBJLAAA = 6;</code>
     */
    private final WolfBroGameInfoOuterClass.WolfBroGameInfo kPPEHBJLAAA = WolfBroGameInfoOuterClass.WolfBroGameInfo.newInstance();

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     */
    private final Utf8String nIEPAOBBFJF = Utf8String.newEmptyInstance();

    /**
     * <code>repeated .Vector JBOFIALLOPI = 18;</code>
     */
    private final RepeatedMessage<VectorOuterClass.Vector> jBOFIALLOPI = RepeatedMessage.newEmptyInstance(VectorOuterClass.Vector.getFactory());

    private WolfBroGameData() {
    }

    /**
     * @return a new empty instance of {@code WolfBroGameData}
     */
    public static WolfBroGameData newInstance() {
      return new WolfBroGameData();
    }

    /**
     * <code>optional uint32 PPINPEHJFAB = 1;</code>
     * @return whether the pPINPEHJFAB field is set
     */
    public boolean hasPPINPEHJFAB() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 PPINPEHJFAB = 1;</code>
     * @return this
     */
    public WolfBroGameData clearPPINPEHJFAB() {
      bitField0_ &= ~0x00000001;
      pPINPEHJFAB = 0;
      return this;
    }

    /**
     * <code>optional uint32 PPINPEHJFAB = 1;</code>
     * @return the pPINPEHJFAB
     */
    public int getPPINPEHJFAB() {
      return pPINPEHJFAB;
    }

    /**
     * <code>optional uint32 PPINPEHJFAB = 1;</code>
     * @param value the pPINPEHJFAB to set
     * @return this
     */
    public WolfBroGameData setPPINPEHJFAB(final int value) {
      bitField0_ |= 0x00000001;
      pPINPEHJFAB = value;
      return this;
    }

    /**
     * <code>optional uint32 id = 4;</code>
     * @return whether the id field is set
     */
    public boolean hasId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 id = 4;</code>
     * @return this
     */
    public WolfBroGameData clearId() {
      bitField0_ &= ~0x00000002;
      id = 0;
      return this;
    }

    /**
     * <code>optional uint32 id = 4;</code>
     * @return the id
     */
    public int getId() {
      return id;
    }

    /**
     * <code>optional uint32 id = 4;</code>
     * @param value the id to set
     * @return this
     */
    public WolfBroGameData setId(final int value) {
      bitField0_ |= 0x00000002;
      id = value;
      return this;
    }

    /**
     * <code>optional bool HFNEKMMMFHO = 9;</code>
     * @return whether the hFNEKMMMFHO field is set
     */
    public boolean hasHFNEKMMMFHO() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional bool HFNEKMMMFHO = 9;</code>
     * @return this
     */
    public WolfBroGameData clearHFNEKMMMFHO() {
      bitField0_ &= ~0x00000004;
      hFNEKMMMFHO = false;
      return this;
    }

    /**
     * <code>optional bool HFNEKMMMFHO = 9;</code>
     * @return the hFNEKMMMFHO
     */
    public boolean getHFNEKMMMFHO() {
      return hFNEKMMMFHO;
    }

    /**
     * <code>optional bool HFNEKMMMFHO = 9;</code>
     * @param value the hFNEKMMMFHO to set
     * @return this
     */
    public WolfBroGameData setHFNEKMMMFHO(final boolean value) {
      bitField0_ |= 0x00000004;
      hFNEKMMMFHO = value;
      return this;
    }

    /**
     * <code>optional .WolfBroGameInfo KPPEHBJLAAA = 6;</code>
     * @return whether the kPPEHBJLAAA field is set
     */
    public boolean hasKPPEHBJLAAA() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional .WolfBroGameInfo KPPEHBJLAAA = 6;</code>
     * @return this
     */
    public WolfBroGameData clearKPPEHBJLAAA() {
      bitField0_ &= ~0x00000008;
      kPPEHBJLAAA.clear();
      return this;
    }

    /**
     * <code>optional .WolfBroGameInfo KPPEHBJLAAA = 6;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableKPPEHBJLAAA()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public WolfBroGameInfoOuterClass.WolfBroGameInfo getKPPEHBJLAAA() {
      return kPPEHBJLAAA;
    }

    /**
     * <code>optional .WolfBroGameInfo KPPEHBJLAAA = 6;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public WolfBroGameInfoOuterClass.WolfBroGameInfo getMutableKPPEHBJLAAA() {
      bitField0_ |= 0x00000008;
      return kPPEHBJLAAA;
    }

    /**
     * <code>optional .WolfBroGameInfo KPPEHBJLAAA = 6;</code>
     * @param value the kPPEHBJLAAA to set
     * @return this
     */
    public WolfBroGameData setKPPEHBJLAAA(final WolfBroGameInfoOuterClass.WolfBroGameInfo value) {
      bitField0_ |= 0x00000008;
      kPPEHBJLAAA.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     * @return whether the nIEPAOBBFJF field is set
     */
    public boolean hasNIEPAOBBFJF() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     * @return this
     */
    public WolfBroGameData clearNIEPAOBBFJF() {
      bitField0_ &= ~0x00000010;
      nIEPAOBBFJF.clear();
      return this;
    }

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     * @return the nIEPAOBBFJF
     */
    public String getNIEPAOBBFJF() {
      return nIEPAOBBFJF.getString();
    }

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     * @return internal {@code Utf8String} representation of nIEPAOBBFJF for reading
     */
    public Utf8String getNIEPAOBBFJFBytes() {
      return this.nIEPAOBBFJF;
    }

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     * @return internal {@code Utf8String} representation of nIEPAOBBFJF for modifications
     */
    public Utf8String getMutableNIEPAOBBFJFBytes() {
      bitField0_ |= 0x00000010;
      return this.nIEPAOBBFJF;
    }

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     * @param value the nIEPAOBBFJF to set
     * @return this
     */
    public WolfBroGameData setNIEPAOBBFJF(final CharSequence value) {
      bitField0_ |= 0x00000010;
      nIEPAOBBFJF.copyFrom(value);
      return this;
    }

    /**
     * <code>optional string NIEPAOBBFJF = 15;</code>
     * @param value the nIEPAOBBFJF to set
     * @return this
     */
    public WolfBroGameData setNIEPAOBBFJF(final Utf8String value) {
      bitField0_ |= 0x00000010;
      nIEPAOBBFJF.copyFrom(value);
      return this;
    }

    /**
     * <code>repeated .Vector JBOFIALLOPI = 18;</code>
     * @return whether the jBOFIALLOPI field is set
     */
    public boolean hasJBOFIALLOPI() {
      return (bitField0_ & 0x00000020) != 0;
    }

    /**
     * <code>repeated .Vector JBOFIALLOPI = 18;</code>
     * @return this
     */
    public WolfBroGameData clearJBOFIALLOPI() {
      bitField0_ &= ~0x00000020;
      jBOFIALLOPI.clear();
      return this;
    }

    /**
     * <code>repeated .Vector JBOFIALLOPI = 18;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableJBOFIALLOPI()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<VectorOuterClass.Vector> getJBOFIALLOPI() {
      return jBOFIALLOPI;
    }

    /**
     * <code>repeated .Vector JBOFIALLOPI = 18;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<VectorOuterClass.Vector> getMutableJBOFIALLOPI() {
      bitField0_ |= 0x00000020;
      return jBOFIALLOPI;
    }

    /**
     * <code>repeated .Vector JBOFIALLOPI = 18;</code>
     * @param value the jBOFIALLOPI to add
     * @return this
     */
    public WolfBroGameData addJBOFIALLOPI(final VectorOuterClass.Vector value) {
      bitField0_ |= 0x00000020;
      jBOFIALLOPI.add(value);
      return this;
    }

    /**
     * <code>repeated .Vector JBOFIALLOPI = 18;</code>
     * @param values the jBOFIALLOPI to add
     * @return this
     */
    public WolfBroGameData addAllJBOFIALLOPI(final VectorOuterClass.Vector... values) {
      bitField0_ |= 0x00000020;
      jBOFIALLOPI.addAll(values);
      return this;
    }

    @Override
    public WolfBroGameData copyFrom(final WolfBroGameData other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        pPINPEHJFAB = other.pPINPEHJFAB;
        id = other.id;
        hFNEKMMMFHO = other.hFNEKMMMFHO;
        kPPEHBJLAAA.copyFrom(other.kPPEHBJLAAA);
        nIEPAOBBFJF.copyFrom(other.nIEPAOBBFJF);
        jBOFIALLOPI.copyFrom(other.jBOFIALLOPI);
      }
      return this;
    }

    @Override
    public WolfBroGameData mergeFrom(final WolfBroGameData other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasPPINPEHJFAB()) {
        setPPINPEHJFAB(other.pPINPEHJFAB);
      }
      if (other.hasId()) {
        setId(other.id);
      }
      if (other.hasHFNEKMMMFHO()) {
        setHFNEKMMMFHO(other.hFNEKMMMFHO);
      }
      if (other.hasKPPEHBJLAAA()) {
        getMutableKPPEHBJLAAA().mergeFrom(other.kPPEHBJLAAA);
      }
      if (other.hasNIEPAOBBFJF()) {
        getMutableNIEPAOBBFJFBytes().copyFrom(other.nIEPAOBBFJF);
      }
      if (other.hasJBOFIALLOPI()) {
        getMutableJBOFIALLOPI().addAll(other.jBOFIALLOPI);
      }
      return this;
    }

    @Override
    public WolfBroGameData clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      pPINPEHJFAB = 0;
      id = 0;
      hFNEKMMMFHO = false;
      kPPEHBJLAAA.clear();
      nIEPAOBBFJF.clear();
      jBOFIALLOPI.clear();
      return this;
    }

    @Override
    public WolfBroGameData clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      kPPEHBJLAAA.clearQuick();
      nIEPAOBBFJF.clear();
      jBOFIALLOPI.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof WolfBroGameData)) {
        return false;
      }
      WolfBroGameData other = (WolfBroGameData) o;
      return bitField0_ == other.bitField0_
        && (!hasPPINPEHJFAB() || pPINPEHJFAB == other.pPINPEHJFAB)
        && (!hasId() || id == other.id)
        && (!hasHFNEKMMMFHO() || hFNEKMMMFHO == other.hFNEKMMMFHO)
        && (!hasKPPEHBJLAAA() || kPPEHBJLAAA.equals(other.kPPEHBJLAAA))
        && (!hasNIEPAOBBFJF() || nIEPAOBBFJF.equals(other.nIEPAOBBFJF))
        && (!hasJBOFIALLOPI() || jBOFIALLOPI.equals(other.jBOFIALLOPI));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(pPINPEHJFAB);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 32);
        output.writeUInt32NoTag(id);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 72);
        output.writeBoolNoTag(hFNEKMMMFHO);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 50);
        output.writeMessageNoTag(kPPEHBJLAAA);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRawByte((byte) 122);
        output.writeStringNoTag(nIEPAOBBFJF);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        for (int i = 0; i < jBOFIALLOPI.length(); i++) {
          output.writeRawLittleEndian16((short) 402);
          output.writeMessageNoTag(jBOFIALLOPI.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(pPINPEHJFAB);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(id);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 2;
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(kPPEHBJLAAA);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += 1 + ProtoSink.computeStringSizeNoTag(nIEPAOBBFJF);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        size += (2 * jBOFIALLOPI.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(jBOFIALLOPI);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public WolfBroGameData mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 8: {
            // pPINPEHJFAB
            pPINPEHJFAB = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 32) {
              break;
            }
          }
          case 32: {
            // id
            id = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 72) {
              break;
            }
          }
          case 72: {
            // hFNEKMMMFHO
            hFNEKMMMFHO = input.readBool();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 50) {
              break;
            }
          }
          case 50: {
            // kPPEHBJLAAA
            input.readMessage(kPPEHBJLAAA);
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 122) {
              break;
            }
          }
          case 122: {
            // nIEPAOBBFJF
            input.readString(nIEPAOBBFJF);
            bitField0_ |= 0x00000010;
            tag = input.readTag();
            if (tag != 146) {
              break;
            }
          }
          case 146: {
            // jBOFIALLOPI
            tag = input.readRepeatedMessage(jBOFIALLOPI, tag);
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
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.pPINPEHJFAB, pPINPEHJFAB);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.id, id);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeBool(FieldNames.hFNEKMMMFHO, hFNEKMMMFHO);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeMessage(FieldNames.kPPEHBJLAAA, kPPEHBJLAAA);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeString(FieldNames.nIEPAOBBFJF, nIEPAOBBFJF);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeRepeatedMessage(FieldNames.jBOFIALLOPI, jBOFIALLOPI);
      }
      output.endObject();
    }

    @Override
    public WolfBroGameData mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -833306869: {
            if (input.isAtField(FieldNames.pPINPEHJFAB)) {
              if (!input.trySkipNullValue()) {
                pPINPEHJFAB = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 3355: {
            if (input.isAtField(FieldNames.id)) {
              if (!input.trySkipNullValue()) {
                id = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -534002378: {
            if (input.isAtField(FieldNames.hFNEKMMMFHO)) {
              if (!input.trySkipNullValue()) {
                hFNEKMMMFHO = input.readBool();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1600235637: {
            if (input.isAtField(FieldNames.kPPEHBJLAAA)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(kPPEHBJLAAA);
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1819586030: {
            if (input.isAtField(FieldNames.nIEPAOBBFJF)) {
              if (!input.trySkipNullValue()) {
                input.readString(nIEPAOBBFJF);
                bitField0_ |= 0x00000010;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1231029503: {
            if (input.isAtField(FieldNames.jBOFIALLOPI)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(jBOFIALLOPI);
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
    public WolfBroGameData clone() {
      return new WolfBroGameData().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static WolfBroGameData parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new WolfBroGameData(), data).checkInitialized();
    }

    public static WolfBroGameData parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new WolfBroGameData(), input).checkInitialized();
    }

    public static WolfBroGameData parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new WolfBroGameData(), input).checkInitialized();
    }

    /**
     * @return factory for creating WolfBroGameData messages
     */
    public static MessageFactory<WolfBroGameData> getFactory() {
      return WolfBroGameDataFactory.INSTANCE;
    }

    private enum WolfBroGameDataFactory implements MessageFactory<WolfBroGameData> {
      INSTANCE;

      @Override
      public WolfBroGameData create() {
        return WolfBroGameData.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName pPINPEHJFAB = FieldName.forField("PPINPEHJFAB");

      static final FieldName id = FieldName.forField("id");

      static final FieldName hFNEKMMMFHO = FieldName.forField("HFNEKMMMFHO");

      static final FieldName kPPEHBJLAAA = FieldName.forField("KPPEHBJLAAA");

      static final FieldName nIEPAOBBFJF = FieldName.forField("NIEPAOBBFJF");

      static final FieldName jBOFIALLOPI = FieldName.forField("JBOFIALLOPI");
    }
  }
}
