package com.nitish.builder;

import com.nitish.exception.TimeFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        private static final String DEFAULT_START_TIME = "17:00";
        private static final String DEFAULT_END_TIME = "04:00";

        public WorkingHourBuilder withStartTime(String startAt) {
            this.startTime = startAt;
            return this;
        }

        public WorkingHourBuilder withEndTime(String endAt) {
            this.endTime = endAt;
            return this;
        }

        public WorkingHour build() {
            WorkingHour workingHour = new WorkingHour();
            workingHour.startTime = null != startTime ? formatTimeTo(startTime) : DEFAULT_START_TIME;
            workingHour.endTime = null != endTime ? formatTimeTo(endTime) : DEFAULT_END_TIME;
            return workingHour;
        }

        private String formatTimeTo(String time) {
            SimpleDateFormat expectedFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat actualFormat = new SimpleDateFormat("hh:mma");
            Date startDate = null;
            try {
                startDate = actualFormat.parse(time);
            } catch (ParseException e) {
                throw new TimeFormatException();
            }
            return expectedFormat.format(startDate);
        }
    }
}
