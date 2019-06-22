package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordPtrTest extends RecordTest {

    @Test
    void testTestNum() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setTestNum(TYPE_U4_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getTestNum(), TYPE_U4_EXPECTED_VALUE);
    }

    @Test
    void testHeadNum() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setHeadNum(TYPE_U1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getHeadNum(), TYPE_U1_EXPECTED_VALUE);
    }

    @Test
    void testSiteNum() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setSiteNum(TYPE_U1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getSiteNum(), TYPE_U1_EXPECTED_VALUE);
    }

    @Test
    void testTestFlg() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setTestFlg(TYPE_B1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getTestFlg(), TYPE_B1_EXPECTED_VALUE);
    }

    @Test
    void testParmFlg() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setParmFlg(TYPE_B1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getParmFlg(), TYPE_B1_EXPECTED_VALUE);
    }

    @Test
    void testResult() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setResult(TYPE_R4_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getResult(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testTestTxt() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setTestTxt(TYPE_CN_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getTestTxt(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testAlarmId() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setAlarmId(TYPE_CN_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getAlarmId(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testOptFlag() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setOptFlag(TYPE_B1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getOptFlag(), TYPE_B1_EXPECTED_VALUE);
    }

    @Test
    void testResScal() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setResScal(TYPE_I1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getResScal(), TYPE_I1_EXPECTED_VALUE);
    }

    @Test
    void testLimScal() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setLlmScal(TYPE_I1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getLlmScal(), TYPE_I1_EXPECTED_VALUE);
    }

    @Test
    void testHlmScal() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setHlmScal(TYPE_I1_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getHlmScal(), TYPE_I1_EXPECTED_VALUE);
    }

    @Test
    void testLoLimit() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setLoLimit(TYPE_R4_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getLoLimit(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testHiLimit() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setHiLimit(TYPE_R4_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getHiLimit(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testUnits() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setUnits(TYPE_CN_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getUnits(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testcResfmt() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setcResfmt(TYPE_CN_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getcResfmt(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testcLlfmt() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setcLlmft(TYPE_CN_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getcLlmft(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testcHlfmt() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setcHlmft(TYPE_CN_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getcHlmft(), TYPE_CN_EXPECTED_VALUE);
    }

    @Test
    void testLoSpec() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setLoSpec(TYPE_R4_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getLoSpec(), TYPE_R4_EXPECTED_VALUE);
    }

    @Test
    void testHiSpec() throws IOException {
        testOptionalField(
                fileHandler.getBuilder()
                        .addRecord(RecordPir.newInstance())
                        .addRecord(RecordPtr.newInstance().setHiSpec(TYPE_R4_EXPECTED_VALUE))
                        .addRecord(RecordPrr.newInstance()),
                fileImage -> fileImage.getPartData().get(0).getPtrs().get(0).getHiSpec(), TYPE_R4_EXPECTED_VALUE);
    }
}
