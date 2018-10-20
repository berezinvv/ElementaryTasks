package com.ssitacademy.berezinvv.chessboard;

public class ChessBoard {

    public static final String WHITE = " ";
    public static final String BLACH = "*";

    private int width;
    private int height;

    public ChessBoard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static final String MESSAGE_INFO = "usage: [<width> <height>]\n" +
            "\twidth  - checkerboard width\n" +
            "\theight - checkerboard height\n";

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                strBuilder.append(BLACH);
            } else {
                strBuilder.append(WHITE);
            }
        }
        String str_odd = strBuilder.toString();
        String str_even = strBuilder.insert(0, " ").substring(0, width);

        strBuilder.delete(0, strBuilder.length());
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                strBuilder.append(str_odd);
            } else {
                strBuilder.append(str_even);
            }
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }
}
