package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Annotations;

import static com.vdurmont.codestyle.core.util.ValueReader.isTrue;

public class CheckstyleAnnotationsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Annotations annotations) {
        if (isTrue(annotations.getForceOverride())) {
            checkstyle.addModule(new CheckModule("MissingOverride"));
        }
    }
}
