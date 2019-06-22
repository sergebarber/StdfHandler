package org.barber.stdfhandler.file;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeB1Test extends TypeTest {

    @Test
    void testReturnsNullWhenNullValueNotNull() {
        testOptionalThrows(RecordTst.newInstance(), RecordTst::getTypeB1WithNull);
    }

    @Test
    void testReturnsNullWhenNullValueSetByUser() {
        testOptionalThrows(RecordTst.newInstance().setTypeB1WithNull(Type.TYPE_B1_DEFAULT_VALUE),
                RecordTst::getTypeB1WithNull);
    }

    @Test
    void testReturnsDefaultWhenNullValueNull() throws IOException {
        testValue(RecordTst.newInstance(), RecordTst::getTypeB1WithDefault, Type.TYPE_B1_DEFAULT_VALUE);
    }

    @Test
    void testValidValues() throws IOException {
        String[] values = {"00000000", "01010111", "11110000", "11111111"};
        for (String expected : values) {
            testValue(
                    RecordTst.newInstance().setTypeB1WithDefault(expected),
                    RecordTst::getTypeB1WithDefault,
                    expected);
        }
    }

    @Test
    void testInvalidValueSetWrongLength() {
        String value = "0".repeat(TypeB1.LENGTH + 1);
        testIllegalValue(
                () -> RecordTst.newInstance().setTypeB1WithDefault(value),
                String.format(TypeB1.ILLEGAL_LENGTH_MESSAGE, value)
        );
    }

    @Test
    void testInvalidValueSetWrongPattern() {
        String value = "00000002";
        testIllegalValue(
                () -> RecordTst.newInstance().setTypeB1WithDefault(value),
                String.format(TypeB1.ILLEGAL_VALUE_MESSAGE, value)
        );
    }

    @Test
    void testGetFlagBitIllegalPositionMin() {
        int position = TypeB1.MIN_POSITION - 1;
        assertThatThrownBy(() -> RecordTst.newInstance().getPartFlgBit(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TypeB1.ILLEGAL_POSITION_MESSAGE, position);
    }

    @Test
    void testGetFlagBitIllegalPositionMax() {
        int position = TypeB1.MAX_POSITION + 1;
        assertThatThrownBy(() -> RecordTst.newInstance().getPartFlgBit(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TypeB1.ILLEGAL_POSITION_MESSAGE, position);
    }

    @Test
    void testGetFlagBitValidPosition() throws IOException {
        String flagString = "11111011";
        int position = 5;
        boolean expected = true;
        testValue(
                RecordTst.newInstance().setTypeB1WithDefault(flagString),
                recordTst -> Optional.of(recordTst.getPartFlgBit(position)),
                expected);
    }

    @Test
    void testSetFlagBitIllegalPositionMin() {
        int position = TypeB1.MIN_POSITION - 1;
        boolean bit = true;
        testIllegalValue(
                () -> RecordTst.newInstance().setPartFlgBit(bit, position),
                String.format(TypeB1.ILLEGAL_POSITION_MESSAGE, position)
        );
    }

    @Test
    void testSetFlagBitIllegalPositionMax() {
        int position = TypeB1.MAX_POSITION + 1;
        boolean bit = true;
        testIllegalValue(
                () -> RecordTst.newInstance().setPartFlgBit(bit, position),
                String.format(TypeB1.ILLEGAL_POSITION_MESSAGE, position)
        );
    }

    @Test
    void testSetFlagBitValidPosition() throws IOException {
        String expected = "11111110";
        boolean bit = true;
        int position = 7;
        testValue(RecordTst.newInstance().setPartFlgBit(bit, position), RecordTst::getTypeB1WithDefault, expected);
    }





















}
