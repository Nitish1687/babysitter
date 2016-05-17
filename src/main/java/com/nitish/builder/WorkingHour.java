package com.nitish.builder;

/**
 * Created by nsm1211 on 17-05-2016.
 */
public class WorkingHour {

    private String startTime;
    private String endTime;

    private WorkingHour() {
    }

    public static WorkingHourBuilder builder() {
        return new WorkingHourBuilder();
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public static class WorkingHourBuilder {

        private String startTime;
        private String endTime;

        public WorkingHour build() {
            WorkingHour workingHour = new WorkingHour();
            workingHour.startTime = startTime;
            workingHour.endTime = endTime;
            return workingHour;
        }

        public WorkingHourBuilder withStartTime(String startAt) {
            this.startTime = startAt;
            return this;
        }


        public WorkingHourBuilder withEndTime(String endAt) {
            this.endTime = endAt;
            return this;
        }
    }
}
