package org.barber.stdfhandler.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

class RecordAtrTest extends RecordTest {

    @Test
    void testAtrModTim() throws IOException {
        Instant expected = Instant.ofEpochSecond(1234567890);
        testOptionalField(new FileBuilder().addRecord(RecordAtr.newInstance().setModTim(expected)),
                fileImage -> fileImage.getAtrs().get(0).getModTim(), expected);
    }

    @Test
    void testAtrCmdLine() throws IOException {
        String expected = "Test CMD_LINE $%$^&&";
        testOptionalField(new FileBuilder().addRecord(RecordAtr.newInstance().setCmdLine(expected)),
                fileImage -> fileImage.getAtrs().get(0).getCmdLine(), expected);
    }
}
