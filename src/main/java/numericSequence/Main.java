package numericSequence;

public class Main {

    public static final String MESSAGE_INFO = "usage: [<number>]\n" +
            "\tnumber - value (integer)\n";

    public static void main(String[] args) {
        if (args.length >= 1) {
            try {
                printToConcole(getNumericSequence(Integer.parseInt(args[0])));
            } catch (NumberFormatException ex) {
                printToConcole("invalid parameters\n" + MESSAGE_INFO);
            }
        } else {
            printToConcole("invalid parameter\n" + MESSAGE_INFO);
        }
    }

    public static String getNumericSequence(int max) {
        StringBuilder strBuilder = new StringBuilder();
        int number = 0;
        double numberInDegree = 0;
        while (numberInDegree < max) {
            number++;
            numberInDegree = Math.pow(number, 2);
            if (numberInDegree <= max) {
                strBuilder.append(number + ",");
            }
        }
        return strBuilder.substring(0, strBuilder.length() - 1);
    }

    public static void printToConcole(String message){
        System.out.println(message);
    }
}
