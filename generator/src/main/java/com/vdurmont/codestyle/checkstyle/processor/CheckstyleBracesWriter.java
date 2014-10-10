package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.util.CheckModuleBuilder;
import com.vdurmont.codestyle.core.exception.CodeStyleException;
import com.vdurmont.codestyle.core.model.Braces;
import com.vdurmont.codestyle.core.model.BracesPlacement;

import java.util.ArrayList;
import java.util.List;

import static com.vdurmont.codestyle.core.util.ValueReader.isTrue;

public class CheckstyleBracesWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Braces braces) {
        addLeftCurlyStyle(checkstyle, braces);
        addRightCurlyNextStatement(checkstyle, braces);
        forceBraces(checkstyle, braces);
    }

    private static void addLeftCurlyStyle(Checkstyle checkstyle, Braces braces) {
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
        String option = getLeftCurlyOption(placement);
        CheckModule module = CheckModuleBuilder.withName("LeftCurly")
                .withProperty("option", option)
                .withProperty("tokens", String.join(",", tokens))
                .build();
        checkstyle.addModule(module);
    }

    private static String getLeftCurlyOption(BracesPlacement placement) {
        switch (placement) {
            case END_OF_LINE:
                return "eol";
            case NEW_LINE:
                return "nl";
        }
        throw new CodeStyleException("Unknown BracesPlament: " + placement);
    }

    private static void addRightCurlyNextStatement(Checkstyle checkstyle, Braces braces) {
        if (braces.getStatementAfterClosingTry() != null) {
            addRightCurlyModule(checkstyle, braces.getStatementAfterClosingTry(), "LITERAL_TRY");
        }
        if (braces.getStatementAfterClosingCatch() != null) {
            addRightCurlyModule(checkstyle, braces.getStatementAfterClosingCatch(), "LITERAL_CATCH");
        }
        if (braces.getStatementAfterClosingFinally() != null) {
            addRightCurlyModule(checkstyle, braces.getStatementAfterClosingFinally(), "LITERAL_FINALLY");
        }
        if (braces.getStatementAfterClosingIf() != null) {
            addRightCurlyModule(checkstyle, braces.getStatementAfterClosingIf(), "LITERAL_IF");
        }
        if (braces.getStatementAfterClosingElse() != null) {
            addRightCurlyModule(checkstyle, braces.getStatementAfterClosingElse(), "LITERAL_ELSE");
        }
        if (braces.getStatementAfterClosingDo() != null) {
            addRightCurlyModule(checkstyle, braces.getStatementAfterClosingDo(), "LITERAL_DO");
        }
    }

    private static void addRightCurlyModule(Checkstyle checkstyle, BracesPlacement placement, String... tokens) {
        String option = getRightCurlyOption(placement);
        CheckModule module = CheckModuleBuilder.withName("RightCurly")
                .withProperty("option", option)
                .withProperty("tokens", String.join(",", tokens))
                .build();
        checkstyle.addModule(module);
    }

    private static String getRightCurlyOption(BracesPlacement placement) {
        switch (placement) {
            case END_OF_LINE:
                return "same";
            case NEW_LINE:
                return "alone";
        }
        throw new CodeStyleException("Unknown BracesPlament: " + placement);
    }

    private static void forceBraces(Checkstyle checkstyle, Braces braces) {
        List<String> tokens = new ArrayList<>();
        if (isTrue(braces.getForceBracesOnIf())) {
            tokens.add("LITERAL_IF");
            tokens.add("LITERAL_ELSE");
        }
        if (isTrue(braces.getForceBracesOnDoWhile())) {
            tokens.add("LITERAL_DO");
        }
        if (isTrue(braces.getForceBracesOnWhile())) {
            tokens.add("LITERAL_WHILE");
        }
        if (isTrue(braces.getForceBracesOnFor())) {
            tokens.add("LITERAL_FOR");
        }

        if (tokens.size() > 0) {
            CheckModule module = CheckModuleBuilder.withName("NeedBraces")
                    .withProperty("tokens", String.join(",", tokens))
                    .build();
            checkstyle.addModule(module);
        }
    }
}
