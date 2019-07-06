package org.barber.stdfhandler.file;


import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

public class FileImage {

    private List<Record> records = new LinkedList<>();

    FileImage() { }

    void addRecord(Record record) {
        records.add(record);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        records.forEach(builder::append);
        return builder.toString();
    }

    ByteArrayOutputStream toStream(ByteConverter byteConverter) {
        List<ByteArrayOutputStream> outputStreams = new LinkedList<>();
        records.forEach(record -> outputStreams.add(record.toBytes(byteConverter)));

        int length = outputStreams.stream().mapToInt(ByteArrayOutputStream::size).sum();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(length);
        outputStreams.forEach(stream -> outputStream.writeBytes(stream.toByteArray()));
        return outputStream;
    }

    public List<Record> getRecords() {
        return records;
    }
}
