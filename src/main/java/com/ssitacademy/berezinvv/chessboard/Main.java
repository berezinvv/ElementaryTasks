package com.ssitacademy.berezinvv.chessboard;

import com.ssitacademy.berezinvv.validator.InputValidator;
import com.ssitacademy.berezinvv.validator.IntValidation;

public class Main {
    public static void main(String[] args) {

        if (InputValidator.isContainsCountParametersArray(args, 2)) {
            IntValidation paramWidth = InputValidator.getInt(args[0],
                    "First parameter ");
            IntValidation paramHeight = InputValidator.getInt(args[1],
                    "Second parameter ");
            if (paramHeight.isValid() && paramHeight.isValid()) {
                int width = paramWidth.getValue();
                int height = paramHeight.getValue();

                ChessBoard chessBoard = new ChessBoard(width, height);
                System.out.println(chessBoard);
            } else {
                System.out.println(paramWidth.getError() + "\n" + paramHeight.getError());
            }

        } else {
            System.out.println("invalid parameters \n" + ChessBoard.MESSAGE_INFO);
        }
    }
}
