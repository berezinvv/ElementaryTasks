package numberToWords;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            try {
                System.out.println(args[0] + " = " + NumberToWords.getNumberToWords(new BigDecimal(args[0])));
            }catch (NumberFormatException ex){
                System.out.println("invalid parameter");
            }

        } else {
            System.out.println("invalid parameter");
        }
    }
}
