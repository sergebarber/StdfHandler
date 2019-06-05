package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordHbr extends Record {

  private static final String NAME = "HBR";
  private static final int GROUP = 1;
  private static final int TYPE = 40;

  private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM");
  private final Type<Integer> hbinNum = new TypeU2("HBIN_NUM");
  private final Type<Long> hbinCnt = new TypeU4("HBIN_CNT");
  private final Type<String> hbinPf = new TypeC1Nl("HBIN_PF");
  private final Type<String> hbinNam = new TypeCnNl("HBIN_NAM");

  RecordHbr() {
    super(NAME, GROUP, TYPE);
    fields.add(headNum);
    fields.add(siteNum);
    fields.add(hbinNum);
    fields.add(hbinCnt);
    fields.add(hbinPf);
    fields.add(hbinNam);
  }

  public static RecordHbr newInstance() {
    return new RecordHbr();
  }


  @Override
  protected void addToImage(FileImage image) {
    image.addHbr(this);
  }

  public Optional<Integer> getHeadNum() {
    return Optional.ofNullable(headNum.getValue());
  }

  public Optional<Integer> getSiteNum() {
    return Optional.ofNullable(siteNum.getValue());
  }

  public Optional<Integer> getHbinNum() {
    return Optional.ofNullable(hbinNum.getValue());
  }

  public Optional<Long> getHbinCnt() {
    return Optional.ofNullable(hbinCnt.getValue());
  }

  public Optional<String> getHbinPf() {
    return Optional.ofNullable(hbinPf.getValue());
  }

  public Optional<String> getHbinNam() {
    return Optional.ofNullable(hbinNam.getValue());
  }

  public RecordHbr setHeadNum(Integer value) {
    headNum.setValue(value);
    return this;
  }

  public RecordHbr setSiteNum(Integer value) {
    siteNum.setValue(value);
    return this;
  }

  public RecordHbr setHbinNum(Integer value) {
    hbinNum.setValue(value);
    return this;
  }

  public RecordHbr setHbinCnt(Long value) {
    hbinCnt.setValue(value);
    return this;
  }

  public RecordHbr setHbinPf(String value) {
    hbinPf.setValue(value);
    return this;
  }

  public RecordHbr setHbinNam(String value) {
    hbinNam.setValue(value);
    return this;
  }
}
