package com.oopawesome.number.integer;

public class SimpleIntNumber implements IntNumber {

    private final int intNumber;

    private SimpleIntNumber(final int intNumber) {
        this.intNumber = intNumber;
    }

    public static IntNumber simpleIntNumber(final int intNumber) {
        return new SimpleIntNumber(intNumber);
    }

    @Override
    public int asInteger() {
        return intNumber;
    }
}
