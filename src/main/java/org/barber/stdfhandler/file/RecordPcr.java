package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordPcr extends Record {

    private static final String NAME = "PCR";
    private static final int TYPE = 1;
    private static final int CODE = 30;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
    private final Type<Integer> siteNum = new TypeU1("SITE_NUM");
    private final Type<Long> partCnt = new TypeU4("PART_CNT");
    private final Type<Long> rtstCnt = new TypeU4Nl("RTST_CNT");
    private final Type<Long> abrtCnt = new TypeU4Nl("ABRT_CNT");
    private final Type<Long> goodCnt = new TypeU4Nl("GOOD_CNT");
    private final Type<Long> funcCnt = new TypeU4Nl("FUNC_CNT");

    RecordPcr() {
        super(NAME, TYPE, CODE);
        fields.add(headNum);
        fields.add(siteNum);
        fields.add(partCnt);
        fields.add(rtstCnt);
        fields.add(abrtCnt);
        fields.add(goodCnt);
        fields.add(funcCnt);
    }

    public static RecordPcr newInstance() {
        return new RecordPcr();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addPcr(this);
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

    public RecordPcr setHeadNum(int value) {
        headNum.setValue(value);
        return this;
    }

    public RecordPcr setSiteNum(int value) {
        siteNum.setValue(value);
        return this;
    }

    public RecordPcr setPartCnt(long value) {
        partCnt.setValue(value);
        return this;
    }

    public RecordPcr setRtstCnt(long value) {
        rtstCnt.setValue(value);
        return this;
    }

    public RecordPcr setAbrtCnt(long value) {
        abrtCnt.setValue(value);
        return this;
    }

    public RecordPcr setGoodCnt(long value) {
        goodCnt.setValue(value);
        return this;
    }

    public RecordPcr setFuncCnt(long value) {
        funcCnt.setValue(value);
        return this;
    }
}
