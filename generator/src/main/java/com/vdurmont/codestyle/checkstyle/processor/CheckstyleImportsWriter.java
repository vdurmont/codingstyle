package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.util.CheckModuleBuilder;
import com.vdurmont.codestyle.core.model.Imports;

import static com.vdurmont.codestyle.core.util.ValueReader.isTrue;

public class CheckstyleImportsWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Imports imports) {
        if (isTrue(imports.getAvoidStarImport())) {
            addAvoidStarImportModule(checkstyle);
        }
    }

    private static void addAvoidStarImportModule(Checkstyle checkstyle) {
        CheckModule module = CheckModuleBuilder.withName("AvoidStarImport")
                .build();
        checkstyle.addModule(module);
    }
}
