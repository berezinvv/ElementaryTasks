package fibonacci;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 2) {
            try{
                System.out.println(fibonacciRange(Long.parseLong(args[0]), Long.parseLong(args[1])));
            } catch (NumberFormatException ex) {
                System.out.println("invalid parameters");
            }
        } else {
            System.out.println("invalid parameters");
        }
    }

    public static String fibonacciRange(long lower, long upper) {
        long curr = 1, prev = 1;
        String str = "";

        if (upper < 2) {
            return str;
        }

        while (curr <= upper) {
            long temp = curr;
            curr = prev + curr;
            prev = temp;
            if (curr >= lower && curr <= upper) {
                str += curr + ",";
            }
        }
        return str.substring(0, str.length() - 1);
    }
}
