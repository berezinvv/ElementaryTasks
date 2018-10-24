package com.ssitacademy.berezinvv.extent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {
    int number = 10;
    int power = 10;

    @Test
    void extentNewPositiveTest() {
        double expected = Math.pow(number, power);
        assertEquals(expected, Main.extentNew(number, power));
    }

    @Test
    void extentNewNegativeTest() {
        double expected = Math.pow(number, number + 2);
        assertNotEquals(expected, Main.extentNew(number, power));
    }
}