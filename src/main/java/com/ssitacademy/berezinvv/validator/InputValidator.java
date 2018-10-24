package com.ssitacademy.berezinvv.validator;

import java.math.BigDecimal;

public class InputValidator {

    public static IntValidation getInt(String str, String msg) {
        IntValidation result = null;
        try {
            result = new IntValidation(true, Integer.parseInt(str), "");
        } catch (NumberFormatException e) {
            result = new IntValidation(false, 0, "- not correct");
        }
        return result;
    }

    public static DoubleValidation getDouble(String str, String msg) {
        DoubleValidation result = null;
        try {
            result = new DoubleValidation(true, Double.parseDouble(str), "");
        } catch (NumberFormatException e) {
            result = new DoubleValidation(false, 0, "- not correct");
        }
        return result;
    }

    public static LongValidation getLong(String str, String msg) {
        LongValidation result = null;
        try {
            result = new LongValidation(true, Long.parseLong(str), "");
        } catch (NumberFormatException e) {
            result = new LongValidation(false, 0, "- not correct");
        }
        return result;
    }

    public static BigDecimalValidation getBigDecimal(String str, String msg) {
        BigDecimalValidation result = null;
        try {
            result = new BigDecimalValidation(true, new BigDecimal(str), "");
        } catch (NumberFormatException e) {
            result = new BigDecimalValidation(false, new BigDecimal(0), "- not correct");
        }
        return result;
    }

    public static boolean isContainsCountParametersOfArray(String[] array, int length) {
        if (array.length >= length) {
            return true;
        } else {
            return false;
        }
    }
}
