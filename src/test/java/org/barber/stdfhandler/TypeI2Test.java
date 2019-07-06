package org.barber.stdfhandler;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class TypeI2Test extends TypeTest {

    static final int TEST_VALUE = -12345;

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testFtrVectOff() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordFtr::newInstance, (r, v) -> ((RecordFtr) r).setVectOff(v),
                r -> ((RecordFtr) r).getVectOff());
    }

    @Test
    void testPrrXcoord() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordPrr::newInstance, (r, v) -> ((RecordPrr) r).setXCoord(v),
                r -> ((RecordPrr) r).getXCoord(), TypeI2.MIN_VALUE);
    }

    @Test
    void testPrrYcoord() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordPrr::newInstance, (r, v) -> ((RecordPrr) r).setYCoord(v),
                r -> ((RecordPrr) r).getYCoord(), TypeI2.MIN_VALUE);
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testMinValue() throws IOException {
        int expected = TypeI2.MIN_VALUE;
        RecordFtr recordFtr = RecordFtr.newInstance().setVectOff(expected);
        testValueFild(recordFtr, record -> recordFtr.getVectOff(), expected);
    }

    @Test
    void testLessThanMinValueThrows() {
        int expected = TypeI2.MIN_VALUE - 1;
        RecordFtr recordFtr = RecordFtr.newInstance();
        testIllegalValue(recordFtr, expected, (record, integer) -> recordFtr.setVectOff(integer),
                String.format(TypeI2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testMaxValue() throws IOException {
        int expected = TypeI2.MAX_VALUE;
        RecordFtr recordFtr = RecordFtr.newInstance().setVectOff(expected);
        testValueFild(recordFtr, record -> recordFtr.getVectOff(), expected);
    }

    @Test
    void testMoreThanMaxValueThrows() {
        int expected = TypeI2.MAX_VALUE + 1;
        RecordFtr recordFtr = RecordFtr.newInstance();
        testIllegalValue(recordFtr, expected, (record, integer) -> recordFtr.setVectOff(integer),
                String.format(TypeI2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testDefaultNullValueSet() throws IOException {
        int expected = TypeI2.DEFAULT_VALUE;
        RecordFtr recordFtr = RecordFtr.newInstance().setVectOff(expected);
        testValueFild(recordFtr, record -> recordFtr.getVectOff(), expected);
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, Integer, Record> setter,
            Function<Record, Optional<Integer>> getter, Integer nullValue) throws IOException {

        testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, nullValue);
    }


    private void callTestOptionalResultWithPredicate(
            Supplier<Record> emptyRecord, BiFunction<Record, Integer, Record> setter,
            Function<Record, Optional<Integer>> getter) throws IOException {

        testValueFieldWithPredicate(emptyRecord, setter, TEST_VALUE, getter);
    }
}
