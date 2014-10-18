package com.vdurmont.codestyle.checkstyle;

import com.puppycrawl.tools.checkstyle.CheckStyleLauncher;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleConfigProcessor;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleWriter;
import com.vdurmont.codestyle.core.model.CodeStyle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class CheckStyleTestUtils {
    public static boolean displayGeneratedCheckstyle = true;

    public static void assertNoCheckstyleErrors(CodeStyle codeStyle, String testFilePath) {
        assertNumCheckstyleErrors(0, codeStyle, testFilePath);
    }

    public static void assertNumCheckstyleErrors(int expectedNumErrors, CodeStyle codeStyle, String testFilePath) {
        int numErrors = getNumCheckstyleErrors(codeStyle, testFilePath);
        assertEquals(expectedNumErrors, numErrors);
    }

    private static int getNumCheckstyleErrors(CodeStyle codeStyle, String testFilePath) {
        CheckstyleWriter writer = new CheckstyleWriter();
        Checkstyle checkstyle = writer.write(codeStyle);

        CheckstyleConfigProcessor processor = new CheckstyleConfigProcessor();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        processor.writeToStream(checkstyle, outputStream);

        if (displayGeneratedCheckstyle) {
            displayGeneratedCheckstyle(outputStream.toByteArray());
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        File testFile = new File("src/test/resources/" + testFilePath);
        return CheckStyleLauncher.getNumErrors(inputStream, testFile);
    }

    private static void displayGeneratedCheckstyle(byte[] inputBytes) {
        ByteArrayInputStream plop = new ByteArrayInputStream(inputBytes);
        int n = plop.available();
        byte[] bytes = new byte[n];
        plop.read(bytes, 0, n);
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}