package com.nitish.calculator;

import com.nitish.builder.WorkingHour;

@FunctionalInterface
public interface ChargeCalculator {

    int calculate(WorkingHour workingHour);
}
