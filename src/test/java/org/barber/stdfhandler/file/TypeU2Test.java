package org.barber.stdfhandler.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeU2Test extends TypeTest {

    @Test
    void testNullValueNull() throws IOException {
        int expected = 0;
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance());
        assertThat(fileReader.read(getInputStream()).getHbrs().get(0).getHbinNum().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testDefaultNullValueSet() throws IOException {
        int expected = 0;
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance().setHbinNum(expected));
        assertThat(fileReader.read(getInputStream()).getHbrs().get(0).getHbinNum().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testNegativeValueThrows() {
        int expected = TypeU2.MIN_VALUE - 1;
        assertThatThrownBy(() -> fileBuilder.addRecord(RecordHbr.newInstance().setHbinNum(expected)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeU2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testTooLargeValueThrows() {
        int expected = TypeU2.MAX_VALUE + 1;
        assertThatThrownBy(() -> fileBuilder.addRecord(RecordHbr.newInstance().setHbinNum(expected)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeU2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testReturnsNullWhenNullValueNotNull() {
        fileBuilder = fileBuilder.addRecord(RecordMir.newInstance());
        assertThatThrownBy(() -> fileReader.read(getInputStream()).getMir().getBurnTim().orElseThrow());

        fileBuilder = fileBuilder.addRecord(RecordPmr.newInstance());
        assertThatThrownBy(() -> fileReader.read(getInputStream()).getPmrs().get(0).getChanTyp().orElseThrow());
    }

    @Test
    void testReturnsNullWhenNullValueSet() {
        fileBuilder = fileBuilder.addRecord(RecordMir.newInstance().setBurnTim(Record.U2_MAX_NULL_VALUE));
        assertThatThrownBy(() -> fileReader.read(getInputStream()).getMir().getBurnTim().orElseThrow());

        int nullValue = 0;
        fileBuilder = fileBuilder.addRecord(RecordPmr.newInstance().setChanTyp(nullValue));
        assertThatThrownBy(() -> fileReader.read(getInputStream()).getPmrs().get(0).getChanTyp().orElseThrow());
    }
}
