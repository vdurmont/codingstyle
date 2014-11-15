package org.codingstyle.module.checkstyle;

import com.puppycrawl.tools.checkstyle.CheckStyleLauncher;
import org.codingstyle.core.model.Annotations;
import org.codingstyle.core.model.Braces;
import org.codingstyle.core.model.Documentation;
import org.codingstyle.core.model.Imports;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.core.model.Page;
import org.codingstyle.core.model.Spaces;
import org.codingstyle.core.model.Style;
import org.codingstyle.module.checkstyle.model.Checkstyle;
import org.codingstyle.module.checkstyle.processor.CheckstyleConfigProcessor;
import org.codingstyle.module.checkstyle.processor.CheckstyleWriter;

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
        File testFile = new File("src/test/resources/" + testFilePath + ".java");
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

    // TODO maybe the writers should handle null properties
    public static Style generateStyle() {
        Style style = new Style();
        style.setProjectName("My project");
        style.setIndentation(new Indentation());
        style.setAnnotations(new Annotations());
        style.setBraces(new Braces());
        style.setDocumentation(new Documentation());
        style.setPage(new Page());
        style.setImports(new Imports());
        style.setSpaces(new Spaces());
        return style;
    }
}