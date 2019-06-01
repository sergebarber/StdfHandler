package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordAtr extends Record {

    private static final String NAME = "ATR";
    private static final byte TYPE = 0;
    private static final byte CODE = 20;

    private static final String MOD_TIM = "MOD_TIM";
    private static final String CMD_LINE = "CMD_LINE";

    RecordAtr() {
        super(NAME, TYPE, CODE);
        fields.put(MOD_TIM, new TypeTime());
        fields.put(CMD_LINE, new TypeCn());
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addAtr(this);
    }

    public static RecordAtr newIstance() {
        return new RecordAtr();
    }

    public Optional<Instant> getModTim() {
        return Optional.ofNullable(TypeTime.cast(fields.get(MOD_TIM).getValue()));
    }

    public Optional<String> getCmdLine() {
        return Optional.ofNullable(TypeString.cast(fields.get(CMD_LINE).getValue()));
    }


    public RecordAtr setModTim(Instant value) {
        fields.get(MOD_TIM).setValue(value);
        return this;
    }

    public RecordAtr setCmdLine(String value) {
        fields.get(CMD_LINE).setValue(value);
        return this;
    }
}
