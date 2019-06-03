package org.barber.stdfhandler.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

class RecordMirTest extends RecordTest {


    @Test
    void testSetupT() throws IOException {
        Instant expected = Instant.ofEpochSecond(1234567890);
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setSetupT(expected)),
                fileImage -> fileImage.getMir().getSetupT(), expected);
    }

    @Test
    void testStartT() throws IOException {
        Instant expected = Instant.ofEpochSecond(1234567890);
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setStartT(expected)),
                fileImage -> fileImage.getMir().getStartT(), expected);
    }

    @Test
    void testStatNum() throws IOException {
        int expected = 123;
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setStatNum(expected)),
                fileImage -> fileImage.getMir().getStatNum(), expected);
    }

    @Test
    void testModeCod() throws IOException {
        String expected = "A";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setModeCod(expected)),
                fileImage -> fileImage.getMir().getModeCod(), expected);
    }

    @Test
    void testRtstCod() throws IOException {
        String expected = "B";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setRtstCod(expected)),
                fileImage -> fileImage.getMir().getRtstCod(), expected);
    }

    @Test
    void testProdCod() throws IOException {
        String expected = "C";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setProtCod(expected)),
                fileImage -> fileImage.getMir().getProtCod(), expected);
    }

    @Test
    void testBurnTim() throws IOException {
        int expected = 12345;
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setBurnTim(expected)),
                fileImage -> fileImage.getMir().getBurnTim(), expected);
    }

    @Test
    void testCmodCod() throws IOException {
        String expected = "D";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setCmodCod(expected)),
                fileImage -> fileImage.getMir().getCmodCod(), expected);
    }

    @Test
    void testLotId() throws IOException {
        String expected = "LOT_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setLotId(expected)),
                fileImage -> fileImage.getMir().getLotId(), expected);
    }

    @Test
    void testPartTyp() throws IOException {
        String expected = "PART_TYP";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setPartTyp(expected)),
                fileImage -> fileImage.getMir().getPartTyp(), expected);
    }

    @Test
    void testNodeNam() throws IOException {
        String expected = "NODE_NAM";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setNodeNam(expected)),
                fileImage -> fileImage.getMir().getNodeNam(), expected);
    }

    @Test
    void testTstrTyp() throws IOException {
        String expected = "TSTR_TYP";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setTstrTyp(expected)),
                fileImage -> fileImage.getMir().getTstrTyp(), expected);
    }

    @Test
    void testJobNam() throws IOException {
        String expected = "JOB_NAM";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setJobNam(expected)),
                fileImage -> fileImage.getMir().getJobNam(), expected);
    }

    @Test
    void testJobRev() throws IOException {
        String expected = "JOB_REV";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setJobRev(expected)),
                fileImage -> fileImage.getMir().getJobRev(), expected);
    }

    @Test
    void testSblotId() throws IOException {
        String expected = "SBLOT_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setSblotId(expected)),
                fileImage -> fileImage.getMir().getSblotId(), expected);
    }

    @Test
    void testOperNam() throws IOException {
        String expected = "OPER_NAM";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setOperNam(expected)),
                fileImage -> fileImage.getMir().getOperNam(), expected);
    }

    @Test
    void testExecTyp() throws IOException {
        String expected = "EXEC_TYP";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setExecTyp(expected)),
                fileImage -> fileImage.getMir().getExecTyp(), expected);
    }

    @Test
    void testExecVer() throws IOException {
        String expected = "EXEC_VER";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setExecVer(expected)),
                fileImage -> fileImage.getMir().getExecVer(), expected);
    }

    @Test
    void testTestCod() throws IOException {
        String expected = "TEST_COD";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setTestCod(expected)),
                fileImage -> fileImage.getMir().getTestCod(), expected);
    }

    @Test
    void testTstTemp() throws IOException {
        String expected = "TST_TEMP";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setTstTemp(expected)),
                fileImage -> fileImage.getMir().getTstTemp(), expected);
    }

    @Test
    void testUserTxt() throws IOException {
        String expected = "USER_TXT";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setUserTxt(expected)),
                fileImage -> fileImage.getMir().getUserTxt(), expected);
    }

    @Test
    void testAuxFile() throws IOException {
        String expected = "AUX_FILE";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setAuxFile(expected)),
                fileImage -> fileImage.getMir().getAuxFile(), expected);
    }

    @Test
    void testPkgTyp() throws IOException {
        String expected = "PKG_TYP";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setPkgTyp(expected)),
                fileImage -> fileImage.getMir().getPkgTyp(), expected);
    }

    @Test
    void testFamlyId() throws IOException {
        String expected = "FAMLY_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setFamlyId(expected)),
                fileImage -> fileImage.getMir().getFamlyId(), expected);
    }

    @Test
    void testDateCod() throws IOException {
        String expected = "DATE_COD";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setDateCod(expected)),
                fileImage -> fileImage.getMir().getDateCod(), expected);
    }

    @Test
    void testFacilId() throws IOException {
        String expected = "FACIL_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setFacilId(expected)),
                fileImage -> fileImage.getMir().getFacilId(), expected);
    }

    @Test
    void testFloorId() throws IOException {
        String expected = "FLOOR_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setFloorId(expected)),
                fileImage -> fileImage.getMir().getFloorId(), expected);
    }

    @Test
    void testProcId() throws IOException {
        String expected = "PROC_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setProcId(expected)),
                fileImage -> fileImage.getMir().getProcId(), expected);
    }

    @Test
    void testOperFrq() throws IOException {
        String expected = "OPER_FRQ";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setOperFrq(expected)),
                fileImage -> fileImage.getMir().getOperFrq(), expected);
    }

    @Test
    void testSpecNam() throws IOException {
        String expected = "SPEC_NAM";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setSpecNam(expected)),
                fileImage -> fileImage.getMir().getSpecNam(), expected);
    }

    @Test
    void testSpecVer() throws IOException {
        String expected = "SPEC_VER";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setSpecVer(expected)),
                fileImage -> fileImage.getMir().getSpecVer(), expected);
    }

    @Test
    void testFlowId() throws IOException {
        String expected = "FLOW_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setFlowId(expected)),
                fileImage -> fileImage.getMir().getFlowId(), expected);
    }

    @Test
    void testSetupId() throws IOException {
        String expected = "SETUP_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setSetupId(expected)),
                fileImage -> fileImage.getMir().getSetupId(), expected);
    }

    @Test
    void testDsgnRev() throws IOException {
        String expected = "DSGN_REV";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setDsgnRev(expected)),
                fileImage -> fileImage.getMir().getDsgnRev(), expected);
    }

    @Test
    void testEngId() throws IOException {
        String expected = "ENG_ID";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setEngId(expected)),
                fileImage -> fileImage.getMir().getEngId(), expected);
    }

    @Test
    void testRomCod() throws IOException {
        String expected = "ROM_COD";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setRomCod(expected)),
                fileImage -> fileImage.getMir().getRomCod(), expected);
    }

    @Test
    void testSerlNum() throws IOException {
        String expected = "SERL_NUM";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setSerlNum(expected)),
                fileImage -> fileImage.getMir().getSerlNum(), expected);
    }

    @Test
    void testSuprNam() throws IOException {
        String expected = "SUPR_NAM";
        testFieldOptional(new FileBuilder().addRecord(RecordMir.newInstance().setSuprNam(expected)),
                fileImage -> fileImage.getMir().getSuprNam(), expected);
    }
}
