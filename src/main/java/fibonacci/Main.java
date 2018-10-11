package fibonacci;

public class Main {

    public static final String MESSAGE_INFO = "usage: [<lower> <upper>]\n" +
            "\tlower  - lower range value\n" +
            "\tupper  - upper range value\n";

    public static void main(String[] args) {
        if (args.length >= 2) {
            try{
                System.out.println(fibonacciRange(Long.parseLong(args[0]), Long.parseLong(args[1])));
            } catch (NumberFormatException ex) {
                printToConcole("invalid parameters\n" + MESSAGE_INFO);
            }
        } else {
            printToConcole("invalid parameters\n" + MESSAGE_INFO);
        }
    }

    public static String fibonacciRange(long lower, long upper) {
        long curr = 1, prev = 0;
        StringBuilder strBuilder = new StringBuilder();


        while (curr <= upper) {
            long temp = curr;
            curr = prev + curr;
            prev = temp;
            if (curr >= lower && curr <= upper) {
                strBuilder.append(curr + ",");
            }
        }
        return strBuilder.substring(0, strBuilder.length() - 1);
    }

    public static void printToConcole(String message){
        System.out.println(message);
    }
}
