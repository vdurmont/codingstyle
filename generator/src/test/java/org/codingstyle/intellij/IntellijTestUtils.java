package org.codingstyle.intellij;

import org.codingstyle.core.model.Style;
import org.codingstyle.intellij.model.CodeScheme;
import org.codingstyle.intellij.processor.IntellijConfigProcessor;
import org.codingstyle.intellij.processor.reader.IntellijReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class IntellijTestUtils {
    public static Style readCodeStyle(String testFileName) {
        try {
            IntellijConfigProcessor processor = new IntellijConfigProcessor();
            File testFile = new File("src/test/resources/intellij/" + testFileName + ".xml");
            InputStream testFileStream = new FileInputStream(testFile);
            CodeScheme codeScheme = processor.readFromStream(testFileStream);
            IntellijReader reader = new IntellijReader();
            return reader.read(codeScheme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}