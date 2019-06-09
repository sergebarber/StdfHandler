package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordHbr extends Record {

    private static final String NAME = "HBR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 40;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
    private final Type<Integer> siteNum = new TypeU1("SITE_NUM", null);
    private final Type<Integer> hbinNum = new TypeU2("HBIN_NUM", null);
    private final Type<Long> hbinCnt = new TypeU4("HBIN_CNT", null);
    private final Type<String> hbinPf = new TypeC1("HBIN_PF", " ");
    private final Type<String> hbinNam = new TypeCn("HBIN_NAM", "");

    private RecordHbr() {
        super(NAME, TYPE, SUBTYPE);
        fields.addAll(asList(headNum, siteNum, hbinNum, hbinCnt, hbinPf, hbinNam));
    }

    public static RecordHbr newInstance() {
        return new RecordHbr();
    }


    @Override
    protected void addToImage(FileImage image) {
        image.addHbr(this);
    }

    public Optional<Integer> getHeadNum() {
        return Optional.ofNullable(headNum.getValue());
    }

    public Optional<Integer> getSiteNum() {
        return Optional.ofNullable(siteNum.getValue());
    }

    public Optional<Integer> getHbinNum() {
        return Optional.ofNullable(hbinNum.getValue());
    }

    public Optional<Long> getHbinCnt() {
        return Optional.ofNullable(hbinCnt.getValue());
    }

    public Optional<String> getHbinPf() {
        return Optional.ofNullable(hbinPf.getValue());
    }

    public Optional<String> getHbinNam() {
        return Optional.ofNullable(hbinNam.getValue());
    }

    public RecordHbr setHeadNum(Integer value) {
        headNum.setValueFromUser(value);
        return this;
    }

    public RecordHbr setSiteNum(Integer value) {
        siteNum.setValueFromUser(value);
        return this;
    }

    public RecordHbr setHbinNum(Integer value) {
        hbinNum.setValueFromUser(value);
        return this;
    }

    public RecordHbr setHbinCnt(Long value) {
        hbinCnt.setValueFromUser(value);
        return this;
    }

    public RecordHbr setHbinPf(String value) {
        hbinPf.setValueFromUser(value);
        return this;
    }

    public RecordHbr setHbinNam(String value) {
        hbinNam.setValueFromUser(value);
        return this;
    }
}
