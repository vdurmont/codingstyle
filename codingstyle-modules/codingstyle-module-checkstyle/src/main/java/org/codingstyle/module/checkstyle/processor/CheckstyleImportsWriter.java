package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Imports;
import org.codingstyle.module.checkstyle.model.CheckModule;
import org.codingstyle.module.checkstyle.model.Checkstyle;

import static org.codingstyle.module.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleImportsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Imports imports) {
        if (imports != null) {
            CheckModule treeWalker = checkstyle.getOrCreateModule("TreeWalker");
            addModuleIfTrue(treeWalker, "AvoidStarImport", imports.getAvoidStarImport());
            addModuleIfTrue(treeWalker, "UnusedImports", imports.getAvoidUnusedImports());
            addModuleIfTrue(treeWalker, "RedundantImport", imports.getAvoidRedundantImports());
        }
    }
}
