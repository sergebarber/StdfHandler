package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.RecordWcr;
import org.barber.stdfhandler.file.WaferData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class TypeR4Test extends TypeTest {

    @Test
    void testReturnsNullWhenNullValueNotNull() {
        fileBuilder = fileBuilder.addWaferData(WaferData.newInstance().setWcr(RecordWcr.newInstance()));
        assertThatThrownBy(() -> fileHandler.read(getInputStream()).getWaferData().get(0).getWcr()
                .getWafrSiz().orElseThrow());
    }

    @Test
    void testReturnsNullWhenNullValueSet() {
        fileBuilder = fileBuilder.addWaferData(WaferData.newInstance().setWcr(RecordWcr.newInstance().setWafrSiz(0f)));
        assertThatThrownBy(() -> fileHandler.read(getInputStream()).getWaferData().get(0).getWcr()
                .getWafrSiz().orElseThrow());
    }
}
