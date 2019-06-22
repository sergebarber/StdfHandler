package org.barber.stdfhandler.file;

import java.util.Arrays;
import java.util.Optional;

public class RecordPtr extends Record {

    private static final String NAME = "PTR";
    private static final int TYPE = 15;
    private static final int SUBTYPE = 10;

    private static final int RES_SCAL_FLAG_POSITION = 0;
    private static final int LLM_SCAL_FLAG_POSITION1 = 4;
    private static final int LLM_SCAL_FLAG_POSITION2 = 6;
    private static final int HLM_SCAL_FLAG_POSITION1 = 5;
    private static final int HLM_SCAL_FLAG_POSITION2 = 7;
    private static final int LO_LIMIT_FLAG_POSITION1 = 4;
    private static final int LO_LIMIT_FLAG_POSITION2 = 6;
    private static final int HI_LIMIT_FLAG_POSITION1 = 5;
    private static final int HI_LIMIT_FLAG_POSITION2 = 7;
    private static final int LO_SPEC_FLAG_POSITION = 2;
    private static final int HI_SPEC_FLAG_POSITION = 3;

    private final Type<Long> testNum = new TypeU4("TEST_NUM", null);
    private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
    private final Type<Integer> siteNum = new TypeU1("SITE_NUM", null);
    private final TypeB1 testFlg = new TypeB1("TEST_FLG", null);
    private final TypeB1 parmFlg = new TypeB1("PARM_FLG", null);
    private final Type<Float> result = new TypeR4("RESULT", null);
    private final Type<String> testTxt = new TypeCn("TEST_TXT", "");
    private final Type<String> alarmId = new TypeCn("ALARM_ID", "");
    private final TypeB1 optflag = new TypeB1("OPT_FLAG", null);
    private final Type<Byte> resScal = new TypeI1("RES_SCAL", null);
    private final Type<Byte> llmScal = new TypeI1("LLM_SCAL", null);
    private final Type<Byte> hlmScal = new TypeI1("HLM_SCAL", null);
    private final Type<Float> loLimit = new TypeR4("LO_LIMIT", null);
    private final Type<Float> hiLimit = new TypeR4("HI_LIMIT", null);
    private final Type<String> units = new TypeCn("UNITS", "");
    private final Type<String> cResfmt = new TypeCn("C_RESFMT", "");
    private final Type<String> cLlmft = new TypeCn("C_LLMFMT", "");
    private final Type<String> cHlmfmt = new TypeCn("C_HLMFMT", "");
    private final Type<Float> loSpec = new TypeR4("LO_SPEC", null);
    private final Type<Float> hiSpec = new TypeR4("HI_SPEC", null);

    private RecordPtr() {
        super(NAME, TYPE, SUBTYPE);
        fields.addAll(Arrays.asList(testNum, headNum, siteNum, testFlg, parmFlg, result, testTxt, alarmId, optflag,
                resScal, llmScal, hlmScal, loLimit, hiLimit, units, cResfmt, cLlmft, cHlmfmt, loSpec, hiSpec));
    }

    public static RecordPtr newInstance() {
        return new RecordPtr();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addPtr(this);
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

    public Optional<Float> getResult() {
        return Optional.ofNullable(result.getValue());
    }

    public Optional<String> getTestTxt() {
        return Optional.ofNullable(testTxt.getValue());
    }

    public Optional<String> getAlarmId() {
        return Optional.ofNullable(alarmId.getValue());
    }

    public Optional<String> getOptFlag() {
        return Optional.ofNullable(optflag.getValue());
    }

    public Optional<Byte> getResScal() {
        return optflag.getBitInPosition(RES_SCAL_FLAG_POSITION) ? Optional.of(resScal.getValue()) : Optional.empty();
    }

    public Optional<Byte> getLlmScal() {
        return optflag.getBitInPosition(LLM_SCAL_FLAG_POSITION1) && optflag.getBitInPosition(LLM_SCAL_FLAG_POSITION2)
                ? Optional.of(llmScal.getValue()) : Optional.empty();
    }

    public Optional<Byte> getHlmScal() {
        return optflag.getBitInPosition(HLM_SCAL_FLAG_POSITION1) && optflag.getBitInPosition(HLM_SCAL_FLAG_POSITION2)
                ? Optional.of(hlmScal.getValue()) : Optional.empty();
    }

    public Optional<Float> getLoLimit() {
        return optflag.getBitInPosition(LO_LIMIT_FLAG_POSITION1) && optflag.getBitInPosition(LO_LIMIT_FLAG_POSITION2)
                ? Optional.of(loLimit.getValue()) : Optional.empty();
    }

    public Optional<Float> getHiLimit() {
        return optflag.getBitInPosition(HI_LIMIT_FLAG_POSITION1) && optflag.getBitInPosition(HI_LIMIT_FLAG_POSITION2)
                ? Optional.of(hiLimit.getValue()) : Optional.empty();
    }

    public Optional<String> getUnits() {
        return Optional.ofNullable(units.getValue());
    }

    public Optional<String> getcResfmt() {
        return Optional.ofNullable(cResfmt.getValue());
    }

    public Optional<String> getcLlmft() {
        return Optional.ofNullable(cLlmft.getValue());
    }

    public Optional<String> getcHlmft() {
        return Optional.ofNullable(cHlmfmt.getValue());
    }

    public Optional<Float> getLoSpec() {
        return optflag.getBitInPosition(LO_SPEC_FLAG_POSITION) ? Optional.of(loSpec.getValue()) : Optional.empty();
    }

    public Optional<Float> getHiSpec() {
        return optflag.getBitInPosition(HI_SPEC_FLAG_POSITION) ? Optional.of(hiSpec.getValue()) : Optional.empty();
    }

    public RecordPtr setTestNum(long testNum) {
        this.testNum.setValueFromUser(testNum);
        return this;
    }

    public RecordPtr setHeadNum(int headNum) {
        this.headNum.setValueFromUser(headNum);
        return this;
    }

    public RecordPtr setSiteNum(int siteNum) {
        this.siteNum.setValueFromUser(siteNum);
        return this;
    }

    public RecordPtr setTestFlg(String testFlg) {
        this.testFlg.setValueFromUser(testFlg);
        return this;
    }

    public RecordPtr setParmFlg(String parmFlg) {
        this.parmFlg.setValueFromUser(parmFlg);
        return this;
    }

    public RecordPtr setResult(float result) {
        this.result.setValueFromUser(result);
        return this;
    }

    public RecordPtr setTestTxt(String testTxt) {
        this.testTxt.setValueFromUser(testTxt);
        return this;
    }

    public RecordPtr setAlarmId(String alarmId) {
        this.alarmId.setValueFromUser(alarmId);
        return this;
    }

    public RecordPtr setOptFlag(String optflag) {
        this.optflag.setValueFromUser(optflag);
        return this;
    }

    public RecordPtr setResScal(byte resScal) {
        this.resScal.setValueFromUser(resScal);
        this.optflag.setBitInPosition(true, RES_SCAL_FLAG_POSITION);
        return this;
    }

    public RecordPtr setLlmScal(byte llmScal) {
        this.llmScal.setValueFromUser(llmScal);
        this.optflag.setBitInPosition(true, LLM_SCAL_FLAG_POSITION1);
        this.optflag.setBitInPosition(true, LLM_SCAL_FLAG_POSITION2);
        return this;
    }

    public RecordPtr setHlmScal(byte hlmScal) {
        this.hlmScal.setValueFromUser(hlmScal);
        this.optflag.setBitInPosition(true, HLM_SCAL_FLAG_POSITION1);
        this.optflag.setBitInPosition(true, HLM_SCAL_FLAG_POSITION2);
        return this;
    }

    public RecordPtr setLoLimit(float loLimit) {
        this.loLimit.setValueFromUser(loLimit);
        this.optflag.setBitInPosition(true, LO_LIMIT_FLAG_POSITION1);
        this.optflag.setBitInPosition(true, LO_LIMIT_FLAG_POSITION2);
        return this;
    }

    public RecordPtr setHiLimit(float hiLimit) {
        this.hiLimit.setValueFromUser(hiLimit);
        this.optflag.setBitInPosition(true, HI_LIMIT_FLAG_POSITION1);
        this.optflag.setBitInPosition(true, HI_LIMIT_FLAG_POSITION2);
        return this;
    }

    public RecordPtr setUnits(String units) {
        this.units.setValueFromUser(units);
        return this;
    }

    public RecordPtr setcResfmt(String cResfmt) {
        this.cResfmt.setValueFromUser(cResfmt);
        return this;
    }

    public RecordPtr setcLlmft(String cLlmft) {
        this.cLlmft.setValueFromUser(cLlmft);
        return this;
    }

    public RecordPtr setcHlmft(String cHlmfmt) {
        this.cHlmfmt.setValueFromUser(cHlmfmt);
        return this;
    }

    public RecordPtr setLoSpec(float loSpec) {
        this.loSpec.setValueFromUser(loSpec);
        this.optflag.setBitInPosition(true, LO_SPEC_FLAG_POSITION);
        return this;
    }

    public RecordPtr setHiSpec(float hiSpec) {
        this.hiSpec.setValueFromUser(hiSpec);
        this.optflag.setBitInPosition(true, HI_SPEC_FLAG_POSITION);
        return this;
    }
}
