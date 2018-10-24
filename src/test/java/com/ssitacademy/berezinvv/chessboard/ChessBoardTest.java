package com.ssitacademy.berezinvv.chessboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessBoardTest {
    ChessBoard chessBoard = new ChessBoard(0, 0);

    @Test
    void toStringPositiveIfParamsZeroTest() {
        String expected = "";
        assertEquals(expected, chessBoard.toString());
    }

    @Test
    void toStringPositiveIfParamsNotZeroTest() {
        String expected = new String("*\n");
        chessBoard.setHeight(1);
        chessBoard.setWidth(1);
        assertEquals(expected, chessBoard.toString());
    }

    @Test
    void toStringPositiveIfParamsNotZeroByLenghtTest() {
        int width = 5;
        int height = 12;
        int expected = width * height + height;
        chessBoard.setHeight(height);
        chessBoard.setWidth(width);
        assertEquals(expected, chessBoard.toString().length());
    }
}