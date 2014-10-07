package com.vdurmont.codestyle.intellij.processor;

import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.model.CodeStyleSetting;
import com.vdurmont.codestyle.intellij.model.Option;
import com.vdurmont.codestyle.intellij.model.Value;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;

public class IntelliJIndentationConverter {
    public static Indentation convert(CodeScheme scheme) {
        Indentation indentation = new Indentation();
        Option otherIndentOptions = scheme.getOption("OTHER_INDENT_OPTIONS");
        if (otherIndentOptions != null) {
            Value value = otherIndentOptions.getValueTag();
            if (value != null) {
                Boolean useTabCharacter = value.getBooleanOption("USE_TAB_CHARACTER");
                indentation.setIndentCharacter(ternaryOp(useTabCharacter, IndentCharacter.TAB, IndentCharacter.SPACE));
                indentation.setIndentSize(value.getIntegerOption("INDENT_SIZE"));
                indentation.setSmartTabs(value.getBooleanOption("SMART_TABS"));
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
