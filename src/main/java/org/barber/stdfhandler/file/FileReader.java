package org.barber.stdfhandler.file;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {

    public FileImage read(InputStream inputStream) throws IOException {
        FileImage file = new FileImage();

        try {
            while (readRecord(inputStream, file));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return file;
    }

    private boolean readRecord(InputStream inputStream, FileImage file) throws IOException {

        byte[] header = inputStream.readNBytes(Record.HEADER_LENGTH);
        if (header.length == 0) return false;

        int recordLength = (int) Type.bytesToValue(new byte[]{header[0], header[1]});
        Record record = Records.getRecord(header[2], Byte.toUnsignedInt(header[3]));

        record.fill(new ByteArrayInputStream(inputStream.readNBytes(recordLength)), file);
        return true;
    }
}
