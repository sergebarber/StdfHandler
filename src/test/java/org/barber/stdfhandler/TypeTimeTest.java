package org.barber.stdfhandler;

import org.barber.stdfhandler.file.RecordAtr;
import org.barber.stdfhandler.file.RecordMir;
import org.barber.stdfhandler.file.RecordMrr;
import org.barber.stdfhandler.file.TypeTime;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

class TypeTimeTest extends TypeTest {

    static final Instant TEST_VALUE = Instant.ofEpochSecond(1234567890);

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testMirSetupT() throws IOException {
        RecordMir recordMir = RecordMir.newInstance().setSetupT(TEST_VALUE);
        testValueFild(recordMir, record -> recordMir.getSetupT(), TEST_VALUE);
    }

    @Test
    void testMirStartT() throws IOException {
        RecordMir recordMir = RecordMir.newInstance().setStartT(TEST_VALUE);
        testValueFild(recordMir, record -> recordMir.getStartT(), TEST_VALUE);
    }

    @Test
    void testMrrFinishT() throws IOException {
        RecordMrr recordMrr = RecordMrr.newInstance().setFinishT(TEST_VALUE);
        testValueFild(recordMrr, record -> recordMrr.getFinishT(), TEST_VALUE);
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testMinValue() throws IOException {
        Instant expected = Instant.ofEpochSecond(TypeTime.MIN_VALUE);
        RecordAtr recordAtr = RecordAtr.newInstance().setModTim(expected);
        testValueFild(recordAtr, record -> recordAtr.getModTim(), expected);
    }

    @Test
    void testLessThanMinValueThrows() {
        Instant expected = Instant.ofEpochSecond(TypeTime.MIN_VALUE - 1);
        RecordAtr recordAtr = RecordAtr.newInstance();
        testIllegalValue(recordAtr, expected, (record, integer) -> recordAtr.setModTim(integer),
            String.format(TypeTime.ILLEGAL_VALUE_MESSAGE, expected.getEpochSecond()));
    }

    @Test
    void testMaxValue() throws IOException {
        Instant expected = Instant.ofEpochSecond(TypeTime.MAX_VALUE);
        RecordAtr recordAtr = RecordAtr.newInstance().setModTim(expected);
        testValueFild(recordAtr, record -> recordAtr.getModTim(), expected);
    }

    @Test
    void testMoreThanMaxValueThrows() {
        Instant expected = Instant.ofEpochSecond(TypeTime.MAX_VALUE + 1);
        RecordAtr recordAtr = RecordAtr.newInstance();
        testIllegalValue(recordAtr, expected, (record, integer) -> recordAtr.setModTim(integer),
            String.format(TypeTime.ILLEGAL_VALUE_MESSAGE, expected.getEpochSecond()));
    }

    @Test
    void testDefaultNullValueSet() throws IOException {
        Instant expected = TypeTime.DEFAULT_VALUE;
        RecordAtr recordAtr = RecordAtr.newInstance();
        testValueFild(recordAtr, record -> recordAtr.getModTim(), expected);
    }
}
