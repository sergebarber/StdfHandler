package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordFar extends Record {

    private static final String NAME = "FAR";
    private static final int TYPE = 0;
    private static final int CODE = 10;

    private final Type<Integer> cpuTyp = new TypeU1("CPU_TYP");
    private final Type<Integer> stdfVer = new TypeU1("STDF_VER");

    RecordFar() {
        super(NAME, TYPE, CODE);
        fields.add(cpuTyp);
        fields.add(stdfVer);
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setFar(this);
    }

    public static RecordFar newInstance() {
        return new RecordFar();
    }

    public Optional<Integer> getCpuTyp() {
        return Optional.ofNullable(cpuTyp.getValue());
    }

    public Optional<Integer> getStdfVer() {
        return Optional.ofNullable(stdfVer.getValue());
    }

    public RecordFar setCpuTyp(int value) {
        cpuTyp.setValue(value);
        return this;
    }

    public RecordFar setStdfVer(int value) {
        stdfVer.setValue(value);
        return this;
    }
}
