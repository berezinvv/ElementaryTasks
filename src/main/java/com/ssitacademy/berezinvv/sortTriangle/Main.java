package com.ssitacademy.berezinvv.sortTriangle;

import com.ssitacademy.berezinvv.validator.DoubleValidation;
import com.ssitacademy.berezinvv.validator.InputValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String MESSAGE_INFO = "usage: [<name>,<firstSide>,<secondSide>,<thirdSide>]\n" +
            "\tname       - triangle name\n" +
            "\tfirstSide  - value of the first side of the triangle\n" +
            "\tsecondSide - value of the second side of the triangle\n" +
            "\tthirdSide  - value of the third side of the triangle\n";

    public static void main(String[] args) {

        boolean keepOn = false;
        Scanner scanner = new Scanner(System.in);
        List<Triangle> triangleList = new ArrayList<Triangle>();

        String[] array;

        do {
            try {

                System.out.println("Enter the triangle param (name,firstSide,secondSide,thirdSide)");
                String line = scanner.nextLine();
                array = line.split(",");

                if (InputValidator.isContainsCountParametersArray(array,4)) {
                    DoubleValidation paramSecond = InputValidator.getDouble(args[0],
                            "Second parameter ");
                    DoubleValidation paramThird = InputValidator.getDouble(args[1],
                            "Third parameter ");
                    DoubleValidation paramFourth = InputValidator.getDouble(args[0],
                            "Fourth parameter ");

                    if (paramSecond.isValid() && paramThird.isValid() && paramFourth.isValid()) {
                        Triangle triangle = new Triangle(array[0], paramSecond.getValue(), paramThird.getValue(), paramFourth.getValue());
                        triangleList.add(triangle);
                    } else {
                        System.out.println(paramSecond.getError() + "\n" + paramThird.getError() + "\n" + paramFourth.getError() + "\n");
                    }
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("invalid parameters\n" + MESSAGE_INFO);
            }
            System.out.println("Do you want to continue(y/yes)?");
            String answer = scanner.next().toLowerCase();
            scanner.nextLine();

            keepOn = (answer.equals("y") || answer.equals("yes")) ? true : false;
        } while (keepOn);

        //sort list
        Collections.sort(triangleList);

        System.out.println("======================== Triangle list: ========================");
        for (Triangle triangle : triangleList) {
            System.out.println(triangle.toString());
        }
        scanner.close();
    }
}
