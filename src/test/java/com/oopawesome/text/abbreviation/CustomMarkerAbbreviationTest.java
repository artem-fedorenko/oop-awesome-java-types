package com.oopawesome.text.abbreviation;

import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.number.integer.SimpleIntNumber;
import com.oopawesome.text.PlainText;
import com.oopawesome.text.Text;
import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CustomMarkerAbbreviationTest {

    @ParameterizedTest
    @MethodSource("getShouldThrowExceptionOnInvalidParametersTestCases")
    void shouldThrowExceptionOnInvalidParameters(Text textToAbbreviate, Text abbreviationMarker, IntNumber maxWidth) {
        // when
        val actualException = catchThrowable(() -> new CustomMarkerAbbreviation(textToAbbreviate, abbreviationMarker, maxWidth).asString());

        // then
        assertThat(actualException).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("getShouldAbbreviateTextTestCases")
    void shouldAbbreviateText(Text textToAbbreviate, Text abbreviationMarker, IntNumber maxWidth, Text expectedResult) {
        // when
        val actualResult = new CustomMarkerAbbreviation(textToAbbreviate, abbreviationMarker, maxWidth);

        // then
        assertThat(actualResult.asString()).isEqualTo(expectedResult.asString());
    }

    private static Stream<Arguments> getShouldThrowExceptionOnInvalidParametersTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(null, new PlainText("."), new SimpleIntNumber(4)),
                Arguments.of(new PlainText("some text"), null, new SimpleIntNumber(4)),
                Arguments.of(new PlainText("some text"), new PlainText("."), null),
                Arguments.of(new PlainText("some short text"), new PlainText("some long abbreviation marker"), new SimpleIntNumber(3))
        );
        //@formatter:on
    }

    private static Stream<Arguments> getShouldAbbreviateTextTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(new PlainText(""), new PlainText("..."), new SimpleIntNumber(4), new PlainText("")),
                Arguments.of(new PlainText("abcdefg"), new PlainText("."), new SimpleIntNumber(5), new PlainText("abcd.")),
                Arguments.of(new PlainText("abcdefg"), new PlainText("."), new SimpleIntNumber(7), new PlainText("abcdefg")),
                Arguments.of(new PlainText("abcdefg"), new PlainText("."), new SimpleIntNumber(8), new PlainText("abcdefg")),
                Arguments.of(new PlainText("abcdefg"), new PlainText(".."), new SimpleIntNumber(4), new PlainText("ab..")),
                Arguments.of(new PlainText("abcdefg"), new PlainText(".."), new SimpleIntNumber(3), new PlainText("a.."))
        );
        //@formatter:on
    }
}
