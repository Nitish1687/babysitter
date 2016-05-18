package com.nitish.validator;

import com.nitish.builder.WorkingHour;

import static com.nitish.calculator.RegexExpression.REGEX;
import static java.lang.Integer.valueOf;

public class TimeValidator {
    public Boolean isStartEndTimeAreValid(WorkingHour workingHour) {
        String[] startTimeToken = workingHour.getStartTime().split(REGEX);
        String[] endTimeToken = workingHour.getEndTime().split(REGEX);
        Boolean isValid = false;
        if (valueOf(startTimeToken[0]) < 17) {
            isValid = false;
            return isValid;
        }
        return isValid;
    }
}
