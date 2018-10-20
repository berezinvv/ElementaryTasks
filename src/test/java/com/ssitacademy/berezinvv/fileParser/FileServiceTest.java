package com.ssitacademy.berezinvv.fileParser;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {
    @Test
    void countPoints() {
        Throwable exception = assertThrows(IOException.class,
                ()->{FileService.countPoints("WRONG", "");} );
    }

    @Test
    void replaceWithStringInFile() {
        Throwable exception = assertThrows(IOException.class,
                ()->{FileService.replaceWithStringInFile("WRONG", "", "");} );
    }

}