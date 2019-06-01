package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordVur extends Record {

    private static final String NAME = "VUR";
    private static final int TYPE = 0;
    private static final int CODE = 30;

    private static final String UPD_NAM = "UPD_NAM";

    RecordVur() {
        super(NAME, TYPE, CODE);
        fields.put(UPD_NAM, new TypeCn());
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setVur(this);
    }

    public static RecordVur newInstance() {
        return new RecordVur();
    }

    public Optional<String> getUpdNam() {
        return Optional.ofNullable(TypeString.cast(fields.get(UPD_NAM).getValue()));
    }

    public RecordVur setUpdNam(String value) {
        fields.get(UPD_NAM).setValue(value);
        return this;
    }
}

