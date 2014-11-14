package org.codingstyle.checkstyle.processor;

import org.codingstyle.checkstyle.model.Checkstyle;
import org.codingstyle.core.model.Documentation;

import static org.codingstyle.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleDocumentationWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Documentation documentation) {
        addModuleIfTrue(checkstyle, "JavadocPackage", documentation.getForcePackageJavadoc());
    }
}
