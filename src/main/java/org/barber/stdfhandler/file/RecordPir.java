package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordPir extends Record{

    private static final String NAME = "PIR";
    private static final int TYPE = 5;
    private static final int SUBTYPE = 10;

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
    private final Type<Integer> siteNum = new TypeU1("SITE_NUM");

    private RecordPir() {
        super(NAME, TYPE, SUBTYPE);
        addFields(headNum, siteNum);
    }

    public static RecordPir newInstance() {
        return new RecordPir();
    }

    public Optional<Integer> getHeadNum() {
        return Optional.ofNullable(headNum.getValue());
    }

    public Optional<Integer> getSiteNum() {
        return Optional.ofNullable(siteNum.getValue());
    }

    public RecordPir setHeadNum(Integer value) {
        headNum.setValueFromUser(value);
        return this;
    }

    public RecordPir setSiteNum(Integer value) {
        siteNum.setValueFromUser(value);
        return this;
    }
}
