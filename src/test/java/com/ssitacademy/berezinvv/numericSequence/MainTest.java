package com.ssitacademy.berezinvv.numericSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    @Test
    void getNumericSequenceIfParamMoreTwo() {
        int max = 4;
        assertTrue(Main.getNumericSequence(max).length() != 0);
    }

    @Test
    void getNumericSequenceIfParamZero() {
        int max = 0;
        assertTrue(Main.getNumericSequence(max).length() == 0);
    }

}