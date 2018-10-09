package numericSequence;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            try {
                System.out.println(printNumericSequence(Double.parseDouble(args[0])));
            } catch (NumberFormatException ex) {
                System.out.println("invalid parameters");
            }
        } else {
            System.out.println("invalid parameter");
        }
    }

    public static String printNumericSequence(double max) {
        String str = "";
        int number = 0;
        double numberInDegree = 0;
        while (numberInDegree < max) {
            number++;
            numberInDegree = Math.pow(number, 2);
            if (numberInDegree <= max) {
                str += number + ",";
            }
        }
        return str.substring(0, str.length() - 1);
    }
}
