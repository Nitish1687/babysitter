package com.nitish.exception;

public class TimeFormatException extends RuntimeException {

    public TimeFormatException() {
    }

    public TimeFormatException(String message) {
        super(message);
    }
}
