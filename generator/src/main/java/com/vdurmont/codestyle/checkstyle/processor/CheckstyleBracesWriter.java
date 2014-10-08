package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.util.CheckModuleBuilder;
import com.vdurmont.codestyle.core.exception.CodeStyleException;
import com.vdurmont.codestyle.core.model.Braces;
import com.vdurmont.codestyle.core.model.BracesPlacement;

public class CheckstyleBracesWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Braces braces) {
        if (braces.getClassBraces() != null) {
            addLeftCurlyModule(checkstyle, braces.getClassBraces(),
                    "ANNOTATION_DEF", "CLASS_DEF", "ENUM_DEF", "INTERFACE_DEF");
        }
        if (braces.getMethodBraces() != null) {
            addLeftCurlyModule(checkstyle, braces.getMethodBraces(), "CTOR_DEF", "METHOD_DEF");
        }
        if (braces.getOtherBraces() != null) {
            addLeftCurlyModule(checkstyle, braces.getOtherBraces(), "LITERAL_CATCH", "LITERAL_DO",
                    "LITERAL_ELSE", "LITERAL_FINALLY", "LITERAL_FOR", "LITERAL_IF", "LITERAL_SWITCH",
                    "LITERAL_SYNCHRONIZED", "LITERAL_TRY", "LITERAL_WHILE");
        }
    }

    private static void addLeftCurlyModule(Checkstyle checkstyle, BracesPlacement placement, String... tokens) {
        String option = getCurlyOption(placement);
        CheckModule module = CheckModuleBuilder.withName("LeftCurly")
                .withProperty("option", option)
                .withProperty("tokens", String.join(",", tokens))
                .build();
        checkstyle.addModule(module);
    }

    private static String getCurlyOption(BracesPlacement placement) {
        switch (placement) {
            case END_OF_LINE:
                return "eol";
            case NEW_LINE:
                return "nl";
        }
        throw new CodeStyleException("Unknown BracesPlament: " + placement);
    }
}
