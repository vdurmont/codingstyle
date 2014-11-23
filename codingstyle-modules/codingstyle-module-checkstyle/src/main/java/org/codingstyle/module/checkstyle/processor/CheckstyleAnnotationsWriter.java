package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Annotations;
import org.codingstyle.module.checkstyle.model.CheckModule;
import org.codingstyle.module.checkstyle.model.Checkstyle;

import static org.codingstyle.module.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;


public class CheckstyleAnnotationsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Annotations annotations) {
        if (annotations != null) {
            CheckModule treewalker = checkstyle.getOrCreateModule("TreeWalker");
            addModuleIfTrue(treewalker, "MissingOverride", annotations.getForceOverride());
        }
    }
}
