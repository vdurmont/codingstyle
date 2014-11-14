package org.codingstyle.checkstyle.processor;

import org.codingstyle.checkstyle.model.Checkstyle;
import org.codingstyle.core.model.Style;
import org.codingstyle.core.processor.Writer;

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
