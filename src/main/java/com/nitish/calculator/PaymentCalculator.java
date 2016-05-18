package com.nitish.calculator;

import com.nitish.builder.WorkingHour;

import static com.nitish.charge.ChargeEnum.START_TIME_TO_BED_TIME_CHARGE;
import static java.lang.Integer.valueOf;
import static java.lang.Math.abs;

public class PaymentCalculator {

    private static final String REGEX = ":";

    public int calculate(WorkingHour workingHour) {
        String startTime = workingHour.getStartTime();
        String[] startTimeToken = startTime.split(REGEX);
        String bedTime = workingHour.getBedTime();
        String[] bedTimeToken = bedTime.split(REGEX);
        return amountCalculationFromStartToBedTime(totalHours(startTimeToken[0], bedTimeToken[0])) +
                amountCalculationFromStartToBedTime(totalMinutes(startTimeToken[1], bedTimeToken[1]));
    }

    private int amountCalculationFromStartToBedTime(int hours) {
        return hours * START_TIME_TO_BED_TIME_CHARGE.getAmount();
    }

    private int totalHours(String startHour, String bedHour) {
        return (valueOf(bedHour) - valueOf(startHour));
    }

    private int totalMinutes(String startMins, String bedMins) {
        Integer startMinutes = valueOf(startMins);
        Integer bedMinutes = valueOf(bedMins);
        return abs((startMinutes == bedMinutes ? 0 : startMinutes + bedMinutes) / 60);
    }

}
