package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

class FullTest {

    private static final Instant DEFAULT_TIME = Instant.ofEpochSecond(12345678);
    private static final int DEFULT_U1 = 123;
    private static final int DEFULT_U2 = 12345;
    private static final long DEFULT_U4 = 12345678;
    private static final List<Integer> DEFAULT_U2_LIST = Arrays.asList(12345, 12346, 12347, 12348, 12349);

    @Test
    void createAndPrintFullFile() throws IOException {

        FileBuilder builder = new FileBuilder()
                .addRecord(RecordAtr.newInstance().setModTim(DEFAULT_TIME).setCmdLine("CMD_LINE"))
                .addRecord(RecordAtr.newInstance().setModTim(DEFAULT_TIME).setCmdLine("CMD_LINE"))
                .addRecord(RecordVur.newInstance().setUpdNam("UPD_NAM"))
                .addRecord(RecordMir.newInstance().setSetupT(DEFAULT_TIME).setStartT(DEFAULT_TIME)
                        .setStatNum(DEFULT_U1).setModeCod("C").setRtstCod("D").setProtCod("E")
                        .setBurnTim(DEFULT_U2).setCmodCod("F").setLotId("LOT_ID").setPartTyp("PART_TYP")
                        .setNodeNam("NODE_NAM").setTstrTyp("TSTR_TYP").setJobNam("JOB_NAM").setJobRev("JOB_REV")
                        .setSblotId("SBLOT_ID").setOperNam("OPER_NAM").setExecTyp("EXEC_TYP").setExecVer("EXEC_VER")
                        .setTestCod("TEST_COD").setTstTemp("TST_TEMP").setUserTxt("USER_TXT").setAuxFile("AUX_FILE")
                        .setPkgTyp("PKG_TYP").setFamlyId("FAMLY_ID").setDateCod("DATE_COD").setFacilId("FACIL_ID")
                        .setFloorId("FLOOR_ID").setProcId("PROC_ID").setOperFrq("OPER_FRQ").setSpecNam("SPEC_NAM")
                        .setSpecVer("SPEC_VER").setFlowId("FLOW_ID").setSetupId("SETUP_ID").setDsgnRev("DSGN_REV")
                        .setEngId("ENG_ID").setRomCod("ROM_COD").setSerlNum("SERL_NUM").setSuprNam("SUPR_NAM"))
                .addRecord(RecordRdr.newInstance().setRtstBin(DEFAULT_U2_LIST))
                .addRecord(RecordSdr.newInstance().setHeadNum(123).setSiteGrp(123)
                        .setSiteNum(Arrays.asList(123, 124, 125, 126, 127)). setHandTyp("HAND_TYP")
                        .setHandId("HAND_ID").setCardTyp("CARD_TYP").setCardId("CARD_ID").setLoadTyp("LOAD_TYP")
                        .setLoadId("LOAD_ID").setDibTyp("DIB_TYP").setDibId("DIB_ID").setCablTyp("CABL_TYP")
                        .setCablId("CABL_ID").setContTyp("CONT_TYP").setContId("CONT_ID").setLasrTyp("LASR_TYP")
                        .setLasrId("LASR_ID").setExtrTyp("EXTR_TYP").setExtrId("EXTR_ID"))
                .addRecord(RecordPcr.newInstance().setHeadNum(DEFULT_U1).setSiteNum(DEFULT_U1)
                        .setPartCnt(DEFULT_U4).setRtstCnt(DEFULT_U4).setAbrtCnt(DEFULT_U4).setGoodCnt(DEFULT_U4)
                        .setFuncCnt(DEFULT_U4))
                .addRecord(RecordHbr.newInstance().setHeadNum(DEFULT_U1).setSiteNum(DEFULT_U1).setHbinNum(DEFULT_U2)
                        .setHbinCnt(DEFULT_U4).setHbinPf("E").setHbinNam("HBIN_NAM"))
                .addRecord(RecordSbr.newInstance().setHeadNum(DEFULT_U1).setSiteNum(DEFULT_U1).setSbinNum(DEFULT_U2)
                        .setSbinCnt(DEFULT_U4).setSbinPf("E").setSbinNam("SBIN_NAM"))
                .addRecord(RecordPmr.newInstance().setPmrIndx(DEFULT_U2).setChanTyp(DEFULT_U2).setChanNam("CHAN_NAM")
                        .setPhyNam("PHY_NAM").setLogNam("LOG_NAM").setHeadNum(DEFULT_U1).setSiteNum(DEFULT_U1))
                .addRecord(RecordPgr.newInstance().setGrpIndx(DEFULT_U2).setGrpNam("GRP_NAM")
                        .setPmrIndx(DEFAULT_U2_LIST))
                .addRecord(RecordPlr.newInstance().setValues(
                        Arrays.asList(12345, 12346, 12347, 12348, 12349),
                        Arrays.asList(12345, 12346, 12347, 12348, 12349),
                        Arrays.asList(123, 124, 125, 126, 127),
                        Arrays.asList("PGM_CHAR_1", "PGM_CHAR_2", "PGM_CHAR_3", "PGM_CHAR_4", "PGM_CHAR_5"),
                        Arrays.asList("RTN_CHAR_1", "RTN_CHAR_2", "RTN_CHAR_3", "RTN_CHAR_4", "RTN_CHAR_5"),
                        Arrays.asList("PGM_CHAL_1", "PGM_CHAL_2", "PGM_CHAL_3", "PGM_CHAL_4", "PGM_CHAL_5"),
                        Arrays.asList("RTN_CHAL_1", "RTN_CHAL_2", "RTN_CHAL_3", "RTN_CHAL_4", "RTN_CHAL_5")))

                .addWaferData(WaferData.newInstance()
                        .setWir(RecordWir.newInstance().setHeadNum(123).setSiteGrp(123).setStartT(Instant.now())
                                .setWaferId("WAFER_ID"))
                        .setWrr(RecordWrr.newInstance().setHeadNum(123).setSiteGrp(123).setFinishT(Instant.now())
                                .setPartCnt(123456L).setRtstCnt(123456L).setAbrtCnt(123456L).setGoodCnt(123456L)
                                .setFuncCnt(123456L).setWaferId("WAFER_ID").setFabwfId("FABWF_ID")
                                .setFrameId("FRAME_ID").setMaskId("MASK_ID").setUsrDesc("USR_DESC")
                                .setExcDesc("EXC_DESC")))



                .addRecord(RecordMrr.newInstance().setFinishT(DEFAULT_TIME).setDispCod("E").setUsrDesc("USR_DESC")
                        .setExcDesc("EXC_DESC"));


        ByteArrayOutputStream outputStream = builder.toStream();
        FileReader fileReader = new FileReader();
        FileImage image = fileReader.read(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(image.toString());

    }
}
