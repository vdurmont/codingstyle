package org.codingstyle.intellij.processor.writer;

import org.codingstyle.core.model.Style;
import org.codingstyle.core.processor.Writer;
import org.codingstyle.intellij.model.CodeScheme;

public class IntellijWriter implements Writer<CodeScheme> {
    @Override
    public CodeScheme write(Style style) {
        CodeScheme scheme = new CodeScheme();
        scheme.setName(style.getProjectName());
        if (style.getIndentation() != null) {
            IntellijIndentationWriter.write(scheme, style.getIndentation());
        }
        return scheme;
    }
}
