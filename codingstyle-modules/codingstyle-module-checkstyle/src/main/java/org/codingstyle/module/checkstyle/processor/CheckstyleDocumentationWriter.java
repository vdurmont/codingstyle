package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Documentation;
import org.codingstyle.module.checkstyle.model.Checkstyle;

import static org.codingstyle.module.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleDocumentationWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Documentation documentation) {
        if (documentation != null) {
            addModuleIfTrue(checkstyle, "JavadocPackage", documentation.getForcePackageJavadoc());
        }
    }
}
