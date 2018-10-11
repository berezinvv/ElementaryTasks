package fileParser;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 2) {//number of line entries
                View.printToConcole("number of line entries = " + FileService.countPoints(args[0], args[1]));
            } else if (args.length == 3) { //replaceWithStringInFile
                FileService.replaceWithStringInFile(args[0], args[1], args[2]);
            } else {
                View.printToConcole("invalid parameters\n" + FileService.MESSAGE_INFO);
            }
        } catch (NumberFormatException ex) {
            View.printToConcole("invalid parameters\n" + FileService.MESSAGE_INFO);
        }
    }
}
