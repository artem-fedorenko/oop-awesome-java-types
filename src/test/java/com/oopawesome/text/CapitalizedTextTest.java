package com.oopawesome.text;

import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CapitalizedTextTest {

    @Test
    void shouldThrowExceptionIfNullString() {
        // when
        val throwable = Assertions.catchThrowable(() -> new CapitalizedText(null));

        // then
        Assertions.assertThat(throwable).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("getShouldCapitalizeTextTestCases")
    void shouldCapitalizeText(Text textToCapitalize, Text expectedResult) {
        // when
        val actualResult = new CapitalizedText(textToCapitalize);

        // then
        assertThat(actualResult.asString()).isEqualTo(expectedResult.asString());
    }

    private static Stream<Arguments> getShouldCapitalizeTextTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(new PlainText(""), new PlainText("")),
                Arguments.of(new PlainText("cat"), new PlainText("Cat")),
                Arguments.of(new PlainText("cAt"), new PlainText("CAt")),
                Arguments.of(new PlainText("'cat'"), new PlainText("'cat'"))
        );
        //@formatter:on
    }
}
