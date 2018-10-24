package com.ssitacademy.berezinvv.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputValidatorTest {
    boolean expectedTrue = true;
    boolean expectedFalse = false;

    @Test
    void isIntPositiveTest() {
        assertEquals(expectedTrue, InputValidator.getInt("10", "").isValid());
    }

    @Test
    void isIntNegativeTest() {
        assertEquals(expectedFalse, InputValidator.getInt("1 0", "").isValid());
    }

    @Test
    void isDoublePositiveTest() {
        assertEquals(expectedTrue, InputValidator.getDouble("10", "").isValid());
    }

    @Test
    void isDoubleNegativeTest() {
        assertEquals(expectedFalse, InputValidator.getDouble("1 0", "").isValid());
    }

    @Test
    void isLongPositiveTest() {
        assertEquals(expectedTrue, InputValidator.getLong("10", "").isValid());
    }

    @Test
    void isLongNegativeTest() {
        assertEquals(expectedFalse, InputValidator.getLong("1 0", "").isValid());
    }

    @Test
    void isBigDecimalPositiveTest() {
        assertEquals(expectedTrue, InputValidator.getBigDecimal("10", "").isValid());
    }

    @Test
    void isBigDecimalNegativeTest() {
        assertEquals(expectedFalse, InputValidator.getBigDecimal("1 0", "").isValid());
    }

    @Test
    void isContainsOneParametersPositiveTest() {
        assertEquals(expectedTrue, InputValidator.isContainsCountParametersOfArray(new String[]{"1"}, 1));
    }

    @Test
    void isItContainsOneParametersNegativeTest() {
        assertEquals(expectedFalse, InputValidator.isContainsCountParametersOfArray(new String[]{}, 1));
    }

    @Test
    void isContainsTwoParametersPositiveTest() {
        assertEquals(expectedTrue, InputValidator.isContainsCountParametersOfArray(new String[]{"1", "2"}, 2));
    }

    @Test
    void isContainsTwoParametersNegativeTest() {
        assertEquals(expectedFalse, InputValidator.isContainsCountParametersOfArray(new String[]{"1"}, 2));
    }
}