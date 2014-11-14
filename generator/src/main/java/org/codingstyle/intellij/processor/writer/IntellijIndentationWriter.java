package org.codingstyle.intellij.processor.writer;

import org.codingstyle.core.model.IndentCharacter;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.intellij.model.CodeScheme;
import org.codingstyle.intellij.model.Option;
import org.codingstyle.intellij.model.Value;

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
        if (indentation.getSmartTabs() != null) {
            Option option = value.getOrCreateOption("SMART_TABS");
            option.setValue(indentation.getSmartTabs());
        }
    }
}
