package com.ssitacademy.berezinvv.sortTriangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TriangleTest {
    Triangle triangleFirst = new Triangle("First", 5, 5, 5);
    Triangle triangleSecond = new Triangle("First", 5, 5, 5);
    Triangle triangleThirt = new Triangle("First", 6, 6, 6);

    @Test
    void compareToPositiveTest() {
        int expected = 0;
        assertEquals(expected, triangleFirst.compareTo(triangleSecond));
    }

    @Test
    void compareToNegativeTest() {
        int expected = 0;
        assertNotEquals(expected, triangleFirst.compareTo(triangleThirt));
    }

}