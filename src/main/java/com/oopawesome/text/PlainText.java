package com.oopawesome.text;

import com.google.common.base.Preconditions;

public final class PlainText implements Text {

    private final String text;

    private PlainText(final String text) {
        Preconditions.checkNotNull(text, "Argument 'text' cannot be null");
        this.text = text;
    }

    public static Text plainText(final String text) {
        return new PlainText(text);
    }

    @Override
    public String asString() {
        return text;
    }
}
