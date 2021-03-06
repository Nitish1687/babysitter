package com.nitish.builder;

import com.nitish.builder.WorkingHour.WorkingHourBuilder;
import com.nitish.exception.TimeFormatException;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkingHourTest {

    @Test
    public void shouldReturnTheWorkingHourBuilder() {
        WorkingHourBuilder builder = WorkingHour.builder();
        assertNotNull(builder);
    }

    @Test
    public void shouldMapWorkingHoursToTwentyFourCycle() {
        WorkingHourBuilder builder = WorkingHour.builder();

        WorkingHour workingHour = builder.withStartTime("5:30PM").withEndTime("4:00AM").build();

        assertEquals("17:30", workingHour.getStartTime());
        assertEquals("04:00", workingHour.getEndTime());
    }

    @Test(expected = TimeFormatException.class)
    public void shouldThrowTimeFormatExceptionWhenTimeIsNotPassedInCorrectFormat() {
        WorkingHourBuilder builder = WorkingHour.builder();
        builder.withStartTime("5:30 PM").withEndTime("4:00 AM").build();
    }

    @Test
    public void shouldSetBedTimeProvidedByUser() {
        WorkingHour workingHour = WorkingHour.builder().withBedTime("09:00PM").build();
        assertEquals("21:00", workingHour.getBedTime());
    }

    @Test
    public void shouldAddedTheDefaultStartBedAndEndTimeIfItsNotProvidedByUser() {
        WorkingHour workingHour = WorkingHour.builder().build();

        assertEquals("17:00", workingHour.getStartTime());
        assertEquals("21:00", workingHour.getBedTime());
        assertEquals("04:00", workingHour.getEndTime());
    }

    @Test
    public void shouldAddMidNightTimeFiledToWorkingHourPOJO() {
        WorkingHour build = WorkingHour.builder().build();
        assertNull(build.getMidNightTime());
    }

    @Test
    public void shouldReturnTheMidNightTime() throws Exception {
        WorkingHour workingHour = WorkingHour.builder().build();

        assertEquals("24:00", workingHour.getMidNightTime());
    }
}