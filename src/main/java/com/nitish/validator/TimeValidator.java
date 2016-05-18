package com.nitish.validator;

import com.nitish.builder.WorkingHour;
import com.nitish.exception.TimeViolationException;

import static com.nitish.calculator.RegexExpression.REGEX;
import static java.lang.Integer.valueOf;

public class TimeValidator {

    public Boolean isStartEndTimeAreValid(WorkingHour workingHour) {
        String[] startTimeToken = workingHour.getStartTime().split(REGEX);
        String[] endTimeToken = workingHour.getEndTime().split(REGEX);
        Boolean isValid = true;
        if (valueOf(startTimeToken[0]) < 17 || (valueOf(endTimeToken[0]) >= 4 && valueOf(endTimeToken[1]) > 0)) {
            throw new TimeViolationException("Started Before 5PM or Ended After 4:00AM");
        }
        return isValid;
    }
}
