package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TypeC1 extends Type<Character> {

  public static final int MAX_VALUE = 255;
  public static final char DEFAULT_VALUE = ' ';

  public static final String ILLEGAL_VALUE_MESSAGE =
      "Illegal argument %s for type StdfC1. Integer value should be less than " + MAX_VALUE;

  private static final int BYTE_LENGTH = 1;

  TypeC1(String name, char nullValue) {
    super(name, nullValue, DEFAULT_VALUE);
  }

  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
    int intValue = byteConverter.bytesToUnsignedInt(stream, BYTE_LENGTH);
    setValue((char) intValue);
  }

  @Override
  void setValueFromUser(Character value) {
    int intValue = (int) value;
    if (intValue > MAX_VALUE) {
      throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value));
    }
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    return byteConverter.unsignedIntegerToBytes(getActualValue(), ByteConverter.L1BYTE_BINARY_STRING_FORMAT);
  }
}
