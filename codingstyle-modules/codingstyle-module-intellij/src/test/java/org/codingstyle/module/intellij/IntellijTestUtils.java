package org.codingstyle.module.intellij;

import org.codingstyle.core.model.Project;
import org.codingstyle.module.intellij.model.CodeScheme;
import org.codingstyle.module.intellij.processor.IntellijConfigProcessor;
import org.codingstyle.module.intellij.processor.reader.IntellijReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class IntellijTestUtils {
    public static Project readCodeStyle(String testFileName) {
        try {
            IntellijConfigProcessor processor = new IntellijConfigProcessor();
            File testFile = new File("src/test/resources/" + testFileName + ".xml");
            InputStream testFileStream = new FileInputStream(testFile);
            CodeScheme codeScheme = processor.readFromStream(testFileStream);
            IntellijReader reader = new IntellijReader();
            return reader.read(codeScheme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}