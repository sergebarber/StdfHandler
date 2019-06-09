package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.Record;
import org.barber.stdfhandler.file.RecordAtr;
import org.barber.stdfhandler.file.TypeTime;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeTimeTest extends TypeTest {

    @Test
    void testNullValueNull() throws IOException {
        Instant expected = Instant.ofEpochSecond(0);
        fileBuilder = fileBuilder.addRecord(RecordAtr.newInstance());
        assertThat(fileReader.read(getInputStream()).getAtrs().get(0).getModTim().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testNullValueSet() throws IOException {
        Instant expected = Instant.ofEpochSecond(0);
        fileBuilder = fileBuilder.addRecord(RecordAtr.newInstance().setModTim(expected));
        assertThat(fileReader.read(getInputStream()).getAtrs().get(0).getModTim().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testNegativeValueThrows() {
        Instant expected = Instant.ofEpochSecond(-1);
        assertThatThrownBy(() -> fileBuilder.addRecord(RecordAtr.newInstance().setModTim(expected)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeTime.ILLEGAL_VALUE_MESSAGE, expected.getEpochSecond()));
    }

    @Test
    void testTooLargeValueThrows() {
        Instant expected = Instant.ofEpochSecond(Record.U4_MAX_NULL_VALUE + 1);
        assertThatThrownBy(() -> fileBuilder.addRecord(RecordAtr.newInstance().setModTim(expected)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeTime.ILLEGAL_VALUE_MESSAGE, expected.getEpochSecond()));
    }
}
