package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

public class RecordAtr extends Record {

    private static final String NAME = "ATR";
    private static final byte TYPE = 0;
    private static final byte SUBTYPE = 20;

    private final Type<Instant> modTim = new TypeTime("MOD_TIM");
    private final Type<String> cmdLine = new TypeCn("CMD_LINE");

    private RecordAtr() {
        super(NAME, TYPE, SUBTYPE);
        addFields(modTim, cmdLine);
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

    public RecordAtr setModTim(Instant modTim) {
        this.modTim.setValueFromUser(modTim);
        return this;
    }

    public RecordAtr setCmdLine(String cmdLine) {
        this.cmdLine.setValueFromUser(cmdLine);
        return this;
    }
}
