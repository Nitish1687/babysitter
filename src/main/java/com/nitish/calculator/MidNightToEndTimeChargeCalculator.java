package com.nitish.calculator;

import com.nitish.builder.WorkingHour;

import static com.nitish.charge.ChargeEnum.MIDNIGHT_TO_END_CHARGE;
import static java.lang.Integer.valueOf;
import static java.lang.Math.abs;

public class MidNightToEndTimeChargeCalculator implements ChargeCalculator {

    private static final String REGEX = ":";

    @Override
    public int calculate(WorkingHour workingHour) {
        int totalAmount = 0;
        String[] midNightToken = new String[]{"00", "00"};
        String[] endTimeToken = workingHour.getEndTime().split(REGEX);
        totalAmount += amountCalculationFromMidNightToEndTime(totalHours(midNightToken[0], endTimeToken[0]))
                + amountCalculationFromMidNightToEndTime(totalMinutes(midNightToken[1], endTimeToken[1]));
        return totalAmount;
    }

    private int amountCalculationFromMidNightToEndTime(int hours) {
        return hours * MIDNIGHT_TO_END_CHARGE.getAmount();
    }

    private int totalHours(String lowerValue, String higherValue) {
        return (valueOf(higherValue) - valueOf(lowerValue));
    }

    private int totalMinutes(String startMins, String bedMins) {
        Integer startMinutes = valueOf(startMins);
        Integer bedMinutes = valueOf(bedMins);
        return abs((startMinutes == bedMinutes ? 0 : startMinutes + bedMinutes) / 60);
    }
}
