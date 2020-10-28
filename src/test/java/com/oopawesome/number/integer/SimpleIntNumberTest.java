package com.oopawesome.number.integer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleIntNumberTest {

    @Test
    void shouldReturnUnchangedInteger() {
        // given
        int originalInteger = 23;

        // when
        int actualInteger = new SimpleIntNumber(originalInteger).asInteger();

        // then
        Assertions.assertThat(actualInteger).isEqualTo(originalInteger);
    }
}
