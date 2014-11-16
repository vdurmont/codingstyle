package org.codingstyle.api.exception;

import org.codingstyle.api.dto.HttpStatus;

public class IllegalInputException extends CodingStyleAPIException {
    public IllegalInputException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
