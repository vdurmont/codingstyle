package org.codingstyle.api.util;

import org.codingstyle.api.exception.IllegalInputException;

public class Preconditions {
    public static void checkNotNull(String message, Object obj) {
        if (obj == null) {
            throw new IllegalInputException(message);
        }
    }

    public static void checkNotEmpty(String message, String string) {
        checkNotNull(message, string);
        if (string.isEmpty()) {
            throw new IllegalInputException(message);
        }
    }

    public static void checkMaxLength(String message, int maxLength, String string) {
        checkNotNull(message, string);
        if (string.length() > maxLength) {
            throw new IllegalInputException(message);
        }
    }
}
