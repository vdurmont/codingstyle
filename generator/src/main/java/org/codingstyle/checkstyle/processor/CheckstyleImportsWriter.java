package org.codingstyle.checkstyle.processor;

import org.codingstyle.checkstyle.model.CheckModule;
import org.codingstyle.checkstyle.model.Checkstyle;
import org.codingstyle.core.model.Imports;

import static org.codingstyle.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleImportsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Imports imports) {
        CheckModule treeWalker = checkstyle.getOrCreateModule("TreeWalker");
        addModuleIfTrue(treeWalker, "AvoidStarImport", imports.getAvoidStarImport());
        addModuleIfTrue(treeWalker, "UnusedImports", imports.getAvoidUnusedImports());
        addModuleIfTrue(treeWalker, "RedundantImport", imports.getAvoidRedundantImports());
    }
}
