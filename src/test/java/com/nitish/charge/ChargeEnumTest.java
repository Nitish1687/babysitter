package com.nitish.charge;

import org.junit.Test;

import static com.nitish.charge.ChargeEnum.BED_TIME_TO_MIDNIGHT_CHARGE;
import static com.nitish.charge.ChargeEnum.START_TIME_TO_BED_TIME_CHARGE;
import static org.junit.Assert.assertEquals;

public class ChargeEnumTest {

    @Test
    public void shouldReturnStandardChargeDuringStartTimeAndBedTime() {
        ChargeEnum startToBedTimeCharge = START_TIME_TO_BED_TIME_CHARGE;
        assertEquals(12, startToBedTimeCharge.getAmount());
    }

    @Test
    public void shouldReturnStandardChargeDuringBedTimeAndMidNight() {
        ChargeEnum bedTimeToMidNightCharge = BED_TIME_TO_MIDNIGHT_CHARGE;
        assertEquals(8, bedTimeToMidNightCharge.getAmount());
    }


}