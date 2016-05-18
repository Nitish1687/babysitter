package com.nitish.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nsm1211 on 18-05-2016.
 */
public class BedTimeToMidNightChargeCalculatorTest {

    @Test
    public void shouldReturnMidNightCharge() {
        ChargeCalculator calculator = new BedTimeToMidNightChargeCalculator();
        int bedToMidNightAmount = calculator.calculate(null);
        assertEquals(0, bedToMidNightAmount);
    }
}