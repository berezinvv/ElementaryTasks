package com.ssitacademy.berezinvv.validator;

public class LongValidation {
    private boolean isValid;
    private long value;
    private String error;

    public LongValidation(boolean isValid, long value, String error) {
        this.isValid = isValid;
        this.value = value;
        this.error = error;
    }

    public boolean isValid() {
        return isValid;
    }

    public long getValue() {
        return value;
    }

    public String getError() {
        return error;
    }
}
