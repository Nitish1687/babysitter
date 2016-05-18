package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;

import static org.junit.Assert.*;


public class MidNightToEndTimeChargeCalculatorTest {

    @Test
    public void shouldReturnMidNightToEndCharge() {
        ChargeCalculator chargeCalculator = new MidNightToEndTimeChargeCalculator();
        WorkingHour workingHour = WorkingHour.builder().build();

        int amount = chargeCalculator.calculate(workingHour);

        assertEquals(64, amount);
    }
}