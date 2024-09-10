package com.fitmanager.system.domain.Goal.exceptions;

public class GoalAlreadyCompletedException extends RuntimeException {

    private static final String DEFAULT_EXCEPTION_MESSAGE;

    public GoalAlreadyCompletedException(String message) {
        super(message == null || message.isEmpty() ? getDefaultExceptionMessage() : message);
    }

    static {
        DEFAULT_EXCEPTION_MESSAGE = "Goal is already completed";
    }

    private static String getDefaultExceptionMessage() {
        return DEFAULT_EXCEPTION_MESSAGE;
    }

};