package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TypeI4 extends Type<Integer> {

  private static final int BYTE_LENGTH = 4;
  public static final int DEFAULT_VALUE = 0;

  TypeI4(String name, int nullValue) {
    super(name, nullValue, DEFAULT_VALUE);
  }

  TypeI4(String name, Supplier<Boolean> isNull) {
    super(name, isNull, DEFAULT_VALUE);
  }

  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
    setValue(byteConverter.bytesToSignedInt(stream, BYTE_LENGTH));
  }

  @Override
  void setValueFromUser(Integer value) {
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    return byteConverter.signedIntegerToBytes(getActualValue(), ByteConverter.L4BYTES_BINARY_STRING_FORMAT,
        BYTE_LENGTH);
  }

}
