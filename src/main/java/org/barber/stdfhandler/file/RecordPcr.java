package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordPcr extends Record {

    private static final String NAME = "PCR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 30;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
    private final Type<Integer> siteNum = new TypeU1("SITE_NUM");
    private final Type<Long> partCnt = new TypeU4("PART_CNT");
    private final Type<Long> rtstCnt = new TypeU4("RTST_CNT", TypeU4.MAX_VALUE);
    private final Type<Long> abrtCnt = new TypeU4("ABRT_CNT", TypeU4.MAX_VALUE);
    private final Type<Long> goodCnt = new TypeU4("GOOD_CNT", TypeU4.MAX_VALUE);
    private final Type<Long> funcCnt = new TypeU4("FUNC_CNT", TypeU4.MAX_VALUE);

    private RecordPcr() {
        super(NAME, TYPE, SUBTYPE);
        addFields(headNum, siteNum, partCnt, rtstCnt, abrtCnt, goodCnt, funcCnt);
    }

    public static RecordPcr newInstance() {
        return new RecordPcr();
    }

    public Optional<Integer> getHeadNum() {
        return Optional.ofNullable(headNum.getValue());
    }

    public Optional<Integer> getSiteNum() {
        return Optional.ofNullable(siteNum.getValue());
    }

    public Optional<Long> getPartCnt() {
        return Optional.ofNullable(partCnt.getValue());
    }

    public Optional<Long> getRtstCnt() {
        return Optional.ofNullable(rtstCnt.getValue());
    }

    public Optional<Long> getAbrtCnt() {
        return Optional.ofNullable(abrtCnt.getValue());
    }

    public Optional<Long> getGoodCnt() {
        return Optional.ofNullable(goodCnt.getValue());
    }

    public Optional<Long> getFuncCnt() {
        return Optional.ofNullable(funcCnt.getValue());
    }

    public RecordPcr setHeadNum(int headNum) {
        this.headNum.setValueFromUser(headNum);
        return this;
    }

    public RecordPcr setSiteNum(int siteNum) {
        this.siteNum.setValueFromUser(siteNum);
        return this;
    }

    public RecordPcr setPartCnt(long partCnt) {
        this.partCnt.setValueFromUser(partCnt);
        return this;
    }

    public RecordPcr setRtstCnt(long rtstCnt) {
        this.rtstCnt.setValueFromUser(rtstCnt);
        return this;
    }

    public RecordPcr setAbrtCnt(long abrtCnt) {
        this.abrtCnt.setValueFromUser(abrtCnt);
        return this;
    }

    public RecordPcr setGoodCnt(long goodCnt) {
        this.goodCnt.setValueFromUser(goodCnt);
        return this;
    }

    public RecordPcr setFuncCnt(long funcCnt) {
        this.funcCnt.setValueFromUser(funcCnt);
        return this;
    }
}
