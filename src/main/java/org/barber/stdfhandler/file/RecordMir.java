package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordMir extends Record {

    private static final String NAME = "MIR";
    private static final byte TYPE = 1;
    private static final byte CODE = 10;

    private final Type<Instant> setupT = new TypeTime("SETUP_T");
    private final Type<Instant> startT = new TypeTime("START_T");
    private final Type<Integer> statNum = new TypeU1("STAT_NUM");
    private final Type<String> modeCod = new TypeC1Nl("MODE_COD");
    private final Type<String> rtstCod = new TypeC1Nl("RTST_COD");
    private final Type<String> protCod = new TypeC1Nl("PROT_COD");
    private final Type<Integer> burnTim = new TypeU2Nl("BURN_TIM");
    private final Type<String> cmodCod = new TypeC1Nl("CMOD_COD");
    private final Type<String> lotId = new TypeCn("LOT_ID");
    private final Type<String> partTyp = new TypeCn("PART_TYP");
    private final Type<String> nodeNam = new TypeCn("NODE_NAM");
    private final Type<String> tstrTyp = new TypeCn("TSTR_TYP");
    private final Type<String> jobNam = new TypeCn("JOB_NAM");
    private final Type<String> jobRev = new TypeC1Nl("JOB_REV");
    private final Type<String> sblotId = new TypeC1Nl("SBLOT_ID");
    private final Type<String> operNam = new TypeC1Nl("OPER_NAM");
    private final Type<String> execTyp = new TypeC1Nl("EXEC_TYP");
    private final Type<String> execVer = new TypeC1Nl("EXEC_VER");
    private final Type<String> testCod = new TypeC1Nl("TEST_COD");
    private final Type<String> tstTemp = new TypeC1Nl("TST_TEMP");
    private final Type<String> userTxt = new TypeC1Nl("USER_TXT");
    private final Type<String> auxFile = new TypeC1Nl("AUX_FILE");
    private final Type<String> pkgTyp = new TypeC1Nl("PKG_TYP");
    private final Type<String> famlyId = new TypeC1Nl("FAMLY_ID");
    private final Type<String> dateCod = new TypeC1Nl("DATE_COD");
    private final Type<String> facilId = new TypeC1Nl("FACIL_ID");
    private final Type<String> floorId = new TypeC1Nl("FLOOR_ID");
    private final Type<String> procId = new TypeC1Nl("PROC_ID");
    private final Type<String> operFrq = new TypeC1Nl("OPER_FRQ");
    private final Type<String> specNam = new TypeC1Nl("SPEC_NAM");
    private final Type<String> specVer = new TypeC1Nl("SPEC_VER");
    private final Type<String> flowId = new TypeC1Nl("FLOW_ID");
    private final Type<String> setupId = new TypeC1Nl("SETUP_ID");
    private final Type<String> dsgnRev = new TypeC1Nl("DSGN_REV");
    private final Type<String> engId = new TypeC1Nl("ENG_ID");
    private final Type<String> romCod = new TypeC1Nl("ROM_COD");
    private final Type<String> serlNum = new TypeC1Nl("SERL_NUM");
    private final Type<String> suprNam = new TypeC1Nl("SUPR_NAM");

    RecordMir() {
        super(NAME, TYPE, CODE);
        fields.add(setupT);
        fields.add(startT);
        fields.add(statNum);
        fields.add(modeCod);
        fields.add(rtstCod);
        fields.add(protCod);
        fields.add(burnTim);
        fields.add(cmodCod);
        fields.add(lotId);
        fields.add(partTyp);
        fields.add(nodeNam);
        fields.add(tstrTyp);
        fields.add(jobNam);
        fields.add(jobRev);
        fields.add(sblotId);
        fields.add(operNam);
        fields.add(execTyp);
        fields.add(execVer);
        fields.add(testCod);
        fields.add(tstTemp);
        fields.add(userTxt);
        fields.add(auxFile);
        fields.add(pkgTyp);
        fields.add(famlyId);
        fields.add(dateCod);
        fields.add(facilId);
        fields.add(floorId);
        fields.add(procId);
        fields.add(operFrq);
        fields.add(specNam);
        fields.add(specVer);
        fields.add(flowId);
        fields.add(setupId);
        fields.add(dsgnRev);
        fields.add(engId);
        fields.add(romCod);
        fields.add(serlNum);
        fields.add(suprNam);
    }

    public static RecordMir newInstance() {
        return new RecordMir();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setMir(this);
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

    public Optional<String> getModeCod() {
        return Optional.ofNullable(modeCod.getValue());
    }

    public Optional<String> getRtstCod() {
        return Optional.ofNullable(rtstCod.getValue());
    }

    public Optional<String> getProtCod() {
        return Optional.ofNullable(protCod.getValue());
    }

    public Optional<Integer> getBurnTim() {
        return Optional.ofNullable(burnTim.getValue());
    }

    public Optional<String> getCmodCod() {
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

    public RecordMir setSetupT(Instant value) {
        setupT.setValue(value);
        return this;
    }

    public RecordMir setStartT(Instant value) {
        startT.setValue(value);
        return this;
    }

    public RecordMir setStatNum(Integer value) {
        statNum.setValue(value);
        return this;
    }

    public RecordMir setModeCod(String value) {
        modeCod.setValue(value);
        return this;
    }

    public RecordMir setRtstCod(String value) {
        rtstCod.setValue(value);
        return this;
    }

    public RecordMir setProtCod(String value) {
        protCod.setValue(value);
        return this;
    }

    public RecordMir setBurnTim(Integer value) {
        burnTim.setValue(value);
        return this;
    }

    public RecordMir setCmodCod(String value) {
        cmodCod.setValue(value);
        return this;
    }

    public RecordMir setLotId(String value) {
        lotId.setValue(value);
        return this;
    }

    public RecordMir setPartTyp(String value) {
        partTyp.setValue(value);
        return this;
    }

    public RecordMir setNodeNam(String value) {
        nodeNam.setValue(value);
        return this;
    }

    public RecordMir setTstrTyp(String value) {
        tstrTyp.setValue(value);
        return this;
    }

    public RecordMir setJobNam(String value) {
        jobNam.setValue(value);
        return this;
    }

    public RecordMir setJobRev(String value) {
        jobRev.setValue(value);
        return this;
    }

    public RecordMir setSblotId(String value) {
        sblotId.setValue(value);
        return this;
    }

    public RecordMir setOperNam(String value) {
        operNam.setValue(value);
        return this;
    }

    public RecordMir setExecTyp(String value) {
        execTyp.setValue(value);
        return this;
    }

    public RecordMir setExecVer(String value) {
        execVer.setValue(value);
        return this;
    }

    public RecordMir setTestCod(String value) {
        testCod.setValue(value);
        return this;
    }

    public RecordMir setTstTemp(String value) {
        tstTemp.setValue(value);
        return this;
    }

    public RecordMir setUserTxt(String value) {
        userTxt.setValue(value);
        return this;
    }

    public RecordMir setAuxFile(String value) {
        auxFile.setValue(value);
        return this;
    }

    public RecordMir setPkgTyp(String value) {
        pkgTyp.setValue(value);
        return this;
    }

    public RecordMir setFamlyId(String value) {
        famlyId.setValue(value);
        return this;
    }

    public RecordMir setDateCod(String value) {
        dateCod.setValue(value);
        return this;
    }

    public RecordMir setFacilId(String value) {
        facilId.setValue(value);
        return this;
    }

    public RecordMir setFloorId(String value) {
        floorId.setValue(value);
        return this;
    }

    public RecordMir setProcId(String value) {
        procId.setValue(value);
        return this;
    }

    public RecordMir setOperFrq(String value) {
        operFrq.setValue(value);
        return this;
    }

    public RecordMir setSpecNam(String value) {
        specNam.setValue(value);
        return this;
    }

    public RecordMir setSpecVer(String value) {
        specVer.setValue(value);
        return this;
    }

    public RecordMir setFlowId(String value) {
        flowId.setValue(value);
        return this;
    }

    public RecordMir setSetupId(String value) {
        setupId.setValue(value);
        return this;
    }

    public RecordMir setDsgnRev(String value) {
        dsgnRev.setValue(value);
        return this;
    }

    public RecordMir setEngId(String value) {
        engId.setValue(value);
        return this;
    }

    public RecordMir setRomCod(String value) {
        romCod.setValue(value);
        return this;
    }

    public RecordMir setSerlNum(String value) {
        serlNum.setValue(value);
        return this;
    }

    public RecordMir setSuprNam(String value) {
        suprNam.setValue(value);
        return this;
    }
}
