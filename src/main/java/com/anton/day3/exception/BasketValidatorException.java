package com.anton.day3.exception;

public class BasketValidatorException extends Exception {
    public BasketValidatorException() {
    }

    public BasketValidatorException(String message) {
        super(message);
    }

    public BasketValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketValidatorException(Throwable cause) {
        super(cause);
    }
}
