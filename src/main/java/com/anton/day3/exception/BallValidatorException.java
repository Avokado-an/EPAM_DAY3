package com.anton.day3.exception;

public class BallValidatorException extends Exception {
    public BallValidatorException() {
    }

    public BallValidatorException(String message) {
        super(message);
    }

    public BallValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public BallValidatorException(Throwable cause) {
        super(cause);
    }
}
