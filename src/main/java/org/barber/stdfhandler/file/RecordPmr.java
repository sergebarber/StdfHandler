package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordPmr extends Record {

  private static final String NAME = "PMR";
  private static final int TYPE = 1;
  private static final int SUBTYPE = 60;

  private final Type<Integer> pmrIndx = new TypeU2("PMR_INDX");
  private final Type<Integer> chanTyp = new TypeU2("CHAN_TYP", TypeU2.DEFAULT_VALUE);
  private final Type<String> chanNam = new TypeCn("CHAN_NAM", TypeCn.DEFAULT_VALUE);
  private final Type<String> phyNam = new TypeCn("PHY_NAM", TypeCn.DEFAULT_VALUE);
  private final Type<String> logNam = new TypeCn("LOG_NAM", TypeCn.DEFAULT_VALUE);
  private final Type<Integer> headNum = new TypeU1("HEAD_NUM", 1);
  private final Type<Integer> siteNum = new TypeU1("SITE_NUM", 1);

  private RecordPmr() {
    super(NAME, TYPE, SUBTYPE);
    addFields(pmrIndx, chanTyp, chanNam, phyNam, logNam, headNum, siteNum);
  }

  public static RecordPmr newInstance() {
    return new RecordPmr();
  }

  public Optional<Integer> getPmrIndx() {
    return Optional.ofNullable(pmrIndx.getValue());
  }

  public Optional<Integer> getChanTyp() {
    return Optional.ofNullable(chanTyp.getValue());
  }

  public Optional<String> getChanNam() {
    return Optional.ofNullable(chanNam.getValue());
  }

  public Optional<String> getPhyNam() {
    return Optional.ofNullable(phyNam.getValue());
  }

  public Optional<String> getLogNam() {
    return Optional.ofNullable(logNam.getValue());
  }

  public Optional<Integer> getHeadNum() {
    return Optional.ofNullable(headNum.getValue());
  }

  public Optional<Integer> getSiteNum() {
    return Optional.ofNullable(siteNum.getValue());
  }

  public RecordPmr setPmrIndx(Integer value) {
    pmrIndx.setValueFromUser(value);
    return this;
  }

  public RecordPmr setChanTyp(Integer value) {
    chanTyp.setValueFromUser(value);
    return this;
  }

  public RecordPmr setChanNam(String value) {
    chanNam.setValueFromUser(value);
    return this;
  }

  public RecordPmr setPhyNam(String value) {
    phyNam.setValueFromUser(value);
    return this;
  }

  public RecordPmr setLogNam(String value) {
    logNam.setValueFromUser(value);
    return this;
  }

  public RecordPmr setHeadNum(Integer value) {
    headNum.setValueFromUser(value);
    return this;
  }

  public RecordPmr setSiteNum(Integer value) {
    siteNum.setValueFromUser(value);
    return this;
  }
}
