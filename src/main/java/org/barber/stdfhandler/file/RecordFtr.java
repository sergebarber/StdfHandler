package org.barber.stdfhandler.file;

import java.util.List;
import java.util.Optional;

public class RecordFtr extends Record {

  private static final String NAME = "FTR";
  private static final int TYPE = 15;
  private static final int SUBTYPE = 20;

  public static final int CYCL_CNT_NULL_BIT = 0;
  public static final int REL_VADR_NULL_BIT = 1;
  public static final int REPT_CNT_NULL_BIT = 2;
  public static final int NUM_FAIL_NULL_BIT = 3;
  public static final int XFAIL_AD_NULL_BIT = 4;
  public static final int YFAIL_AD_NULL_BIT = 4;
  public static final int VECT_OFF_NULL_BIT = 5;

  private final Type<Long> testNum = new TypeU4("TEST_NUM");
  private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM");
  private final TypeB1 testFlg = new TypeB1("TEST_FLG");
  private final TypeB1 optFlag = new TypeB1("OPT_FLAG");
  private final Type<Long> cyclCnt = new TypeU4("CYCL_CNT", checkFlag(optFlag, CYCL_CNT_NULL_BIT));
  private final Type<Long> relVadr = new TypeU4("REL_VADR", checkFlag(optFlag, REL_VADR_NULL_BIT));
  private final Type<Long> reptCnt = new TypeU4("REPT_CNT", checkFlag(optFlag, REPT_CNT_NULL_BIT));
  private final Type<Long> numFail = new TypeU4("NUM_FAIL", checkFlag(optFlag, NUM_FAIL_NULL_BIT));
  private final Type<Integer> xfailAd = new TypeI4("XFAIL_AD", checkFlag(optFlag, XFAIL_AD_NULL_BIT));
  private final Type<Integer> yfailAd = new TypeI4("YFAIL_AD", checkFlag(optFlag, YFAIL_AD_NULL_BIT));
  private final Type<Integer> vectOff = new TypeI2("VECT_OFF", checkFlag(optFlag, VECT_OFF_NULL_BIT));
  private final Type<Integer> rtnIcnt = new TypeU2("RTN_ICNT");
  private final Type<Integer> pgmIcnt = new TypeU2("PGM_ICNT");
  private final TypeArray<TypeU2, Integer> rtnIndx = new TypeArray<>("RTN_INDX", TypeU2::new, rtnIcnt, TypeU2.MAX_VALUE);
  private final TypeArray<TypeN1, byte[]> rtnStat = new TypeArray<>("RTN_STAT", TypeN1::new, rtnIcnt, TypeU2.MAX_VALUE);
  private final TypeArray<TypeU2, Integer> pgmIndx = new TypeArray<>("PGM_INDX", TypeU2::new, pgmIcnt, TypeU2.MAX_VALUE);
  private final TypeArray<TypeN1, byte[]> pgmStat = new TypeArray<>("PGM_STAT", TypeN1::new, pgmIcnt, TypeU2.MAX_VALUE);
  private final Type<byte[]> failPin = new TypeDn("FAIL_PIN", TypeDn.DEFAULT_VALUE);
  private final Type<String> vectNam = new TypeCn("VECT_NAM", TypeCn.DEFAULT_VALUE);
  private final Type<String> timeSet = new TypeCn("TIME_SET", TypeCn.DEFAULT_VALUE);
  private final Type<String> opCode = new TypeCn("OP_CODE", TypeCn.DEFAULT_VALUE);
  private final Type<String> testTxt = new TypeCn("TEST_TXT", TypeCn.DEFAULT_VALUE);
  private final Type<String> alarmId = new TypeCn("ALARM_ID", TypeCn.DEFAULT_VALUE);
  private final Type<String> progTxt = new TypeCn("PROG_TXT", TypeCn.DEFAULT_VALUE);
  private final Type<String> rsltTxt = new TypeCn("RSLT_TXT", TypeCn.DEFAULT_VALUE);
  private final Type<Integer> patgNum = new TypeU1("PATG_NUM", TypeU1.MAX_VALUE);
  private final Type<byte[]> spinMap = new TypeDn("SPIN_MAP", TypeDn.DEFAULT_VALUE);

  private RecordFtr() {
    super(NAME, TYPE, SUBTYPE);
    addFields(testNum, headNum, siteNum, testFlg, optFlag, cyclCnt, relVadr, reptCnt, numFail, xfailAd, yfailAd,
        vectOff, rtnIcnt, pgmIcnt, rtnIndx, rtnStat, pgmIndx, pgmStat, failPin, vectNam, timeSet, opCode, testTxt,
        alarmId, progTxt, rsltTxt, patgNum, spinMap);
  }

  public static RecordFtr newInstance() {
    return new RecordFtr();
  }

  public Optional<Long> getTestNum() {
    return Optional.ofNullable(testNum.getValue());
  }

  public Optional<Integer> getHeadNum() {
    return Optional.ofNullable(headNum.getValue());
  }

  public Optional<Integer> getSiteNum() {
    return Optional.ofNullable(siteNum.getValue());
  }

  public boolean getTestFlgBit(int position) {
    return testFlg.getBitInPosition(position);
  }

  public boolean getOptFlagBit(int position) {
    return optFlag.getBitInPosition(position);
  }

  public Optional<Long> getCyclCnt() {
    return Optional.ofNullable(cyclCnt.getValue());
  }

  public Optional<Long> getRelVadr() {
    return Optional.ofNullable(relVadr.getValue());
  }

  public Optional<Long> getReptCnt() {
    return Optional.ofNullable(reptCnt.getValue());
  }

  public Optional<Long> getNumFail() {
    return Optional.ofNullable(numFail.getValue());
  }

  public Optional<Integer> getXfailAd() {
    return Optional.ofNullable(xfailAd.getValue());
  }

  public Optional<Integer> getYfailAd() {
    return Optional.ofNullable(yfailAd.getValue());
  }

  public Optional<Integer> getVectOff() {
    return Optional.ofNullable(vectOff.getValue());
  }

  public Optional<Integer> getRtnIcnt() {
    return Optional.ofNullable(rtnIcnt.getValue());
  }

  public Optional<Integer> getPgmIcnt() {
    return Optional.ofNullable(pgmIcnt.getValue());
  }

  public List<Integer> getRtnIndx() {
    return rtnIndx.getBasicTypeList();
  }

  public List<byte[]> getRtnStat() {
    return rtnStat.getBasicTypeList();
  }

  public List<Integer> getPgmIndx() {
    return pgmIndx.getBasicTypeList();
  }

  public List<byte[]> getPgmStat() {
    return pgmStat.getBasicTypeList();
  }

  public Optional<byte[]> getFailPin() {
    return Optional.ofNullable(failPin.getValue());
  }

  public Optional<String> getVectNam() {
    return Optional.ofNullable(vectNam.getValue());
  }

  public Optional<String> getTimeSet() {
    return Optional.ofNullable(timeSet.getValue());
  }

  public Optional<String> getOpCode() {
    return Optional.ofNullable(opCode.getValue());
  }

  public Optional<String> getTestTxt() {
    return Optional.ofNullable(testTxt.getValue());
  }

  public Optional<String> getAlarmId() {
    return Optional.ofNullable(alarmId.getValue());
  }

  public Optional<String> getProgTxt() {
    return Optional.ofNullable(progTxt.getValue());
  }

  public Optional<String> getRsltTxt() {
    return Optional.ofNullable(rsltTxt.getValue());
  }

  public Optional<Integer> getPatgNum() {
    return Optional.ofNullable(patgNum.getValue());
  }

  public Optional<byte[]> getSpinMap() {
    return Optional.ofNullable(spinMap.getValue());
  }


  public RecordFtr setTestNum(long testNum) {
    this.testNum.setValueFromUser(testNum);
    return this;
  }

  public RecordFtr setHeadNum(int headNum) {
    this.headNum.setValueFromUser(headNum);
    return this;
  }

  public RecordFtr setSiteNum(int siteNum) {
    this.siteNum.setValueFromUser(siteNum);
    return this;
  }

  public RecordFtr setTestFlgBit(boolean flag, int position) {
    testFlg.setBitInPosition(flag, position);
    return this;
  }

  public RecordFtr setOptFlagBit(boolean flag, int position) {
    optFlag.setBitInPosition(flag, position);
    return this;
  }

  public RecordFtr setCyclCnt(long cyclCnt) {
    this.cyclCnt.setValueFromUser(cyclCnt);
    this.optFlag.setBitInPosition(true, CYCL_CNT_NULL_BIT);
    return this;
  }

  public RecordFtr setRelVadr(long relVadr) {
    this.relVadr.setValueFromUser(relVadr);
    this.optFlag.setBitInPosition(true, REL_VADR_NULL_BIT);
    return this;
  }

  public RecordFtr setReptCnt(long reptCnt) {
    this.reptCnt.setValueFromUser(reptCnt);
    this.optFlag.setBitInPosition(true, REPT_CNT_NULL_BIT);
    return this;
  }

  public RecordFtr setNumFail(long numFail) {
    this.numFail.setValueFromUser(numFail);
    this.optFlag.setBitInPosition(true, NUM_FAIL_NULL_BIT);
    return this;
  }

  public RecordFtr setXfailAd(int xfailAd) {
    this.xfailAd.setValueFromUser(xfailAd);
    this.optFlag.setBitInPosition(true, XFAIL_AD_NULL_BIT);
    return this;
  }

  public RecordFtr setYfailAd(int yfailAd) {
    this.yfailAd.setValueFromUser(yfailAd);
    this.optFlag.setBitInPosition(true, YFAIL_AD_NULL_BIT);
    return this;
  }

  public RecordFtr setVectOff(int vectOff) {
    this.vectOff.setValueFromUser(vectOff);
    this.optFlag.setBitInPosition(true, VECT_OFF_NULL_BIT);
    return this;
  }

  public RecordFtr setRtnIndxAndStat(List<Integer> rtnIndx, List<byte[]> rtnStat) {
    if (rtnIndx.size() != rtnStat.size()) {
      throw new IllegalArgumentException(
              String.format(ARRAYS_UNEQUAL_SIZES_MESSAGE, this.rtnIndx.getName(), this.rtnStat.getName()));
    }
    this.rtnIndx.setValueFromBasicTypeList(rtnIndx);
    this.rtnStat.setValueFromBasicTypeList(rtnStat);
    return this;
  }

  public RecordFtr setPgmIndxAndStat(List<Integer> pgmIndx, List<byte[]> pgmStat) {
    if (pgmIndx.size() != pgmStat.size()) {
      throw new IllegalArgumentException(
              String.format(ARRAYS_UNEQUAL_SIZES_MESSAGE, this.pgmIndx.getName(), this.pgmStat.getName()));
    }
    this.pgmIndx.setValueFromBasicTypeList(pgmIndx);
    this.pgmStat.setValueFromBasicTypeList(pgmStat);
    return this;
  }

  public RecordFtr setFailPin(byte[] failPin) {
    this.failPin.setValueFromUser(failPin);
    return this;
  }

  public RecordFtr setVectNam(String vectNam) {
    this.vectNam.setValueFromUser(vectNam);
    return this;
  }

  public RecordFtr setTimeSet(String timeSet) {
    this.timeSet.setValueFromUser(timeSet);
    return this;
  }

  public RecordFtr setOpCode(String opCode) {
    this.opCode.setValueFromUser(opCode);
    return this;
  }

  public RecordFtr setTestTxt(String testTxt) {
    this.testTxt.setValueFromUser(testTxt);
    return this;
  }

  public RecordFtr setAlarmId(String alarmId) {
    this.alarmId.setValueFromUser(alarmId);
    return this;
  }

  public RecordFtr setProgTxt(String progTxt) {
    this.progTxt.setValueFromUser(progTxt);
    return this;
  }

  public RecordFtr setRsltTxt(String rsltTxt) {
    this.rsltTxt.setValueFromUser(rsltTxt);
    return this;
  }

  public RecordFtr setPatgNum(int patgNum) {
    this.patgNum.setValueFromUser(patgNum);
    return this;
  }

  public RecordFtr setSpinMap(byte[] spinMap) {
    this.spinMap.setValueFromUser(spinMap);
    return this;
  }
}
