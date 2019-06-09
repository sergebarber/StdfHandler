package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.RecordSdr;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class RecordSdrTest extends RecordTest {

    @Test
    void testHeadNum() throws IOException {
        int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setHeadNum(expected)),
                fileImage -> fileImage.getSdrs().get(0).getHeadNum(), expected);
    }

    @Test
    void testSiteGrp() throws IOException {
        int expected = "SITE_GRP".substring(0, 1).codePoints().sum();
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setSiteGrp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getSiteGrp(), expected);
    }


    @Test
    void testSiteNum() throws IOException {
        List<Integer> expected = Arrays.asList(123, 124, 125, 126, 127);

        testListField(new FileBuilder().addRecord(RecordSdr.newInstance().setSiteNum(expected)),
                fileImage -> fileImage.getSdrs().get(0).getSiteNum(), expected);
    }

    @Test
    void testHandTyp() throws IOException {
        String expected = "HAND_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setHandTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getHandTyp(), expected);
    }

    @Test
    void testHandId() throws IOException {
        String expected = "HAND_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setHandId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getHandId(), expected);
    }

    @Test
    void testCardTyp() throws IOException {
        String expected = "CARD_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setCardTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getCardTyp(), expected);
    }

    @Test
    void testCardId() throws IOException {
        String expected = "CARD_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setCardId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getCardId(), expected);
    }

    @Test
    void testLoadTyp() throws IOException {
        String expected = "LOAD_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setLoadTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getLoadTyp(), expected);
    }

    @Test
    void testLoadId() throws IOException {
        String expected = "LOAD_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setLoadId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getLoadId(), expected);
    }

    @Test
    void testDibTyp() throws IOException {
        String expected = "DIB_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setDibTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getDibTyp(), expected);
    }

    @Test
    void testDibId() throws IOException {
        String expected = "DIB_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setDibId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getDibId(), expected);
    }

    @Test
    void testCablTyp() throws IOException {
        String expected = "CABL_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setCablTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getCablTyp(), expected);
    }

    @Test
    void testCablId() throws IOException {
        String expected = "CABL_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setCablId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getCablId(), expected);
    }

    @Test
    void testContTyp() throws IOException {
        String expected = "CONT_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setContTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getContTyp(), expected);
    }

    @Test
    void testContId() throws IOException {
        String expected = "CONT_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setContId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getContId(), expected);
    }

    @Test
    void testLasrTyp() throws IOException {
        String expected = "LASR_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setLasrTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getLasrTyp(), expected);
    }

    @Test
    void testLasrId() throws IOException {
        String expected = "LASR_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setLasrId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getLasrId(), expected);
    }

    @Test
    void testExtrTyp() throws IOException {
        String expected = "EXTR_TYP";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setExtrTyp(expected)),
                fileImage -> fileImage.getSdrs().get(0).getExtrTyp(), expected);
    }

    @Test
    void testExtrId() throws IOException {
        String expected = "EXTR_ID";
        testOptionalField(new FileBuilder().addRecord(RecordSdr.newInstance().setExtrId(expected)),
                fileImage -> fileImage.getSdrs().get(0).getExtrId(), expected);
    }
}
