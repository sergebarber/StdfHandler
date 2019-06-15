package org.barber.stdfhandler.file;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileHandler {

    private static final int HEADER_RECORD_LENGTH_BYTES = 2;
    private static final int HEADER_RECORD_TYPE_BYTES = 1;
    private static final int HEADER_RECORD_SUBTYPE_BYTES = 1;

    private ByteConverter byteConverter;

    private FileHandler(ByteConverter byteConverter) {
        this.byteConverter = byteConverter;
    }

    public static FileHandler newInstance() {
        return new FileHandler(new ByteConverter(IntegerConverter.LITTLE_ENDIAN, FloatingPointConverter.IEEE754));
    }

    public static FileHandler newInstance(IntegerConverter integerParser, FloatingPointConverter floatingPointConverter) {
        return new FileHandler(new ByteConverter(integerParser, floatingPointConverter));
    }

    public FileImage read(InputStream inputStream) throws IOException {
        FileImage file = new FileImage();

        try {
            while (readRecord(inputStream, file)) ;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return file;
    }

    public FileBuilder getBuilder() {
        return new FileBuilder(byteConverter);
    }

    private boolean readRecord(InputStream inputStream, FileImage file) throws IOException {

        if (inputStream.available() == 0) {
            return false;
        }

        int length = byteConverter.bytesToUnsignedInt(new ByteArrayInputStream(
                inputStream.readNBytes(HEADER_RECORD_LENGTH_BYTES)), HEADER_RECORD_LENGTH_BYTES);
        int type = byteConverter.bytesToUnsignedInt(new ByteArrayInputStream(inputStream.readNBytes(HEADER_RECORD_TYPE_BYTES)),
                HEADER_RECORD_TYPE_BYTES);
        int subtype = byteConverter.bytesToUnsignedInt(new ByteArrayInputStream(inputStream.readNBytes(
                HEADER_RECORD_SUBTYPE_BYTES)), HEADER_RECORD_SUBTYPE_BYTES);

        Record record = Records.getRecord(type, subtype);
        record.fill(new ByteArrayInputStream(inputStream.readNBytes(length)), byteConverter, file);
        return true;
    }
}
