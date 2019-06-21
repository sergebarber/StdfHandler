package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TypeC1 extends Type<Character> {

  public static final int MAX_VALUE = 255;
  public static final int MIN_VALUE = 0;
  public static final String ILLEGAL_VALUE_MESSAGE =
      "Illegal argument %s for type StdfC1. Integer value should be " + MIN_VALUE + " <= %d <= " + MAX_VALUE;

  private static final int BYTE_LENGTH = 1;

  TypeC1(String name, Character nullValue) {
    super(name, nullValue, CHAR_DEFAULT_VALUE);
  }

  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
    int intValue = byteConverter.bytesToUnsignedInt(stream, BYTE_LENGTH);
    setValue((char) intValue);
  }

  @Override
  void setValueFromUser(Character value) {
    int intValue = (int) value;
    if (intValue < MIN_VALUE || intValue > MAX_VALUE) {
      throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value, intValue));
    }
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    return byteConverter.unsignedIntegerToBytes(getActualValue(), ByteConverter.L1BYTE_BINARY_STRING_FORMAT);
  }
}
