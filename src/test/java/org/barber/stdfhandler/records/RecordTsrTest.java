package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordTsrTest extends RecordTest {

    @Test
    void testHeadNum() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setHeadNum(TYPE_U1_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getHeadNum(), TYPE_U1_EXPECTED_VALUE);
    }

    @Test
    void testSiteNum() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setSiteNum(TYPE_U1_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getSiteNum(), TYPE_U1_EXPECTED_VALUE);
    }

    @Test
    void testTestTyp() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTestTyp(TYPE_C1_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTestTyp(), TYPE_C1_EXPECTED_VALUE);
    }

    @Test
    void testTestNum() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTestNum(TYPE_U4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTestNum(), TYPE_U4_EXPECTED_VALUE);
    }

    @Test
    void testExecCnt() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setExecCnt(TYPE_U4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getExecCnt(), TYPE_U4_EXPECTED_VALUE);
    }

    @Test
    void testFailCnt() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setFailCnt(TYPE_U4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getFailCnt(), TYPE_U4_EXPECTED_VALUE);
    }

    @Test
    void testAlrmCnt() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setAlrmCnt(TYPE_U4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getAlrmCnt(), TYPE_U4_EXPECTED_VALUE);
    }

    @Test
    void testTestNam() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTestNam(TYPE_CN_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTestNam(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testSeqNam() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setSeqName(TYPE_CN_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getSeqName(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testTestLbl() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTestLbl(TYPE_CN_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTestLbl(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testOptFlg() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setOptFlag(TYPE_B1_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getOptFlag(), TYPE_B1_EXPECTED_VALUE);
    }

    @Test
    void testTestTim() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTestTim(TYPE_R4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTestTim(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testTestMin() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTestMin(TYPE_R4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTestMin(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testTestMax() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTestMax(TYPE_R4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTestMax(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testTstSums() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTstSums(TYPE_R4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTstSums(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testTstSqrc() throws IOException {
        testOptionalField(
                fileHandler.getBuilder().addRecord(RecordTsr.newInstance().setTstSqrc(TYPE_R4_EXPECTED_VALUE)),
                fileImage -> fileImage.getTsrs().get(0).getTstSqrc(), TYPE_R4_EXPECTED_VALUE);
    }
}
