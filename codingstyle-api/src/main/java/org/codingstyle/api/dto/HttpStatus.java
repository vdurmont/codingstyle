package org.codingstyle.api.dto;

public enum HttpStatus {
    //4**
    BAD_REQUEST(400),
    NOT_FOUND(404),

    //5**
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    private HttpStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
