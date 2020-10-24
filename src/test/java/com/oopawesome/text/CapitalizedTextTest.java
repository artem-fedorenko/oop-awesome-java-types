package com.oopawesome.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.oopawesome.text.CapitalizedText.capitalizedText;
import static com.oopawesome.text.PlainText.plainText;
import static org.assertj.core.api.Assertions.assertThat;

class CapitalizedTextTest {

    @Test
    void shouldThrowExceptionIfNullString() {
        // when
        final Throwable throwable = Assertions.catchThrowable(() -> capitalizedText(null));

        // then
        Assertions.assertThat(throwable).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("getShouldCapitalizeTextTestCases")
    void shouldCapitalizeText(Text textToCapitalize, Text expectedResult) {
        // when
        final Text actualResult = capitalizedText(textToCapitalize);

        // then
        assertThat(actualResult.asString()).isEqualTo(expectedResult.asString());
    }

    private static Stream<Arguments> getShouldCapitalizeTextTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(plainText(""), plainText("")),
                Arguments.of(plainText("cat"), plainText("Cat")),
                Arguments.of(plainText("cAt"), plainText("CAt")),
                Arguments.of(plainText("'cat'"), plainText("'cat'"))
        );
        //@formatter:on
    }
}
