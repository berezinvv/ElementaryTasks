package chessboard;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("- you need to enter two parameters: width and height");
        } else if (args.length < 2) {
            System.out.println("not enough parameters");
        } else {

            try {
                ChessBoard.printChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            } catch (NumberFormatException ex) {
                System.out.println("invalid parameters");
            }
        }

    }
}
