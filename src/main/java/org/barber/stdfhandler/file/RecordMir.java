package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

public class RecordMir extends Record {

    private static final String NAME = "MIR";
    private static final byte TYPE = 1;
    private static final byte SUBTYPE = 10;

    private final Type<Instant> setupT = new TypeTime("SETUP_T");
    private final Type<Instant> startT = new TypeTime("START_T");
    private final Type<Integer> statNum = new TypeU1("STAT_NUM");
    private final Type<Character> modeCod = new TypeC1("MODE_COD", TypeC1.DEFAULT_VALUE);
    private final Type<Character> rtstCod = new TypeC1("RTST_COD", TypeC1.DEFAULT_VALUE);
    private final Type<Character> protCod = new TypeC1("PROT_COD", TypeC1.DEFAULT_VALUE);
    private final Type<Integer> burnTim = new TypeU2("BURN_TIM", TypeU2.MAX_VALUE);
    private final Type<Character> cmodCod = new TypeC1("CMOD_COD", TypeC1.DEFAULT_VALUE);
    private final Type<String> lotId = new TypeCn("LOT_ID");
    private final Type<String> partTyp = new TypeCn("PART_TYP");
    private final Type<String> nodeNam = new TypeCn("NODE_NAM");
    private final Type<String> tstrTyp = new TypeCn("TSTR_TYP");
    private final Type<String> jobNam = new TypeCn("JOB_NAM");
    private final Type<String> jobRev = new TypeCn("JOB_REV", TypeCn.DEFAULT_VALUE);
    private final Type<String> sblotId = new TypeCn("SBLOT_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> operNam = new TypeCn("OPER_NAM", TypeCn.DEFAULT_VALUE);
    private final Type<String> execTyp = new TypeCn("EXEC_TYP", TypeCn.DEFAULT_VALUE);
    private final Type<String> execVer = new TypeCn("EXEC_VER", TypeCn.DEFAULT_VALUE);
    private final Type<String> testCod = new TypeCn("TEST_COD", TypeCn.DEFAULT_VALUE);
    private final Type<String> tstTemp = new TypeCn("TST_TEMP", TypeCn.DEFAULT_VALUE);
    private final Type<String> userTxt = new TypeCn("USER_TXT", TypeCn.DEFAULT_VALUE);
    private final Type<String> auxFile = new TypeCn("AUX_FILE", TypeCn.DEFAULT_VALUE);
    private final Type<String> pkgTyp = new TypeCn("PKG_TYP", TypeCn.DEFAULT_VALUE);
    private final Type<String> famlyId = new TypeCn("FAMLY_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> dateCod = new TypeCn("DATE_COD", TypeCn.DEFAULT_VALUE);
    private final Type<String> facilId = new TypeCn("FACIL_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> floorId = new TypeCn("FLOOR_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> procId = new TypeCn("PROC_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> operFrq = new TypeCn("OPER_FRQ", TypeCn.DEFAULT_VALUE);
    private final Type<String> specNam = new TypeCn("SPEC_NAM", TypeCn.DEFAULT_VALUE);
    private final Type<String> specVer = new TypeCn("SPEC_VER", TypeCn.DEFAULT_VALUE);
    private final Type<String> flowId = new TypeCn("FLOW_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> setupId = new TypeCn("SETUP_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> dsgnRev = new TypeCn("DSGN_REV", TypeCn.DEFAULT_VALUE);
    private final Type<String> engId = new TypeCn("ENG_ID", TypeCn.DEFAULT_VALUE);
    private final Type<String> romCod = new TypeCn("ROM_COD", TypeCn.DEFAULT_VALUE);
    private final Type<String> serlNum = new TypeCn("SERL_NUM", TypeCn.DEFAULT_VALUE);
    private final Type<String> suprNam = new TypeCn("SUPR_NAM", TypeCn.DEFAULT_VALUE);

    private RecordMir() {
        super(NAME, TYPE, SUBTYPE);
        addFields(setupT, startT, statNum, modeCod, rtstCod, protCod, burnTim, cmodCod, lotId, partTyp,
                nodeNam, tstrTyp, jobNam, jobRev, sblotId, operNam, execTyp, execVer, testCod, tstTemp, userTxt,
                auxFile, pkgTyp, famlyId, dateCod, facilId, floorId, procId, operFrq, specNam, specVer, flowId,
                setupId, dsgnRev, engId, romCod, serlNum, suprNam);
    }

    public static RecordMir newInstance() {
        return new RecordMir();
    }

    public Optional<Instant> getSetupT() {
        return Optional.ofNullable(setupT.getValue());
    }

    public Optional<Instant> getStartT() {
        return Optional.ofNullable(startT.getValue());
    }

    public Optional<Integer> getStatNum() {
        return Optional.ofNullable(statNum.getValue());
    }

    public Optional<Character> getModeCod() {
        return Optional.ofNullable(modeCod.getValue());
    }

    public Optional<Character> getRtstCod() {
        return Optional.ofNullable(rtstCod.getValue());
    }

    public Optional<Character> getProtCod() {
        return Optional.ofNullable(protCod.getValue());
    }

    public Optional<Integer> getBurnTim() {
        return Optional.ofNullable(burnTim.getValue());
    }

    public Optional<Character> getCmodCod() {
        return Optional.ofNullable(cmodCod.getValue());
    }

    public Optional<String> getLotId() {
        return Optional.ofNullable(lotId.getValue());
    }

    public Optional<String> getPartTyp() {
        return Optional.ofNullable(partTyp.getValue());
    }

    public Optional<String> getNodeNam() {
        return Optional.ofNullable(nodeNam.getValue());
    }

    public Optional<String> getTstrTyp() {
        return Optional.ofNullable(tstrTyp.getValue());
    }

    public Optional<String> getJobNam() {
        return Optional.ofNullable(jobNam.getValue());
    }

    public Optional<String> getJobRev() {
        return Optional.ofNullable(jobRev.getValue());
    }

    public Optional<String> getSblotId() {
        return Optional.ofNullable(sblotId.getValue());
    }

    public Optional<String> getOperNam() {
        return Optional.ofNullable(operNam.getValue());
    }

    public Optional<String> getExecTyp() {
        return Optional.ofNullable(execTyp.getValue());
    }

    public Optional<String> getExecVer() {
        return Optional.ofNullable(execVer.getValue());
    }

    public Optional<String> getTestCod() {
        return Optional.ofNullable(testCod.getValue());
    }

    public Optional<String> getTstTemp() {
        return Optional.ofNullable(tstTemp.getValue());
    }

    public Optional<String> getUserTxt() {
        return Optional.ofNullable(userTxt.getValue());
    }

    public Optional<String> getAuxFile() {
        return Optional.ofNullable(auxFile.getValue());
    }

    public Optional<String> getPkgTyp() {
        return Optional.ofNullable(pkgTyp.getValue());
    }

    public Optional<String> getFamlyId() {
        return Optional.ofNullable(famlyId.getValue());
    }

    public Optional<String> getDateCod() {
        return Optional.ofNullable(dateCod.getValue());
    }

    public Optional<String> getFacilId() {
        return Optional.ofNullable(facilId.getValue());
    }

    public Optional<String> getFloorId() {
        return Optional.ofNullable(floorId.getValue());
    }

    public Optional<String> getProcId() {
        return Optional.ofNullable(procId.getValue());
    }

    public Optional<String> getOperFrq() {
        return Optional.ofNullable(operFrq.getValue());
    }

    public Optional<String> getSpecNam() {
        return Optional.ofNullable(specNam.getValue());
    }

    public Optional<String> getSpecVer() {
        return Optional.ofNullable(specVer.getValue());
    }

    public Optional<String> getFlowId() {
        return Optional.ofNullable(flowId.getValue());
    }

    public Optional<String> getSetupId() {
        return Optional.ofNullable(setupId.getValue());
    }

    public Optional<String> getDsgnRev() {
        return Optional.ofNullable(dsgnRev.getValue());
    }

    public Optional<String> getEngId() {
        return Optional.ofNullable(engId.getValue());
    }

    public Optional<String> getRomCod() {
        return Optional.ofNullable(romCod.getValue());
    }

    public Optional<String> getSerlNum() {
        return Optional.ofNullable(serlNum.getValue());
    }

    public Optional<String> getSuprNam() {
        return Optional.ofNullable(suprNam.getValue());
    }

    public RecordMir setSetupT(Instant setupT) {
        this.setupT.setValueFromUser(setupT);
        return this;
    }

    public RecordMir setStartT(Instant startT) {
        this.startT.setValueFromUser(startT);
        return this;
    }

    public RecordMir setStatNum(Integer statNum) {
        this.statNum.setValueFromUser(statNum);
        return this;
    }

    public RecordMir setModeCod(char modeCod) {
        this.modeCod.setValueFromUser(modeCod);
        return this;
    }

    public RecordMir setRtstCod(char rtstCod) {
        this.rtstCod.setValueFromUser(rtstCod);
        return this;
    }

    public RecordMir setProtCod(char protCod) {
        this.protCod.setValueFromUser(protCod);
        return this;
    }

    public RecordMir setBurnTim(int burnTim) {
        this.burnTim.setValueFromUser(burnTim);
        return this;
    }

    public RecordMir setCmodCod(char cmodCod) {
        this.cmodCod.setValueFromUser(cmodCod);
        return this;
    }

    public RecordMir setLotId(String lotId) {
        this.lotId.setValueFromUser(lotId);
        return this;
    }

    public RecordMir setPartTyp(String partTyp) {
        this.partTyp.setValueFromUser(partTyp);
        return this;
    }

    public RecordMir setNodeNam(String nodeNam) {
        this.nodeNam.setValueFromUser(nodeNam);
        return this;
    }

    public RecordMir setTstrTyp(String tstrTyp) {
        this.tstrTyp.setValueFromUser(tstrTyp);
        return this;
    }

    public RecordMir setJobNam(String jobNam) {
        this.jobNam.setValueFromUser(jobNam);
        return this;
    }

    public RecordMir setJobRev(String jobRev) {
        this.jobRev.setValueFromUser(jobRev);
        return this;
    }

    public RecordMir setSblotId(String sblotId) {
        this.sblotId.setValueFromUser(sblotId);
        return this;
    }

    public RecordMir setOperNam(String operNam) {
        this.operNam.setValueFromUser(operNam);
        return this;
    }

    public RecordMir setExecTyp(String execTyp) {
        this.execTyp.setValueFromUser(execTyp);
        return this;
    }

    public RecordMir setExecVer(String execVer) {
        this.execVer.setValueFromUser(execVer);
        return this;
    }

    public RecordMir setTestCod(String testCod) {
        this.testCod.setValueFromUser(testCod);
        return this;
    }

    public RecordMir setTstTemp(String tstTemp) {
        this.tstTemp.setValueFromUser(tstTemp);
        return this;
    }

    public RecordMir setUserTxt(String userTxt) {
        this.userTxt.setValueFromUser(userTxt);
        return this;
    }

    public RecordMir setAuxFile(String auxFile) {
        this.auxFile.setValueFromUser(auxFile);
        return this;
    }

    public RecordMir setPkgTyp(String pkgTyp) {
        this.pkgTyp.setValueFromUser(pkgTyp);
        return this;
    }

    public RecordMir setFamlyId(String famlyId) {
        this.famlyId.setValueFromUser(famlyId);
        return this;
    }

    public RecordMir setDateCod(String dateCod) {
        this.dateCod.setValueFromUser(dateCod);
        return this;
    }

    public RecordMir setFacilId(String facilId) {
        this.facilId.setValueFromUser(facilId);
        return this;
    }

    public RecordMir setFloorId(String floorId) {
        this.floorId.setValueFromUser(floorId);
        return this;
    }

    public RecordMir setProcId(String procId) {
        this.procId.setValueFromUser(procId);
        return this;
    }

    public RecordMir setOperFrq(String operFrq) {
        this.operFrq.setValueFromUser(operFrq);
        return this;
    }

    public RecordMir setSpecNam(String specNam) {
        this.specNam.setValueFromUser(specNam);
        return this;
    }

    public RecordMir setSpecVer(String specVer) {
        this.specVer.setValueFromUser(specVer);
        return this;
    }

    public RecordMir setFlowId(String flowId) {
        this.flowId.setValueFromUser(flowId);
        return this;
    }

    public RecordMir setSetupId(String setupId) {
        this.setupId.setValueFromUser(setupId);
        return this;
    }

    public RecordMir setDsgnRev(String dsgnRev) {
        this.dsgnRev.setValueFromUser(dsgnRev);
        return this;
    }

    public RecordMir setEngId(String engId) {
        this.engId.setValueFromUser(engId);
        return this;
    }

    public RecordMir setRomCod(String romCod) {
        this.romCod.setValueFromUser(romCod);
        return this;
    }

    public RecordMir setSerlNum(String serlNum) {
        this.serlNum.setValueFromUser(serlNum);
        return this;
    }

    public RecordMir setSuprNam(String suprNam) {
        this.suprNam.setValueFromUser(suprNam);
        return this;
    }
}
