package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.exception.CodingStyleException;
import org.codingstyle.core.model.Braces;
import org.codingstyle.core.model.BracesPlacement;
import org.codingstyle.module.checkstyle.model.CheckModule;
import org.codingstyle.module.checkstyle.model.Checkstyle;
import org.codingstyle.module.checkstyle.util.CheckModuleBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.codingstyle.core.model.Braces.ForcedBracesBlock;
import static org.codingstyle.core.model.Braces.LeftBracesBlock;
import static org.codingstyle.core.model.Braces.RightBracesBlock;
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
                    throw new CodingStyleException("Unknown LeftBracesBlock: " + entry.getKey());
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
        throw new CodingStyleException("Unknown BracesPlacement: " + placement);
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
                    throw new CodingStyleException("Unknown RightBracesBlock: " + entry.getKey());
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
        throw new CodingStyleException("Unknown BracesPlacement: " + placement);
    }

    private static void addCurlyModule(String name, Checkstyle checkstyle, String option, String tokens) {
        CheckModule treeWalker = checkstyle.getOrCreateModule("TreeWalker");
        CheckModule module = CheckModuleBuilder.withName(name)
                .withProperty("option", option)
                .withProperty("tokens", tokens)
                .build();
        treeWalker.addModule(module);
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
                    throw new CodingStyleException("Unknown ForcedBracesBlock: " + entry.getKey());
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
