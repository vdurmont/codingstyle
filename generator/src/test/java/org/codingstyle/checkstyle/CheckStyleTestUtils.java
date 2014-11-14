package org.codingstyle.checkstyle;

import com.puppycrawl.tools.checkstyle.CheckStyleLauncher;
import org.codingstyle.checkstyle.model.Checkstyle;
import org.codingstyle.checkstyle.processor.CheckstyleConfigProcessor;
import org.codingstyle.checkstyle.processor.CheckstyleWriter;
import org.codingstyle.core.model.Style;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckStyleTestUtils {
    public static boolean displayGeneratedCheckstyle = true;

    public static void assertNoCheckstyleErrors(Style style, String testFilePath) {
        assertNumCheckstyleErrors(0, style, testFilePath);
    }

    public static void assertHasCheckstyleErrors(Style style, String testFilePath) {
        int numErrors = getNumCheckstyleErrors(style, testFilePath);
        assertTrue(0 < numErrors);
    }

    public static void assertNumCheckstyleErrors(int expectedNumErrors, Style style, String testFilePath) {
        int numErrors = getNumCheckstyleErrors(style, testFilePath);
        assertEquals(expectedNumErrors, numErrors);
    }

    private static int getNumCheckstyleErrors(Style style, String testFilePath) {
        CheckstyleWriter writer = new CheckstyleWriter();
        Checkstyle checkstyle = writer.write(style);

        CheckstyleConfigProcessor processor = new CheckstyleConfigProcessor();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        processor.writeToStream(checkstyle, outputStream);

        if (displayGeneratedCheckstyle) {
            displayGeneratedCheckstyle(outputStream.toByteArray());
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        File testFile = new File("src/test/resources/checkstyle/" + testFilePath + ".java");
        return CheckStyleLauncher.getNumErrors(inputStream, testFile);
    }

    private static void displayGeneratedCheckstyle(byte[] inputBytes) {
        ByteArrayInputStream stream = new ByteArrayInputStream(inputBytes);
        int n = stream.available();
        byte[] bytes = new byte[n];
        stream.read(bytes, 0, n);
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}