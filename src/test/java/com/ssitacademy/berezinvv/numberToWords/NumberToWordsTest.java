package com.ssitacademy.berezinvv.numberToWords;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberToWordsTest {
    @Test
    void getNumberToWordsIfParamZeroTest() {
        assertTrue(NumberToWords.getNumberToWords(new BigDecimal(0)).contains("ноль"));
    }

    @Test
    void getNumberToWordsIfParamLessThanZeroTest() {
        assertTrue(NumberToWords.getNumberToWords(new BigDecimal(-100)).contains("минус"));
    }

    @Test
    void getNumberToWordsWithParamLenghtNotZeroTest() {
        assertTrue(NumberToWords.getNumberToWords(new BigDecimal(1030)).length() != 0);
    }
}