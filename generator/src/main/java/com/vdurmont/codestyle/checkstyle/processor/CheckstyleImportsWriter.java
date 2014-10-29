package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Imports;

import static com.vdurmont.codestyle.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleImportsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Imports imports) {
        CheckModule treeWalker = checkstyle.getOrCreateModule("TreeWalker");
        addModuleIfTrue(treeWalker, "AvoidStarImport", imports.getAvoidStarImport());
        addModuleIfTrue(treeWalker, "UnusedImports", imports.getAvoidUnusedImports());
        addModuleIfTrue(treeWalker, "RedundantImport", imports.getAvoidRedundantImports());
    }
}
