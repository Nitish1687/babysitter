package com.nitish.charge;

public enum ChargeEnum {

    START_TIME_TO_BED_TIME_CHARGE(12);

    private int amount;

    ChargeEnum(int amt) {
        amount = amt;
    }

    public int getAmount() {
        return amount;
    }
}
