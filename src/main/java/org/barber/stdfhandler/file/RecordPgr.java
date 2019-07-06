package org.barber.stdfhandler.file;

import java.util.List;
import java.util.Optional;

public class RecordPgr extends Record {

    private static final String NAME = "PGR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 62;

    private final Type<Integer> grpIndx = new TypeU2("GRP_INDX");
    private final Type<String> grpNam = new TypeCn("GRP_NAM", TypeCn.DEFAULT_VALUE);
    private final Type<Integer> indxCnt = new TypeU2("INDX_CNT");
    private final TypeArray<TypeU2, Integer> pmrIndx = new TypeArray<>("PMR_INDX", TypeU2::new, indxCnt, TypeU2.MAX_VALUE);

    private RecordPgr() {
        super(NAME, TYPE, SUBTYPE);
        addFields(grpIndx, grpNam, indxCnt, pmrIndx);
    }

    public static RecordPgr newInstance() {
        return new RecordPgr();
    }

    public Optional<Integer> getGrpIndx() {
        return Optional.ofNullable(grpIndx.getValue());
    }

    public Optional<String> getGrpNam() {
        return Optional.ofNullable(grpNam.getValue());
    }

    public Optional<Integer> getIndxCnt() {
        return Optional.ofNullable(indxCnt.getValue());
    }

    public List<Integer> getPmrIndx() {
        return pmrIndx.getBasicTypeList();
    }

    public RecordPgr setGrpIndx(int grpIndx) {
        this.grpIndx.setValueFromUser(grpIndx);
        return this;
    }

    public RecordPgr setGrpNam(String grpNam) {
        this.grpNam.setValueFromUser(grpNam);
        return this;
    }

    public RecordPgr setPmrIndx(List<Integer> pmrIndxs) {
        this.pmrIndx.setValueFromBasicTypeList(pmrIndxs);
        return this;
    }
}
