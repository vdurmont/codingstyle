package org.codingstyle.api.exception;


import org.codingstyle.api.dto.HttpStatus;
import org.codingstyle.core.exception.CodingStyleException;

public class CodingStyleAPIException extends CodingStyleException {
    private final HttpStatus status;

    public CodingStyleAPIException(String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public CodingStyleAPIException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
