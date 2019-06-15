package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordWcrTest extends RecordTest {

    @Test
    void testWafrSiz() throws IOException {
        float expected = (float) "WAFR_SIZ".codePoints().average().orElseThrow();
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setWafrSiz(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getWafrSiz(),
                expected);
    }

    @Test
    void testDieHt() throws IOException {
        float expected = (float) "DIE_HT".codePoints().average().orElseThrow();
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setDieHt(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getDieHt(),
                expected);
    }

    @Test
    void testDieWid() throws IOException {
        float expected = (float) "DIE_WID".codePoints().average().orElseThrow();
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setDieWid(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getDieWid(),
                expected);
    }

    @Test
    void testWfUnits() throws IOException {
        int expected = "WF_UNITS".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setWfUnits(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getWfUnits(),
                expected);
    }

    @Test
    void testWfFlat() throws IOException {
        String expected = "WF_FLAT".substring(2, 3);
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setWfFlat(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getWfFlat(),
                expected);
    }

    @Test
    void testCenterX() throws IOException {
        int expected = "CENTER_X".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setCenterX(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getCenterX(),
                expected);
    }

    @Test
    void testCenterY() throws IOException {
        int expected = "CENTER_Y".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setCenterY(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getCenterY(),
                expected);
    }

    @Test
    void testPosX() throws IOException {
        String expected = "POS_X".substring(3, 4);
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setPosX(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getPosX(),
                expected);
    }

    @Test
    void testPosY() throws IOException {
        String expected = "POS_Y".substring(3, 4);
        testOptionalField(fileHandler.getBuilder().addWaferData(
                WaferData.newInstance().setWcr(RecordWcr.newInstance().setPosY(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWcr().getPosY(),
                expected);
    }

    @Test
    void test() {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(-12));
        s = new StringBuilder(s.substring(16));
        String[] split = s.toString().split("");
        s = new StringBuilder("1");
        for (int i = 1; i < split.length; i++) {
            s.append(split[i].equals("1") ? "0" : "1");
        }
        s.replace(0, 1, "0");
        System.out.println(s);
        System.out.println((-(Integer.parseInt(s.toString(), 2) + 1)));

    }
}
