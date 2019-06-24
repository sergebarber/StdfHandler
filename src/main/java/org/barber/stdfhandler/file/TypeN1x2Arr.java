package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypeN1x2Arr extends Type<List<TypeN1x2>> {


  private static final String ILLEGAL_SIZE_MESSAGE =
      "Invalid size %d for type N1x2Arr. Should be no more than %d";
  private static final List<TypeN1x2> DEFAULT_VALUE = new ArrayList<>();

  private final int maxSize;
  private final Type<Integer> sizeField;

  public TypeN1x2Arr(String name, List<TypeN1x2> nullValue, Type<Integer> sizeField, int maxSize) {
    super(name, nullValue, DEFAULT_VALUE);
    this.sizeField = sizeField;
    this.maxSize = maxSize;
  }

  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
    Integer size = sizeField.getActualValue();
    List<TypeN1x2> value = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      TypeN1x2 element = new TypeN1x2(getName() + "_" + i, null);
      element.setValueFromStream(stream, byteConverter);
      value.add(element);
    }
    setValue(value);
  }

  @Override
  void setValueFromUser(List<TypeN1x2> value) {
    if (value.size() > maxSize) {
      throw new IllegalArgumentException(String.format(ILLEGAL_SIZE_MESSAGE, value.size(), maxSize));
    }
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    int size = sizeField.getActualValue();
    byte[] bytes = new byte[size];
    for (int i = 0; i < size; i++) {
      bytes[i] = getActualValue().get(i).toBytes(byteConverter)[0];
    }
    return bytes;
  }
}
