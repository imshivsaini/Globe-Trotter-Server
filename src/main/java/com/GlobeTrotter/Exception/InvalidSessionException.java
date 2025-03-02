package com.GlobeTrotter.Exception;

public class InvalidSessionException extends GlobeTrotterException {
    private final String sessionId;

    public InvalidSessionException(String sessionId) {
        super(String.format("Session with ID '%s' is invalid or has expired", sessionId));
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}