package com.vdurmont.codestyle.intellij;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.processor.Writer;
import com.vdurmont.codestyle.intellij.model.CodeScheme;

public class IntelliJWriter implements Writer<CodeScheme> {
    @Override
    public CodeScheme write(CodeStyle codeStyle) {
        throw new RuntimeException("Not implemented.");
    }
}
