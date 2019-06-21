package org.barber.stdfhandler.file;

import java.util.EnumSet;
import java.util.function.Supplier;

enum Records {

    FAR(RecordFar::newInstance),
    ATR(RecordAtr::newInstance),
    VUR(RecordVur::newInstance),
    MIR(RecordMir::newInstance),
    SDR(RecordSdr::newInstance),
    RDR(RecordRdr::newInstance),
    PCR(RecordPcr::newInstance),
    HBR(RecordHbr::newInstance),
    SBR(RecordSbr::newInstance),
    PMR(RecordPmr::newInstance),
    PGR(RecordPgr::newInstance),
    PLR(RecordPlr::newInstance),
    WIR(RecordWir::newInstance),
    WCR(RecordWcr::newInstance),
    WRR(RecordWrr::newInstance),
    PIR(RecordPir::newInstance),
    PRR(RecordPrr::newInstance),

    MRR(RecordMrr::newInstance),
    TST(RecordTst::newInstance);

    private Supplier<Record> supplier;

    Records(Supplier<Record> supplier) {
        this.supplier = supplier;
    }

    Record getRecord() {
        return supplier.get();
    }

    private static final EnumSet<Records> records = EnumSet.allOf(Records.class);

    static Record getRecord(int type, int subtype) {

        Records enumInstance = records.stream()
                .filter(record -> record.getRecord().getType() == type)
                .filter(record -> record.getRecord().getSubtype() == subtype)
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        String.format("Unknown combination of record group %d and record type %d", type, subtype)));

        return enumInstance.getRecord();
    }
}
