package org.barber.stdfhandler.file;

import java.util.Arrays;
import java.util.Optional;

public class RecordWcr extends Record {

    private static final String NAME = "WCR";
    private static final int TYPE = 2;
    private static final int SUBTYPE = 30;

    private final Type<Float> wafrSiz = new TypeR4("WAFR_SIZ", 0f);
    private final Type<Float> dieHt = new TypeR4("DIE_HT", 0f);
    private final Type<Float> dieWid = new TypeR4("DIE_WID", 0f);
    private final Type<Integer> wfUnits = new TypeU1("WF_UNITS", 0);
    private final Type<Character> wfFlat = new TypeC1("WF_FLAT", ' ');
    private final Type<Integer> centerX = new TypeI2("CENTER_X", TypeI2.MIN_VALUE);
    private final Type<Integer> centerY = new TypeI2("CENTER_Y", TypeI2.MIN_VALUE);
    private final Type<Character> posX = new TypeC1("POS_X", ' ');
    private final Type<Character> posY = new TypeC1("POS_Y", ' ');

    private RecordWcr() {
        super(NAME, TYPE, SUBTYPE);
        fields.addAll(Arrays.asList(wafrSiz, dieHt, dieWid, wfUnits, wfFlat, centerX, centerY, posX, posY));
    }

    public static RecordWcr newInstance() {
        return new RecordWcr();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addWcr(this);
    }

    public Optional<Float> getWafrSiz() {
        return Optional.ofNullable(wafrSiz.getValue());
    }

    public Optional<Float> getDieHt() {
        return Optional.ofNullable(dieHt.getValue());
    }

    public Optional<Float> getDieWid() {
        return Optional.ofNullable(dieWid.getValue());
    }

    public Optional<Integer> getWfUnits() {
        return Optional.ofNullable(wfUnits.getValue());
    }

    public Optional<Character> getWfFlat() {
        return Optional.ofNullable(wfFlat.getValue());
    }

    public Optional<Integer> getCenterX() {
        return Optional.ofNullable(centerX.getValue());
    }

    public Optional<Integer> getCenterY() {
        return Optional.ofNullable(centerY.getValue());
    }

    public Optional<Character> getPosX() {
        return Optional.ofNullable(posX.getValue());
    }

    public Optional<Character> getPosY() {
        return Optional.ofNullable(posY.getValue());
    }


    public RecordWcr setWafrSiz(Float value) {
        wafrSiz.setValueFromUser(value);
        return this;
    }

    public RecordWcr setDieHt(Float value) {
        dieHt.setValueFromUser(value);
        return this;
    }

    public RecordWcr setDieWid(Float value) {
        dieWid.setValueFromUser(value);
        return this;
    }

    public RecordWcr setWfUnits(Integer value) {
        wfUnits.setValueFromUser(value);
        return this;
    }

    public RecordWcr setWfFlat(char value) {
        wfFlat.setValueFromUser(value);
        return this;
    }

    public RecordWcr setCenterX(Integer value) {
        centerX.setValueFromUser(value);
        return this;
    }

    public RecordWcr setCenterY(Integer value) {
        centerY.setValueFromUser(value);
        return this;
    }

    public RecordWcr setPosX(char value) {
        posX.setValueFromUser(value);
        return this;
    }

    public RecordWcr setPosY(char value) {
        posY.setValueFromUser(value);
        return this;
    }
}
