package com.ssitacademy.berezinvv.fileParser;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileServiceTest {
    @Test
    void countPointsTest() {
        Throwable exception = assertThrows(IOException.class,
                () -> {
                    FileService.countPoints("WRONG", "");
                });
    }

    @Test
    void replaceWithStringInFileTest() {
        Throwable exception = assertThrows(IOException.class,
                () -> {
                    FileService.replaceWithStringInFile("WRONG", "", "");
                });
    }

}