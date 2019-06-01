package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordFar extends Record {

    private static final String NAME = "FAR";
    private static final int TYPE = 0;
    private static final int CODE = 10;

    private static final String CPU_TYP = "CPU_TYP";
    private static final String STDF_VER = "STDF_VER";

    RecordFar() {
        super(NAME, TYPE, CODE);
        fields.put(CPU_TYP, new TypeU1());
        fields.put(STDF_VER, new TypeU1());
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setFar(this);
    }

    public Optional<Integer> getCpuTyp() {
        Type type = fields.get(CPU_TYP);
        return Optional.ofNullable(TypeU1.TYPE.cast(type.getValue()));
    }

    public Optional<Integer> getStdfVer() {
        Type type = fields.get(STDF_VER);
        return Optional.ofNullable(TypeU1.TYPE.cast(type.getValue()));
    }

    void setCpuTyp(int cpuTyp) {
        fields.get(CPU_TYP).setValue(cpuTyp);
    }

    void setStdfVer(int stdfVer) {
        fields.get(STDF_VER).setValue(stdfVer);
    }
}
