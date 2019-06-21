package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.RecordWcr;
import org.barber.stdfhandler.file.WaferData;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordWcrTest extends RecordTest {

    @Test
    void testWafrSiz() throws IOException {
        float expected = (float) "WAFR_SIZ".codePoints().average().orElseThrow();
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setWafrSiz(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getWafrSiz(),
                expected);
    }

    @Test
    void testDieHt() throws IOException {
        float expected = (float) "DIE_HT".codePoints().average().orElseThrow();
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setDieHt(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getDieHt(),
                expected);
    }

    @Test
    void testDieWid() throws IOException {
        float expected = (float) "DIE_WID".codePoints().average().orElseThrow();
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setDieWid(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getDieWid(),
                expected);
    }

    @Test
    void testWfUnits() throws IOException {
        int expected = "WF_UNITS".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setWfUnits(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getWfUnits(),
                expected);
    }

    @Test
    void testWfFlat() throws IOException {
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setWfFlat(CHAR_EXPECTED))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getWfFlat(),
                CHAR_EXPECTED);
    }

    @Test
    void testCenterX() throws IOException {
        int expected = "CENTER_X".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setCenterX(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getCenterX(),
                expected);
    }

    @Test
    void testCenterY() throws IOException {
        int expected = "CENTER_Y".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setCenterY(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getCenterY(),
                expected);
    }

    @Test
    void testPosX() throws IOException {
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setPosX(CHAR_EXPECTED))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getPosX(),
                CHAR_EXPECTED);
    }

    @Test
    void testPosY() throws IOException {
        testOptionalField(fileHandler.getBuilder().addWafer(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setPosY(CHAR_EXPECTED))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getPosY(),
                CHAR_EXPECTED);
    }
}
