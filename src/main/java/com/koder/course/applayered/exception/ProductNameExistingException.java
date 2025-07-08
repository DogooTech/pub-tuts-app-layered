package com.koder.course.applayered.exception;

public class ProductNameExistingException extends RuntimeException {
    public ProductNameExistingException() {
        super();
    }

    public ProductNameExistingException(String message) {
        super(message);
    }

    public ProductNameExistingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNameExistingException(Throwable cause) {
        super(cause);
    }
}