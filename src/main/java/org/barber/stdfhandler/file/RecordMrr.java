package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordMrr extends Record {

    private static final String NAME = "MRR";
    private static final int TYPE = 1;
    private static final int GROUP = 20;

    private final Type<Instant> finishT = new TypeTime("FINISH_T");
    private final Type<String> dispCod = new TypeC1Nl("DISP_COD");
    private final Type<String> usrDesc = new TypeCnNl("USR_DESC");
    private final Type<String> excDesc = new TypeCnNl("EXC_DESC");

    public RecordMrr() {
        super(NAME, TYPE, GROUP);
        fields.add(finishT);
        fields.add(dispCod);
        fields.add(usrDesc);
        fields.add(excDesc);
    }

    public static RecordMrr newInstance() {
        return new RecordMrr();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setMrr(this);
    }

    public Optional<Instant> getFinishT() {
        return Optional.ofNullable(finishT.getValue());
    }

    public Optional<String> getDispCod() {
        return Optional.ofNullable(dispCod.getValue());
    }

    public Optional<String> getUsrDesc() {
        return Optional.ofNullable(usrDesc.getValue());
    }

    public Optional<String> getExcDesc() {
        return Optional.ofNullable(excDesc.getValue());
    }

    public RecordMrr setFinishT(Instant value) {
        finishT.setValue(value);
        return this;
    }

    public RecordMrr setDispCod(String value) {
        dispCod.setValue(value);
        return this;
    }

    public RecordMrr setUsrDesc(String value) {
        usrDesc.setValue(value);
        return this;
    }

    public RecordMrr setExcDesc(String value) {
        excDesc.setValue(value);
        return this;
    }
}
