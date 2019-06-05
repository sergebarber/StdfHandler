package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordSbr extends Record {

  private static final String NAME = "SBR";
  private static final int GROUP = 1;
  private static final int TYPE = 50;

  private final Type<Integer> headNum = new TypeU1("HEAD_NUM");
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM");
  private final Type<Integer> sbinNum = new TypeU2("SBIN_NUM");
  private final Type<Long> sbinCnt = new TypeU4("SBIN_CNT");
  private final Type<String> sbinPf = new TypeC1Nl("SBIN_PF");
  private final Type<String> sbinNam = new TypeCnNl("SBIN_NAM");

  RecordSbr() {
    super(NAME, GROUP, TYPE);
    fields.add(headNum);
    fields.add(siteNum);
    fields.add(sbinNum);
    fields.add(sbinCnt);
    fields.add(sbinPf);
    fields.add(sbinNam);
  }

  public static RecordSbr newInstance() {
    return new RecordSbr();
  }

  @Override
  protected void addToImage(FileImage image) {
    image.addSbr(this);
  }

  public Optional<Integer> getHeadNum() {
    return Optional.ofNullable(headNum.getValue());
  }

  public Optional<Integer> getSiteNum() {
    return Optional.ofNullable(siteNum.getValue());
  }

  public Optional<Integer> getSbinNum() {
    return Optional.ofNullable(sbinNum.getValue());
  }

  public Optional<Long> getSbinCnt() {
    return Optional.ofNullable(sbinCnt.getValue());
  }

  public Optional<String> getSbinPf() {
    return Optional.ofNullable(sbinPf.getValue());
  }

  public Optional<String> getSbinNam() {
    return Optional.ofNullable(sbinNam.getValue());
  }

  public RecordSbr setHeadNum(int value) {
    headNum.setValue(value);
    return this;
  }

  public RecordSbr setSiteNum(int value) {
    siteNum.setValue(value);
    return this;
  }

  public RecordSbr setSbinNum(int value) {
    sbinNum.setValue(value);
    return this;
  }

  public RecordSbr setSbinCnt(long value) {
    sbinCnt.setValue(value);
    return this;
  }

  public RecordSbr setSbinPf(String value) {
    sbinPf.setValue(value);
    return this;
  }

  public RecordSbr setSbinNam(String value) {
    sbinNam.setValue(value);
    return this;
  }
}
