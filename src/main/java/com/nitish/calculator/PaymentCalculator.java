package com.nitish.calculator;

import com.nitish.builder.WorkingHour;

import static com.nitish.charge.ChargeEnum.START_TIME_TO_BED_TIME_CHARGE;
import static java.lang.Integer.valueOf;

public class PaymentCalculator {

    private static final String REGEX = ":";

    public int calculate(WorkingHour workingHour) {
        String startTime = workingHour.getStartTime();
        String[] startTimeToken = startTime.split(REGEX);
        String bedTime = workingHour.getBedTime();
        String[] bedTimeToken = bedTime.split(REGEX);
        return (valueOf(bedTimeToken[0]) - valueOf(startTimeToken[0])) * START_TIME_TO_BED_TIME_CHARGE.getAmount();
    }
}
