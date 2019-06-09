package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Record {

    static final int HEADER_LENGTH = 4;

    public static final int U2_MAX_NULL_VALUE = 65535;
    public static final long U4_MAX_NULL_VALUE = 4_294_967_295L;

    private static final String RECORD_DELIMITER = "_".repeat(30) + "\n";
    private static final String FIELD_FORMAT = "%s%-12s %s%s";
    private static final String DELIMITER = ":";
    private static final String NEW_LINE = "\n";
    private static final String TAB = " ".repeat(3);

    private final String name;
    private final int type;
    private final int subtype;

    List<Type> fields = new ArrayList<>();

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

    protected abstract void addToImage(FileImage image);

    void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        fields.forEach(field -> field.setValueFromStream(bytes));
        addToImage(fileImage);
    }

    ByteArrayOutputStream toBytes() {
        ByteArrayOutputStream fieldsBytes = new ByteArrayOutputStream();
        fields.forEach(field -> fieldsBytes.writeBytes(field.toBytes()));
        return addHeader(fieldsBytes);
    }

    private ByteArrayOutputStream addHeader(ByteArrayOutputStream fieldsBytes) {
        ByteArrayOutputStream recordOutputStream = new ByteArrayOutputStream();
        recordOutputStream.writeBytes(getHeaderBytes(fieldsBytes.size()));
        recordOutputStream.writeBytes(fieldsBytes.toByteArray());
        return recordOutputStream;
    }

    private byte[] getHeaderBytes(int length) {
        byte[] recordLength = Type.toBytes(length, Type.U2_BINARY_STRING_FORMAT);
        return new byte[]{
                recordLength[0],
                recordLength[1],
                Type.toBytes(type, Type.U1_BINARY_STRING_FORMAT)[0],
                Type.toBytes(subtype, Type.U1_BINARY_STRING_FORMAT)[0]
        };
    }

    List<Type> asList(Type ... fields) {
        return Arrays.asList(fields);
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
        return String.format(FIELD_FORMAT , TAB, name + DELIMITER, value, NEW_LINE );
    }
}
