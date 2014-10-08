package com.vdurmont.codestyle.core.util;

public class ValueReader {
    /**
     * This method returns the value of a {@link java.lang.Boolean} and takes care of a null value.
     *
     * @param bool the {@link Boolean} to test
     * @return the value of the input, false if null
     */
    public static boolean isTrue(Boolean bool) {
        return bool != null && bool;
    }
}
