package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class TypeArray<T extends Type<U>, U> extends Type<List<T>> {

  private static final String ILLEGAL_SIZE_MESSAGE =
      "Invalid size %d for type N1x2Arr. Should be no more than %d";

  private final BiFunction<String, U, T> constructor;
  private final int maxSize;
  private final Type<Integer> sizeField;

  public TypeArray(String name, List<T> nullValue, BiFunction<String, U, T> constructor,
      Type<Integer> sizeField, int maxSize) {
    super(name, nullValue, new ArrayList<>());
    this.sizeField = sizeField;
    this.maxSize = maxSize;
    this.constructor = constructor;
  }



  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
    Integer size = sizeField.getActualValue();
    List<T> value = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      T element = constructor.apply(getName() + "_" + i, null);
      element.setValueFromStream(stream, byteConverter);
      value.add(element);
    }
    setValue(value);
  }

  @Override
  void setValueFromUser(List<T> value) {
    if (value.size() > maxSize) {
      throw new IllegalArgumentException(String.format(ILLEGAL_SIZE_MESSAGE, value.size(), maxSize));
    }
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    getActualValue().forEach(element -> bytes.writeBytes(element.toBytes(byteConverter)));
    return bytes.toByteArray();
  }

  void setValueFromRawType(List<U> values) {
    List<T> value = new ArrayList<>(values.size());
    for (int i = 0; i < values.size(); i++) {
      T element = constructor.apply(getName() + "_" + i, null);
      element.setValueFromUser(values.get(i));
      value.add(element);
    }
    setValueFromUser(value);
  }
}
