package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentCalculatorTest {

    @Mock
    private StartToBedTimeChargeCalculator startToBedTimeChargeCalculator;

    @Test
    public void shouldCalculateChargeFromStartToEndTime() {
        PaymentCalculator calculator = new PaymentCalculator(startToBedTimeChargeCalculator);
        WorkingHour workingHour = WorkingHour.builder().withStartTime("5:00PM").withEndTime("03:00AM").build();
        when(startToBedTimeChargeCalculator.calculate(workingHour)).thenReturn(21);

        int amount = calculator.calculate(workingHour);

        assertEquals(21, amount);
    }
}