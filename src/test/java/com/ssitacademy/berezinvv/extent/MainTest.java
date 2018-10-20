package com.ssitacademy.berezinvv.extent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int a = 10;
    int b = 10;
    @Test
    void extentNewPositiveTest() {
        assertEquals(Math.pow(a,b), Main.extentNew(a,b));
    }
    @Test
    void extentNewNegativeTest() {
        assertNotEquals(Math.pow(a,a-a), Main.extentNew(a,b));
    }
}