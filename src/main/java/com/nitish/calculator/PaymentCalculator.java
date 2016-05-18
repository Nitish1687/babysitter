package com.nitish.calculator;

import com.nitish.builder.WorkingHour;

public class PaymentCalculator {

    private final ChargeCalculator chargeCalculator;
    private static final String REGEX = ":";

    public PaymentCalculator(ChargeCalculator calculator) {
        this.chargeCalculator = calculator;
    }

    public final int calculate(WorkingHour workingHour) {
        return chargeCalculator.calculate(workingHour);
    }


}
