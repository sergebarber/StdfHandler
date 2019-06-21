package org.barber.stdfhandler.file;

import java.util.Arrays;
import java.util.Optional;

class RecordTst extends Record {

  private static final String NAME = "TEST";
  private static final int TYPE = 255;
  private static final int SUBTYPE = 255;

  private final TypeB1 typeB1WithNull = new TypeB1("TypeB1", Type.TYPE_B1_DEFAULT_VALUE);
  private final TypeB1 typeB1WithDefault = new TypeB1("TypeB1", null);
  private final Type<byte[]> typeBnWithNull = new TypeBn("TypeBn", Type.TYPE_BN_DEFAULT_VALUE);
  private final Type<byte[]> typeBnWithDefault = new TypeBn("TypeBn", null);
  private final Type<Character> typeC1WithNull = new TypeC1("TypeC1", ' ');
  private final Type<Character> typeC1WithDefault = new TypeC1("TypeC1", null);

  private RecordTst() {
    super(NAME, TYPE, SUBTYPE);
    fields.addAll(Arrays.asList(
        typeB1WithNull, typeB1WithDefault,
        typeBnWithNull, typeBnWithDefault,
        typeC1WithNull, typeC1WithDefault
    ));
  }

  static RecordTst newInstance() {
    return new RecordTst();
  }

  @Override
  protected void addToImage(FileImage image) {
    image.setTest(this);
  }

  Optional<String> getTypeB1WithNull() {
    return Optional.ofNullable(typeB1WithNull.getValue());
  }

  Optional<String> getTypeB1WithDefault() {
    return Optional.ofNullable(typeB1WithDefault.getValue());
  }

  int getPartFlgBit(int position) {
    return typeB1WithDefault.getBitInPosition(position);
  }

  RecordTst setTypeB1WithNull(String value) {
    typeB1WithNull.setValueFromUser(value);
    return this;
  }

  RecordTst setTypeB1WithDefault(String value) {
    typeB1WithDefault.setValueFromUser(value);
    return this;
  }

  RecordTst setPartFlgBit(int value, int position) {
    typeB1WithDefault.setBitInPosition(value, position);
    return this;
  }

  Optional<byte[]> getTypeBnWithNull() {
    return Optional.ofNullable(typeBnWithNull.getValue());
  }

  Optional<byte[]> getTypeBnWithDefault() {
    return Optional.ofNullable(typeBnWithDefault.getValue());
  }

  RecordTst setTypeBnWithNull(byte[] value) {
    typeBnWithNull.setValueFromUser(value);
    return this;
  }

  RecordTst setTypeBnWithDefault(byte[] value) {
    typeBnWithDefault.setValueFromUser(value);
    return this;
  }

  Optional<Character> getTypeC1WithNullValue() {
    return Optional.ofNullable(typeC1WithNull.getValue());
  }

  Optional<Character> getTypeC1WithDefault() {
    return Optional.ofNullable(typeC1WithDefault.getValue());
  }

  RecordTst setTypeC1WithNullValue(Character value) {
    this.typeC1WithNull.setValueFromUser(value);
    return this;
  }

  RecordTst setTypeC1WithDefault(Character value) {
    this.typeC1WithDefault.setValueFromUser(value);
    return this;
  }
}
