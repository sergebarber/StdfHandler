package org.barber.stdfhandler.file;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {

    private static final int HEADER_RECORD_LENGTH_BYTES = 2;
    private static final int HEADER_RECORD_TYPE_BYTES = 1;
    private static final int HEADER_RECORD_SUBTYPE_BYTES = 1;

    private Logger logger = Logger.getLogger("StdfHandler");

    private ByteConverter byteConverter;
    private List<Record> records = new LinkedList<>();

    private FileHandler(ByteConverter byteConverter) {
        this.byteConverter = byteConverter;
    }

    public static FileHandler newInstance() {
        return new FileHandler(new ByteConverter(IntegerConverter.LITTLE_ENDIAN, FloatingPointConverter.IEEE754b32));
    }

    public static FileHandler newInstance(IntegerConverter integerParser, FloatingPointConverter floatingPointConverter) {
        return new FileHandler(new ByteConverter(integerParser, floatingPointConverter));
    }

    public List<Record> readAsRecordList(InputStream inputStream) throws IOException {
        try {
            while (readRecord(inputStream, records::add)) ;
        } catch (IllegalStateException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }
        return records;
    }

    private boolean readRecord(InputStream inputStream, Consumer<Record> recordHandler) throws IOException {

        if (inputStream.available() == 0) {
            return false;
        }

        int length = byteConverter.bytesToUnsignedInt(new ByteArrayInputStream(
                inputStream.readNBytes(HEADER_RECORD_LENGTH_BYTES)), HEADER_RECORD_LENGTH_BYTES);
        int type = byteConverter.bytesToUnsignedInt(new ByteArrayInputStream(inputStream.readNBytes(HEADER_RECORD_TYPE_BYTES)),
                HEADER_RECORD_TYPE_BYTES);
        int subtype = byteConverter.bytesToUnsignedInt(new ByteArrayInputStream(inputStream.readNBytes(
                HEADER_RECORD_SUBTYPE_BYTES)), HEADER_RECORD_SUBTYPE_BYTES);

        Record record = Record.getRecord(type, subtype);
        record.fill(new ByteArrayInputStream(inputStream.readNBytes(length)), byteConverter);
        recordHandler.accept(record);
        return true;
    }

    public FileBuilder getBuilder() {
        return new FileBuilder(byteConverter);
    }
}
