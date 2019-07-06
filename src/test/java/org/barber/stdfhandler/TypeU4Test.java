package org.barber.stdfhandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

class TypeU4Test extends TypeTest {

  static final long TEST_VALUE = 123456789;

  // ************************************************************************************
  // Records tests
  // ************************************************************************************

  @Test
  void testFtrCyclCnt() throws IOException {
    callTestOptionalResultWithPredicate(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr) r).setCyclCnt(v),
            r -> ((RecordFtr) r).getCyclCnt());
  }

  @Test
  void testFtrRelVadr() throws IOException {
    callTestOptionalResultWithPredicate(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr) r).setRelVadr(v),
            r -> ((RecordFtr) r).getRelVadr());
  }

  @Test
  void testFtrReptCnt() throws IOException {
    callTestOptionalResultWithPredicate(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr) r).setReptCnt(v),
            r -> ((RecordFtr) r).getReptCnt());
  }

  @Test
  void testFtrNumFail() throws IOException {
    callTestOptionalResultWithPredicate(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr) r).setNumFail(v),
            r -> ((RecordFtr) r).getNumFail());
  }

  @Test
  void testHbrHbinCnt() throws IOException {
    RecordHbr recordHbr = RecordHbr.newInstance().setHbinCnt(TEST_VALUE);
    testValueFild(recordHbr, record -> recordHbr.getHbinCnt(), TEST_VALUE);
  }

  @Test
  void testMprTestNum() throws IOException {
    RecordMpr recordMpr = RecordMpr.newInstance().setTestNum(TEST_VALUE);
    testValueFild(recordMpr, record -> recordMpr.getTestNum(), TEST_VALUE);
  }

  @Test
  void testPcrPartCnt() throws IOException {
    RecordPcr recordPcr = RecordPcr.newInstance().setPartCnt(TEST_VALUE);
    testValueFild(recordPcr, record -> recordPcr.getPartCnt(), TEST_VALUE);
  }

  @Test
  void testPcrRtstCnt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPcr::newInstance, (r, v) -> ((RecordPcr) r).setRtstCnt(v),
            r -> ((RecordPcr) r).getRtstCnt()
    );
  }

  @Test
  void testPcrAbrtCnt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPcr::newInstance, (r, v) -> ((RecordPcr) r).setAbrtCnt(v),
            r -> ((RecordPcr) r).getAbrtCnt());
  }

  @Test
  void testPcrGoodCnt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPcr::newInstance, (r, v) -> ((RecordPcr) r).setGoodCnt(v), r -> ((RecordPcr) r).getGoodCnt());
  }

  @Test
  void testPcrFuncCnt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPcr::newInstance, (r, v) -> ((RecordPcr) r).setFuncCnt(v), r -> ((RecordPcr) r).getFuncCnt());
  }

  @Test
  void testPrrTestT() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPrr::newInstance, (r, v) -> ((RecordPrr) r).setTestT(v), r -> ((RecordPrr) r).getTestT(),
            TypeU4.DEFAULT_VALUE);
  }

  // ************************************************************************************
  // Type tests
  // ************************************************************************************

  @Test
  void testMinValue() throws IOException {
    long expected = TypeU4.MIN_VALUE;
    RecordFtr recordFtr = RecordFtr.newInstance().setTestNum(expected);
    testValueFild(recordFtr, record -> recordFtr.getTestNum(), expected);
  }

  @Test
  void testLessThanMinValueThrows() {
    long expected = TypeU4.MIN_VALUE - 1;
    RecordFtr recordFtr = RecordFtr.newInstance();
    testIllegalValue(recordFtr, expected, (record, integer) -> recordFtr.setTestNum(integer),
        String.format(TypeU4.ILLEGAL_VALUE_MESSAGE, expected));
  }

  @Test
  void testMaxValue() throws IOException {
    long expected = TypeU4.MAX_VALUE;
    RecordFtr recordFtr = RecordFtr.newInstance().setTestNum(expected);
    testValueFild(recordFtr, record -> recordFtr.getTestNum(), expected);
  }

  @Test
  void testMoreThanMaxValueThrows() {
    long expected = TypeU4.MAX_VALUE + 1;
    RecordFtr recordFtr = RecordFtr.newInstance();
    testIllegalValue(recordFtr, expected, (record, integer) -> recordFtr.setTestNum(integer),
        String.format(TypeU4.ILLEGAL_VALUE_MESSAGE, expected));
  }

  @Test
  void testDefaultNullValueSet() throws IOException {
    long expected = TypeU4.DEFAULT_VALUE;
    RecordFtr recordFtr = RecordFtr.newInstance().setTestNum(expected);
    testValueFild(recordFtr, record -> recordFtr.getTestNum(), expected);
  }

  private void callTestOptionalResultWithNullValue(
          Supplier<Record> emptyRecord, BiFunction<Record, Long, Record> setter,
          Function<Record, Optional<Long>> getter, Long nullValue) throws IOException {

    testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, nullValue);
  }

  private void callTestOptionalResultWithNullValue(
          Supplier<Record> emptyRecord, BiFunction<Record, Long, Record> setter,
          Function<Record, Optional<Long>> getter) throws IOException {

    callTestOptionalResultWithNullValue(emptyRecord, setter, getter, TypeU4.MAX_VALUE);
  }

  private void callTestOptionalResultWithPredicate(
          Supplier<Record> emptyRecord, BiFunction<Record, Long, Record> setter,
          Function<Record, Optional<Long>> getter) throws IOException {

    testValueFieldWithPredicate(emptyRecord, setter, TEST_VALUE, getter);
  }
}
