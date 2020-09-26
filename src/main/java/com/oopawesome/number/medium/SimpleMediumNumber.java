package com.oopawesome.number.medium;

public class SimpleMediumNumber implements MediumNumber {

    private final int mediumNumber;

    private SimpleMediumNumber(final int mediumNumber) {
        this.mediumNumber = mediumNumber;
    }

    public static MediumNumber simpleMediumNumber(final int mediumNumber) {
        return new SimpleMediumNumber(mediumNumber);
    }

    @Override
    public int asInteger() {
        return mediumNumber;
    }
}
