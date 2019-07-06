package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;

public class TypeDn extends Type<byte[]> {

  private static final int BYTE_FOR_LENGTH = 2;
  public static final int MAX_LENGTH = 65535;
  public static final byte[] DEFAULT_VALUE = new byte[0];

  public static final String ILLEGAL_LENGTH_MESSAGE =
      "Illegal length %d of the argument array. Should be no more then " + MAX_LENGTH;

  TypeDn(String name, byte[] nullValue) {
    super(name, nullValue, DEFAULT_VALUE);
  }

  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
    int length = byteConverter.bytesToUnsignedInt(stream, BYTE_FOR_LENGTH);
    setValue(stream.readNBytes(length));
  }

  @Override
  void setValueFromUser(byte[] value) {
    if (value.length > MAX_LENGTH) {
      throw new IllegalArgumentException(String.format(ILLEGAL_LENGTH_MESSAGE, value.length));
    }
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    byte[] value = getActualValue();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(value.length + 2);
    outputStream.writeBytes(byteConverter.unsignedIntegerToBytes(value.length,
        ByteConverter.L2BYTES_BINARY_STRING_FORMAT));
    outputStream.writeBytes(value);
    return outputStream.toByteArray();
  }

  @Override
  public String toString() {
    return Arrays.toString(getActualValue());
  }
}
