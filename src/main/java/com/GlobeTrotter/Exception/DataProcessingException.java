package com.GlobeTrotter.Exception;

public class DataProcessingException extends GlobeTrotterException {
    public DataProcessingException(String message) {
        super(message);
    }

    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}