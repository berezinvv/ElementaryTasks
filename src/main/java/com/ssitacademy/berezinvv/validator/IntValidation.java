package com.ssitacademy.berezinvv.validator;

public class IntValidation {
    private boolean isValid;
    private int value;
    private String error;

    public IntValidation(boolean isValid, int value, String error) {
        this.isValid = isValid;
        this.value = value;
        this.error = error;
    }

    public boolean isValid() {
        return isValid;
    }

    public int getValue() {
        return value;
    }

    public String getError() {
        return error;
    }
}
