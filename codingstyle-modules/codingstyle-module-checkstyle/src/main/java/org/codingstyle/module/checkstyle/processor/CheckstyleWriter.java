package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Project;
import org.codingstyle.core.processor.Writer;
import org.codingstyle.module.checkstyle.model.Checkstyle;

public class CheckstyleWriter implements Writer<Checkstyle> {
    @Override
    public Checkstyle write(Project project) {
        Checkstyle checkstyle = new Checkstyle();

        CheckstyleIndentationWriter.buildCheckstyle(checkstyle, project.getIndentation());
        CheckstyleBracesWriter.buildCheckstyle(checkstyle, project.getBraces());
        CheckstyleAnnotationsWriter.buildCheckstyle(checkstyle, project.getAnnotations());
        CheckstyleImportsWriter.buildCheckstyle(checkstyle, project.getImports());
        CheckstyleDocumentationWriter.buildCheckstyle(checkstyle, project.getDocumentation());

        return checkstyle;
    }
}
