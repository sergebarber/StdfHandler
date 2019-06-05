package org.barber.stdfhandler.file;

import java.util.EnumSet;
import java.util.function.Supplier;

enum Records {

    FAR(RecordFar::new),
    ATR(RecordAtr::new),
    VUR(RecordVur::new),
    MIR(RecordMir::new),
    MRR(RecordMrr::new),
    RDR(RecordRdr::new),
    PCR(RecordPcr::new),
    HBR(RecordHbr::new),
    SBR(RecordSbr::new);

    private Supplier<Record> supplier;

    Records(Supplier<Record> supplier) {
        this.supplier = supplier;
    }

    Record getRecord() {
        return supplier.get();
    }

    private static final EnumSet<Records> records = EnumSet.allOf(Records.class);

    static Record getRecord(int group, int code) {

        Records enumInstance = records.stream()
                .filter(record -> record.getRecord().getGroup() == group)
                .filter(record -> record.getRecord().getCode() == code)
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        String.format("Unknown combination of record group %d and record type %d", group, code)));

        return enumInstance.getRecord();
    }
}
