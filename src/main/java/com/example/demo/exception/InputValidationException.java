package com.example.demo.exception;

public class InputValidationException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InputValidationException(String message) {
        super();
        this.message = message;
    }
}