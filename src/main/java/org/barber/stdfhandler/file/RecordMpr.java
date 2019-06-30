package org.barber.stdfhandler.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecordMpr extends Record {

  private static final String NAME = "MPR";
  private static final int TYPE = 15;
  private static final int SUBTYPE = 15;

  private final Type<Long> testNum = new TypeU4("TEST_NUM", null);
  private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM", null);
  private final TypeB1 testFlg = new TypeB1("TEST_FLG", null);
  private final TypeB1 parmFlg = new TypeB1("PARM_FLG", null);
  private final Type<Integer> rtnIcnt = new TypeU2("RTN_ICNT", null);
  private final Type<Integer> rsltCnt = new TypeU2("RSLT_CNT", null);
  private final TypeArray<TypeN1x2, byte[]> rtnStat =
      new TypeArray<>("RTN_STAT", null, TypeN1x2::new, rtnIcnt, TypeU2.MAX_VALUE);
  private final TypeArray<TypeR4, Float> rtnRslt =
      new TypeArray<>("RTN_RSLT", null, TypeR4::new, rsltCnt, TypeU2.MAX_VALUE);
  private final Type<String> testTxt = new TypeCn("TEST_TXT", "");
  private final Type<String> alarmId = new TypeCn("ALARM_ID", "");
  private final TypeB1 optFlag = new TypeB1("OPT_FLAG", null);
  private final Type<Byte> resScal = new TypeI1("RES_SCAL", null);
  private final Type<Byte> llmScal = new TypeI1("LLM_SCAL", null);
  private final Type<Byte> hlmScal = new TypeI1("HLM_SCAL", null);
  private final Type<Float> loLimit = new TypeR4("LO_LIMIT", null);
  private final Type<Float> hiLimit = new TypeR4("HI_LIMIT", null);
  private final Type<Float> startIn = new TypeR4("START_IN", null);
  private final Type<Float> incrIn = new TypeR4("INCR_IN", null);
  private final TypeArray<TypeU2, Integer> rtnIndx =
      new TypeArray<>("RTN_INDX", null, TypeU2::new, rtnIcnt, TypeU2.MAX_VALUE);
  private final Type<String> units = new TypeCn("UNITS", "");
  private final Type<String> unitsIn = new TypeCn("UNITS_IN", "");
  private final Type<String> cResmft = new TypeCn("C_RESFMT", "");
  private final Type<String> cLlmfmt = new TypeCn("C_LLMFMT", "");
  private final Type<String> cHlmfmt = new TypeCn("C_HLMFMT", "");
  private final Type<Float> loSpec = new TypeR4("LO_SPEC", null);
  private final Type<Float> hiSpec = new TypeR4("HI_SPEC", null);

  private RecordMpr() {
    super(NAME, TYPE, SUBTYPE);
    fields.addAll(Arrays.asList(testNum, headNum, siteNum, testFlg, parmFlg, rtnIcnt, rsltCnt, rtnStat, rtnRslt,
        testTxt, alarmId, optFlag, resScal, llmScal, hlmScal, loLimit, hiLimit, startIn, incrIn, rtnIndx, units,
        unitsIn, cResmft, cLlmfmt, cHlmfmt, loSpec, hiSpec));
  }

  public static RecordMpr newInstance() {
    return new RecordMpr();
  }

  @Override
  protected void addToImage(FileImage image) {
    image.addMpr(this);
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

  public Optional<String> getTestFlg() {
    return Optional.ofNullable(testFlg.getValue());
  }

  public Optional<String> getParmFlg() {
    return Optional.ofNullable(parmFlg.getValue());
  }

  public List<byte[]> getRtnStat() {
    return rtnStat.getValue().stream().map(Type::getValue).collect(Collectors.toList());
  }

  public List<Float> getRtnRslt() {
    return rtnRslt.getValue().stream().map(Type::getValue).collect(Collectors.toList());
  }

  public Optional<String> getTestTxt() {
    return Optional.ofNullable(testTxt.getValue());
  }

  public Optional<String> getAlarmId() {
    return Optional.ofNullable(alarmId.getValue());
  }

  public Optional<String> getOptFlag() {
    return Optional.ofNullable(optFlag.getValue());
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
    return rtnIndx.getValue().stream().map(Type::getValue).collect(Collectors.toList());
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


  public RecordMpr setTestNum(long value) {
    testNum.setValueFromUser(value);
    return this;
  }

  public RecordMpr setHeadNum(int value) {
    headNum.setValueFromUser(value);
    return this;
  }

  public RecordMpr setSiteNum(int value) {
    siteNum.setValueFromUser(value);
    return this;
  }

  public RecordMpr setTestFlg(String value) {
    testFlg.setValueFromUser(value);
    return this;
  }

  public RecordMpr setParmFlg(String value) {
    parmFlg.setValueFromUser(value);
    return this;
  }

  public RecordMpr setRtnStat(List<byte[]> value) {
    rtnStat.setValueFromRawType(value);
    return this;
  }

  public RecordMpr setRtnRslt(List<Float> value) {
    rtnRslt.setValueFromRawType(value);
    return this;
  }

  public RecordMpr setTestTxt(String value) {
    testTxt.setValueFromUser(value);
    return this;
  }

  public RecordMpr setAlarmId(String value) {
    alarmId.setValueFromUser(value);
    return this;
  }

  public RecordMpr setOptFlag(String value) {
    optFlag.setValueFromUser(value);
    return this;
  }

  public RecordMpr setResScal(byte value) {
    resScal.setValueFromUser(value);
    return this;
  }

  public RecordMpr setLlmScal(byte value) {
    llmScal.setValueFromUser(value);
    return this;
  }

  public RecordMpr setHlmScal(byte value) {
    hlmScal.setValueFromUser(value);
    return this;
  }

  public RecordMpr setLoLimit(float value) {
    loLimit.setValueFromUser(value);
    return this;
  }

  public RecordMpr setHiLimit(float value) {
    hiLimit.setValueFromUser(value);
    return this;
  }

  public RecordMpr setStartIn(float value) {
    startIn.setValueFromUser(value);
    return this;
  }

  public RecordMpr setIncrIn(float value) {
    incrIn.setValueFromUser(value);
    return this;
  }

  public RecordMpr setRtnIndx(List<Integer> value) {
    rtnIndx.setValueFromRawType(value);
    return this;
  }

  public RecordMpr setUnits(String value) {
    units.setValueFromUser(value);
    return this;
  }

  public RecordMpr setUnitsIn(String value) {
    unitsIn.setValueFromUser(value);
    return this;
  }

  public RecordMpr setcResmft(String value) {
    cResmft.setValueFromUser(value);
    return this;
  }

  public RecordMpr setcLlmfmt(String value) {
    cLlmfmt.setValueFromUser(value);
    return this;
  }

  public RecordMpr setcHlmfmt(String value) {
    cHlmfmt.setValueFromUser(value);
    return this;
  }

  public RecordMpr setLoSpec(float value) {
    loSpec.setValueFromUser(value);
    return this;
  }

  public RecordMpr setHiSpec(float value) {
    hiSpec.setValueFromUser(value);
    return this;
  }
}
