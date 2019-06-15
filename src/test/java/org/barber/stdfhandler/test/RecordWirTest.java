package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.RecordWir;
import org.barber.stdfhandler.file.WaferData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

class RecordWirTest extends RecordTest {

    @Test
    void testHeadNum() throws IOException {
        int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
        testOptionalField(
                fileHandler.getBuilder().addWaferData(
                        WaferData.newInstance().setWir(
                                RecordWir.newInstance().setHeadNum(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWir().getHeadNum(),
                expected);
    }

    @Test
    void testSiteGrp() throws IOException {
        int expected = "SITE_GRP".substring(0, 1).codePoints().sum();
        testOptionalField(
                fileHandler.getBuilder().addWaferData(
                        WaferData.newInstance().setWir(
                                RecordWir.newInstance().setSiteGrp(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWir().getSiteGrp(),
                expected);
    }

    @Test
    void testStartT() throws IOException {
        Instant expected = Instant.ofEpochSecond("START_T".codePoints().sum());
        testOptionalField(
                fileHandler.getBuilder().addWaferData(
                        WaferData.newInstance().setWir(
                                RecordWir.newInstance().setStartT(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWir().getStartT(),
                expected);
    }

    @Test
    void testWaferId() throws IOException {
        String expected = "WAFER_ID";
        testOptionalField(
                fileHandler.getBuilder().addWaferData(
                        WaferData.newInstance().setWir(
                                RecordWir.newInstance().setWaferId(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWir().getWaferId(),
                expected);
    }
}
