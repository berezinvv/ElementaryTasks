package com.ssitacademy.berezinvv.numericSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {
    @Test
    void getNumericSequenceIfParamMoreTwoTest() {
        int max = 4;
        int expected = 0;
        assertNotEquals(expected, Main.getNumericSequence(max).length());
    }

    @Test
    void getNumericSequenceIfParamZeroTest() {
        int max = 0;
        int expected = 0;
        assertEquals(expected, Main.getNumericSequence(max).length());
    }

}