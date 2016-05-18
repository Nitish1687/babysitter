package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import com.nitish.validator.TimeValidator;

import static com.nitish.charge.ChargeEnum.START_TIME_TO_BED_TIME_CHARGE;
import static java.lang.Integer.valueOf;
import static java.lang.Math.abs;

public class StartToBedTimeChargeCalculator implements ChargeCalculator {

    private final TimeValidator validator;
    private final ChargeCalculator nextChargeCalculator;
    private static final String REGEX = ":";

    public StartToBedTimeChargeCalculator(TimeValidator validator, ChargeCalculator chargeCalculator) {
        this.validator = validator;
        this.nextChargeCalculator = chargeCalculator;
    }

    @Override
    public int calculate(WorkingHour workingHour) {
        int totalAmount = 0;
        String startTime = workingHour.getStartTime();
        String[] startTimeToken = startTime.split(REGEX);
        String bedTime = workingHour.getBedTime();
        String[] bedTimeToken = bedTime.split(REGEX);
        if (validator.isStartEndTimeAreValid(workingHour)) {
            totalAmount += amountCalculationFromStartToBedTime(totalHours(startTimeToken[0], bedTimeToken[0])) +
                    amountCalculationFromStartToBedTime(totalMinutes(startTimeToken[1], bedTimeToken[1]));
        }
        return totalAmount + nextChargeCalculator.calculate(workingHour);
    }

    private int amountCalculationFromStartToBedTime(int hours) {
        return hours * START_TIME_TO_BED_TIME_CHARGE.getAmount();
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
