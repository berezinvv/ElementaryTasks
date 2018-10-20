package com.ssitacademy.berezinvv.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void isIntPositiveTest() {
        assertTrue(InputValidator.getInt("10","").isValid());
    }

    @Test
    void isIntNegativeTest() {
        assertFalse(InputValidator.getInt("1 0","").isValid());
    }

    @Test
    void isDoublePositiveTest() {
        assertTrue(InputValidator.getDouble("10","").isValid());
    }

    @Test
    void isDoubleNegativeTest() {
        assertFalse(InputValidator.getDouble("1 0","").isValid());
    }

    @Test
    void isLongPositiveTest() {
        assertTrue(InputValidator.getLong("10","").isValid());
    }

    @Test
    void isLongNegativeTest() {
        assertFalse(InputValidator.getLong("1 0","").isValid());
    }

    @Test
    void isBigDecimalPositiveTest() {
        assertTrue(InputValidator.getBigDecimal("10","").isValid());
    }

    @Test
    void isBigDecimalNegativeTest() {
        assertFalse(InputValidator.getBigDecimal("1 0","").isValid());
    }

    @Test
    void isContainsOneParametersPositiveTest() {
        assertTrue(InputValidator.isContainsCountParametersArray(new String[]{"1"},1));
    }

    @Test
    void isItContainsOneParametersNegativeTest() {
        assertFalse(InputValidator.isContainsCountParametersArray(new String[]{},1));
    }

    @Test
    void isContainsTwoParametersPositiveTest() {
        assertTrue(InputValidator.isContainsCountParametersArray(new String[]{"1","2"},2));
    }

    @Test
    void isContainsTwoParametersNegativeTest() {
        assertFalse(InputValidator.isContainsCountParametersArray(new String[]{"1"},2));
    }

    @Test
    void isItContainsThreeParametersPositiveTest() {
        assertTrue(InputValidator.isContainsCountParametersArray(new String[]{"1","2","3"},3));
    }

    @Test
    void isContainsThreeParametersNegativeTest() {
        assertFalse(InputValidator.isContainsCountParametersArray(new String[]{"1","2"},3));
    }

    @Test
    void isContainsFourParametersPositiveTest() {
        assertTrue(InputValidator.isContainsCountParametersArray(new String[]{"1","2","3","4"},4));
    }

    @Test
    void isContainsFourParametersNegativeTest() {
        assertFalse(InputValidator.isContainsCountParametersArray(new String[]{"1","2","3"},4));
    }

}