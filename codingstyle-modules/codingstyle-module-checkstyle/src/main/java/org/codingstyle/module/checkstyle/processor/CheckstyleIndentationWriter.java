package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.IndentCharacter;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.module.checkstyle.model.CheckModule;
import org.codingstyle.module.checkstyle.model.Checkstyle;
import org.codingstyle.module.checkstyle.util.CheckModuleBuilder;

public class CheckstyleIndentationWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Indentation indentation) {
        checkIndentCharacter(checkstyle, indentation.getIndentCharacter());
        checkIndentSize(checkstyle, indentation.getIndentSize(), indentation.getLabelIndentSize());
    }

    private static void checkIndentCharacter(Checkstyle checkstyle, IndentCharacter character) {
        if (character != null) {
            switch (character) {
                case TAB:
                    addTabModule(checkstyle);
                    break;
                case SPACE:
                    checkstyle.addModule(new CheckModule("FileTabCharacter"));
                    break;
            }
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
