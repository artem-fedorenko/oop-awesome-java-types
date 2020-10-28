package com.oopawesome.text;

import lombok.val;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlainTextTest {

    @Test
    void shouldThrowExceptionIfNullString() {
        // when
        val throwable = Assertions.catchThrowable(() -> new PlainText(null));

        // then
        Assertions.assertThat(throwable).isNotNull();
    }

    @Test
    void shouldReturnUnchangedString() {
        // given
        val originalString = "some string";

        // when
        val actualString = new PlainText(originalString).asString();

        // then
        Assertions.assertThat(actualString).isEqualTo(originalString);
    }
}
