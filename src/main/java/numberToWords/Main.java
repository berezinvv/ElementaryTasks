package numberToWords;

import java.math.BigDecimal;

import static numberToWords.NumberToWords.MESSAGE_INFO;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            try {
                View.printToConcole(args[0] + " = " + NumberToWords.getNumberToWords(new BigDecimal(args[0])));
            } catch (NumberFormatException ex) {
                View.printToConcole("invalid parameter\n" + MESSAGE_INFO);
            }

        } else {
            View.printToConcole("invalid parameter\n" + MESSAGE_INFO);
        }
    }
}
