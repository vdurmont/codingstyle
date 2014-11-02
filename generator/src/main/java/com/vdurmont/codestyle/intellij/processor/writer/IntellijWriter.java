package com.vdurmont.codestyle.intellij.processor.writer;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.processor.Writer;
import com.vdurmont.codestyle.intellij.model.CodeScheme;

public class IntellijWriter implements Writer<CodeScheme> {
    @Override
    public CodeScheme write(CodeStyle codeStyle) {
        CodeScheme scheme = new CodeScheme();
        scheme.setName(codeStyle.getProjectName());
        if (codeStyle.getIndentation() != null) {
            IntellijIndentationWriter.write(scheme, codeStyle.getIndentation());
        }
        return scheme;
    }
}
