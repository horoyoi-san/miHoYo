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

public final class PFIJOKJPNBBOuterClass {
  /**
   * Protobuf type {@code PFIJOKJPNBB}
   */
  public static final class PFIJOKJPNBB extends ProtoMessage<PFIJOKJPNBB> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 GHKJMINHFJL = 10;</code>
     */
    private int gHKJMINHFJL;

    /**
     * <code>optional uint32 stamina = 15;</code>
     */
    private int stamina;

    private PFIJOKJPNBB() {
    }

    /**
     * @return a new empty instance of {@code PFIJOKJPNBB}
     */
    public static PFIJOKJPNBB newInstance() {
      return new PFIJOKJPNBB();
    }

    /**
     * <code>optional uint32 GHKJMINHFJL = 10;</code>
     * @return whether the gHKJMINHFJL field is set
     */
    public boolean hasGHKJMINHFJL() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 GHKJMINHFJL = 10;</code>
     * @return this
     */
    public PFIJOKJPNBB clearGHKJMINHFJL() {
      bitField0_ &= ~0x00000001;
      gHKJMINHFJL = 0;
      return this;
    }

    /**
     * <code>optional uint32 GHKJMINHFJL = 10;</code>
     * @return the gHKJMINHFJL
     */
    public int getGHKJMINHFJL() {
      return gHKJMINHFJL;
    }

    /**
     * <code>optional uint32 GHKJMINHFJL = 10;</code>
     * @param value the gHKJMINHFJL to set
     * @return this
     */
    public PFIJOKJPNBB setGHKJMINHFJL(final int value) {
      bitField0_ |= 0x00000001;
      gHKJMINHFJL = value;
      return this;
    }

    /**
     * <code>optional uint32 stamina = 15;</code>
     * @return whether the stamina field is set
     */
    public boolean hasStamina() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 stamina = 15;</code>
     * @return this
     */
    public PFIJOKJPNBB clearStamina() {
      bitField0_ &= ~0x00000002;
      stamina = 0;
      return this;
    }

    /**
     * <code>optional uint32 stamina = 15;</code>
     * @return the stamina
     */
    public int getStamina() {
      return stamina;
    }

    /**
     * <code>optional uint32 stamina = 15;</code>
     * @param value the stamina to set
     * @return this
     */
    public PFIJOKJPNBB setStamina(final int value) {
      bitField0_ |= 0x00000002;
      stamina = value;
      return this;
    }

    @Override
    public PFIJOKJPNBB copyFrom(final PFIJOKJPNBB other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        gHKJMINHFJL = other.gHKJMINHFJL;
        stamina = other.stamina;
      }
      return this;
    }

    @Override
    public PFIJOKJPNBB mergeFrom(final PFIJOKJPNBB other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasGHKJMINHFJL()) {
        setGHKJMINHFJL(other.gHKJMINHFJL);
      }
      if (other.hasStamina()) {
        setStamina(other.stamina);
      }
      return this;
    }

    @Override
    public PFIJOKJPNBB clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      gHKJMINHFJL = 0;
      stamina = 0;
      return this;
    }

    @Override
    public PFIJOKJPNBB clearQuick() {
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
      if (!(o instanceof PFIJOKJPNBB)) {
        return false;
      }
      PFIJOKJPNBB other = (PFIJOKJPNBB) o;
      return bitField0_ == other.bitField0_
        && (!hasGHKJMINHFJL() || gHKJMINHFJL == other.gHKJMINHFJL)
        && (!hasStamina() || stamina == other.stamina);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 80);
        output.writeUInt32NoTag(gHKJMINHFJL);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(stamina);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(gHKJMINHFJL);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(stamina);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public PFIJOKJPNBB mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 80: {
            // gHKJMINHFJL
            gHKJMINHFJL = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // stamina
            stamina = input.readUInt32();
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
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.gHKJMINHFJL, gHKJMINHFJL);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.stamina, stamina);
      }
      output.endObject();
    }

    @Override
    public PFIJOKJPNBB mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -512266766: {
            if (input.isAtField(FieldNames.gHKJMINHFJL)) {
              if (!input.trySkipNullValue()) {
                gHKJMINHFJL = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1897344401: {
            if (input.isAtField(FieldNames.stamina)) {
              if (!input.trySkipNullValue()) {
                stamina = input.readUInt32();
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
    public PFIJOKJPNBB clone() {
      return new PFIJOKJPNBB().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static PFIJOKJPNBB parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new PFIJOKJPNBB(), data).checkInitialized();
    }

    public static PFIJOKJPNBB parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new PFIJOKJPNBB(), input).checkInitialized();
    }

    public static PFIJOKJPNBB parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new PFIJOKJPNBB(), input).checkInitialized();
    }

    /**
     * @return factory for creating PFIJOKJPNBB messages
     */
    public static MessageFactory<PFIJOKJPNBB> getFactory() {
      return PFIJOKJPNBBFactory.INSTANCE;
    }

    private enum PFIJOKJPNBBFactory implements MessageFactory<PFIJOKJPNBB> {
      INSTANCE;

      @Override
      public PFIJOKJPNBB create() {
        return PFIJOKJPNBB.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName gHKJMINHFJL = FieldName.forField("GHKJMINHFJL");

      static final FieldName stamina = FieldName.forField("stamina");
    }
  }
}
