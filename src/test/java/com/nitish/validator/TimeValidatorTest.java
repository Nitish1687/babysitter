package com.nitish.validator;

import com.nitish.builder.WorkingHour;
import com.nitish.exception.TimeViolationException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TimeValidatorTest {

    @Test(expected = TimeViolationException.class)
    public void shouldThrowExceptionWhenStartTimeIsLessThen17Hours() {
        TimeValidator timeValidator = new TimeValidator();
        timeValidator.isStartEndTimeAreValid(WorkingHour.builder().withStartTime("4:59PM").build());
    }

    @Test
    public void shouldReturnTrueWhenStartTimeIs17Hours() {
        TimeValidator timeValidator = new TimeValidator();

        Boolean isValid = timeValidator.isStartEndTimeAreValid(WorkingHour.builder().withStartTime("5:00PM").build());

        assertTrue(isValid);

    }

    @Test
    public void shouldReturnTrueWhenEndTimeEndBefore4hours() {

        TimeValidator timeValidator = new TimeValidator();

        Boolean isValid = timeValidator.isStartEndTimeAreValid(WorkingHour.builder().withEndTime("3:59AM").build());

        assertTrue(isValid);

    }

    @Test(expected = TimeViolationException.class)
    public void shouldThrowExceptionWhenEndTimeIsMoreThen4Hours() {
        TimeValidator timeValidator = new TimeValidator();
        timeValidator.isStartEndTimeAreValid(WorkingHour.builder().withEndTime("4:01AM").build());
    }
}