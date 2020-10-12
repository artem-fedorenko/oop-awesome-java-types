package com.oopawesome.text.abbreviation;

import com.google.common.base.Preconditions;
import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.text.Text;

import static com.oopawesome.text.PlainText.plainText;
import static com.oopawesome.text.abbreviation.Abbreviations.abbreviation;

final class NormalAbbreviation implements Text {

    private final Text textToAbbreviate;
    private final IntNumber maxWidth;

    NormalAbbreviation(final Text textToAbbreviate, final IntNumber maxWidth) {
        Preconditions.checkNotNull(textToAbbreviate, "Argument 'textToAbbreviate' cannot be null");
        Preconditions.checkNotNull(maxWidth, "Argument 'maxWidth' cannot be null");
        Preconditions.checkArgument(maxWidth.asInteger() > 3, "Argument 'maxWidth' must be at least 4");
        this.textToAbbreviate = textToAbbreviate;
        this.maxWidth = maxWidth;
    }

    @Override
    public String asString() {
        return abbreviation(textToAbbreviate, plainText("..."), maxWidth).asString();
    }
}
