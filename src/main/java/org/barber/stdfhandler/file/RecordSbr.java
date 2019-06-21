package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordSbr extends Record {

  private static final String NAME = "SBR";
  private static final int TYPE = 1;
  private static final int SUBTYPE = 50;

  private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM", null);
  private final Type<Integer> sbinNum = new TypeU2("SBIN_NUM", null);
  private final Type<Long> sbinCnt = new TypeU4("SBIN_CNT", null);
  private final Type<Character> sbinPf = new TypeC1("SBIN_PF", ' ');
  private final Type<String> sbinNam = new TypeCn("SBIN_NAM", "");

  private RecordSbr() {
    super(NAME, TYPE, SUBTYPE);
    fields.addAll(asList(headNum, siteNum, sbinNum, sbinCnt, sbinPf, sbinNam));
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

  public Optional<Character> getSbinPf() {
    return Optional.ofNullable(sbinPf.getValue());
  }

  public Optional<String> getSbinNam() {
    return Optional.ofNullable(sbinNam.getValue());
  }

  public RecordSbr setHeadNum(int value) {
    headNum.setValueFromUser(value);
    return this;
  }

  public RecordSbr setSiteNum(int value) {
    siteNum.setValueFromUser(value);
    return this;
  }

  public RecordSbr setSbinNum(int value) {
    sbinNum.setValueFromUser(value);
    return this;
  }

  public RecordSbr setSbinCnt(long value) {
    sbinCnt.setValueFromUser(value);
    return this;
  }

  public RecordSbr setSbinPf(char value) {
    sbinPf.setValueFromUser(value);
    return this;
  }

  public RecordSbr setSbinNam(String value) {
    sbinNam.setValueFromUser(value);
    return this;
  }
}
