package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentCalculatorTest {


    @Test
    public void shouldReturnCustomsChargesFromStartToMidNightTime() {
        PaymentCalculator calculator = new PaymentCalculator();

        int amount = calculator.calculate(WorkingHour.builder().withStartTime("5:00PM").withBedTime("10:00PM").build());

        assertEquals(76, amount);

    }
}