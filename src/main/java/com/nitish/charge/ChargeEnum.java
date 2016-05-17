package com.nitish.charge;

public enum ChargeEnum {

    START_TIME_TO_BED_TIME_CHARGE(12);

    private Integer amount;

    ChargeEnum(int amt) {
        amount = amt;
    }

    public Integer getAmount() {
        return amount;
    }
}
