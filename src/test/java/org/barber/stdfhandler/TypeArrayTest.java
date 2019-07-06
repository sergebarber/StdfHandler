package org.barber.stdfhandler;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeArrayTest extends TypeTest {

    static final List<Integer> U1_TEST_VALUE = Arrays.asList(
            TypeU1Test.TEST_VALUE, TypeU1Test.TEST_VALUE, TypeU1Test.TEST_VALUE);
    static final List<Integer> U2_TEST_VALUE = Arrays.asList(
            TypeU2Test.TEST_VALUE, TypeU2Test.TEST_VALUE, TypeU2Test.TEST_VALUE);
    static final List<Float> R4_TEST_VALUE = Arrays.asList(
            TypeR4Test.TEST_VALUE, TypeR4Test.TEST_VALUE, TypeR4Test.TEST_VALUE);
    static final List<String> CN_TEST_VALUE = Arrays.asList(
            TypeCnTest.TEST_VALUE, TypeCnTest.TEST_VALUE, TypeCnTest.TEST_VALUE);
    static final List<byte[]> N1_TEST_VALUE = Arrays.asList(
            TypeN1Test.TEST_VALUE, TypeN1Test.TEST_VALUE, TypeN1Test.TEST_VALUE);


    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testFtrRtnIndx() throws IOException {
        RecordFtr recordFtr = RecordFtr.newInstance().setRtnIndxAndStat(U2_TEST_VALUE, N1_TEST_VALUE);
        testListField(recordFtr, r -> recordFtr.getRtnIndx(), U2_TEST_VALUE, recordFtr::getRtnIcnt);
    }

    @Test
    void testFtrRtnStat() throws IOException {
        RecordFtr recordFtr = RecordFtr.newInstance().setRtnIndxAndStat(U2_TEST_VALUE, N1_TEST_VALUE);
        testListField(recordFtr, r -> recordFtr.getRtnStat(), N1_TEST_VALUE, recordFtr::getRtnIcnt);
    }

    @Test
    void testFtrRtnDifferentLengthArgumentsThrow() {
        List<Integer> rtnIndx = getTestList(1, 4);
        assertThatThrownBy(() -> RecordFtr.newInstance().setRtnIndxAndStat(rtnIndx, N1_TEST_VALUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Record.ARRAYS_UNEQUAL_SIZES_MESSAGE);
    }

    @Test
    void testFtrPgmIndx() throws IOException {
        RecordFtr recordFtr = RecordFtr.newInstance().setPgmIndxAndStat(U2_TEST_VALUE, N1_TEST_VALUE);
        testListField(recordFtr, r -> recordFtr.getPgmIndx(), U2_TEST_VALUE, recordFtr::getPgmIcnt);
    }

    @Test
    void testFtrPgmStat() throws IOException {
        RecordFtr recordFtr = RecordFtr.newInstance().setPgmIndxAndStat(U2_TEST_VALUE, N1_TEST_VALUE);
        testListField(recordFtr, r -> recordFtr.getPgmStat(), N1_TEST_VALUE, recordFtr::getPgmIcnt);
    }

    @Test
    void testFtrPgmDifferentLengthArgumentsThrow() {
        List<Integer> pgmIndx = getTestList(1, 4);
        assertThatThrownBy(() -> RecordFtr.newInstance().setPgmIndxAndStat(pgmIndx, N1_TEST_VALUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Record.ARRAYS_UNEQUAL_SIZES_MESSAGE);
    }

    @Test
    void testMprRtnStat() throws IOException {
        RecordMpr recordMpr = RecordMpr.newInstance().setRtnStat(N1_TEST_VALUE);
        testListField(recordMpr, r -> recordMpr.getRtnStat(), N1_TEST_VALUE, recordMpr::getRtnIcnt);
    }

    @Test
    void testMprRtnRslt() throws IOException {
        RecordMpr recordMpr = RecordMpr.newInstance().setRtnRslt(R4_TEST_VALUE);
        testListField(recordMpr, r -> recordMpr.getRtnRslt(), R4_TEST_VALUE, recordMpr::getRsltCnt);
    }

    @Test
    void testMprRtnIndx() throws IOException {
        RecordMpr recordMpr = RecordMpr.newInstance().setRtnIndx(U2_TEST_VALUE);
        testListField(recordMpr, r -> recordMpr.getRtnIndx(), U2_TEST_VALUE, recordMpr::getRtnIcnt);
    }

    @Test
    void testPgrPmrIndx() throws IOException {
        RecordPgr recordPgr = RecordPgr.newInstance().setPmrIndx(U2_TEST_VALUE);
        testListField(recordPgr, r -> recordPgr.getPmrIndx(), U2_TEST_VALUE, recordPgr::getIndxCnt);
    }

    @Test
    void testPlrValues() throws IOException {
        RecordPlr recordPlr = RecordPlr.newInstance().setValues(
                U2_TEST_VALUE, U2_TEST_VALUE, U1_TEST_VALUE, CN_TEST_VALUE, CN_TEST_VALUE, CN_TEST_VALUE, CN_TEST_VALUE);
        testListField(recordPlr, r -> recordPlr.getGrpIndx(), U2_TEST_VALUE, recordPlr::getGrpCnt);
        testListField(recordPlr, r -> recordPlr.getGrpMode(), U2_TEST_VALUE, recordPlr::getGrpCnt);
        testListField(recordPlr, r -> recordPlr.getGrpRadx(), U1_TEST_VALUE, recordPlr::getGrpCnt);
        testListField(recordPlr, r -> recordPlr.getPgmChar(), CN_TEST_VALUE, recordPlr::getGrpCnt);
        testListField(recordPlr, r -> recordPlr.getRtnChar(), CN_TEST_VALUE, recordPlr::getGrpCnt);
        testListField(recordPlr, r -> recordPlr.getPgmChal(), CN_TEST_VALUE, recordPlr::getGrpCnt);
        testListField(recordPlr, r -> recordPlr.getRtnChal(), CN_TEST_VALUE, recordPlr::getGrpCnt);
    }

    @Test
    void testPlrValuesDifferentLengthArgumentsThrow() {
        List<Integer> grpRadx = getTestList(1, 4);
        assertThatThrownBy(() -> RecordPlr.newInstance().setValues(U2_TEST_VALUE, U2_TEST_VALUE, grpRadx, CN_TEST_VALUE,
                CN_TEST_VALUE, CN_TEST_VALUE, CN_TEST_VALUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Record.ARRAYS_UNEQUAL_SIZES_MESSAGE);
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testSetU2SizeArrayTooLarge() {
        RecordFtr recordFtr = RecordFtr.newInstance();
        List<Integer> tooLargeInt = getTestList(1, TypeU2.MAX_VALUE + 1);
        List<byte[]> tooLargeByte = getTestList(new byte[]{12, 12}, TypeU2.MAX_VALUE + 1);
        testIllegalValue(recordFtr, tooLargeInt, (r, v) -> recordFtr.setRtnIndxAndStat(tooLargeInt, tooLargeByte),
                String.format(TypeArray.ILLEGAL_SIZE_MESSAGE,
                        tooLargeInt.size(), TypeU2.class.getName(), TypeU2.MAX_VALUE));
    }

    private <T> List<T> getTestList(T fill, int size) {
        List<T> tooLarge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tooLarge.add(fill);
        }
        return tooLarge;
    }
}
