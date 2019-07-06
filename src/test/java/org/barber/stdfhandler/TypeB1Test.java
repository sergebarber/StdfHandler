package org.barber.stdfhandler;

import org.barber.stdfhandler.file.RecordFtr;
import org.barber.stdfhandler.file.RecordMpr;
import org.barber.stdfhandler.file.TypeB1;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeB1Test extends TypeTest {

  private static final boolean TEST_VALUE = true;
  private static final int TEST_POSITION = 3;

  // ************************************************************************************
  // Records tests
  // ************************************************************************************

  @Test
  void testFtrTestFlgBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setTestFlgBit(TEST_VALUE, TEST_POSITION);
    testBitValue(recordFtr, record -> recordFtr.getTestFlgBit(TEST_POSITION));
  }

  @Test
  void testFtrOptFlgBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setOptFlagBit(TEST_VALUE, TEST_POSITION);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(TEST_POSITION));
  }

  @Test
  void testFtrCyclCntBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setCyclCnt(TypeU1Test.TEST_VALUE);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(RecordFtr.CYCL_CNT_NULL_BIT));
  }

  @Test
  void testFtrRelVadrBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setRelVadr(TypeU1Test.TEST_VALUE);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(RecordFtr.REL_VADR_NULL_BIT));
  }

  @Test
  void testFtrReptCntBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setReptCnt(TypeU1Test.TEST_VALUE);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(RecordFtr.REPT_CNT_NULL_BIT));
  }

  @Test
  void testFtrNumFailBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setNumFail(TypeU1Test.TEST_VALUE);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(RecordFtr.NUM_FAIL_NULL_BIT));
  }

  @Test
  void testFtrXfailAdBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setXfailAd(TypeI4Test.TEST_VALUE);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(RecordFtr.XFAIL_AD_NULL_BIT));
  }

  @Test
  void testFtrYfailAdBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setYfailAd(TypeI4Test.TEST_VALUE);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(RecordFtr.YFAIL_AD_NULL_BIT));
  }

  @Test
  void testFtrVectOffBit() throws IOException {
    RecordFtr recordFtr = RecordFtr.newInstance().setVectOff(TypeI2Test.TEST_VALUE);
    testBitValue(recordFtr, record -> recordFtr.getOptFlagBit(RecordFtr.VECT_OFF_NULL_BIT));
  }

  @Test
  void testMprResScalBit() throws IOException {
    RecordMpr recordMpr = RecordMpr.newInstance().setResScal(TypeI1Test.TEST_VALUE);
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.RES_SCAL_BIT_NUMBER));
  }

  @Test
  void testMprLlmScalAndLoLimitBits() throws IOException {
    RecordMpr recordMpr = RecordMpr.newInstance().setLlmScalAndLoLimit(TypeI1Test.TEST_VALUE, TypeR4Test.TEST_VALUE);
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.LLM_SCAL_BIT_NUMBER_1));
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.LLM_SCAL_BIT_NUMBER_2));
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.LO_LIMIT_BIT_NUMBER_1));
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.LO_LIMIT_BIT_NUMBER_2));
  }

  @Test
  void testMprHlmScalAndhiLimitBits() throws IOException {
    RecordMpr recordMpr = RecordMpr.newInstance().setHlmScalAndHiLimit(TypeI1Test.TEST_VALUE, TypeR4Test.TEST_VALUE);
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.HLM_SCAL_BIT_NUMBER_1));
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.HLM_SCAL_BIT_NUMBER_2));
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.HI_LIMIT_BIT_NUMBER_1));
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.HI_LIMIT_BIT_NUMBER_2));
  }

  @Test
  void testMprHlmStartInAndIncrInBits() throws IOException {
    RecordMpr recordMpr = RecordMpr.newInstance().setStartInAndIncrIn(TypeI1Test.TEST_VALUE, TypeR4Test.TEST_VALUE);
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.START_IN_BIT_NUMBER));
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.INCR_IN_BIT_NUMBER));
  }

  @Test
  void testMprLoSpecBit() throws IOException {
    RecordMpr recordMpr = RecordMpr.newInstance().setLoSpec(TypeR4Test.TEST_VALUE);
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.LO_SPEC_BIT_NUMBER));
  }

  @Test
  void testMprHiSpecBit() throws IOException {
    RecordMpr recordMpr = RecordMpr.newInstance().setHiSpec(TypeR4Test.TEST_VALUE);
    testBitValue(recordMpr, record -> recordMpr.getOptFlgBit(RecordMpr.HI_SPEC_BIT_NUMBER));
  }

  // ************************************************************************************
  // Type tests
  // ************************************************************************************

  @Test
  void testFlagSetBitNegativePositionThrows() {
    int position = TypeB1.MIN_POSITION - 1;
    assertThatThrownBy(() -> RecordFtr.newInstance().setTestFlgBit(true, position))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format(TypeB1.ILLEGAL_POSITION_MESSAGE, position));
  }

  @Test
  void testFlagGetBitNegativePositionThrows() {
    int position = TypeB1.MIN_POSITION - 1;
    RecordFtr recordFtr = RecordFtr.newInstance();
    assertThatThrownBy(() -> recordFtr.getTestFlgBit(position))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format(TypeB1.ILLEGAL_POSITION_MESSAGE, position));
  }

  @Test
  void testFlagSetBitIllegalPositivePositionThrows() {
    int position = TypeB1.MAX_POSITION + 1;
    assertThatThrownBy(() -> RecordFtr.newInstance().setTestFlgBit(true, position))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format(TypeB1.ILLEGAL_POSITION_MESSAGE, position));
  }

  @Test
  void testFlagGetBitIllegalPositivePositionThrows() {
    int position = TypeB1.MAX_POSITION + 1;
    RecordFtr recordFtr = RecordFtr.newInstance();
    assertThatThrownBy(() -> recordFtr.getTestFlgBit(position))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format(TypeB1.ILLEGAL_POSITION_MESSAGE, position));
  }
}
