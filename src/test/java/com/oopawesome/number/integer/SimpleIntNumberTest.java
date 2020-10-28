package com.oopawesome.number.integer;

import lombok.val;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleIntNumberTest {

    @Test
    void shouldReturnUnchangedInteger() {
        // given
        val originalInteger = 23;

        // when
        val actualInteger = new SimpleIntNumber(originalInteger).asInteger();

        // then
        Assertions.assertThat(actualInteger).isEqualTo(originalInteger);
    }
}
