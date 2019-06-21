package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordWrr extends Record {

    private static final String NAME = "WRR";
    private static final int TYPE = 2;
    private static final int SUBTYPE = 20;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
    private final Type<Integer> siteGrp = new TypeU1("SITE_GRP", 255);
    private final Type<Instant> finishT = new TypeTime("FINISH_T", null);
    private final Type<Long> partCnt = new TypeU4("PART_CNT", null);
    private final Type<Long> rtstCnt = new TypeU4("RTST_CNT", U4_MAX_NULL_VALUE);
    private final Type<Long> abrtCnt = new TypeU4("ABRT_CNT", U4_MAX_NULL_VALUE);
    private final Type<Long> goodCnt = new TypeU4("GOOD_CNT", U4_MAX_NULL_VALUE);
    private final Type<Long> funcCnt = new TypeU4("FUNC_CNT", U4_MAX_NULL_VALUE);
    private final Type<String> waferId = new TypeCn("WAFER_ID", "");
    private final Type<String> fabwfId = new TypeCn("FABWF_ID", "");
    private final Type<String> frameId = new TypeCn("FRAME_ID", "");
    private final Type<String> maskId = new TypeCn("MASK_ID", "");
    private final Type<String> usrDesc = new TypeCn("USR_DESC", "");
    private final Type<String> excDesc = new TypeCn("EXC_DESC", "");

    private RecordWrr() {
        super(NAME, TYPE, SUBTYPE);
        fields.addAll(asList(headNum, siteGrp, finishT, partCnt, rtstCnt, abrtCnt, goodCnt, funcCnt, waferId, fabwfId,
                frameId, maskId, usrDesc, excDesc));
    }

    public static RecordWrr newInstance() {
        return new RecordWrr();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addWrr(this);

    }

    public Optional<Integer> getHeadNum() {
        return Optional.ofNullable(headNum.getValue());
    }

    public Optional<Integer> getSiteGrp() {
        return Optional.ofNullable(siteGrp.getValue());
    }

    public Optional<Instant> getFinishT() {
        return Optional.ofNullable(finishT.getValue());
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

    public Optional<String> getWaferId() {
        return Optional.ofNullable(waferId.getValue());
    }

    public Optional<String> getFabwfId() {
        return Optional.ofNullable(fabwfId.getValue());
    }

    public Optional<String> getFrameId() {
        return Optional.ofNullable(frameId.getValue());
    }

    public Optional<String> getMaskId() {
        return Optional.ofNullable(maskId.getValue());
    }

    public Optional<String> getUsrDesc() {
        return Optional.ofNullable(usrDesc.getValue());
    }

    public Optional<String> getExcDesc() {
        return Optional.ofNullable(excDesc.getValue());
    }

    public RecordWrr setHeadNum(Integer value) {
        headNum.setValueFromUser(value);
        return this;
    }

    public RecordWrr setSiteGrp(Integer value) {
        siteGrp.setValueFromUser(value);
        return this;
    }

    public RecordWrr setFinishT(Instant value) {
        finishT.setValueFromUser(value);
        return this;
    }

    public RecordWrr setPartCnt(Long value) {
        partCnt.setValueFromUser(value);
        return this;
    }

    public RecordWrr setRtstCnt(Long value) {
        rtstCnt.setValueFromUser(value);
        return this;
    }

    public RecordWrr setAbrtCnt(Long value) {
        abrtCnt.setValueFromUser(value);
        return this;
    }

    public RecordWrr setGoodCnt(Long value) {
        goodCnt.setValueFromUser(value);
        return this;
    }

    public RecordWrr setFuncCnt(Long value) {
        funcCnt.setValueFromUser(value);
        return this;
    }

    public RecordWrr setWaferId(String value) {
        waferId.setValueFromUser(value);
        return this;
    }

    public RecordWrr setFabwfId(String value) {
        fabwfId.setValueFromUser(value);
        return this;
    }

    public RecordWrr setFrameId(String value) {
        frameId.setValueFromUser(value);
        return this;
    }

    public RecordWrr setMaskId(String value) {
        maskId.setValueFromUser(value);
        return this;
    }

    public RecordWrr setUsrDesc(String value) {
        usrDesc.setValueFromUser(value);
        return this;
    }

    public RecordWrr setExcDesc(String value) {
        excDesc.setValueFromUser(value);
        return this;
    }
}
