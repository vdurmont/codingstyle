package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.util.CheckModuleBuilder;
import com.vdurmont.codestyle.core.model.Indentation;

public class CheckstyleIndentationConverter {
    public static void buildCheckstyle(Checkstyle checkstyle, Indentation indentation) {
        switch (indentation.getIndentCharacter()) {
            case TAB:
                addTabModule(checkstyle);
                break;
            case SPACE:
                checkstyle.addModule(new CheckModule("FileTabCharacter"));
        }
    }

    private static void addTabModule(Checkstyle checkstyle) {
        CheckModule module = CheckModuleBuilder.withName("RegexpSinglelineJava")
                .withProperty("format", "^\\t* +\\t*\\S")
                .withProperty("message", "Line has leading space characters.")
                .withProperty("ignoreComments", "true")
                .build();
        checkstyle.addModule(module);
    }
}
