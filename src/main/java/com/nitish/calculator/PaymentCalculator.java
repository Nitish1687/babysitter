package com.nitish.calculator;

import com.nitish.builder.WorkingHour;

import static com.nitish.charge.ChargeEnum.*;
import static java.lang.Integer.valueOf;
import static java.lang.Math.abs;

public class PaymentCalculator {

    private static final String REGEX = ":";

    public int calculate(WorkingHour workingHour) {
        int totalAmount = 0;
        totalAmount += chargeFromStartTimeToBedTime(workingHour);
        totalAmount += chargeFromBedTimeToMidNight(workingHour);
        totalAmount += chargeFromMidNightToEndTime(workingHour);
        return totalAmount;
    }

    private int chargeFromStartTimeToBedTime(WorkingHour workingHour) {
        int totalAmount = 0;
        String startTime = workingHour.getStartTime();
        String[] startTimeToken = startTime.split(REGEX);
        String bedTime = workingHour.getBedTime();
        String[] bedTimeToken = bedTime.split(REGEX);
        totalAmount += amountCalculationFromStartToBedTime(totalHours(startTimeToken[0], bedTimeToken[0])) +
                amountCalculationFromStartToBedTime(totalMinutes(startTimeToken[1], bedTimeToken[1]));
        return totalAmount;
    }

    private int chargeFromBedTimeToMidNight(WorkingHour workingHour) {
        int totalAmount = 0;
        String[] bedTimeToken = workingHour.getBedTime().split(REGEX);
        String[] midNightToken = workingHour.getMidNightTime().split(REGEX);
        totalAmount += amountCalculationFromBedTimeToMidNight(totalHours(bedTimeToken[0], midNightToken[0]))
                + amountCalculationFromBedTimeToMidNight(totalMinutes(bedTimeToken[1], midNightToken[1]));
        return totalAmount;
    }

    private int chargeFromMidNightToEndTime(WorkingHour workingHour) {
        int totalAmount = 0;
        String[] midNightToken = new String[]{"00","00"};
        String[] endTimeToken = workingHour.getEndTime().split(REGEX);
        totalAmount += amountCalculationFromMidNightToEndTime(totalHours(midNightToken[0], endTimeToken[0]))
                + amountCalculationFromMidNightToEndTime(totalMinutes(midNightToken[1], endTimeToken[1]));
        return totalAmount;
    }

    private int amountCalculationFromStartToBedTime(int hours) {
        return hours * START_TIME_TO_BED_TIME_CHARGE.getAmount();
    }

    private int amountCalculationFromBedTimeToMidNight(int hours) {
        return hours * BED_TIME_TO_MIDNIGHT_CHARGE.getAmount();
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
