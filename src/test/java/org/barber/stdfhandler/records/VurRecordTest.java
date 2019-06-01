package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.FileBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class VurRecordTest extends RecordTest {

    @Test
    void testUpdNam() throws IOException {
        String value = "Test UPD_NAM";
        testField(new FileBuilder().setVurUpdNam(value), fileImage -> fileImage.getVur().getUpdNam(), value);
    }
}
