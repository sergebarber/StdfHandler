package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordMrr extends Record {

    private static final String NAME = "MRR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 20;

    private final Type<Instant> finishT = new TypeTime("FINISH_T");
    private final Type<Character> dispCod = new TypeC1("DISP_COD", TypeC1.DEFAULT_VALUE);
    private final Type<String> usrDesc = new TypeCn("USR_DESC", TypeCn.DEFAULT_VALUE);
    private final Type<String> excDesc = new TypeCn("EXC_DESC", TypeCn.DEFAULT_VALUE);

    private RecordMrr() {
        super(NAME, TYPE, SUBTYPE);
        addFields(finishT, dispCod, usrDesc, excDesc);
    }

    public static RecordMrr newInstance() {
        return new RecordMrr();
    }

    public Optional<Instant> getFinishT() {
        return Optional.ofNullable(finishT.getValue());
    }

    public Optional<Character> getDispCod() {
        return Optional.ofNullable(dispCod.getValue());
    }

    public Optional<String> getUsrDesc() {
        return Optional.ofNullable(usrDesc.getValue());
    }

    public Optional<String> getExcDesc() {
        return Optional.ofNullable(excDesc.getValue());
    }

    public RecordMrr setFinishT(Instant finishT) {
        this.finishT.setValueFromUser(finishT);
        return this;
    }

    public RecordMrr setDispCod(char dispCod) {
        this.dispCod.setValueFromUser(dispCod);
        return this;
    }

    public RecordMrr setUsrDesc(String usrDesc) {
        this.usrDesc.setValueFromUser(usrDesc);
        return this;
    }

    public RecordMrr setExcDesc(String excDesc) {
        this.excDesc.setValueFromUser(excDesc);
        return this;
    }
}
