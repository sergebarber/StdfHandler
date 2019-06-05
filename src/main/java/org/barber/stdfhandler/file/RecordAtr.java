package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordAtr extends Record {

    private static final String NAME = "ATR";
    private static final byte TYPE = 0;
    private static final byte CODE = 20;

    private final Type<Instant> modTim = new TypeTime("MOD_TIM");
    private final Type<String> cmdLine = new TypeCn("CMD_LINE");

    RecordAtr() {
        super(NAME, TYPE, CODE);
        fields.add(modTim);
        fields.add(cmdLine);
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addAtr(this);
    }

    public static RecordAtr newInstance() {
        return new RecordAtr();
    }

    public Optional<Instant> getModTim() {
        return Optional.ofNullable(modTim.getValue());
    }

    public Optional<String> getCmdLine() {
        return Optional.ofNullable(cmdLine.getValue());
    }


    public RecordAtr setModTim(Instant value) {
        modTim.setValue(value);
        return this;
    }

    public RecordAtr setCmdLine(String value) {
        cmdLine.setValue(value);
        return this;
    }
}
