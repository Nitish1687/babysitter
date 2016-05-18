package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BedTimeToMidNightChargeCalculatorTest {

    @Mock
    private MidNightToEndTimeChargeCalculator chargeCalculator;

    @Test
    public void shouldReturnBedToMidNightCharge() {
        ChargeCalculator calculator = new BedTimeToMidNightChargeCalculator(chargeCalculator);

        int bedToMidNightAmount = calculator.calculate(WorkingHour.builder().withStartTime("6:00PM").build());

        assertEquals(24, bedToMidNightAmount);
    }

    @Test
    public void shouldMakeACallToMidNightToEndChargeCalculator() {
        WorkingHour workingHour = WorkingHour.builder().build();
        ChargeCalculator bedTimeToMidNightChargeCalculator = new BedTimeToMidNightChargeCalculator(chargeCalculator);
        Mockito.when(chargeCalculator.calculate(workingHour)).thenReturn(0);

        bedTimeToMidNightChargeCalculator.calculate(workingHour);

        verify(chargeCalculator).calculate(workingHour);
    }
}