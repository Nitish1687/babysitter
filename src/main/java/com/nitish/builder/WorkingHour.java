package com.nitish.builder;

/**
 * Created by nsm1211 on 17-05-2016.
 */
public class WorkingHour {
    private WorkingHour(){}

    public static WorkingHourBuilder builder() {
        return new WorkingHourBuilder();
    }

    public static class WorkingHourBuilder {
    }
}
