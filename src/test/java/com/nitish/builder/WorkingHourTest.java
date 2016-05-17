package com.nitish.builder;

import com.nitish.builder.WorkingHour.WorkingHourBuilder;
import org.junit.Test;

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
}