package com.nitish.validator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimeValidatorTest {

    @Test
    public void shouldReturnFalseWhenStartTimeIsLessThen17Hours() {
        TimeValidator timeValidator = new TimeValidator();

        Boolean isValid = timeValidator.isStartEndTimeAreValid(WorkingHour.builder().withStartTime("4:00PM").build());

        assertFalse(isValid);
    }

    @Test
    public void shouldReturnTrueWhenStartTimeIs17Hours() {
        TimeValidator timeValidator = new TimeValidator();

        Boolean isValid = timeValidator.isStartEndTimeAreValid(WorkingHour.builder().withStartTime("5:00PM").build());

        assertTrue(isValid);

    }
}