package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import com.nitish.validator.TimeValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StartToBedTimeChargeCalculatorTest {

    @Mock
    private TimeValidator validator;
    @Mock
    private BedTimeToMidNightChargeCalculator chargeCalculator;

    @Test
    public void shouldCalculateChargeFromStartToBedTime() {
        ChargeCalculator calculator = new StartToBedTimeChargeCalculator(validator, chargeCalculator);
        WorkingHour workingHour = WorkingHour.builder().withStartTime("5:00PM").build();
        when(validator.isStartEndTimeAreValid(workingHour)).thenReturn(true);

        int amount = calculator.calculate(workingHour);

        Assert.assertEquals(48, amount);
    }
}