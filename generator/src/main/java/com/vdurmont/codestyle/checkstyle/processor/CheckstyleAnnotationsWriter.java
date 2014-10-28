package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Annotations;

import static com.vdurmont.codestyle.checkstyle.processor.CheckstyleWriterUtil.addModuleIfTrue;

public class CheckstyleAnnotationsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Annotations annotations) {
        CheckModule treewalker = checkstyle.getOrCreateModule("TreeWalker");
        addModuleIfTrue(treewalker, "MissingOverride", annotations.getForceOverride());
    }
}
