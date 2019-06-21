package org.barber.stdfhandler.file;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class TypeC1Test extends TypeTest {

  @Test
  void testValidValues() throws IOException {
    for (int i = 0; i < 255; i++) {
      char expected = (char)i;
      testValue(RecordTst.newInstance().setTypeC1WithDefault(expected), RecordTst::getTypeC1WithDefault, expected);
    }
  }

  @Test
  void testReturnsNullWhenNullValueNotNull() {
    testOptionalThrows(RecordTst.newInstance(), RecordTst::getTypeC1WithNullValue);
  }

  @Test
  void testReturnsDefaultWhenNullValueNull() throws IOException {
    char expected = Type.CHAR_DEFAULT_VALUE;
    testValue(RecordTst.newInstance(), RecordTst::getTypeC1WithDefault, expected);
  }

  @Test
  void testReturnsNullWhenNullValueSet() {
    testOptionalThrows(RecordTst.newInstance().setTypeC1WithNullValue(' '), RecordTst::getTypeC1WithNullValue);
  }

  @Test
  void testSetInvalidValueTooBig() {
    char value = 256;
    testIllegalValue(
        () -> RecordTst.newInstance().setTypeC1WithNullValue(value),
        String.format(TypeC1.ILLEGAL_VALUE_MESSAGE, value, (int) value)
    );
  }
}
