package com.example.demo.exception;

public class ApiKeyException extends RuntimeException {
    public ApiKeyException(String message) {
        super(message);
    }
}