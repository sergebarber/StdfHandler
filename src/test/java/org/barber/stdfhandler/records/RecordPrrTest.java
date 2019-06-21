package org.barber.stdfhandler.records;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.barber.stdfhandler.file.FileImage;
import org.barber.stdfhandler.file.PartData;
import org.barber.stdfhandler.file.RecordPrr;
import org.junit.jupiter.api.Test;

class RecordPrrTest extends RecordTest {

  @Test
  void testHeadNum() throws IOException {
    int expected = 123;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setHeadNum(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getHeadNum(),
        expected);
  }

  @Test
  void testSiteNum() throws IOException {
    int expected = 123;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setSiteNum(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getSiteNum(),
        expected);
  }

  @Test
  void testPartFlg() throws IOException {
    String expected = "10101011";
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setPartFlg(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getPartFlg(),
        expected);
  }

  @Test
  void testPartFlgBit() throws IOException {
    int expected = 1;
    int position = 3;
    ByteArrayOutputStream outputStream = fileHandler.getBuilder().addPart(PartData.newInstance().setPrr(
        RecordPrr.newInstance().setPartFlgBit(expected, position))).toStream();
    FileImage image = readFile(outputStream);
    assertThat(image.getPartData().get(0).getPrr().getPartFlgBit(position)).isEqualTo(expected);
  }

  @Test
  void testNumTest() throws IOException {
    int expected = 12345;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setNumTest(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getNumTest(),
        expected);
  }

  @Test
  void testHardBin() throws IOException {
    int expected = 12345;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setHardBin(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getHardBin(),
        expected);
  }

  @Test
  void testSoftBin() throws IOException {
    int expected = 12345;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setSoftBin(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getSoftBin(),
        expected);
  }

  @Test
  void testXCoord() throws IOException {
    int expected = -12345;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setXCoord(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getXCoord(),
        expected);
  }

  @Test
  void testYCoord() throws IOException {
    int expected = -12345;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setYCoord(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getYCoord(),
        expected);
  }

  @Test
  void testTestT() throws IOException {
    long expected = 1234567890;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setTestT(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getTestT(),
        expected);
  }

  @Test
  void testPartId() throws IOException {
    String expected = "PART_ID";
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setPartId(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getPartId(),
        expected);
  }

  @Test
  void testPartTxt() throws IOException {
    String expected = "PART_TXT";
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setPartTxt(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getPartTxt(),
        expected);
  }

  @Test
  void testPartFix() throws IOException {
    byte[] expected = {12, 13, 14};
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPrr(RecordPrr.newInstance().setPartFix(expected))),
        fileImage -> fileImage.getPartData().get(0).getPrr().getPartFix(),
        expected);
  }
}
