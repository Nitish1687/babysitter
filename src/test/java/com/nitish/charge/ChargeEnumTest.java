package com.nitish.charge;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ChargeEnumTest {

    @Test
    public void shouldReturnStandardChargeDuringStartTimeToBedTime() {
        ChargeEnum startToBedTimeCharge = ChargeEnum.valueOf("START_TIME_TO_BED_TIME_CHARGE");
        assertNotNull(startToBedTimeCharge);
    }
}