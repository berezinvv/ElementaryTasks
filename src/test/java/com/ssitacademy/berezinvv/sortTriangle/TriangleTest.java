package com.ssitacademy.berezinvv.sortTriangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTest {
    Triangle triangleFirst = new Triangle("First", 5, 5, 5);
    Triangle triangleSecond = new Triangle("First", 5, 5, 5);
    Triangle triangleThirt = new Triangle("First", 6, 6, 6);

    @Test
    void compareToPositive() {
        assertTrue(triangleFirst.compareTo(triangleSecond) == 0);
    }

    @Test
    void compareToNegative() {
        assertFalse(triangleFirst.compareTo(triangleThirt) == 0);
    }

}