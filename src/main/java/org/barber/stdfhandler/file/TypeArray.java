package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TypeArray<T extends Type<U>, U> extends Type<List<T>> {

  public static final String ILLEGAL_SIZE_MESSAGE =
      "Invalid size %d for an array of type %s. Should be no more than %d";

  private final Function<String, T> constructor;
  private final int maxSize;
  private final Type<Integer> sizeField;

  TypeArray(String name, Function<String, T> constructor, Type<Integer> sizeField, int maxSize) {
    super(name, new ArrayList<>());
    this.sizeField = sizeField;
    this.maxSize = maxSize;
    this.constructor = constructor;
  }

  @Override
  void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
    Integer size = sizeField.getActualValue();
    List<T> value = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      T element = constructor.apply(getName() + "_" + i);
      element.setValueFromStream(stream, byteConverter);
      value.add(element);
    }
    setValue(value);
  }

  @Override
  void setValueFromUser(List<T> value) {
    if (value.size() > maxSize) {
      throw new IllegalArgumentException(String.format(ILLEGAL_SIZE_MESSAGE, value.size(),
              sizeField.getClass().getName(), maxSize));
    }
    sizeField.setValue(value.size());
    setValue(value);
  }

  @Override
  byte[] toBytes(ByteConverter byteConverter) {
    List<byte[]> bytes = new LinkedList<>();
    getActualValue().forEach(element -> bytes.add(element.toBytes(byteConverter)));
    int length = bytes.stream().mapToInt(e -> e.length).sum();
    int pointer = 0;
    byte[] res = new byte[length];
    for (byte[] typeBytes : bytes) {
      System.arraycopy(typeBytes, 0, res, pointer, typeBytes.length);
      pointer += typeBytes.length;
    }
    return res;

//    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//    getActualValue().forEach(element -> bytes.writeBytes(element.toBytes(byteConverter)));
//    return bytes.toByteArray();
  }

  void setValueFromBasicTypeList(List<U> values) {
    List<T> value = new ArrayList<>(values.size());
    for (int i = 0; i < values.size(); i++) {
      T element = constructor.apply(getName() + "_" + i);
      element.setValueFromUser(values.get(i));
      value.add(element);
    }
    setValueFromUser(value);
  }

  List<U> getBasicTypeList() {
    return getActualValue().stream().map(Type::getActualValue).collect(Collectors.toList());
  }
}
