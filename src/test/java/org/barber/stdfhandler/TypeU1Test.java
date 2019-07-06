package org.barber.stdfhandler;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

class TypeU1Test extends TypeTest {

    static final int TEST_VALUE = 123;

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testFarStdfVer() throws IOException {
        RecordFar recordFar = RecordFar.newInstance().setStdfVer(TEST_VALUE);
        testValueFild(recordFar, record -> recordFar.getStdfVer(), TEST_VALUE);
    }

    @Test
    void testFtrHeadNum() throws IOException {
        RecordFtr recordFtr = RecordFtr.newInstance().setHeadNum(TEST_VALUE);
        testValueFild(recordFtr, record -> recordFtr.getHeadNum(), TEST_VALUE);
    }

    @Test
    void testFtrSiteNum() throws IOException {
        RecordFtr recordFtr = RecordFtr.newInstance().setSiteNum(TEST_VALUE);
        testValueFild(recordFtr, record -> recordFtr.getSiteNum(), TEST_VALUE);
    }

    @Test
    void testFtrPatgNum() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setPatgNum(v), r -> ((RecordFtr)r).getPatgNum()
        );
    }

    @Test
    void testHbrHeadNum() throws IOException {
        RecordHbr recordHbr = RecordHbr.newInstance().setHeadNum(TEST_VALUE);
        testValueFild(recordHbr, record -> recordHbr.getHeadNum(), TEST_VALUE);
    }

    @Test
    void testHbrSiteNum() throws IOException {
        RecordHbr recordHbr = RecordHbr.newInstance().setSiteNum(TEST_VALUE);
        testValueFild(recordHbr, record -> recordHbr.getSiteNum(), TEST_VALUE);
    }

    @Test
    void testMirStatNum() throws IOException {
        RecordMir recordMir = RecordMir.newInstance().setStatNum(TEST_VALUE);
        testValueFild(recordMir, record -> recordMir.getStatNum(), TEST_VALUE);
    }

    @Test
    void testMprHeadNum() throws IOException {
        RecordMpr recordMpr = RecordMpr.newInstance().setHeadNum(TEST_VALUE);
        testValueFild(recordMpr, record -> recordMpr.getHeadNum(), TEST_VALUE);
    }

    @Test
    void testMprSiteNum() throws IOException {
        RecordMpr recordMpr = RecordMpr.newInstance().setSiteNum(TEST_VALUE);
        testValueFild(recordMpr, record -> recordMpr.getSiteNum(), TEST_VALUE);
    }

    @Test
    void testPcrHeadNum() throws IOException {
        RecordPcr recordPcr = RecordPcr.newInstance().setHeadNum(TEST_VALUE);
        testValueFild(recordPcr, record -> recordPcr.getHeadNum(), TEST_VALUE);
    }

    @Test
    void testPcrSiteNum() throws IOException {
        RecordPcr recordPcr = RecordPcr.newInstance().setSiteNum(TEST_VALUE);
        testValueFild(recordPcr, record -> recordPcr.getSiteNum(), TEST_VALUE);
    }

    @Test
    void testPirHeadNum() throws IOException {
        RecordPir recordPir = RecordPir.newInstance().setHeadNum(TEST_VALUE);
        testValueFild(recordPir, record -> recordPir.getHeadNum(), TEST_VALUE);
    }

    @Test
    void testPirSiteNum() throws IOException {
        RecordPir recordPir = RecordPir.newInstance().setSiteNum(TEST_VALUE);
        testValueFild(recordPir, record -> recordPir.getSiteNum(), TEST_VALUE);
    }

    @Test
    void testPmrHeadNum() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordPmr::newInstance, (r, v) -> ((RecordPmr)r).setHeadNum(v), r -> ((RecordPmr)r).getHeadNum(), 1);
    }

    @Test
    void testPmrSiteNum() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordPmr::newInstance, (r, v) -> ((RecordPmr)r).setSiteNum(v), r -> ((RecordPmr)r).getSiteNum(), 1);
    }

    @Test
    void testPrrHeadNum() throws IOException {
        RecordPrr recordPrr = RecordPrr.newInstance().setHeadNum(TEST_VALUE);
        testValueFild(recordPrr, record -> recordPrr.getHeadNum(), TEST_VALUE);
    }

    @Test
    void testPrrSiteNum() throws IOException {
        RecordPrr recordPrr = RecordPrr.newInstance().setSiteNum(TEST_VALUE);
        testValueFild(recordPrr, record -> recordPrr.getSiteNum(), TEST_VALUE);
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testMinValue() throws IOException {
        int expected = TypeU1.MIN_VALUE;
        RecordFar recordFar = RecordFar.newInstance().setCpuTyp(expected);
        testValueFild(recordFar, record -> recordFar.getCpuTyp(), expected);
    }

    @Test
    void testLessThanMinValueThrows() {
        int expected = TypeU1.MIN_VALUE - 1;
        RecordFar recordFar = RecordFar.newInstance();
        testIllegalValue(recordFar, expected, (record, integer) -> recordFar.setCpuTyp(integer),
                String.format(TypeU1.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testMaxValue() throws IOException {
        int expected = TypeU1.MAX_VALUE;
        RecordFar recordFar = RecordFar.newInstance().setCpuTyp(expected);
        testValueFild(recordFar, record -> recordFar.getCpuTyp(), expected);
    }

    @Test
    void testMoreThanMaxValueThrows() {
        int expected = TypeU1.MAX_VALUE + 1;
        RecordFar recordFar = RecordFar.newInstance();
        testIllegalValue(recordFar, expected, (record, integer) -> recordFar.setCpuTyp(integer),
                String.format(TypeU1.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testDefaultNullValueSet() throws IOException {
        int expected = TypeU1.DEFAULT_VALUE;
        RecordFar recordFar = RecordFar.newInstance().setCpuTyp(expected);
        testValueFild(recordFar, record -> recordFar.getCpuTyp(), expected);
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, Integer, Record> setter,
            Function<Record, Optional<Integer>> getter, Integer nullValue) throws IOException {

        testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, nullValue);
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, Integer, Record> setter,
            Function<Record, Optional<Integer>> getter) throws IOException {

        callTestOptionalResultWithNullValue(emptyRecord, setter, getter, TypeU1.MAX_VALUE);
    }
}
