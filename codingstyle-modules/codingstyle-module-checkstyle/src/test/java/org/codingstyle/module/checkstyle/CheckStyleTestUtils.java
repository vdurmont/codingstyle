package org.codingstyle.module.checkstyle;

import com.puppycrawl.tools.checkstyle.CheckStyleLauncher;
import org.codingstyle.core.model.Project;
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

    public static void assertNoCheckstyleErrors(Project project, String testFilePath) {
        assertNumCheckstyleErrors(0, project, testFilePath);
    }

    public static void assertHasCheckstyleErrors(Project project, String testFilePath) {
        int numErrors = getNumCheckstyleErrors(project, testFilePath);
        assertTrue(0 < numErrors);
    }

    public static void assertNumCheckstyleErrors(int expectedNumErrors, Project project, String testFilePath) {
        int numErrors = getNumCheckstyleErrors(project, testFilePath);
        assertEquals(expectedNumErrors, numErrors);
    }

    private static int getNumCheckstyleErrors(Project project, String testFilePath) {
        CheckstyleWriter writer = new CheckstyleWriter();
        Checkstyle checkstyle = writer.write(project);

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

    public static Project generateStyle() {
        Project project = new Project();
        project.setName("My project");
        return project;
    }
}