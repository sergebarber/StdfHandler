package org.barber.stdfhandler.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TypeU1Test extends TypeTest {

    @Test
    void testNullValueNull() throws IOException {
        int expected = 0;
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance());
        assertThat(fileReader.read(getInputStream()).getHbrs().get(0).getHeadNum().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testDefaultNullValueSet() throws IOException {
        int expected = 0;
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance().setHeadNum(expected));
        assertThat(fileReader.read(getInputStream()).getHbrs().get(0).getHeadNum().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testNegativeValueThrows() {
        int expected = TypeU1.MIN_VALUE - 1;
        assertThatThrownBy(() -> fileBuilder.addRecord(RecordHbr.newInstance().setHeadNum(expected)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeU1.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testTooLargeValueThrows() {
        int expected = TypeU1.MAX_VALUE + 1;
        assertThatThrownBy(() -> fileBuilder.addRecord(RecordHbr.newInstance().setHeadNum(expected)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeU1.ILLEGAL_VALUE_MESSAGE, expected));
    }
}
