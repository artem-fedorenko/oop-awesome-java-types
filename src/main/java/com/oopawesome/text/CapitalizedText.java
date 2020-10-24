package com.oopawesome.text;

import com.google.common.base.Preconditions;

public final class CapitalizedText implements Text {

    private final Text textToCapitalize;

    private CapitalizedText(final Text textToCapitalize) {
        Preconditions.checkNotNull(textToCapitalize, "Argument 'textToCapitalize' cannot be null");
        this.textToCapitalize = textToCapitalize;
    }

    public static Text capitalizedText(final Text textToCapitalize) {
        return new CapitalizedText(textToCapitalize);
    }

    @Override
    public String asString() {
        if (isEmptyText(textToCapitalize)) {
            return textToCapitalize.asString();
        }
        if (isOneCharText(textToCapitalize)) {
            return String.valueOf(getFirstCharCapitalized(textToCapitalize));
        }
        return getFirstCharCapitalized(textToCapitalize) + getTextAfterFirstChar(textToCapitalize);
    }

    private boolean isEmptyText(final Text textToCapitalize) {
        return "".equals(textToCapitalize.asString());
    }

    private boolean isOneCharText(final Text textToCapitalize) {
        return textToCapitalize.asString().length() == 1;
    }

    private char getFirstCharCapitalized(final Text textToCapitalize) {
        final char firstChar = textToCapitalize.asString().charAt(0);
        return Character.toTitleCase(firstChar);
    }

    private String getTextAfterFirstChar(final Text textToCapitalize) {
        return textToCapitalize.asString().substring(1);
    }
}
