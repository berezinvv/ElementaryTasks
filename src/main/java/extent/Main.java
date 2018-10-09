package extent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double a = 0;
        double b = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number:");
            a = scanner.nextDouble();

            System.out.println("Enter the number power:");
            b = scanner.nextDouble();

            System.out.println(extentNew(a, b));

        } catch (NumberFormatException | InputMismatchException ex) {
            System.out.println("invalid parameters");
        }

}

    public static double extentNew(double a, double b) {

        double res = 1;

        for (int i = 0; i < b; ) {
            if (i == 0 || i == 1) {
                res *= a;
                i++;
            } else if (i * 2 <= b) {
                res *= res;
                i *= i;
            } else {
                res = res * a;
                i++;
            }
        }
        return res;
    }
}
