package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class Record {

    static final int HEADER_LENGTH = 4;

    private static final String DELIMITER = ": ";
    private static final String NEW_LINE = "\n";
    private static final String TAB = " ".repeat(3);

    private final String name;
    private final int group;
    private final int code;

    Map<String, Type> fields = new LinkedHashMap<>();

    Record(String name, int group, int code) {
        this.name = name;
        this.group = group;
        this.code = code;
    }

    public int getGroup() {
        return group;
    }

    public int getCode() {
        return code;
    }

    protected abstract void addToImage(FileImage image);

    final void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        fields.values().forEach(field -> field.setValue(bytes));
        addToImage(fileImage);
    }

    final ByteArrayOutputStream toBytes() {

        ByteArrayOutputStream fieldsBytes = new ByteArrayOutputStream();
        fields.values().forEach(field -> fieldsBytes.writeBytes(field.toBytes()));

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
                Type.toBytes(group, Type.U1_BINARY_STRING_FORMAT)[0],
                Type.toBytes(code, Type.U1_BINARY_STRING_FORMAT)[0]
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(recordAsString(name));
        fields.forEach((k, v) -> builder.append(fieldAsString(k, v.asString())));
        return builder.toString();
    }

    private static String recordAsString(String name) {
        return name + DELIMITER + NEW_LINE;
    }

    static String fieldAsString(String name, String value) {
        return TAB + name + DELIMITER + value + NEW_LINE;
    }
}
