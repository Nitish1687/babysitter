package com.nitish.builder;

import org.junit.Assert;
import org.junit.Test;

public class WorkingHourTest {

    @Test
    public void shouldReturnTheWorkingHourBuilder() {
        WorkingHour.WorkingHourBuilder builder = WorkingHour.builder();
        Assert.assertNotNull(builder);
    }
}