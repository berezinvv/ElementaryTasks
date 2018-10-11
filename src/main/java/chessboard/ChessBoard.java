package chessboard;

public class ChessBoard {

    public static final String MESSAGE_INFO = "usage: [<width> <height>]\n" +
            "\twidth  - checkerboard width\n" +
            "\theight - checkerboard height\n";

    static public void printChessBoard(int width, int height) {

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                str.append("*");
            } else {
                str.append(" ");
            }
        }
        String str_odd = str.toString();
        String str_even = str.insert(0,"").substring(0, width);

        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                View.printToConcole(str_odd);
            } else {
                View.printToConcole(str_even);
            }

        }
    }
}
