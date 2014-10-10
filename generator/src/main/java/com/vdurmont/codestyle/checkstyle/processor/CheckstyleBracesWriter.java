package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.util.CheckModuleBuilder;
import com.vdurmont.codestyle.core.exception.CodeStyleException;
import com.vdurmont.codestyle.core.model.Braces;
import com.vdurmont.codestyle.core.model.BracesPlacement;

import java.util.ArrayList;
import java.util.List;

import static com.vdurmont.codestyle.core.model.Braces.ForcedBracesBlock;
import static com.vdurmont.codestyle.core.model.Braces.LeftBracesBlock;
import static com.vdurmont.codestyle.core.model.Braces.RightBracesBlock;
import static java.util.Map.Entry;

public class CheckstyleBracesWriter {
    public static void buildCheckstyle(Checkstyle checkstyle, Braces braces) {
        addLeftCurlyStyle(checkstyle, braces);
        addRightCurlyStyle(checkstyle, braces);
        forceBraces(checkstyle, braces);
    }

    private static void addLeftCurlyStyle(Checkstyle checkstyle, Braces braces) {
        for (Entry<LeftBracesBlock, BracesPlacement> entry : braces.getLeftBracesPlacements().entrySet()) {
            String tokens;
            switch (entry.getKey()) {
                case CLASS:
                    tokens = "ANNOTATION_DEF,CLASS_DEF,ENUM_DEF,INTERFACE_DEF";
                    break;
                case METHOD:
                    tokens = "CTOR_DEF,METHOD_DEF";
                    break;
                case OTHER:
                    tokens = "LITERAL_CATCH,LITERAL_DO,LITERAL_ELSE,LITERAL_FINALLY,LITERAL_FOR,LITERAL_IF,"
                            + "LITERAL_SWITCH,LITERAL_SYNCHRONIZED,LITERAL_TRY,LITERAL_WHILE";
                    break;
                default:
                    throw new CodeStyleException("Unknown LeftBracesBlock: " + entry.getKey());
            }
            addCurlyModule("LeftCurly", checkstyle, getLeftCurlyOption(entry.getValue()), tokens);
        }
    }

    private static String getLeftCurlyOption(BracesPlacement placement) {
        switch (placement) {
            case END_OF_LINE:
                return "eol";
            case NEW_LINE:
                return "nl";
        }
        throw new CodeStyleException("Unknown BracesPlacement: " + placement);
    }

    private static void addRightCurlyStyle(Checkstyle checkstyle, Braces braces) {
        for (Entry<RightBracesBlock, BracesPlacement> entry : braces.getRightBracesPlacements().entrySet()) {
            String tokens;
            switch (entry.getKey()) {
                case IF:
                    tokens = "LITERAL_IF";
                    break;
                case ELSE:
                    tokens = "LITERAL_ELSE";
                    break;
                case DO:
                    tokens = "LITERAL_DO";
                    break;
                case TRY:
                    tokens = "LITERAL_TRY";
                    break;
                case CATCH:
                    tokens = "LITERAL_CATCH";
                    break;
                case FINALLY:
                    tokens = "LITERAL_FINALLY";
                    break;
                default:
                    throw new CodeStyleException("Unknown RightBracesBlock: " + entry.getKey());
            }
            addCurlyModule("RightCurly", checkstyle, getRightCurlyOption(entry.getValue()), tokens);
        }
    }

    private static String getRightCurlyOption(BracesPlacement placement) {
        switch (placement) {
            case END_OF_LINE:
                return "same";
            case NEW_LINE:
                return "alone";
        }
        throw new CodeStyleException("Unknown BracesPlacement: " + placement);
    }

    private static void addCurlyModule(String name, Checkstyle checkstyle, String option, String tokens) {
        CheckModule module = CheckModuleBuilder.withName(name)
                .withProperty("option", option)
                .withProperty("tokens", tokens)
                .build();
        checkstyle.addModule(module);
    }

    private static void forceBraces(Checkstyle checkstyle, Braces braces) {
        List<String> tokens = new ArrayList<>();

        for (Entry<ForcedBracesBlock, Boolean> entry : braces.getForcedBraces().entrySet()) {
            switch (entry.getKey()) {
                case IF:
                    tokens.add("LITERAL_IF");
                    tokens.add("LITERAL_ELSE");
                    break;
                case DO_WHILE:
                    tokens.add("LITERAL_DO");
                    break;
                case WHILE:
                    tokens.add("LITERAL_WHILE");
                    break;
                case FOR:
                    tokens.add("LITERAL_FOR");
                    break;
                default:
                    throw new CodeStyleException("Unknown ForcedBracesBlock: " + entry.getKey());
            }
        }

        if (tokens.size() > 0) {
            CheckModule module = CheckModuleBuilder.withName("NeedBraces")
                    .withProperty("tokens", String.join(",", tokens))
                    .build();
            checkstyle.addModule(module);
        }
    }
}
