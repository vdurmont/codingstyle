package org.codingstyle.module.intellij.processor.writer;

import org.codingstyle.core.model.Project;
import org.codingstyle.core.processor.Writer;
import org.codingstyle.module.intellij.model.CodeScheme;

public class IntellijWriter implements Writer<CodeScheme> {
    @Override
    public CodeScheme write(Project project) {
        CodeScheme scheme = new CodeScheme();
        scheme.setName(project.getName());
        if (project.getIndentation() != null) {
            IntellijIndentationWriter.write(scheme, project.getIndentation());
        }
        return scheme;
    }
}
