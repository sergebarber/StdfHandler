package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordVur extends Record {

    private static final String NAME = "VUR";
    private static final int TYPE = 0;
    private static final int SUBTYPE = 30;

    private static final Type<String> updNam = new TypeCn("UPD_NAM", null);

    RecordVur() {
        super(NAME, TYPE, SUBTYPE);
        fields.add(updNam);
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setVur(this);
    }

    public static RecordVur newInstance() {
        return new RecordVur();
    }

    public Optional<String> getUpdNam() {
        return Optional.ofNullable(updNam.getValue());
    }

    public RecordVur setUpdNam(String value) {
        updNam.setValueFromUser(value);
        return this;
    }
}

