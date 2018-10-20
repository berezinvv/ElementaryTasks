package com.ssitacademy.berezinvv.validator;

public class DoubleValidation {
    private boolean isValid;
    private double value;
    private String error;

    public DoubleValidation(boolean isValid, double value, String error) {
        this.isValid = isValid;
        this.value = value;
        this.error = error;
    }

    public boolean isValid() {
        return isValid;
    }

    public double getValue() {
        return value;
    }

    public String getError() {
        return error;
    }
}
