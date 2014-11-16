package org.codingstyle.api.exception;

import org.codingstyle.api.dto.HttpStatus;

public class ResourceNotFoundException extends CodingStyleAPIException {
    public ResourceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
