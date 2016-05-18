package com.nitish.validator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TimeValidatorTest {

    @Test
    public void shouldValidatedStartAndEndTimeBeCorrect() {
        TimeValidator timeValidator = new TimeValidator();

        Boolean isValid = timeValidator.isStartEndTimeAreValid(WorkingHour.builder().withStartTime("4:00PM").withEndTime("4:30AM").build());

        assertFalse(isValid);
    }
}