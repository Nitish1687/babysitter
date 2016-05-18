package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentCalculatorTest {


    @Test
    public void shouldCalculateChargeFromStartToEndTime() {
        PaymentCalculator calculator = new PaymentCalculator();

        int amount = calculator.calculate(WorkingHour.builder().withStartTime("5:00PM").withEndTime("03:00AM").build());

        assertEquals(120, amount);
    }
}