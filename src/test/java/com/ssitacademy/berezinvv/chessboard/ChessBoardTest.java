package com.ssitacademy.berezinvv.chessboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChessBoardTest {
    ChessBoard chessBoard = new ChessBoard(0, 0);

    @Test
    void toStringPositiveIfParamsZero() {
        String expected = "";
        assertEquals(expected, chessBoard.toString());
    }
    @Test
    void toStringPositiveIfParamsNotZero() {
        String expected = new String("*\n");
        chessBoard.setHeight(1);
        chessBoard.setWidth(1);
        assertTrue(chessBoard.toString().equals(expected));
    }
    @Test
    void toStringPositiveIfParamsNotZeroByLenght() {
        int width = 5;
        int height = 12;
        chessBoard.setHeight(height);
        chessBoard.setWidth(width);
        assertTrue(chessBoard.toString().length() == width * height + height);
    }
}