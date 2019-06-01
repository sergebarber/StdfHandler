package org.barber.stdfhandler.file;

import java.io.ByteArrayOutputStream;
import java.time.Instant;

public class FileBuilder {

  public static final int DEFAULT_CPU_TYP = 2;
  public static final int DEFAULT_STDF_VER = 4;

  private final FileImage image = new FileImage();

  public ByteArrayOutputStream toStream() {
    return image.toStream();
  }

  public FileBuilder() {
    RecordFar far = new RecordFar();
    far.setCpuTyp(DEFAULT_CPU_TYP);
    far.setStdfVer(DEFAULT_STDF_VER);
    image.setFar(far);
  }

  // FAR record

  public FileBuilder setFarCpuTyp(int cpuTyp) {
    image.getFar().setCpuTyp(cpuTyp);
    return this;
  }

  public FileBuilder setFarStdfVer(int stdfVer) {
    if (image.getFar() == null) {
      image.setFar(new RecordFar());
    }
    image.getFar().setStdfVer(stdfVer);
    return this;
  }

  // ATR record

  public FileBuilder addAtr() {
    image.addAtr(new RecordAtr());
    return this;
  }

  public FileBuilder addAtr(Instant modTime) {
    RecordAtr atr = new RecordAtr();
    atr.setModTim(modTime);
    image.addAtr(atr);
    return this;
  }

  public FileBuilder addAtr(String cmdLine) {
    RecordAtr atr = new RecordAtr();
    atr.setCmdLine(cmdLine);
    image.addAtr(atr);
    return this;
  }

  public FileBuilder addAtr(Instant modTime, String cmdLine) {
    RecordAtr atr = new RecordAtr();
    atr.setModTim(modTime);
    atr.setCmdLine(cmdLine);
    image.addAtr(atr);
    return this;
  }

//  // VUR record
//
//  public StdfBuilder addVur() {
//    image.setVur(new RecordVur());
//    return this;
//  }
//
//  public StdfBuilder addVur(String updNam) {
//    image.setVur(new RecordVur());
//    image.getVur().setUpdNam(updNam);
//    return this;
//  }
//
//  public StdfBuilder setVurUpdNam(String updNam) {
//    if (image.getVur() == null) {
//      image.setVur(new RecordVur());
//    }
//    image.getVur().setUpdNam(updNam);
//    return this;
//  }
//
//  // MIR record
//
//  public StdfBuilder setMir() {
//    image.setMir(new RecordMir());
//    return this;
//  }
//
//  public void setMirIfNull() {
//    if (image.getMir() == null) setMir();
//  }
//
//  public StdfBuilder setMirSetupT(Instant value) {
//    setMirIfNull();
//    image.getMir().setSetupT(value);
//    return this;
//  }
//
//  public StdfBuilder setMirStartT(Instant value) {
//    setMirIfNull();
//    image.getMir().setStartT(value);
//    return this;
//  }
//
//  public StdfBuilder setMirStatNum(Integer value) {
//    setMirIfNull();
//    image.getMir().setStatNum(value);
//    return this;
//  }
//
//  public StdfBuilder setMirModeCod(String value) {
//    setMirIfNull();
//    image.getMir().setModeCod(value);
//    return this;
//  }
//
//  public StdfBuilder setMirRtstCod(String value) {
//    setMirIfNull();
//    image.getMir().setRtstCod(value);
//    return this;
//  }
//
//  public StdfBuilder setMirProtCod(String value) {
//    setMirIfNull();
//    image.getMir().setProtCod(value);
//    return this;
//  }
//
//  public StdfBuilder setMirBurnTim(Integer value) {
//    setMirIfNull();
//    image.getMir().setBurnTim(value);
//    return this;
//  }
//
//  public StdfBuilder setMirCmodCod(String value) {
//    setMirIfNull();
//    image.getMir().setCmodCod(value);
//    return this;
//  }
//
//  public StdfBuilder setMirLotId(String value) {
//    setMirIfNull();
//    image.getMir().setLotId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirPartTyp(String value) {
//    setMirIfNull();
//    image.getMir().setPartTyp(value);
//    return this;
//  }
//
//  public StdfBuilder setMirNodeNam(String value) {
//    setMirIfNull();
//    image.getMir().setNodeNam(value);
//    return this;
//  }
//
//  public StdfBuilder setMirTstrTyp(String value) {
//    setMirIfNull();
//    image.getMir().setTstrTyp(value);
//    return this;
//  }
//
//  public StdfBuilder setMirJobNam(String value) {
//    setMirIfNull();
//    image.getMir().setJobNam(value);
//    return this;
//  }
//
//  public StdfBuilder setMirJobRev(String value) {
//    setMirIfNull();
//    image.getMir().setJobRev(value);
//    return this;
//  }
//
//  public StdfBuilder setMirSblotId(String value) {
//    setMirIfNull();
//    image.getMir().setSblotId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirOperNam(String value) {
//    setMirIfNull();
//    image.getMir().setOperNam(value);
//    return this;
//  }
//
//  public StdfBuilder setMirExecTyp(String value) {
//    setMirIfNull();
//    image.getMir().setExecTyp(value);
//    return this;
//  }
//
//  public StdfBuilder setMirExecVer(String value) {
//    setMirIfNull();
//    image.getMir().setExecVer(value);
//    return this;
//  }
//
//  public StdfBuilder setMirTestCod(String value) {
//    setMirIfNull();
//    image.getMir().setTestCod(value);
//    return this;
//  }
//
//  public StdfBuilder setMirTstTemp(String value) {
//    setMirIfNull();
//    image.getMir().setTstTemp(value);
//    return this;
//  }
//
//  public StdfBuilder setMirUserTxt(String value) {
//    setMirIfNull();
//    image.getMir().setUserTxt(value);
//    return this;
//  }
//
//  public StdfBuilder setMirAuxFile(String value) {
//    setMirIfNull();
//    image.getMir().setAuxFile(value);
//    return this;
//  }
//
//  public StdfBuilder setMirPkgTyp(String value) {
//    setMirIfNull();
//    image.getMir().setPkgTyp(value);
//    return this;
//  }
//
//  public StdfBuilder setMirFamlyId(String value) {
//    setMirIfNull();
//    image.getMir().setFamlyId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirDateCod(String value) {
//    setMirIfNull();
//    image.getMir().setDateCod(value);
//    return this;
//  }
//
//  public StdfBuilder setMirFacilId(String value) {
//    setMirIfNull();
//    image.getMir().setFacilId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirFloorId(String value) {
//    setMirIfNull();
//    image.getMir().setFloorId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirProcId(String value) {
//    setMirIfNull();
//    image.getMir().setProcId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirOperFrq(String value) {
//    setMirIfNull();
//    image.getMir().setOperFrq(value);
//    return this;
//  }
//
//  public StdfBuilder setMirSpecNam(String value) {
//    setMirIfNull();
//    image.getMir().setSpecNam(value);
//    return this;
//  }
//
//  public StdfBuilder setMirSpecVer(String value) {
//    setMirIfNull();
//    image.getMir().setSpecVer(value);
//    return this;
//  }
//
//  public StdfBuilder setMirFlowId(String value) {
//    setMirIfNull();
//    image.getMir().setFlowId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirSetupId(String value) {
//    setMirIfNull();
//    image.getMir().setSetupId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirDsgnRev(String value) {
//    setMirIfNull();
//    image.getMir().setDsgnRev(value);
//    return this;
//  }
//
//  public StdfBuilder setMirEngId(String value) {
//    setMirIfNull();
//    image.getMir().setEngId(value);
//    return this;
//  }
//
//  public StdfBuilder setMirRomCod(String value) {
//    setMirIfNull();
//    image.getMir().setRomCod(value);
//    return this;
//  }
//
//  public StdfBuilder setMirSerlNum(String value) {
//    setMirIfNull();
//    image.getMir().setSerlNum(value);
//    return this;
//  }
//
//  public StdfBuilder setMirSuprNam(String value) {
//    setMirIfNull();
//    image.getMir().setSuprNam(value);
//    return this;
//  }
}
