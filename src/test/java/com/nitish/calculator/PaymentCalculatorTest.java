package com.nitish.calculator;

import com.nitish.builder.WorkingHour;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PaymentCalculatorTest {

    @Test
    public void shouldCalculateCharge() {
        PaymentCalculator calculator = new PaymentCalculator();

        Integer amount = calculator.calculate(WorkingHour.builder().build());

        assertNotNull(amount);
    }
}