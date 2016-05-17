package com.nitish.builder;

/**
 * Created by nsm1211 on 17-05-2016.
 */
public class WorkingHour {

    private String startTime;

    private WorkingHour() {
    }

    public static WorkingHourBuilder builder() {
        return new WorkingHourBuilder();
    }

    public String getStartTime() {
        return startTime;
    }

    public static class WorkingHourBuilder {

        private String startTime;

        public WorkingHour build() {
            WorkingHour workingHour = new WorkingHour();
            workingHour.startTime = startTime;
            return workingHour;
        }

        public WorkingHourBuilder withStartTime(String startAt) {
            this.startTime = startAt;
            return this;
        }
    }
}
