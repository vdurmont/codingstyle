package org.codingstyle.checkstyle.processor;

import org.codingstyle.checkstyle.model.CheckModule;
import org.codingstyle.checkstyle.model.Checkstyle;
import org.codingstyle.core.model.Annotations;

import static org.codingstyle.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleAnnotationsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Annotations annotations) {
        CheckModule treewalker = checkstyle.getOrCreateModule("TreeWalker");
        addModuleIfTrue(treewalker, "MissingOverride", annotations.getForceOverride());
    }
}
