package com.ssitacademy.berezinvv.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {
    @Test
    void isfibonacciRangeEmptyPositiveTest() {
        String expected = "";
        assertEquals(expected, Main.fibonacciRange(0, 0));
    }

    @Test
    void isfibonacciRangeNotEmptyPositiveTest() {
        String expected = "";
        assertNotEquals(expected, Main.fibonacciRange(0, 8));
    }

}