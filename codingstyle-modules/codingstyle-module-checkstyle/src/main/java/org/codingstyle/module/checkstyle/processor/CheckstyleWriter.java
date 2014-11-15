package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Style;
import org.codingstyle.core.processor.Writer;
import org.codingstyle.module.checkstyle.model.Checkstyle;

public class CheckstyleWriter implements Writer<Checkstyle> {
    @Override
    public Checkstyle write(Style style) {
        Checkstyle checkstyle = new Checkstyle();

        CheckstyleIndentationWriter.buildCheckstyle(checkstyle, style.getIndentation());
        CheckstyleBracesWriter.buildCheckstyle(checkstyle, style.getBraces());
        CheckstyleAnnotationsWriter.buildCheckstyle(checkstyle, style.getAnnotations());
        CheckstyleImportsWriter.buildCheckstyle(checkstyle, style.getImports());
        CheckstyleDocumentationWriter.buildCheckstyle(checkstyle, style.getDocumentation());

        return checkstyle;
    }
}
