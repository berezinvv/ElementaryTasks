package com.ssitacademy.berezinvv.envelopeAnalysis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeTest {

    Envelope envelopeFirst = new Envelope( 5,5);
    Envelope envelopeSecond = new Envelope( 6,6);
    Envelope envelopeThird = new Envelope( 4,8);

    @Test
    void isFitIntoOtherPositive() {
        assertTrue(envelopeFirst.isFitIntoOther(envelopeSecond));
    }

    @Test
    void isFitIntoOtherNegative() {
        assertFalse(envelopeFirst.isFitIntoOther(envelopeThird));
    }

}