package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.FileBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FarRecordTest extends RecordTest {

    @Test
    void testFarCpuTyp() throws IOException {
        testField(new FileBuilder(), fileImage -> fileImage.getFar().getCpuTyp(), FileBuilder.DEFAULT_CPU_TYP);

        int cpuTyp = 7;
        testField(new FileBuilder().setFarCpuTyp(cpuTyp), fileImage -> fileImage.getFar().getCpuTyp(), cpuTyp);
    }

    @Test
    void testFarStdfVer() throws IOException {
        testField(new FileBuilder(), fileImage -> fileImage.getFar().getStdfVer(), FileBuilder.DEFAULT_STDF_VER);

        int stdfVer = 3;
        testField(new FileBuilder().setFarStdfVer(stdfVer), fileImage -> fileImage.getFar().getStdfVer(), stdfVer);
    }
}
