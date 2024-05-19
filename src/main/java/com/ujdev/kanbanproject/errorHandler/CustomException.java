package com.ujdev.kanbanproject.errorHandler;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
