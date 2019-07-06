package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordHbr extends Record {

    private static final String NAME = "HBR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 40;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
    private final Type<Integer> siteNum = new TypeU1("SITE_NUM");
    private final Type<Integer> hbinNum = new TypeU2("HBIN_NUM");
    private final Type<Long> hbinCnt = new TypeU4("HBIN_CNT");
    private final Type<Character> hbinPf = new TypeC1("HBIN_PF", TypeC1.DEFAULT_VALUE);
    private final Type<String> hbinNam = new TypeCn("HBIN_NAM", TypeCn.DEFAULT_VALUE);

    private RecordHbr() {
        super(NAME, TYPE, SUBTYPE);
        addFields(headNum, siteNum, hbinNum, hbinCnt, hbinPf, hbinNam);
    }

    public static RecordHbr newInstance() {
        return new RecordHbr();
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

    public Optional<Character> getHbinPf() {
        return Optional.ofNullable(hbinPf.getValue());
    }

    public Optional<String> getHbinNam() {
        return Optional.ofNullable(hbinNam.getValue());
    }

    public RecordHbr setHeadNum(int headNum) {
        this.headNum.setValueFromUser(headNum);
        return this;
    }

    public RecordHbr setSiteNum(int siteNum) {
        this.siteNum.setValueFromUser(siteNum);
        return this;
    }

    public RecordHbr setHbinNum(int hbinNum) {
        this.hbinNum.setValueFromUser(hbinNum);
        return this;
    }

    public RecordHbr setHbinCnt(long hbinCnt) {
        this.hbinCnt.setValueFromUser(hbinCnt);
        return this;
    }

    public RecordHbr setHbinPf(char hbinPf) {
        this.hbinPf.setValueFromUser(hbinPf);
        return this;
    }

    public RecordHbr setHbinNam(String hbinNam) {
        this.hbinNam.setValueFromUser(hbinNam);
        return this;
    }
}
