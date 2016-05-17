package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentCalculatorTest {

    private static final int DEFAULT_CHARGE_BETWEEN_START_TO_BED_TIME = 48;

    @Test
    public void shouldCalculateChargeFromStartTimeToBedTime() {
        PaymentCalculator calculator = new PaymentCalculator();

        int amount = calculator.calculate(WorkingHour.builder().build());

        assertEquals(DEFAULT_CHARGE_BETWEEN_START_TO_BED_TIME, amount);
    }
}