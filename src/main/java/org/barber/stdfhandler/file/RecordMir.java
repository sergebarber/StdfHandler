package org.barber.stdfhandler.file;

import java.time.Instant;
import java.util.Optional;

public class RecordMir extends Record {

    private static final String NAME = "MIR";
    private static final byte TYPE = 1;
    private static final byte CODE = 10;

    private static final String SETUP_T = "SETUP_T";
    private static final String START_T = "START_T";
    private static final String STAT_NUM = "STAT_NUM";
    private static final String MODE_COD = "MODE_COD";
    private static final String RTST_COD = "RTST_COD";
    private static final String PROT_COD = "PROT_COD";
    private static final String BURN_TIM = "BURN_TIM";
    private static final String CMOD_COD = "CMOD_COD";
    private static final String LOT_ID = "LOT_ID";
    private static final String PART_TYP = "PART_TYP";
    private static final String NODE_NAM = "NODE_NAM";
    private static final String TSTR_TYP = "TSTR_TYP";
    private static final String JOB_NAM = "JOB_NAM";
    private static final String JOB_REV = "JOB_REV";
    private static final String SBLOT_ID = "SBLOT_ID";
    private static final String OPER_NAM = "OPER_NAM";
    private static final String EXEC_TYP = "EXEC_TYP";
    private static final String EXEC_VER = "EXEC_VER";
    private static final String TEST_COD = "TEST_COD";
    private static final String TST_TEMP = "TST_TEMP";
    private static final String USER_TXT = "USER_TXT";
    private static final String AUX_FILE = "AUX_FILE";
    private static final String PKG_TYP = "PKG_TYP";
    private static final String FAMLY_ID = "FAMLY_ID";
    private static final String DATE_COD = "DATE_COD";
    private static final String FACIL_ID = "FACIL_ID";
    private static final String FLOOR_ID = "FLOOR_ID";
    private static final String PROC_ID = "PROC_ID";
    private static final String OPER_FRQ = "OPER_FRQ";
    private static final String SPEC_NAM = "SPEC_NAM";
    private static final String SPEC_VER = "SPEC_VER";
    private static final String FLOW_ID = "FLOW_ID";
    private static final String SETUP_ID = "SETUP_ID";
    private static final String DSGN_REV = "DSGN_REV";
    private static final String ENG_ID = "ENG_ID";
    private static final String ROM_COD = "ROM_COD";
    private static final String SERL_NUM = "SERL_NUM";
    private static final String SUPR_NAM = "SUPR_NAM";

    RecordMir() {
        super(NAME, TYPE, CODE);
        fields.put(SETUP_T, new TypeTime());
        fields.put(START_T, new TypeTime());
        fields.put(STAT_NUM, new TypeU1());
        fields.put(MODE_COD, new TypeC1Nl());
        fields.put(RTST_COD, new TypeC1Nl());
        fields.put(PROT_COD, new TypeC1Nl());
        fields.put(BURN_TIM, new TypeU2Nl());
        fields.put(CMOD_COD, new TypeC1Nl());
        fields.put(LOT_ID, new TypeCn());
        fields.put(PART_TYP, new TypeCn());
        fields.put(NODE_NAM, new TypeCn());
        fields.put(TSTR_TYP, new TypeCn());
        fields.put(JOB_NAM, new TypeCn());
        fields.put(JOB_REV, new TypeCnNl());
        fields.put(SBLOT_ID, new TypeCnNl());
        fields.put(OPER_NAM, new TypeCnNl());
        fields.put(EXEC_TYP, new TypeCnNl());
        fields.put(EXEC_VER, new TypeCnNl());
        fields.put(TEST_COD, new TypeCnNl());
        fields.put(TST_TEMP, new TypeCnNl());
        fields.put(USER_TXT, new TypeCnNl());
        fields.put(AUX_FILE, new TypeCnNl());
        fields.put(PKG_TYP, new TypeCnNl());
        fields.put(FAMLY_ID, new TypeCnNl());
        fields.put(DATE_COD, new TypeCnNl());
        fields.put(FACIL_ID, new TypeCnNl());
        fields.put(FLOOR_ID, new TypeCnNl());
        fields.put(PROC_ID, new TypeCnNl());
        fields.put(OPER_FRQ, new TypeCnNl());
        fields.put(SPEC_NAM, new TypeCnNl());
        fields.put(SPEC_VER, new TypeCnNl());
        fields.put(FLOW_ID, new TypeCnNl());
        fields.put(SETUP_ID, new TypeCnNl());
        fields.put(DSGN_REV, new TypeCnNl());
        fields.put(ENG_ID, new TypeCnNl());
        fields.put(ROM_COD, new TypeCnNl());
        fields.put(SERL_NUM, new TypeCnNl());
        fields.put(SUPR_NAM, new TypeCnNl());
    }

    public static RecordMir newInstance() {
        return new RecordMir();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setMir(this);
    }

    public Optional<Instant> getSetupT() {
        return Optional.ofNullable(TypeTime.cast(fields.get(SETUP_T).getValue()));
    }

    public Optional<Instant> getStartT() {
        return Optional.ofNullable(TypeTime.cast(fields.get(START_T).getValue()));
    }

    public Optional<Integer> getStatNum() {
        return Optional.ofNullable(TypeInt.cast(fields.get(STAT_NUM).getValue()));
    }

    public Optional<String> getModeCod() {
        return Optional.ofNullable(TypeString.cast(fields.get(MODE_COD).getValue()));
    }

    public Optional<String> getRtstCod() {
        return Optional.ofNullable(TypeString.cast(fields.get(RTST_COD).getValue()));
    }

    public Optional<String> getProtCod() {
        return Optional.ofNullable(TypeString.cast(fields.get(PROT_COD).getValue()));
    }

    public Optional<Integer> getBurnTim() {
        return Optional.ofNullable(TypeInt.cast(fields.get(BURN_TIM).getValue()));
    }

    public Optional<String> getCmodCod() {
        return Optional.ofNullable(TypeString.TYPE.cast(fields.get(CMOD_COD).getValue()));
    }

    public Optional<String> getLotId() {
        return Optional.ofNullable(TypeString.cast(fields.get(LOT_ID).getValue()));
    }

    public Optional<String> getPartTyp() {
        return Optional.ofNullable(TypeString.cast(fields.get(PART_TYP).getValue()));
    }

    public Optional<String> getNodeNam() {
        return Optional.ofNullable(TypeString.cast(fields.get(NODE_NAM).getValue()));
    }

    public Optional<String> getTstrTyp() {
        return Optional.ofNullable(TypeString.cast(fields.get(TSTR_TYP).getValue()));
    }

    public Optional<String> getJobNam() {
        return Optional.ofNullable(TypeString.cast(fields.get(JOB_NAM).getValue()));
    }

    public Optional<String> getJobRev() {
        return Optional.ofNullable(TypeString.cast(fields.get(JOB_REV).getValue()));
    }

    public Optional<String> getSblotId() {
        return Optional.ofNullable(TypeString.cast(fields.get(SBLOT_ID).getValue()));
    }

    public Optional<String> getOperNam() {
        return Optional.ofNullable(TypeString.cast(fields.get(OPER_NAM).getValue()));
    }

    public Optional<String> getExecTyp() {
        return Optional.ofNullable(TypeString.cast(fields.get(EXEC_TYP).getValue()));
    }

    public Optional<String> getExecVer() {
        return Optional.ofNullable(TypeString.cast(fields.get(EXEC_VER).getValue()));
    }

    public Optional<String> getTestCod() {
        return Optional.ofNullable(TypeString.cast(fields.get(TEST_COD).getValue()));
    }

    public Optional<String> getTstTemp() {
        return Optional.ofNullable(TypeString.cast(fields.get(TST_TEMP).getValue()));
    }

    public Optional<String> getUserTxt() {
        return Optional.ofNullable(TypeString.cast(fields.get(USER_TXT).getValue()));
    }

    public Optional<String> getAuxFile() {
        return Optional.ofNullable(TypeString.cast(fields.get(AUX_FILE).getValue()));
    }

    public Optional<String> getPkgTyp() {
        return Optional.ofNullable(TypeString.cast(fields.get(PKG_TYP).getValue()));
    }

    public Optional<String> getFamlyId() {
        return Optional.ofNullable(TypeString.cast(fields.get(FAMLY_ID).getValue()));
    }

    public Optional<String> getDateCod() {
        return Optional.ofNullable(TypeString.cast(fields.get(DATE_COD).getValue()));
    }

    public Optional<String> getFacilId() {
        return Optional.ofNullable(TypeString.cast(fields.get(FACIL_ID).getValue()));
    }

    public Optional<String> getFloorId() {
        return Optional.ofNullable(TypeString.cast(fields.get(FLOOR_ID).getValue()));
    }

    public Optional<String> getProcId() {
        return Optional.ofNullable(TypeString.cast(fields.get(PROC_ID).getValue()));
    }

    public Optional<String> getOperFrq() {
        return Optional.ofNullable(TypeString.cast(fields.get(OPER_FRQ).getValue()));
    }

    public Optional<String> getSpecNam() {
        return Optional.ofNullable(TypeString.cast(fields.get(SPEC_NAM).getValue()));
    }

    public Optional<String> getSpecVer() {
        return Optional.ofNullable(TypeString.cast(fields.get(SPEC_VER).getValue()));
    }

    public Optional<String> getFlowId() {
        return Optional.ofNullable(TypeString.cast(fields.get(FLOW_ID).getValue()));
    }

    public Optional<String> getSetupId() {
        return Optional.ofNullable(TypeString.cast(fields.get(SETUP_ID).getValue()));
    }

    public Optional<String> getDsgnRev() {
        return Optional.ofNullable(TypeString.cast(fields.get(DSGN_REV).getValue()));
    }

    public Optional<String> getEngId() {
        return Optional.ofNullable(TypeString.cast(fields.get(ENG_ID).getValue()));
    }

    public Optional<String> getRomCod() {
        return Optional.ofNullable(TypeString.cast(fields.get(ROM_COD).getValue()));
    }

    public Optional<String> getSerlNum() {
        return Optional.ofNullable(TypeString.cast(fields.get(SERL_NUM).getValue()));
    }

    public Optional<String> getSuprNam() {
        return Optional.ofNullable(TypeString.cast(fields.get(SUPR_NAM).getValue()));
    }

    public RecordMir setSetupT(Instant value) {
        fields.get(SETUP_T).setValue(value);
        return this;
    }

    public RecordMir setStartT(Instant value) {
        fields.get(START_T).setValue(value);
        return this;
    }

    public RecordMir setStatNum(Integer value) {
        fields.get(STAT_NUM).setValue(value);
        return this;
    }

    public RecordMir setModeCod(String value) {
        fields.get(MODE_COD).setValue(value);
        return this;
    }

    public RecordMir setRtstCod(String value) {
        fields.get(RTST_COD).setValue(value);
        return this;
    }

    public RecordMir setProtCod(String value) {
        fields.get(PROT_COD).setValue(value);
        return this;
    }

    public RecordMir setBurnTim(Integer value) {
        fields.get(BURN_TIM).setValue(value);
        return this;
    }

    public RecordMir setCmodCod(String value) {
        fields.get(CMOD_COD).setValue(value);
        return this;
    }

    public RecordMir setLotId(String value) {
        fields.get(LOT_ID).setValue(value);
        return this;
    }

    public RecordMir setPartTyp(String value) {
        fields.get(PART_TYP).setValue(value);
        return this;
    }

    public RecordMir setNodeNam(String value) {
        fields.get(NODE_NAM).setValue(value);
        return this;
    }

    public RecordMir setTstrTyp(String value) {
        fields.get(TSTR_TYP).setValue(value);
        return this;
    }

    public RecordMir setJobNam(String value) {
        fields.get(JOB_NAM).setValue(value);
        return this;
    }

    public RecordMir setJobRev(String value) {
        fields.get(JOB_REV).setValue(value);
        return this;
    }

    public RecordMir setSblotId(String value) {
        fields.get(SBLOT_ID).setValue(value);
        return this;
    }

    public RecordMir setOperNam(String value) {
        fields.get(OPER_NAM).setValue(value);
        return this;
    }

    public RecordMir setExecTyp(String value) {
        fields.get(EXEC_TYP).setValue(value);
        return this;
    }

    public RecordMir setExecVer(String value) {
        fields.get(EXEC_VER).setValue(value);
        return this;
    }

    public RecordMir setTestCod(String value) {
        fields.get(TEST_COD).setValue(value);
        return this;
    }

    public RecordMir setTstTemp(String value) {
        fields.get(TST_TEMP).setValue(value);
        return this;
    }

    public RecordMir setUserTxt(String value) {
        fields.get(USER_TXT).setValue(value);
        return this;
    }

    public RecordMir setAuxFile(String value) {
        fields.get(AUX_FILE).setValue(value);
        return this;
    }

    public RecordMir setPkgTyp(String value) {
        fields.get(PKG_TYP).setValue(value);
        return this;
    }

    public RecordMir setFamlyId(String value) {
        fields.get(FAMLY_ID).setValue(value);
        return this;
    }

    public RecordMir setDateCod(String value) {
        fields.get(DATE_COD).setValue(value);
        return this;
    }

    public RecordMir setFacilId(String value) {
        fields.get(FACIL_ID).setValue(value);
        return this;
    }

    public RecordMir setFloorId(String value) {
        fields.get(FLOOR_ID).setValue(value);
        return this;
    }

    public RecordMir setProcId(String value) {
        fields.get(PROC_ID).setValue(value);
        return this;
    }

    public RecordMir setOperFrq(String value) {
        fields.get(OPER_FRQ).setValue(value);
        return this;
    }

    public RecordMir setSpecNam(String value) {
        fields.get(SPEC_NAM).setValue(value);
        return this;
    }

    public RecordMir setSpecVer(String value) {
        fields.get(SPEC_VER).setValue(value);
        return this;
    }

    public RecordMir setFlowId(String value) {
        fields.get(FLOW_ID).setValue(value);
        return this;
    }

    public RecordMir setSetupId(String value) {
        fields.get(SETUP_ID).setValue(value);
        return this;
    }

    public RecordMir setDsgnRev(String value) {
        fields.get(DSGN_REV).setValue(value);
        return this;
    }

    public RecordMir setEngId(String value) {
        fields.get(ENG_ID).setValue(value);
        return this;
    }

    public RecordMir setRomCod(String value) {
        fields.get(ROM_COD).setValue(value);
        return this;
    }

    public RecordMir setSerlNum(String value) {
        fields.get(SERL_NUM).setValue(value);
        return this;
    }

    public RecordMir setSuprNam(String value) {
        fields.get(SUPR_NAM).setValue(value);
        return this;
    }
}
