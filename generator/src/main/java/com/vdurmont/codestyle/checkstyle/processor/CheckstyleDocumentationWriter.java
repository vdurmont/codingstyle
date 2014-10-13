package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Documentation;

import static com.vdurmont.codestyle.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleDocumentationWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Documentation documentation) {
        addModuleIfTrue(checkstyle, "JavadocPackage", documentation.getForcePackageJavadoc());
    }
}
