package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.RecordAtr;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

class RecordAtrTest extends RecordTest {

    @Test
    void testAtrModTim() throws IOException {
        Instant expected = Instant.ofEpochSecond(1234567890);
        testOptionalField(fileHandler.getBuilder().addRecord(RecordAtr.newInstance().setModTim(expected)),
                fileImage -> fileImage.getAtrs().get(0).getModTim(), expected);
    }

    @Test
    void testAtrCmdLine() throws IOException {
        String expected = "Test CMD_LINE $%$^&&";
        testOptionalField(fileHandler.getBuilder().addRecord(RecordAtr.newInstance().setCmdLine(expected)),
                fileImage -> fileImage.getAtrs().get(0).getCmdLine(), expected);
    }
}
