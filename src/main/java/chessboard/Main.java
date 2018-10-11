package chessboard;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            View.printToConcole("invalid parameters \n" + ChessBoard.MESSAGE_INFO);
        } else {

            try {
                ChessBoard.printChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            } catch (NumberFormatException ex) {
                View.printToConcole("invalid parameters");
            }
        }

    }
}
