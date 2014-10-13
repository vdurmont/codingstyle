package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Imports;

import static com.vdurmont.codestyle.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleImportsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Imports imports) {
        addModuleIfTrue(checkstyle, "AvoidStarImport", imports.getAvoidStarImport());
        addModuleIfTrue(checkstyle, "UnusedImports", imports.getAvoidUnusedImports());
    }
}
