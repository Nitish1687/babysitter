package com.nitish.exception;

public class TimeViolationException extends RuntimeException {

    public TimeViolationException(){}

    public TimeViolationException(String message) {
        super(message);
    }
}
