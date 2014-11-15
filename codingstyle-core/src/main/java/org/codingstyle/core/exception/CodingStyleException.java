package org.codingstyle.core.exception;

public class CodingStyleException extends RuntimeException {
    public CodingStyleException(Exception e) {
        super(e);
    }

    public CodingStyleException(String message) {
        super(message);
    }

    public CodingStyleException(String message, Exception e) {
        super(message, e);
    }
}
