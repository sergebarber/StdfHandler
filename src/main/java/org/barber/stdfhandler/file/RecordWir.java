package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordWir extends Record {

    private static final String NAME = "WIR";
    private static final int TYPE = 2;
    private static final int SUBTYPE = 10;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
    private final Type<Integer> siteGrp = new TypeU1("SITE_GRP", 255);
    private final Type<Instant> startT = new TypeTime("START_T", null);
    private final Type<String> waferId = new TypeCn("WAFER_ID", "");

    private RecordWir() {
        super(NAME, TYPE, SUBTYPE);
        fields.addAll(asList(headNum, siteGrp, startT, waferId));
    }

    public static RecordWir newInstance() {
        return new RecordWir();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addWir(this);
    }

    public Optional<Integer> getHeadNum() {
        return Optional.ofNullable(headNum.getValue());
    }

    public Optional<Integer> getSiteGrp() {
        return Optional.ofNullable(siteGrp.getValue());
    }

    public Optional<Instant> getStartT() {
        return Optional.ofNullable(startT.getValue());
    }

    public Optional<String> getWaferId() {
        return Optional.ofNullable(waferId.getValue());
    }


    public RecordWir setHeadNum(Integer value) {
        headNum.setValueFromUser(value);
        return this;
    }

    public RecordWir setSiteGrp(Integer value) {
        siteGrp.setValueFromUser(value);
        return this;
    }

    public RecordWir setStartT(Instant value) {
        startT.setValueFromUser(value);
        return this;
    }

    public RecordWir setWaferId(String value) {
        waferId.setValueFromUser(value);
        return this;
    }
}
