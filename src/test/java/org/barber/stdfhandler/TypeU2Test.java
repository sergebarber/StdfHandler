package org.barber.stdfhandler;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class TypeU2Test extends TypeTest {

    static final int TEST_VALUE = 12345;

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testMirBurnTim() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordMir::newInstance, (r, v) -> ((RecordMir) r).setBurnTim(v), r -> ((RecordMir) r).getBurnTim());
    }

    @Test
    void testPgrGrpIndx() throws IOException {
        RecordPgr recordPgr = RecordPgr.newInstance().setGrpIndx(TEST_VALUE);
        testValueFild(recordPgr, record -> recordPgr.getGrpIndx(), TEST_VALUE);
    }

    @Test
    void testPmrPmrIndx() throws IOException {
        RecordPmr recordPmr = RecordPmr.newInstance().setPmrIndx(TEST_VALUE);
        testValueFild(recordPmr, record -> recordPmr.getPmrIndx(), TEST_VALUE);
    }

    @Test
    void testPmrChanTyp() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordPmr::newInstance, (r, v) -> ((RecordPmr) r).setChanTyp(v),
                r -> ((RecordPmr) r).getChanTyp(), TypeU2.MIN_VALUE);
    }

    @Test
    void testPrrNumTest() throws IOException {
        RecordPrr recordPrr = RecordPrr.newInstance().setNumTest(TEST_VALUE);
        testValueFild(recordPrr, record -> recordPrr.getNumTest(), TEST_VALUE);
    }

    @Test
    void testPrrHardBin() throws IOException {
        RecordPrr recordPrr = RecordPrr.newInstance().setHardBin(TEST_VALUE);
        testValueFild(recordPrr, record -> recordPrr.getHardBin(), TEST_VALUE);
    }

    @Test
    void testPrrSoftBin() throws IOException {
        RecordPrr recordPrr = RecordPrr.newInstance().setSoftBin(TEST_VALUE);
        testValueFild(recordPrr, record -> recordPrr.getSoftBin(), TEST_VALUE);
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testMinValue() throws IOException {
        int expected = TypeU2.MIN_VALUE;
        RecordHbr recordHbr = RecordHbr.newInstance().setHbinNum(expected);
        testValueFild(recordHbr, record -> recordHbr.getHbinNum(), expected);
    }

    @Test
    void testLessThanMinValueThrows() {
        int expected = TypeU2.MIN_VALUE - 1;
        RecordHbr recordHbr = RecordHbr.newInstance();
        testIllegalValue(recordHbr, expected, (record, integer) -> recordHbr.setHbinNum(integer),
                String.format(TypeU2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testMaxValue() throws IOException {
        int expected = TypeU2.MAX_VALUE;
        RecordHbr recordHbr = RecordHbr.newInstance().setHbinNum(expected);
        testValueFild(recordHbr, record -> recordHbr.getHbinNum(), expected);
    }

    @Test
    void testMoreThanMaxValueThrows() {
        int expected = TypeU2.MAX_VALUE + 1;
        RecordHbr recordHbr = RecordHbr.newInstance();
        testIllegalValue(recordHbr, expected, (record, integer) -> recordHbr.setHbinNum(integer),
                String.format(TypeU2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testDefaultNullValueSet() throws IOException {
        int expected = TypeU2.DEFAULT_VALUE;
        RecordHbr recordHbr = RecordHbr.newInstance().setHbinNum(expected);
        testValueFild(recordHbr, record -> recordHbr.getHbinNum(), expected);
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, Integer, Record> setter,
            Function<Record, Optional<Integer>> getter, Integer nullValue) throws IOException {

        testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, nullValue);
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, Integer, Record> setter,
            Function<Record, Optional<Integer>> getter) throws IOException {

        callTestOptionalResultWithNullValue(emptyRecord, setter, getter, TypeU2.MAX_VALUE);
    }
}
