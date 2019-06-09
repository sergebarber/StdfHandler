package org.barber.stdfhandler.test;

import java.io.IOException;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.RecordPcr;
import org.junit.jupiter.api.Test;

class RecordPcrTest extends RecordTest {

  @Test
  void testHeadNum() throws IOException {
    int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordPcr.newInstance().setHeadNum(expected)),
        fileImage -> fileImage.getPcrs().get(0).getHeadNum(), expected);
  }

  @Test
  void testSiteNum() throws IOException {
    int expected = "SITE_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordPcr.newInstance().setSiteNum(expected)),
        fileImage -> fileImage.getPcrs().get(0).getSiteNum(), expected);
  }

  @Test
  void testPartCnt() throws IOException {
    long expected = "PART_CNT".codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordPcr.newInstance().setPartCnt(expected)),
        fileImage -> fileImage.getPcrs().get(0).getPartCnt(), expected);
  }

  @Test
  void testRtstCnt() throws IOException {
    long expected = "RTST_CNT".codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordPcr.newInstance().setRtstCnt(expected)),
        fileImage -> fileImage.getPcrs().get(0).getRtstCnt(), expected);
  }

  @Test
  void testAbrtCnt() throws IOException {
    long expected = "ABRT_CNT".codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordPcr.newInstance().setAbrtCnt(expected)),
        fileImage -> fileImage.getPcrs().get(0).getAbrtCnt(), expected);
  }

  @Test
  void testGoodCnt() throws IOException {
    long expected = "GOOD_CNT".codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordPcr.newInstance().setGoodCnt(expected)),
        fileImage -> fileImage.getPcrs().get(0).getGoodCnt(), expected);
  }

  @Test
  void testFuncCnt() throws IOException {
    long expected = "FUNC_CNT".codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordPcr.newInstance().setFuncCnt(expected)),
        fileImage -> fileImage.getPcrs().get(0).getFuncCnt(), expected);
  }
}
