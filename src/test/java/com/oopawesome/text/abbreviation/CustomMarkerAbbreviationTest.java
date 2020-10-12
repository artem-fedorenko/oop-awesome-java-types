package com.oopawesome.text.abbreviation;

import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.text.Text;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.oopawesome.number.integer.SimpleIntNumber.simpleIntNumber;
import static com.oopawesome.text.PlainText.plainText;
import static com.oopawesome.text.abbreviation.Abbreviations.abbreviation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CustomMarkerAbbreviationTest {

    @ParameterizedTest
    @MethodSource("getShouldThrowExceptionOnInvalidParametersTestCases")
    void shouldThrowExceptionOnInvalidParameters(Text textToAbbreviate, Text abbreviationMarker, IntNumber maxWidth) {
        // when
        final Throwable actualException = catchThrowable(() -> abbreviation(textToAbbreviate, abbreviationMarker, maxWidth));

        // then
        assertThat(actualException).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("getShouldAbbreviateTextTestCases")
    void shouldAbbreviateText(Text textToAbbreviate, Text abbreviationMarker, IntNumber maxWidth, Text expectedResult) {
        // when
        final Text actualResult = abbreviation(textToAbbreviate, abbreviationMarker, maxWidth);

        // then
        assertThat(actualResult.asString()).isEqualTo(expectedResult.asString());
    }

    private static Stream<Arguments> getShouldThrowExceptionOnInvalidParametersTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(null, plainText("."), simpleIntNumber(4)),
                Arguments.of(plainText("some text"), null, simpleIntNumber(4)),
                Arguments.of(plainText("some text"), plainText("."), null),
                Arguments.of(plainText("some short text"), plainText("some long abbreviation marker"), simpleIntNumber(3))
        );
        //@formatter:on
    }

    private static Stream<Arguments> getShouldAbbreviateTextTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(plainText(""), plainText("..."), simpleIntNumber(4), plainText("")),
                Arguments.of(plainText("abcdefg"), plainText("."), simpleIntNumber(5), plainText("abcd.")),
                Arguments.of(plainText("abcdefg"), plainText("."), simpleIntNumber(7), plainText("abcdefg")),
                Arguments.of(plainText("abcdefg"), plainText("."), simpleIntNumber(8), plainText("abcdefg")),
                Arguments.of(plainText("abcdefg"), plainText(".."), simpleIntNumber(4), plainText("ab..")),
                Arguments.of(plainText("abcdefg"), plainText(".."), simpleIntNumber(3), plainText("a.."))
        );
        //@formatter:on
    }
}
