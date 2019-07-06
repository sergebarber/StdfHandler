package org.barber.stdfhandler;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

class TypeCnTest extends TypeTest {

  static final String TEST_VALUE = "Test string for Cn type";

  // ************************************************************************************
  // Records tests
  // ************************************************************************************

  @Test
  void testBpsSeqName() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordBps::newInstance, (r, v) -> ((RecordBps)r).setSeqName(v), r -> ((RecordBps)r).getSeqName()
    );
  }

  @Test
  void testFtrVectNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setVectNam(v), r -> ((RecordFtr)r).getVectNam());
  }

  @Test
  void testFtrTimeSet() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setTimeSet(v), r -> ((RecordFtr)r).getTimeSet());
  }

  @Test
  void testFtrOpCode() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setOpCode(v), r -> ((RecordFtr)r).getOpCode());
  }

  @Test
  void testFtrTestTxt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setTestTxt(v), r -> ((RecordFtr)r).getTestTxt());
  }

  @Test
  void testFtrAlarmId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setAlarmId(v), r -> ((RecordFtr)r).getAlarmId());
  }

  @Test
  void testFtrProgTxt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setProgTxt(v), r -> ((RecordFtr)r).getProgTxt());
  }

  @Test
  void testFtrRsltTxt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setRsltTxt(v), r -> ((RecordFtr)r).getRsltTxt());
  }

  @Test
  void testHbrHbinNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordHbr::newInstance, (r, v) -> ((RecordHbr)r).setHbinNam(v), r -> ((RecordHbr)r).getHbinNam());
  }

  @Test
  void testMirLotId() throws IOException {
    RecordMir recordMir = RecordMir.newInstance().setLotId(TEST_VALUE);
    testValueFild(recordMir, record -> recordMir.getLotId(), TEST_VALUE);
  }

  @Test
  void testMirPartTyp() throws IOException {
    RecordMir recordMir = RecordMir.newInstance().setPartTyp(TEST_VALUE);
    testValueFild(recordMir, record -> recordMir.getPartTyp(), TEST_VALUE);
  }

  @Test
  void testMirNodeNam() throws IOException {
    RecordMir recordMir = RecordMir.newInstance().setNodeNam(TEST_VALUE);
    testValueFild(recordMir, record -> recordMir.getNodeNam(), TEST_VALUE);
  }

  @Test
  void testMirTstrTyp() throws IOException {
    RecordMir recordMir = RecordMir.newInstance().setTstrTyp(TEST_VALUE);
    testValueFild(recordMir, record -> recordMir.getTstrTyp(), TEST_VALUE);
  }

  @Test
  void testMirJobNam() throws IOException {
    RecordMir recordMir = RecordMir.newInstance().setJobNam(TEST_VALUE);
    testValueFild(recordMir, record -> recordMir.getJobNam(), TEST_VALUE);
  }

  @Test
  void testMirJobRev() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setJobRev(v), r -> ((RecordMir)r).getJobRev());
  }

  @Test
  void testMirSblotId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setSblotId(v), r -> ((RecordMir)r).getSblotId());
  }

  @Test
  void testMirOperNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setOperNam(v), r -> ((RecordMir)r).getOperNam());
  }

  @Test
  void testMirExecTyp() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setExecTyp(v), r -> ((RecordMir)r).getExecTyp());
  }

  @Test
  void testMirExecVer() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setExecVer(v), r -> ((RecordMir)r).getExecVer());
  }

  @Test
  void testMirTestCod() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setTestCod(v), r -> ((RecordMir)r).getTestCod());
  }

  @Test
  void testMirTstTemp() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setTstTemp(v), r -> ((RecordMir)r).getTstTemp());
  }

  @Test
  void testMirUserTxt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setUserTxt(v), r -> ((RecordMir)r).getUserTxt());
  }

  @Test
  void testMirAuxFile() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setAuxFile(v), r -> ((RecordMir)r).getAuxFile());
  }

  @Test
  void testMirPkgTyp() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setPkgTyp(v), r -> ((RecordMir)r).getPkgTyp());
  }

  @Test
  void testMirFamlyId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setFamlyId(v), r -> ((RecordMir)r).getFamlyId());
  }

  @Test
  void testMirDateCod() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setDateCod(v), r -> ((RecordMir)r).getDateCod());
  }

  @Test
  void testMirfacilId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setFacilId(v), r -> ((RecordMir)r).getFacilId());
  }

  @Test
  void testMirFloorId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setFloorId(v), r -> ((RecordMir)r).getFloorId());
  }

  @Test
  void testMirProcId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setProcId(v), r -> ((RecordMir)r).getProcId());
  }

  @Test
  void testMirOperFrq() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setOperFrq(v), r -> ((RecordMir)r).getOperFrq());
  }

  @Test
  void testMirSpecNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setSpecNam(v), r -> ((RecordMir)r).getSpecNam());
  }

  @Test
  void testMirSpecVer() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setSpecVer(v), r -> ((RecordMir)r).getSpecVer());
  }

  @Test
  void testMirFlowId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setFlowId(v), r -> ((RecordMir)r).getFlowId());
  }

  @Test
  void testMirSetupId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setSetupId(v), r -> ((RecordMir)r).getSetupId());
  }

  @Test
  void testMirDsgnRev() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setDsgnRev(v), r -> ((RecordMir)r).getDsgnRev());
  }

  @Test
  void testMirEngId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setEngId(v), r -> ((RecordMir)r).getEngId());
  }

  @Test
  void testMirRomCod() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setRomCod(v), r -> ((RecordMir)r).getRomCod());
  }

  @Test
  void testMirSerlNum() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setSerlNum(v), r -> ((RecordMir)r).getSerlNum());
  }

  @Test
  void testMirSuprNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMir::newInstance, (r, v) -> ((RecordMir)r).setSuprNam(v), r -> ((RecordMir)r).getSuprNam());
  }

  @Test
  void testMprTestTxt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setTestTxt(v), r -> ((RecordMpr)r).getTestTxt());
  }

  @Test
  void testMprAlarmId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setAlarmId(v), r -> ((RecordMpr)r).getAlarmId());
  }

  @Test
  void testMprUnits() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setUnits(v), r -> ((RecordMpr)r).getUnits());
  }

  @Test
  void testMprUnitsIn() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setUnitsIn(v), r -> ((RecordMpr)r).getUnitsIn());
  }

  @Test
  void testMprCresfmt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setcResmft(v), r -> ((RecordMpr)r).getcResmft());
  }

  @Test
  void testMprCllmfmt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setcLlmfmt(v), r -> ((RecordMpr)r).getcLlmfmt());
  }

  @Test
  void testMprChlmfmt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setcHlmfmt(v), r -> ((RecordMpr)r).getcHlmfmt());
  }

  @Test
  void testMrrUsrDesc() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMrr::newInstance, (r, v) -> ((RecordMrr)r).setUsrDesc(v), r -> ((RecordMrr)r).getUsrDesc());
  }

  @Test
  void testMrrExcDesc() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordMrr::newInstance, (r, v) -> ((RecordMrr)r).setExcDesc(v), r -> ((RecordMrr)r).getExcDesc());
  }

  @Test
  void testPgrGrpNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPgr::newInstance, (r, v) -> ((RecordPgr)r).setGrpNam(v), r -> ((RecordPgr)r).getGrpNam());
  }

  @Test
  void testPmrChanNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPmr::newInstance, (r, v) -> ((RecordPmr)r).setChanNam(v), r -> ((RecordPmr)r).getChanNam());
  }

  @Test
  void testPmrPhyNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPmr::newInstance, (r, v) -> ((RecordPmr)r).setPhyNam(v), r -> ((RecordPmr)r).getPhyNam());
  }

  @Test
  void testPmrLogNam() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPmr::newInstance, (r, v) -> ((RecordPmr)r).setLogNam(v), r -> ((RecordPmr)r).getLogNam());
  }

  @Test
  void testPrrPartId() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPrr::newInstance, (r, v) -> ((RecordPrr)r).setPartId(v), r -> ((RecordPrr)r).getPartId());
  }

  @Test
  void testPrrPartTxt() throws IOException {
    callTestOptionalResultWithNullValue(
            RecordPrr::newInstance, (r, v) -> ((RecordPrr)r).setPartTxt(v), r -> ((RecordPrr)r).getPartTxt());
  }

  // ************************************************************************************
  // Type tests
  // ************************************************************************************

  @Test
  void testMaxValue() throws IOException {
    String expected = "A".repeat(TypeCn.MAX_LENGTH);
    RecordAtr recordAtr = RecordAtr.newInstance().setCmdLine(expected);
    testValueFild(recordAtr, record -> recordAtr.getCmdLine(), expected);
  }

  @Test
  void testMoreThanMaxValue() throws IOException {
    String set = "A".repeat(TypeCn.MAX_LENGTH + 1);
    String expected = "A".repeat(TypeCn.MAX_LENGTH);
    RecordAtr recordAtr = RecordAtr.newInstance().setCmdLine(set);
    testValueFild(recordAtr, record -> recordAtr.getCmdLine(), expected);
  }

  @Test
  void testDefaultNullValueSet() throws IOException {
    String expected = TypeCn.DEFAULT_VALUE;
    RecordAtr recordAtr = RecordAtr.newInstance();
    testValueFild(recordAtr, record -> recordAtr.getCmdLine(), expected);
  }

  private void callTestOptionalResultWithNullValue(
          Supplier<Record> emptyRecord, BiFunction<Record, String, Record> setter,
          Function<Record, Optional<String>> getter) throws IOException {

    testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, TypeCn.DEFAULT_VALUE);
  }
}
