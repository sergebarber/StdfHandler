package org.barber.stdfhandler.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class TypeBnTest extends TypeTest {

    @Test
    void testReturnsNullWhenNullValueNotNull() {
        testOptionalThrows(RecordTst.newInstance(), RecordTst::getTypeBnWithNull);
    }

    @Test
    void testReturnsNullWhenNullValueSetByUser() {
        testOptionalThrows(RecordTst.newInstance().setTypeBnWithNull(Type.TYPE_BN_DEFAULT_VALUE),
                RecordTst::getTypeBnWithNull);
    }

    @Test
    void testReturnsDefaultWhenNullValueNull() throws IOException {
        testValue(RecordTst.newInstance(), RecordTst::getTypeBnWithDefault, Type.TYPE_BN_DEFAULT_VALUE);
    }

    @Test
    void testValidValues() throws IOException {
        byte[] longArray = new byte[TypeBn.MAX_LENGTH];
        for (int i = 0; i < longArray.length; i++) {
            longArray[i] = (byte)i;
        }
        byte[][] values = {{12}, {12,13,14}, {12,13,14,15,16,17,18,19}, longArray};
        for (byte[] expected : values) {
            testValue(
                    RecordTst.newInstance().setTypeBnWithDefault(expected),
                    RecordTst::getTypeBnWithDefault,
                    expected);
        }
    }

    @Test
    void testInvalidValueSetWrongLength() {
        byte[] value = new byte[TypeBn.MAX_LENGTH + 1];
        testIllegalValue(
                () -> RecordTst.newInstance().setTypeBnWithDefault(value),
                String.format(TypeBn.ILLEGAL_LENGTH_MESSAGE, value.length)
        );
    }
}
