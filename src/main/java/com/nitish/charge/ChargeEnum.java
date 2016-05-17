package com.nitish.charge;

public enum ChargeEnum {

    START_TIME_TO_BED_TIME_CHARGE(12),
    BED_TIME_TO_MIDNIGHT_CHARGE(8),
    MIDNIGHT_TO_END_CHARGE(16);

    private int amount;

    ChargeEnum(int amt) {
        amount = amt;
    }

    public int getAmount() {
        return amount;
    }
}
