package com.ssitacademy.berezinvv.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void isfibonacciRangeEmptyPositive() {
        assertTrue(Main.fibonacciRange(0,0).equals(""));
    }

    @Test
    void isfibonacciRangeNotEmptyPositive() {
        assertFalse(Main.fibonacciRange(0,8).equals(""));
    }

}