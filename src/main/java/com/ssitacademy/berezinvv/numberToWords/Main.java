package com.ssitacademy.berezinvv.numberToWords;

import com.ssitacademy.berezinvv.validator.BigDecimalValidation;
import com.ssitacademy.berezinvv.validator.InputValidator;

import java.math.BigDecimal;

import static com.ssitacademy.berezinvv.numberToWords.NumberToWords.MESSAGE_INFO;

public class Main {
    public static void main(String[] args) {
        if (InputValidator.isContainsCountParametersOfArray(args,1)) {
            BigDecimalValidation param = InputValidator.getBigDecimal(args[0],
                    "Parameter ");
            if (param.isValid()) {
                System.out.println(param.getValue() + " = " + NumberToWords.getNumberToWords(param.getValue()));
            }else {
                System.out.println(param.getError());
            }
        } else {
            System.out.println("invalid parameter\n" + MESSAGE_INFO);
        }
    }
}
