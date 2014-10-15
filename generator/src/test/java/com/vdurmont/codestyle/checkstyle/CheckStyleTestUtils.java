package com.vdurmont.codestyle.checkstyle;

import com.puppycrawl.tools.checkstyle.CheckStyleLauncher;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleConfigProcessor;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleWriter;
import com.vdurmont.codestyle.core.model.CodeStyle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class CheckStyleTestUtils {
    public static void assertNoCheckstyleError(CodeStyle codeStyle, String testFilePath) {
        CheckstyleWriter writer = new CheckstyleWriter();
        Checkstyle checkstyle = writer.write(codeStyle);

        CheckstyleConfigProcessor processor = new CheckstyleConfigProcessor();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        processor.writeToStream(checkstyle, outputStream);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        int numErrors = CheckStyleLauncher.getNumErrors(inputStream, testFilePath);
        assertEquals(0, numErrors);
    }
}