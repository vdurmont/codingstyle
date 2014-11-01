package com.vdurmont.codestyle.intellij.processor;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.processor.Writer;
import com.vdurmont.codestyle.intellij.model.CodeScheme;

public class IntellijWriter implements Writer<CodeScheme> {
    @Override
    public CodeScheme write(CodeStyle codeStyle) {
        throw new RuntimeException("Not implemented.");
    }
}
