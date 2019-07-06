package org.barber.stdfhandler.file;

import java.util.List;
import java.util.Optional;

public class RecordMpr extends Record {

  private static final String NAME = "MPR";
  private static final int TYPE = 15;
  private static final int SUBTYPE = 15;

  public static final int RES_SCAL_BIT_NUMBER = 0;
  public static final int LLM_SCAL_BIT_NUMBER_1 = 4;
  public static final int LLM_SCAL_BIT_NUMBER_2 = 6;
  public static final int HLM_SCAL_BIT_NUMBER_1 = 5;
  public static final int HLM_SCAL_BIT_NUMBER_2 = 7;
  public static final int LO_LIMIT_BIT_NUMBER_1 = 4;
  public static final int LO_LIMIT_BIT_NUMBER_2 = 6;
  public static final int HI_LIMIT_BIT_NUMBER_1 = 5;
  public static final int HI_LIMIT_BIT_NUMBER_2 = 7;
  public static final int START_IN_BIT_NUMBER = 1;
  public static final int INCR_IN_BIT_NUMBER = 1;
  public static final int LO_SPEC_BIT_NUMBER = 2;
  public static final int HI_SPEC_BIT_NUMBER = 3;


  private final Type<Long> testNum = new TypeU4("TEST_NUM");
  private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM");
  private final TypeB1 testFlg = new TypeB1("TEST_FLG");
  private final TypeB1 parmFlg = new TypeB1("PARM_FLG");
  private final Type<Integer> rtnIcnt = new TypeU2("RTN_ICNT");
  private final Type<Integer> rsltCnt = new TypeU2("RSLT_CNT");
  private final TypeArray<TypeN1, byte[]> rtnStat = new TypeArray<>("RTN_STAT", TypeN1::new, rtnIcnt, TypeU2.MAX_VALUE);
  private final TypeArray<TypeR4, Float> rtnRslt = new TypeArray<>("RTN_RSLT", TypeR4::new, rsltCnt, TypeU2.MAX_VALUE);
  private final Type<String> testTxt = new TypeCn("TEST_TXT", TypeCn.DEFAULT_VALUE);
  private final Type<String> alarmId = new TypeCn("ALARM_ID", TypeCn.DEFAULT_VALUE);
  private final TypeB1 optFlag = new TypeB1("OPT_FLAG");
  private final Type<Byte> resScal = new TypeI1("RES_SCAL", checkFlag(optFlag, RES_SCAL_BIT_NUMBER));
  private final Type<Byte> llmScal = new TypeI1("LLM_SCAL",
          () -> checkFlag(optFlag, LLM_SCAL_BIT_NUMBER_1).get() || checkFlag(optFlag, LLM_SCAL_BIT_NUMBER_2).get());
  private final Type<Byte> hlmScal = new TypeI1("HLM_SCAL",
          () -> checkFlag(optFlag, HLM_SCAL_BIT_NUMBER_1).get() || checkFlag(optFlag, HLM_SCAL_BIT_NUMBER_2).get());
  private final Type<Float> loLimit = new TypeR4("LO_LIMIT",
          () -> checkFlag(optFlag, LO_LIMIT_BIT_NUMBER_1).get() || checkFlag(optFlag, LO_LIMIT_BIT_NUMBER_2).get());
  private final Type<Float> hiLimit = new TypeR4("HI_LIMIT",
          () -> checkFlag(optFlag, HI_LIMIT_BIT_NUMBER_1).get() || checkFlag(optFlag, HI_LIMIT_BIT_NUMBER_2).get());
  private final Type<Float> startIn = new TypeR4("START_IN", checkFlag(optFlag, START_IN_BIT_NUMBER));
  private final Type<Float> incrIn = new TypeR4("INCR_IN", checkFlag(optFlag, INCR_IN_BIT_NUMBER));
  private final TypeArray<TypeU2, Integer> rtnIndx = new TypeArray<>("RTN_INDX", TypeU2::new, rtnIcnt, TypeU2.MAX_VALUE);
  private final Type<String> units = new TypeCn("UNITS", TypeCn.DEFAULT_VALUE);
  private final Type<String> unitsIn = new TypeCn("UNITS_IN", TypeCn.DEFAULT_VALUE);
  private final Type<String> cResmft = new TypeCn("C_RESFMT", TypeCn.DEFAULT_VALUE);
  private final Type<String> cLlmfmt = new TypeCn("C_LLMFMT", TypeCn.DEFAULT_VALUE);
  private final Type<String> cHlmfmt = new TypeCn("C_HLMFMT", TypeCn.DEFAULT_VALUE);
  private final Type<Float> loSpec = new TypeR4("LO_SPEC", checkFlag(optFlag, LO_SPEC_BIT_NUMBER));
  private final Type<Float> hiSpec = new TypeR4("HI_SPEC", checkFlag(optFlag, HI_SPEC_BIT_NUMBER));

  private RecordMpr() {
    super(NAME, TYPE, SUBTYPE);
    addFields(testNum, headNum, siteNum, testFlg, parmFlg, rtnIcnt, rsltCnt, rtnStat, rtnRslt, testTxt, alarmId,
        optFlag, resScal, llmScal, hlmScal, loLimit, hiLimit, startIn, incrIn, rtnIndx, units,
        unitsIn, cResmft, cLlmfmt, cHlmfmt, loSpec, hiSpec);
  }

  public static RecordMpr newInstance() {
    return new RecordMpr();
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

  public boolean getParmFlgBit(int position) {
    return parmFlg.getBitInPosition(position);
  }

  public Optional<Integer> getRtnIcnt() {
    return Optional.ofNullable(rtnIcnt.getValue());
  }

  public Optional<Integer> getRsltCnt() {
    return Optional.ofNullable(rsltCnt.getValue());
  }

  public List<byte[]> getRtnStat() {
    return rtnStat.getBasicTypeList();
  }

  public List<Float> getRtnRslt() {
    return rtnRslt.getBasicTypeList();
  }

  public Optional<String> getTestTxt() {
    return Optional.ofNullable(testTxt.getValue());
  }

  public Optional<String> getAlarmId() {
    return Optional.ofNullable(alarmId.getValue());
  }

  public boolean getOptFlgBit(int position) {
    return optFlag.getBitInPosition(position);
  }

  public Optional<Byte> getResScal() {
    return Optional.ofNullable(resScal.getValue());
  }

  public Optional<Byte> getLlmScal() {
    return Optional.ofNullable(llmScal.getValue());
  }

  public Optional<Byte> getHlmScal() {
    return Optional.ofNullable(hlmScal.getValue());
  }

  public Optional<Float> getLoLimit() {
    return Optional.ofNullable(loLimit.getValue());
  }

  public Optional<Float> getHiLimit() {
    return Optional.ofNullable(hiLimit.getValue());
  }

  public Optional<Float> getStartIn() {
    return Optional.ofNullable(startIn.getValue());
  }

  public Optional<Float> getIncrIn() {
    return Optional.ofNullable(incrIn.getValue());
  }

  public List<Integer> getRtnIndx() {
    return rtnIndx.getBasicTypeList();
  }

  public Optional<String> getUnits() {
    return Optional.ofNullable(units.getValue());
  }

  public Optional<String> getUnitsIn() {
    return Optional.ofNullable(unitsIn.getValue());
  }

  public Optional<String> getcResmft() {
    return Optional.ofNullable(cResmft.getValue());
  }

  public Optional<String> getcLlmfmt() {
    return Optional.ofNullable(cLlmfmt.getValue());
  }

  public Optional<String> getcHlmfmt() {
    return Optional.ofNullable(cHlmfmt.getValue());
  }

  public Optional<Float> getLoSpec() {
    return Optional.ofNullable(loSpec.getValue());
  }

  public Optional<Float> getHiSpec() {
    return Optional.ofNullable(hiSpec.getValue());
  }


  public RecordMpr setTestNum(long testNum) {
    this.testNum.setValueFromUser(testNum);
    return this;
  }

  public RecordMpr setHeadNum(int headNum) {
    this.headNum.setValueFromUser(headNum);
    return this;
  }

  public RecordMpr setSiteNum(int siteNum) {
    this.siteNum.setValueFromUser(siteNum);
    return this;
  }

  public RecordMpr setTestFlgBit(boolean flag, int position) {
    this.testFlg.setBitInPosition(flag, position);
    return this;
  }

  public RecordMpr setParmFlgBit(boolean flag, int position) {
    this.parmFlg.setBitInPosition(flag, position);
    return this;
  }

  public RecordMpr setRtnStat(List<byte[]> rtnStat) {
    this.rtnStat.setValueFromBasicTypeList(rtnStat);
    return this;
  }

  public RecordMpr setRtnRslt(List<Float> rtnRslt) {
    this.rtnRslt.setValueFromBasicTypeList(rtnRslt);
    return this;
  }

  public RecordMpr setTestTxt(String testTxt) {
    this.testTxt.setValueFromUser(testTxt);
    return this;
  }

  public RecordMpr setAlarmId(String alarmId) {
    this.alarmId.setValueFromUser(alarmId);
    return this;
  }

  public RecordMpr setOptFlgBit(boolean flag, int position) {
    optFlag.setBitInPosition(flag, position);
    return this;
  }

  public RecordMpr setResScal(byte resScal) {
    this.resScal.setValueFromUser(resScal);
    this.optFlag.setBitInPosition(true, RES_SCAL_BIT_NUMBER);
    return this;
  }

  public RecordMpr setLlmScalAndLoLimit(byte llmScal, float loLimit) {
    this.llmScal.setValueFromUser(llmScal);
    this.optFlag.setBitInPosition(true, LLM_SCAL_BIT_NUMBER_1);
    this.optFlag.setBitInPosition(true, LLM_SCAL_BIT_NUMBER_2);
    this.loLimit.setValueFromUser(loLimit);
    this.optFlag.setBitInPosition(true, LO_LIMIT_BIT_NUMBER_1);
    this.optFlag.setBitInPosition(true, LO_LIMIT_BIT_NUMBER_2);
    return this;
  }

  public RecordMpr setHlmScalAndHiLimit(byte hlmScal, float hiLimit) {
    this.hlmScal.setValueFromUser(hlmScal);
    this.optFlag.setBitInPosition(true, HLM_SCAL_BIT_NUMBER_1);
    this.optFlag.setBitInPosition(true, HLM_SCAL_BIT_NUMBER_2);
    this.hiLimit.setValueFromUser(hiLimit);
    this.optFlag.setBitInPosition(true, HI_LIMIT_BIT_NUMBER_1);
    this.optFlag.setBitInPosition(true, HI_LIMIT_BIT_NUMBER_2);
    return this;
  }

  public RecordMpr setStartInAndIncrIn(float startIn, float incrIn) {
    this.startIn.setValueFromUser(startIn);
    this.optFlag.setBitInPosition(true, START_IN_BIT_NUMBER);
    this.incrIn.setValueFromUser(incrIn);
    this.optFlag.setBitInPosition(true, INCR_IN_BIT_NUMBER);
    return this;
  }

  public RecordMpr setRtnIndx(List<Integer> rtnIndx) {
    this.rtnIndx.setValueFromBasicTypeList(rtnIndx);
    return this;
  }

  public RecordMpr setUnits(String units) {
    this.units.setValueFromUser(units);
    return this;
  }

  public RecordMpr setUnitsIn(String unitsIn) {
    this.unitsIn.setValueFromUser(unitsIn);
    return this;
  }

  public RecordMpr setcResmft(String cResmft) {
    this.cResmft.setValueFromUser(cResmft);
    return this;
  }

  public RecordMpr setcLlmfmt(String cLlmfmt) {
    this.cLlmfmt.setValueFromUser(cLlmfmt);
    return this;
  }

  public RecordMpr setcHlmfmt(String cHlmfmt) {
    this.cHlmfmt.setValueFromUser(cHlmfmt);
    return this;
  }

  public RecordMpr setLoSpec(float loSpec) {
    this.loSpec.setValueFromUser(loSpec);
    this.optFlag.setBitInPosition(true, LO_SPEC_BIT_NUMBER);
    return this;
  }

  public RecordMpr setHiSpec(float hiSpec) {
    this.hiSpec.setValueFromUser(hiSpec);
    this.optFlag.setBitInPosition(true, HI_SPEC_BIT_NUMBER);
    return this;
  }
}
