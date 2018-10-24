package com.ssitacademy.berezinvv.extent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = 0;
        int power = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number:");
            number = scanner.nextInt();

            System.out.println("Enter the number power:");
            power = scanner.nextInt();

            System.out.println(extentNew(number, power));

        } catch (NumberFormatException | InputMismatchException ex) {
            System.out.println("invalid parameters");
        }
    }

    public static double extentNew(int number, int power) {
        double res = 1;

        if (number == 0) {
            return 0;
        }
        for (int i = 0; i < Math.abs(power); ) {
            if (i == 0 || i == 1) {
                res *= number;
                i++;
            } else if (i * 2 <= power) {
                res *= res;
                i *= 2;
            } else {
                res = res * number;
                i++;
            }
        }
        return (power > 0) ? res : 1 / res;
    }
}
