package com.nitish.calculator;

import com.nitish.builder.WorkingHour;

import static com.nitish.charge.ChargeEnum.BED_TIME_TO_MIDNIGHT_CHARGE;
import static java.lang.Integer.valueOf;
import static java.lang.Math.abs;

public class BedTimeToMidNightChargeCalculator implements ChargeCalculator {
    private static final String REGEX = ":";
    private final ChargeCalculator nextChargeCalculator;

    public BedTimeToMidNightChargeCalculator(ChargeCalculator midNightToEndTimeChargeCalculator) {
        this.nextChargeCalculator = midNightToEndTimeChargeCalculator;
    }

    @Override
    public int calculate(WorkingHour workingHour) {
        int totalAmount = 0;
        String[] bedTimeToken = workingHour.getBedTime().split(REGEX);
        String[] midNightToken = workingHour.getMidNightTime().split(REGEX);
        totalAmount += amountCalculationFromBedTimeToMidNight(totalHours(bedTimeToken[0], midNightToken[0]))
                + amountCalculationFromBedTimeToMidNight(totalMinutes(bedTimeToken[1], midNightToken[1]));
        return totalAmount + nextChargeCalculator.calculate(workingHour);
    }

    private int amountCalculationFromBedTimeToMidNight(int hours) {
        return hours * BED_TIME_TO_MIDNIGHT_CHARGE.getAmount();
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
