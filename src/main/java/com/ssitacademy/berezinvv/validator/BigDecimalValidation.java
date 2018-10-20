package com.ssitacademy.berezinvv.validator;

import java.math.BigDecimal;

public class BigDecimalValidation {
    private boolean isValid;
    private BigDecimal value;
    private String error;

    public BigDecimalValidation(boolean isValid, BigDecimal value, String error) {
        this.isValid = isValid;
        this.value = value;
        this.error = error;
    }

    public boolean isValid() {
        return isValid;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getError() {
        return error;
    }
}
