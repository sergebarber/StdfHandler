package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class TypeN1 extends Type<byte[]> {

  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 15;
  private static final byte[] DEFAULT_VALUE = {0, 0};

  private static final String INVALID_ARGUMENT_MESSAGE =
      "Invalid values [%d, %d] for type N1. Each byte should be " + MIN_VALUE + " <= b <= " + MAX_VALUE;

  TypeN1(String name) {
    super(name, DEFAULT_VALUE);
  }

  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) {
    String pair = ByteConverter.unsignedToBinaryString(stream.read(), ByteConverter.L1BYTE_BINARY_STRING_FORMAT);
    getActualValue()[0] = Byte.parseByte(pair.substring(4), 2);
    getActualValue()[1] = Byte.parseByte(pair.substring(0, 4), 2);
  }

  @Override
  void setValueFromUser(byte[] value) {
    if (value[0] < MIN_VALUE || value[0] > MAX_VALUE || value[1] < MIN_VALUE || value[1] > MAX_VALUE) {
      throw new IllegalArgumentException(String.format(INVALID_ARGUMENT_MESSAGE, value[0], value[1]));
    }
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    byte[] pair = getActualValue();
    int combined = (pair[1] << 4) + pair[0];
    return byteConverter.unsignedIntegerToBytes(combined, ByteConverter.L1BYTE_BINARY_STRING_FORMAT);
  }

  @Override
  public String toString() {
    return Arrays.toString(getActualValue());
  }
}
