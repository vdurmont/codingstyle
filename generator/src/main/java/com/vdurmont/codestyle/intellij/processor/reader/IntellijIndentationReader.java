package com.vdurmont.codestyle.intellij.processor.reader;

import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.model.CodeStyleSetting;
import com.vdurmont.codestyle.intellij.model.Option;
import com.vdurmont.codestyle.intellij.model.Value;

public class IntellijIndentationReader {
    public static Indentation toIndentation(CodeScheme scheme) {
        Indentation indentation = new Indentation();
        Option otherIndentOptions = scheme.getOption("OTHER_INDENT_OPTIONS");
        if (otherIndentOptions != null) {
            Value value = otherIndentOptions.getValueTag();
            if (value != null) {
                Boolean useTabCharacter = value.getBooleanOption("USE_TAB_CHARACTER");
                indentation.setIndentCharacter(ternaryOp(useTabCharacter, IndentCharacter.TAB, IndentCharacter.SPACE));
                indentation.setIndentSize(value.getIntegerOption("INDENT_SIZE"));
                indentation.setContinuationIndentSize(value.getIntegerOption("CONTINUATION_INDENT_SIZE"));
                indentation.setTabSize(value.getIntegerOption("TAB_SIZE"));
                indentation.setSmartTabs(value.getBooleanOption("SMART_TABS"));
                indentation.setLabelIndentSize(value.getIntegerOption("LABEL_INDENT_SIZE"));
                indentation.setLabelIndentAbsolute(value.getBooleanOption("LABEL_INDENT_ABSOLUTE"));
                indentation.setRelativeIndents(value.getBooleanOption("USE_RELATIVE_INDENTS"));
            }
        }
        CodeStyleSetting setting = scheme.getCodeStyleSetting("JAVA");
        if (setting != null) {
            indentation.setReindentComments(setting.getBooleanOption("LINE_COMMENT_AT_FIRST_COLUMN"));
        }
        return indentation;
    }

    private static <T> T ternaryOp(Boolean condition, T ifTrue, T ifFalse) {
        if (condition == null) {
            return null;
        }
        return condition ? ifTrue : ifFalse;
    }
}
