package com.ssitacademy.berezinvv.numericSequence;

import com.ssitacademy.berezinvv.validator.InputValidator;
import com.ssitacademy.berezinvv.validator.IntValidation;

public class Main {

    public static final String MESSAGE_INFO = "usage: [<number>]\n" +
            "\tnumber - value (integer)\n";

    public static void main(String[] args) {
        if (InputValidator.isContainsCountParametersArray(args,1)) {
            IntValidation param = InputValidator.getInt(args[0],
                    "Parameter ");
            if (param.isValid()) {
                System.out.println(getNumericSequence(param.getValue()));
            } else {
                System.out.println(param.getError());
            }
        } else {
            System.out.println("invalid parameter\n" + MESSAGE_INFO);
        }
    }

    public static String getNumericSequence(int max) {
        StringBuilder strBuilder = new StringBuilder();
        int number = 0;
        double numberInDegree = 0;
        while (numberInDegree < max) {
            number++;
            numberInDegree = Math.pow(number, 2);
            if (numberInDegree <= max) {
                strBuilder.append(number + ",");
            }
        }
        return strBuilder.substring(0, (strBuilder.length() == 0) ? 0 : strBuilder.length() - 1);
    }
}
