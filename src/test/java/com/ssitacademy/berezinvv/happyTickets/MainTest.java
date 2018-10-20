package com.ssitacademy.berezinvv.happyTickets;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void readFile() {
        Throwable exception = assertThrows(IOException.class,
                ()->{Main.readFile("WRONG");} );
    }
}