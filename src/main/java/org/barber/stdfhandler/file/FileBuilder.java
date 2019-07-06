package org.barber.stdfhandler.file;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

public class FileBuilder {

  public static final int DEFAULT_CPU_TYP = 2;
  public static final int DEFAULT_STDF_VER = 4;

  private final List<Record> records = new LinkedList<>();
  private final ByteConverter byteConverter;

  public ByteArrayOutputStream toStream() {
    List<ByteArrayOutputStream> outputStreams = new LinkedList<>();
    records.forEach(record -> outputStreams.add(record.toBytes(byteConverter)));

    int length = outputStreams.stream().mapToInt(ByteArrayOutputStream::size).sum();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(length);
    outputStreams.forEach(stream -> outputStream.writeBytes(stream.toByteArray()));
    return outputStream;
  }

  FileBuilder(ByteConverter byteConverter) {
    this(byteConverter, RecordFar.newInstance().setCpuTyp(DEFAULT_CPU_TYP).setStdfVer(DEFAULT_STDF_VER));
  }

  FileBuilder(ByteConverter byteConverter, RecordFar recordFar) {
    this.byteConverter = byteConverter;
    this.records.add(recordFar);
  }

  public FileBuilder addRecord(Record record) {
    records.add(record);
    return this;
  }
}
