package com.vdurmont.codestyle.intellij;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.processor.IntelliJConfigProcessor;
import com.vdurmont.codestyle.intellij.processor.IntelliJReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class IntellijTestUtils {
    public static CodeStyle readCodeStyle(String testFileName) {
        try {
            IntelliJConfigProcessor processor = new IntelliJConfigProcessor();
            File testFile = new File("src/test/resources/intellij/" + testFileName + ".xml");
            InputStream testFileStream = new FileInputStream(testFile);
            CodeScheme codeScheme = processor.readFromStream(testFileStream);
            IntelliJReader reader = new IntelliJReader();
            return reader.read(codeScheme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}