package org.codingstyle.api.test;

import org.codingstyle.core.model.Entity;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestTools {
    public static DateTime setCurrentDate(DateTime date) {
        DateTimeUtils.setCurrentMillisFixed(date.getMillis());
        return date;
    }

    public static DateTime setCurrentDateNow() {
        return setCurrentDate(DateTime.now());
    }

    public static void releaseTime() {
        DateTimeUtils.setCurrentMillisSystem();
    }

    public static String randomString(int length) {
        String string = "";
        do {
            string += randomString();
        } while (string.length() < length);
        if (string.length() > length) {
            string = string.substring(0, length);
        }
        return string;
    }

    public static String randomString() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static <T extends Entity> void assertSameEntities(T entity1, T entity2) {
        if (entity1 == null) {
            assertNull(entity2);
        } else {
            assertNotNull(entity2);
            assertNotNull(entity1.getId());
            assertNotNull(entity2.getId());
            assertEquals(entity1.getId(), entity2.getId());
        }
    }
}
