package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.RecordWrr;
import org.barber.stdfhandler.file.WaferData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

class RecordWrrTest extends RecordTest {

    @Test
    void testHeadNum() throws IOException {
        int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setHeadNum(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getHeadNum(),
                expected);
    }

    @Test
    void testSiteGrp() throws IOException {
        int expected = "SITE_GRP".substring(0, 1).codePoints().sum();
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setSiteGrp(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getSiteGrp(),
                expected);
    }

    @Test
    void testFinishT() throws IOException {
        Instant expected = Instant.ofEpochSecond("FINISH_T".substring(0, 1).codePoints().sum());
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setFinishT(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getFinishT(),
                expected);
    }

    @Test
    void testPartCnt() throws IOException {
        Long expected = "PART_CNT".substring(0, 1).codePoints().asLongStream().sum();
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setPartCnt(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getPartCnt(),
                expected);
    }

    @Test
    void testRtstCnt() throws IOException {
        Long expected = "RTST_CNT".substring(0, 1).codePoints().asLongStream().sum();
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setRtstCnt(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getRtstCnt(),
                expected);
    }

    @Test
    void testAbrtCnt() throws IOException {
        Long expected = "ABRT_CNT".substring(0, 1).codePoints().asLongStream().sum();
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setAbrtCnt(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getAbrtCnt(),
                expected);
    }

    @Test
    void testGoodCnt() throws IOException {
        Long expected = "GOOD_CNT".substring(0, 1).codePoints().asLongStream().sum();
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setGoodCnt(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getGoodCnt(),
                expected);
    }

    @Test
    void testFuncCnt() throws IOException {
        Long expected = "FUNC_CNT".substring(0, 1).codePoints().asLongStream().sum();
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setFuncCnt(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getFuncCnt(),
                expected);
    }

    @Test
    void testWaferId() throws IOException {
        String expected = "WAFER_ID";
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setWaferId(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getWaferId(),
                expected);
    }

    @Test
    void testFabwfId() throws IOException {
        String expected = "FABWF_ID";
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setFabwfId(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getFabwfId(),
                expected);
    }

    @Test
    void testFrameId() throws IOException {
        String expected = "FRAME_ID";
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setFrameId(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getFrameId(),
                expected);
    }

    @Test
    void testMaskId() throws IOException {
        String expected = "MASK_ID";
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setMaskId(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getMaskId(),
                expected);
    }

    @Test
    void testUserDesc() throws IOException {
        String expected = "USR_DESC";
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setUsrDesc(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getUsrDesc(),
                expected);
    }

    @Test
    void testExcDesc() throws IOException {
        String expected = "EXC_DESC";
        testOptionalField(
                new FileBuilder().addWaferData(
                        WaferData.newInstance().setWrr(
                                RecordWrr.newInstance().setExcDesc(expected))),
                fileImage -> fileImage.getWaferData().get(0).getWrr().getExcDesc(),
                expected);
    }
}
