package com.oopawesome.text.abbreviation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import com.google.common.base.Preconditions;
import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.text.PlainText;
import com.oopawesome.text.Text;

@Value
@Getter(AccessLevel.NONE)
public class NormalAbbreviation implements Text {

    @NonNull Text textToAbbreviate;
    @NonNull IntNumber maxWidth;

    @Override
    public String asString() {
        Preconditions.checkArgument(maxWidth.asInteger() > 3, "Argument 'maxWidth' must be at least 4");
        return new CustomMarkerAbbreviation(textToAbbreviate, new PlainText("..."), maxWidth).asString();
    }
}
