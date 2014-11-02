package com.vdurmont.codestyle.intellij.processor.writer;

import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.model.Option;
import com.vdurmont.codestyle.intellij.model.Value;

public class IntellijIndentationWriter {
    public static void write(CodeScheme scheme, Indentation indentation) {
        Option otherIndentOptions = scheme.getOrCreateOption("OTHER_INDENT_OPTIONS");
        Value value = otherIndentOptions.getOrCreateValueTag();
        if (indentation.getIndentCharacter() != null) {
            Option useTabCharacter = value.getOrCreateOption("USE_TAB_CHARACTER");
            useTabCharacter.setValue(indentation.getIndentCharacter() == IndentCharacter.TAB);
        }
        if (indentation.getTabSize() != null) {
            Option option = value.getOrCreateOption("TAB_SIZE");
            option.setValue(indentation.getTabSize());
        }
        if (indentation.getIndentSize() != null) {
            Option option = value.getOrCreateOption("INDENT_SIZE");
            option.setValue(indentation.getIndentSize());
        }
        if (indentation.getContinuationIndentSize() != null) {
            Option option = value.getOrCreateOption("CONTINUATION_INDENT_SIZE");
            option.setValue(indentation.getContinuationIndentSize());
        }
        if (indentation.getLabelIndentAbsolute() != null) {
            Option option = value.getOrCreateOption("LABEL_INDENT_ABSOLUTE");
            option.setValue(indentation.getLabelIndentAbsolute());
        }
        if (indentation.getLabelIndentSize() != null) {
            Option option = value.getOrCreateOption("LABEL_INDENT_SIZE");
            option.setValue(indentation.getLabelIndentSize());
        }
    }
}
