package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Record {

    private static final String RECORD_DELIMITER = "_".repeat(30) + "\n";
    private static final String FIELD_FORMAT = "%s%-12s %s%s";
    private static final String DELIMITER = ":";
    private static final String NEW_LINE = "\n";
    private static final String TAB = " ".repeat(3);

    public static final String ARRAYS_UNEQUAL_SIZES_MESSAGE
            = "Illegal list arguments sizes: all list should be of equal size";

    private static final EnumSet<Records> records = EnumSet.allOf(Records.class);

    private final String name;
    private final int type;
    private final int subtype;

    private List<Type> fields = new ArrayList<>();

    Record(String name, int type, int subtype) {
        this.name = name;
        this.type = type;
        this.subtype = subtype;
    }

    int getType() {
        return type;
    }

    int getSubtype() {
        return subtype;
    }

    void addFields(Type... fields) {
        this.fields.addAll(Arrays.asList(fields));
    }

    void fill(ByteArrayInputStream bytes, ByteConverter byteConverter) throws IOException {
        for (Type field : fields) {
            field.setValueFromStream(bytes, byteConverter);
        }
    }

    ByteArrayOutputStream toBytes(ByteConverter byteConverter) {
        ByteArrayOutputStream fieldsBytes = new ByteArrayOutputStream();
        fields.forEach(field -> fieldsBytes.writeBytes(field.toBytes(byteConverter)));
        return addHeader(fieldsBytes, byteConverter);
    }

    private ByteArrayOutputStream addHeader(ByteArrayOutputStream fieldsBytes, ByteConverter byteConverter) {
        ByteArrayOutputStream recordOutputStream = new ByteArrayOutputStream();
        recordOutputStream.writeBytes(getHeaderBytes(fieldsBytes.size(), byteConverter));
        recordOutputStream.writeBytes(fieldsBytes.toByteArray());
        return recordOutputStream;
    }

    private byte[] getHeaderBytes(int length, ByteConverter byteConverter) {
        byte[] recordLength = byteConverter.toBytes(length, ByteConverter.L2BYTES_BINARY_STRING_FORMAT);
        return new byte[]{
                recordLength[0],
                recordLength[1],
                byteConverter.toBytes(type, ByteConverter.L1BYTE_BINARY_STRING_FORMAT)[0],
                byteConverter.toBytes(subtype, ByteConverter.L1BYTE_BINARY_STRING_FORMAT)[0]
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(recordAsString(name));
        fields.forEach(t -> builder.append(fieldAsString(t.getName(), t.toString())));
        return builder.toString();
    }

    private static String recordAsString(String name) {
        return RECORD_DELIMITER + name + DELIMITER + NEW_LINE;
    }

    private static String fieldAsString(String name, String value) {
        return String.format(FIELD_FORMAT, TAB, name + DELIMITER, value, NEW_LINE);
    }

    static Supplier<Boolean> checkFlag(TypeB1 flagField, int position) {
        return () -> !flagField.getBitInPosition(position);
    }

    static Record getRecord(int type, int subtype) {

        Records enumInstance = records.stream()
                .filter(record -> record.getRecord().getType() == type)
                .filter(record -> record.getRecord().getSubtype() == subtype)
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        String.format("Unknown combination of record group %d and record type %d", type, subtype)));

        return enumInstance.getRecord();
    }

    private enum Records {

        FAR(RecordFar::newInstance),
        ATR(RecordAtr::newInstance),
        //    VUR(RecordVur::newInstance),
        MIR(RecordMir::newInstance),
        //    SDR(RecordSdr::newInstance),
//    RDR(RecordRdr::newInstance),
        PCR(RecordPcr::newInstance),
        HBR(RecordHbr::newInstance),
        //    SBR(RecordSbr::newInstance),
        PMR(RecordPmr::newInstance),
        PGR(RecordPgr::newInstance),
        PLR(RecordPlr::newInstance),
        //    WIR(RecordWir::newInstance),
//    WCR(RecordWcr::newInstance),
//    WRR(RecordWrr::newInstance),
        PIR(RecordPir::newInstance),
        //    PTR(RecordPtr::newInstance),
//    FTR(RecordFtr::newInstance),
        MPR(RecordMpr::newInstance),
        BPS(RecordBps::newInstance),
        EPS(RecordEps::newInstance),
        FTR(RecordFtr::newInstance),
        PRR(RecordPrr::newInstance),
        //
//    TSR(RecordTsr::newInstance),
        MRR(RecordMrr::newInstance);
//    TST(RecordTst::newInstance);

        private Supplier<Record> supplier;

        Records(Supplier<Record> supplier) {
            this.supplier = supplier;
        }

        Record getRecord() {
            return supplier.get();
        }
    }
}
