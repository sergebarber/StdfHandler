package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.RecordPmr;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordPmrTest extends RecordTest {

    @Test
    void testPmrIndx() throws IOException {
        int expected = "PMR_INDX".codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addRecord(RecordPmr.newInstance().setPmrIndx(expected)),
                fileImage -> fileImage.getPmrs().get(0).getPmrIndx(), expected);
    }

    @Test
    void testChanTyp() throws IOException {
        int expected = "CHAN_TYP".codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addRecord(RecordPmr.newInstance().setChanTyp(expected)),
                fileImage -> fileImage.getPmrs().get(0).getChanTyp(), expected);
    }

    @Test
    void testChanNam() throws IOException {
        String expected = "CHAN_NAM";
        testOptionalField(fileHandler.getBuilder().addRecord(RecordPmr.newInstance().setChanNam(expected)),
                fileImage -> fileImage.getPmrs().get(0).getChanNam(), expected);
    }

    @Test
    void testPhyNam() throws IOException {
        String expected = "PHY_NAM";
        testOptionalField(fileHandler.getBuilder().addRecord(RecordPmr.newInstance().setPhyNam(expected)),
                fileImage -> fileImage.getPmrs().get(0).getPhyNam(), expected);
    }

    @Test
    void testLogNam() throws IOException {
        String expected = "LOG_NAM";
        testOptionalField(fileHandler.getBuilder().addRecord(RecordPmr.newInstance().setLogNam(expected)),
                fileImage -> fileImage.getPmrs().get(0).getLogNam(), expected);
    }

    @Test
    void testHeadNum() throws IOException {
        int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addRecord(RecordPmr.newInstance().setHeadNum(expected)),
                fileImage -> fileImage.getPmrs().get(0).getHeadNum(), expected);
    }

    @Test
    void testsiteNum() throws IOException {
        int expected = "SITE_NUM".substring(0, 1).codePoints().sum();
        testOptionalField(fileHandler.getBuilder().addRecord(RecordPmr.newInstance().setSiteNum(expected)),
                fileImage -> fileImage.getPmrs().get(0).getSiteNum(), expected);
    }
}
