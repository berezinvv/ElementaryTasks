package extent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            printToConcole("Enter the number:");
            a = scanner.nextInt();

            printToConcole("Enter the number power:");
            b = scanner.nextInt();

            printToConcole(extentNew(a, b));

        } catch (NumberFormatException | InputMismatchException ex) {
            printToConcole("invalid parameters");
        }

    }

    public static double extentNew(int a, int b) {

        double res = 1;

        if (a == 0) {
            return 0;
        }

        for (int i = 0; i < Math.abs(b); ) {
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
        return (b > 0) ? res : 1 / res;
    }

    public static void printToConcole(String message){
        System.out.println(message);
    }

    public static void printToConcole(double value){
        System.out.println(value);
    }
}
