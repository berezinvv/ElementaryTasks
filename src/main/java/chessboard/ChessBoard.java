package chessboard;

public class ChessBoard {
    static public void printChessBoard(int width, int height) {
        String str = "";

        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                str += "*";
            } else {
                str += " ";
            }
        }

        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                System.out.println(str);
            } else {
                System.out.println((" " + str).substring(0, width));
            }

        }
    }
}
