package com.ssitacademy.berezinvv.fibonacci;

import com.ssitacademy.berezinvv.validator.InputValidator;
import com.ssitacademy.berezinvv.validator.LongValidation;

public class Main {

    public static final String MESSAGE_INFO = "usage: [<lower> <upper>]\n" +
            "\tlower  - lower range value\n" +
            "\tupper  - upper range value\n";

    public static void main(String[] args) {
        if (InputValidator.isContainsCountParametersOfArray(args, 2)) {

            LongValidation paramLower = InputValidator.getLong(args[0],
                    "First parameter ");
            LongValidation paramUpper = InputValidator.getLong(args[1],
                    "Second parameter ");
            if (paramLower.isValid() && paramUpper.isValid()) {
                System.out.println(fibonacciRange(paramLower.getValue(), paramUpper.getValue()));
            } else {
                System.out.println(paramLower.getError() + "\n" + paramUpper.getError());
            }
        } else {
            System.out.println("invalid parameters\n" + MESSAGE_INFO);
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
        return strBuilder.substring(0, (strBuilder.length() == 0) ? 0 : strBuilder.length() - 1);
    }
}
