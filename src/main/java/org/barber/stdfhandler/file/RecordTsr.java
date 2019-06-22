package org.barber.stdfhandler.file;

import java.util.Arrays;
import java.util.Optional;

public class RecordTsr extends Record {

    private static final String NAME = "TSR";
    private static final int TYPE = 10;
    private static final int SUBTYPE = 30;

    private static final int TEST_MIN_FLAG_POSITION = 0;
    private static final int TEST_MAX_FLAG_POSITION = 1;
    private static final int TEST_TIM_FLAG_POSITION = 2;
    private static final int TST_SUMS_FLAG_POSITION = 4;
    private static final int TST_SQRC_FLAG_POSITION = 5;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
    private final Type<Integer> siteNum = new TypeU1("SITE_NUM", null);
    private final Type<Character> testTyp = new TypeC1("TEST_TYP", ' ');
    private final Type<Long> testNum = new TypeU4("TEST_NUM", null);
    private final Type<Long> execCount = new TypeU4("EXEC_CNT", TypeU4.MAX_VALUE);
    private final Type<Long> failCnt = new TypeU4("FAIL_CNT", TypeU4.MAX_VALUE);
    private final Type<Long> alrmCnt = new TypeU4("ALRM_CNT", TypeU4.MAX_VALUE);
    private final Type<String> testNam = new TypeCn("TEST_NAM", "");
    private final Type<String> seqName = new TypeCn("SEQ_NAME", "");
    private final Type<String> testLbl = new TypeCn("TEST_LBL", "");
    private final TypeB1 optFlag = new TypeB1("OPT_FLAG", null);
    private final Type<Float> testTim = new TypeR4("TEST_TIM", null);
    private final Type<Float> testMin = new TypeR4("TEST_MIN", null);
    private final Type<Float> testMax = new TypeR4("TEST_MAX", null);
    private final Type<Float> tstSums = new TypeR4("TST_SUMS", null);
    private final Type<Float> tstSqrc = new TypeR4("TST_SQRS", null);

    private RecordTsr() {
        super(NAME, TYPE, SUBTYPE);
        fields.addAll(Arrays.asList(headNum, siteNum, testTyp, testNum, execCount, failCnt, alrmCnt, testNam, seqName,
                testLbl, optFlag, testTim, testMin, testMax, tstSums, tstSqrc));
    }

    public static RecordTsr newInstance() {
        return new RecordTsr();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addTsr(this);
    }

    public Optional<Integer> getHeadNum() {
        return Optional.ofNullable(headNum.getValue());
    }

    public Optional<Integer> getSiteNum() {
        return Optional.ofNullable(siteNum.getValue());
    }

    public Optional<Character> getTestTyp() {
        return Optional.ofNullable(testTyp.getValue());
    }

    public Optional<Long> getTestNum() {
        return Optional.ofNullable(testNum.getValue());
    }

    public Optional<Long> getExecCnt() {
        return Optional.ofNullable(execCount.getValue());
    }

    public Optional<Long> getFailCnt() {
        return Optional.ofNullable(failCnt.getValue());
    }

    public Optional<Long> getAlrmCnt() {
        return Optional.ofNullable(alrmCnt.getValue());
    }

    public Optional<String> getTestNam() {
        return Optional.ofNullable(testNam.getValue());
    }

    public Optional<String> getSeqName() {
        return Optional.ofNullable(seqName.getValue());
    }

    public Optional<String> getTestLbl() {
        return Optional.ofNullable(testLbl.getValue());
    }

    public Optional<String> getOptFlag() {
        return Optional.ofNullable(optFlag.getValue());
    }

    public Optional<Float> getTestTim() {
        return optFlag.getBitInPosition(TEST_TIM_FLAG_POSITION) ? Optional.of(testTim.getValue()) : Optional.empty();
    }

    public Optional<Float> getTestMin() {
        return optFlag.getBitInPosition(TEST_MIN_FLAG_POSITION) ? Optional.of(testMin.getValue()) : Optional.empty();
    }

    public Optional<Float> getTestMax() {
        return optFlag.getBitInPosition(TEST_MAX_FLAG_POSITION) ? Optional.of(testMax.getValue()) : Optional.empty();
    }

    public Optional<Float> getTstSums() {
        return optFlag.getBitInPosition(TST_SUMS_FLAG_POSITION) ? Optional.of(tstSums.getValue()) : Optional.empty();
    }

    public Optional<Float> getTstSqrc() {
        return optFlag.getBitInPosition(TST_SQRC_FLAG_POSITION) ? Optional.of(tstSqrc.getValue()) : Optional.empty();
    }


    public RecordTsr setHeadNum(int value) {
        headNum.setValueFromUser(value);
        return this;
    }

    public RecordTsr setSiteNum(int value) {
        siteNum.setValueFromUser(value);
        return this;
    }

    public RecordTsr setTestTyp(char value) {
        testTyp.setValueFromUser(value);
        return this;
    }

    public RecordTsr setTestNum(long value) {
        testNum.setValueFromUser(value);
        return this;
    }

    public RecordTsr setExecCnt(long value) {
        execCount.setValueFromUser(value);
        return this;
    }

    public RecordTsr setFailCnt(long value) {
        failCnt.setValueFromUser(value);
        return this;
    }

    public RecordTsr setAlrmCnt(long value) {
        alrmCnt.setValueFromUser(value);
        return this;
    }

    public RecordTsr setTestNam(String value) {
        testNam.setValueFromUser(value);
        return this;
    }

    public RecordTsr setSeqName(String value) {
        seqName.setValueFromUser(value);
        return this;
    }

    public RecordTsr setTestLbl(String testLbl) {
        this.testLbl.setValueFromUser(testLbl);
        return this;
    }

    public RecordTsr setOptFlag(String optFlag) {
        this.optFlag.setValueFromUser(optFlag);
        return this;
    }

    public RecordTsr setTestTim(float testTim) {
        this.testTim.setValueFromUser(testTim);
        this.optFlag.setBitInPosition(true, TEST_TIM_FLAG_POSITION);
        return this;
    }

    public RecordTsr setTestMin(float testMin) {
        this.testMin.setValueFromUser(testMin);
        this.optFlag.setBitInPosition(true, TEST_MIN_FLAG_POSITION);
        return this;
    }

    public RecordTsr setTestMax(float testMax) {
        this.testMax.setValueFromUser(testMax);
        this.optFlag.setBitInPosition(true, TEST_MAX_FLAG_POSITION);
        return this;
    }

    public RecordTsr setTstSums(float tstSums) {
        this.tstSums.setValueFromUser(tstSums);
        this.optFlag.setBitInPosition(true, TST_SUMS_FLAG_POSITION);
        return this;
    }

    public RecordTsr setTstSqrc(float tstSqrc) {
        this.tstSqrc.setValueFromUser(tstSqrc);
        this.optFlag.setBitInPosition(true, TST_SQRC_FLAG_POSITION);
        return this;
    }
}
