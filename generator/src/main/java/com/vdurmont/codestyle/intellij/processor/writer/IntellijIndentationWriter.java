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
            useTabCharacter.setBooleanValue(indentation.getIndentCharacter() == IndentCharacter.TAB);
        }
        if (indentation.getTabSize() != null) {
            Option useTabCharacter = value.getOrCreateOption("TAB_SIZE");
            useTabCharacter.setIntegerValue(indentation.getTabSize());
        }
    }
}
