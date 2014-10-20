package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.util.CheckModuleBuilder;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;

public class CheckstyleIndentationWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Indentation indentation) {
        checkIndentCharacter(checkstyle, indentation.getIndentCharacter());
        checkIndentSize(checkstyle, indentation.getIndentSize(), indentation.getLabelIndentSize());
    }

    private static void checkIndentCharacter(Checkstyle checkstyle, IndentCharacter character) {
        switch (character) {
            case TAB:
                addTabModule(checkstyle);
                break;
            case SPACE:
                checkstyle.addModule(new CheckModule("FileTabCharacter"));
                break;
        }
    }

    private static void addTabModule(Checkstyle checkstyle) {
        CheckModule treewalker = checkstyle.getOrCreateModule("TreeWalker");
        CheckModule module = CheckModuleBuilder.withName("RegexpSinglelineJava")
                .withProperty("format", "^\\t* +\\t*\\S")
                .withProperty("message", "Line has leading space characters.")
                .withProperty("ignoreComments", "true")
                .build();
        treewalker.addModule(module);
    }

    private static void checkIndentSize(Checkstyle checkstyle, Integer indentSize, Integer labelIndentSize) {
        if (indentSize != null || labelIndentSize != null) {
            CheckModule treewalker = checkstyle.getOrCreateModule("TreeWalker");
            CheckModuleBuilder builder = CheckModuleBuilder.withName("Indentation");
            if (indentSize != null) {
                builder.withProperty("basicOffset", indentSize);
            }
            if (labelIndentSize != null) {
                builder.withProperty("caseIndent", labelIndentSize);
            }
            treewalker.addModule(builder.build());
        }
    }
}
