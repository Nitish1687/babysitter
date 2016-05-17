package com.nitish.builder;

import com.nitish.builder.WorkingHour.WorkingHourBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WorkingHourTest {

    @Test
    public void shouldReturnTheWorkingHourBuilder() {
        WorkingHourBuilder builder = WorkingHour.builder();
        assertNotNull(builder);
    }

    @Test
    public void shouldReturnWorkingHourObjectByUsingBuilderPattern() {
        WorkingHour workingHour = WorkingHour.builder().build();
        assertNotNull(workingHour);
    }

    @Test
    public void shouldSetStartTimeToWorkingHourByBuilder() {
        WorkingHourBuilder builder = WorkingHour.builder();

        WorkingHour workingHour = builder.withStartTime("5:00PM").build();

        assertEquals("5:00PM", workingHour.getStartTime());
    }

    @Test
    public void shouldSetEndTimeToWorkingHourByBuilder() {
        WorkingHourBuilder builder = WorkingHour.builder();

        WorkingHour workingHour = builder.withEndTime("4:00AM").build();

        assertEquals("4:00AM", workingHour.getEndTime());


    }
}