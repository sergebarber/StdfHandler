package org.barber.stdfhandler.file;

import java.util.List;
import java.util.Optional;

public class RecordPlr extends Record {

    private static final String NAME = "PLR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 63;

    private final Type<Integer> grpCnt = new TypeU2("GRP_CNT");
    private final TypeArray<TypeU2, Integer> grpIndx = new TypeArray<>("GRP_INDX", TypeU2::new, grpCnt, TypeU2.MAX_VALUE);
    private final TypeArray<TypeU2, Integer> grpMode = new TypeArray<>("GRP_MODE", TypeU2::new, grpCnt, TypeU2.MAX_VALUE);
    private final TypeArray<TypeU1, Integer> grpRadx = new TypeArray<>("GRP_RADX", TypeU1::new, grpCnt, TypeU2.MAX_VALUE);
    private final TypeArray<TypeCn, String> pgmChar = new TypeArray<>("PGM_CHAR", TypeCn::new, grpCnt, TypeU2.MAX_VALUE);
    private final TypeArray<TypeCn, String> rtnChar = new TypeArray<>("RTN_CHAR", TypeCn::new, grpCnt, TypeU2.MAX_VALUE);
    private final TypeArray<TypeCn, String> pgmChal = new TypeArray<>("PGM_CHAL", TypeCn::new, grpCnt, TypeU2.MAX_VALUE);
    private final TypeArray<TypeCn, String> rtnChal = new TypeArray<>("PGM_CHAL", TypeCn::new, grpCnt, TypeU2.MAX_VALUE);

    private RecordPlr() {
        super(NAME, TYPE, SUBTYPE);
        addFields(grpCnt, grpIndx, grpMode, grpRadx, pgmChar, rtnChar, pgmChal, rtnChal);
    }

    public static RecordPlr newInstance() {
        return new RecordPlr();
    }

    public Optional<Integer> getGrpCnt() {
        return Optional.ofNullable(grpCnt.getValue());
    }

    public List<Integer> getGrpIndx() {
        return grpIndx.getBasicTypeList();
    }

    public List<Integer> getGrpMode() {
        return grpMode.getBasicTypeList();
    }

    public List<Integer> getGrpRadx() {
        return grpRadx.getBasicTypeList();
    }

    public List<String> getPgmChar() {
        return pgmChar.getBasicTypeList();
    }

    public List<String> getRtnChar() {
        return rtnChar.getBasicTypeList();
    }

    public List<String> getPgmChal() {
        return pgmChal.getBasicTypeList();
    }

    public List<String> getRtnChal() {
        return rtnChal.getBasicTypeList();
    }

    public RecordPlr setValues(List<Integer> grpIndx, List<Integer> grpMode, List<Integer> grpRadx,
                          List<String> pgmChar, List<String> rtnChar, List<String> pgmChal, List<String> rtnChal) {

        if (!checkSizesEquals(grpIndx.size(), grpMode.size(), grpRadx.size(), pgmChar.size(), rtnChar.size(),
                pgmChal.size(), rtnChal.size())) {
            throw new IllegalArgumentException(ARRAYS_UNEQUAL_SIZES_MESSAGE);
        }

        this.grpIndx.setValueFromBasicTypeList(grpIndx);
        this.grpMode.setValueFromBasicTypeList(grpMode);
        this.grpRadx.setValueFromBasicTypeList(grpRadx);
        this.pgmChar.setValueFromBasicTypeList(pgmChar);
        this.rtnChar.setValueFromBasicTypeList(rtnChar);
        this.pgmChal.setValueFromBasicTypeList(pgmChal);
        this.rtnChal.setValueFromBasicTypeList(rtnChal);
        return this;
    }

    private boolean checkSizesEquals(int... sizes) {
        for (int i = 1; i < sizes.length; i++) {
            if (sizes[i] != sizes[0]) {
                return false;
            }
        }
        return true;
    }
}
