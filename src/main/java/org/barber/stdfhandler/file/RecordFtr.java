package org.barber.stdfhandler.file;

public class RecordFtr extends Record {

  private static final String NAME = "FTR";
  private static final int TYPE = 15;
  private static final int SUBTYPE = 20;

  private final Type<Long> testNum = new TypeU4("TEST_NUM", null);
  private final Type<Integer> headNUm = new TypeU1("HEAD_NUM", null);
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM", null);
  private final TypeB1 testFlg = new TypeB1("TEST_FLG", null);
  private final TypeB1 optFlag = new TypeB1("OPT_FLAG", null);
  private final Type<Long> cyclCnt = new TypeU4("CYCL_CNT", () -> optFlag.getBitInPosition(0) == 1);
  REL_VADR U*4 Relative vector address OPT_FLAG bit 1 = 1
  REPT_CNT U*4 Repeat count of vector OPT_FLAG bit 2 = 1
  NUM_FAIL U*4 Number of pins with 1 or more failures OPT_FLAG bit 3 = 1
  XFAIL_AD I*4 X logical device failure address OPT_FLAG bit 4 = 1
  YFAIL_AD I*4 Y logical device failure address OPT_FLAG bit 4 = 1
  VECT_OFF I*2 Offset from vector of interest OPT_FLAG bit 5 = 1
  RTN_ICNT U*2 Count (j) of return data PMR indexes See note
  PGM_ICNT U*2 Count (k) of programmed state indexes See note
  RTN_INDX jxU*2 Array of return data PMR indexes RTN_ICNT = 0
  RTN_STAT jxN*1 Array of returned states RTN_ICNT = 0
  PGM_INDX kxU*2 Array of programmed state indexes PGM_ICNT = 0
  PGM_STAT kxN*1 Array of programmed states PGM_ICNT = 0
  FAIL_PIN D*n Failing pin bitfield length bytes = 0
  VECT_NAM C*n Vector module pattern name length byte = 0
  TIME_SET C*n Time set name length byte = 0
  OP_CODE C*n Vector Op Code length byte = 0
  TEST_TXT C*n Descriptive text or label length byte = 0
  ALARM_ID C*n Name of alarm length byte = 0
  PROG_TXT C*n Additional programmed information length byte = 0
  RSLT_TXT C*n Additional result information length byte = 0
  PATG_NUM U*1 Pattern generator number 255
  SPIN_MAP D*n Bit map of enabled comparators length byte = 0

}
