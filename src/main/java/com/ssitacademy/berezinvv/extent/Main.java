package com.ssitacademy.berezinvv.extent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number:");
            a = scanner.nextInt();

            System.out.println("Enter the number power:");
            b = scanner.nextInt();

            System.out.println(extentNew(a, b));

        } catch (NumberFormatException | InputMismatchException ex) {
            System.out.println("invalid parameters");
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
                i *= 2;
            } else {
                res = res * a;
                i++;
            }
        }
        return (b > 0) ? res : 1 / res;
    }
}
