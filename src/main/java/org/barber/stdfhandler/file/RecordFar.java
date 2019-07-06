package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordFar extends Record {

    private static final String NAME = "FAR";
    static final int TYPE = 0;
    private static final int SUBTYPE = 10;

    private final Type<Integer> cpuTyp = new TypeU1("CPU_TYP");
    private final Type<Integer> stdfVer = new TypeU1("STDF_VER");

    private RecordFar() {
        super(NAME, TYPE, SUBTYPE);
        addFields(cpuTyp, stdfVer);
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

    public RecordFar setCpuTyp(int cpuTyp) {
        this.cpuTyp.setValueFromUser(cpuTyp);
        return this;
    }

    public RecordFar setStdfVer(int stdfVer) {
        this.stdfVer.setValueFromUser(stdfVer);
        return this;
    }
}
