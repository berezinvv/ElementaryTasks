package com.ssitacademy.berezinvv.numberToWords;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordsTest {
    @Test
    void getNumberToWordsIfParamZero() {
        assertTrue(NumberToWords.getNumberToWords(new BigDecimal(0)).contains("ноль"));
    }
    @Test
    void getNumberToWordsIfParamLessThanZero() {
        assertTrue(NumberToWords.getNumberToWords(new BigDecimal(-100)).contains("минус"));
    }
    @Test
    void getNumberToWordsWithParamLenghtNotZero() {
        assertTrue(NumberToWords.getNumberToWords(new BigDecimal(1030)).length()!=0);
    }
}