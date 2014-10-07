package com.vdurmont.codestyle.core.exception;

public class CodeStyleException extends RuntimeException {
    public CodeStyleException(Exception e) {
        super(e);
    }

    public CodeStyleException(String message) {
        super(message);
    }

    public CodeStyleException(String message, Exception e) {
        super(message, e);
    }
}
