package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

abstract class Record {

    static final int HEADER_LENGTH = 4;

    private static final String DELIMITER = ": ";
    private static final String NEW_LINE = "\n";
    private static final String TAB = " ".repeat(3);

    private final String name;
    private final int group;
    private final int code;

    List<Type> fields = new ArrayList<>();

    Record(String name, int group, int code) {
        this.name = name;
        this.group = group;
        this.code = code;
    }

    int getGroup() {
        return group;
    }

    int getCode() {
        return code;
    }

    protected abstract void addToImage(FileImage image);

    void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        fields.forEach(field -> field.setValue(bytes));
        addToImage(fileImage);
    }

    ByteArrayOutputStream toBytes() {
        ByteArrayOutputStream fieldsBytes = new ByteArrayOutputStream();
        fields.forEach(field -> fieldsBytes.writeBytes(field.toBytes()));
        return addHeader(fieldsBytes);
    }

    ByteArrayOutputStream addHeader(ByteArrayOutputStream fieldsBytes) {
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
        fields.forEach(t -> builder.append(fieldAsString(t.getName(), t.toString())));
        return builder.toString();
    }

    private static String recordAsString(String name) {
        return name + DELIMITER + NEW_LINE;
    }

    static String fieldAsString(String name, String value) {
        return TAB + name + DELIMITER + value + NEW_LINE;
    }
}
