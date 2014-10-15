package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.processor.Writer;

public class CheckstyleWriter implements Writer<Checkstyle> {
    @Override
    public Checkstyle write(CodeStyle codeStyle) {
        // TODO code
        Checkstyle checkstyle = new Checkstyle();

        CheckstyleIndentationWriter.buildCheckstyle(checkstyle, codeStyle.getIndentation());
        CheckstyleAnnotationsWriter.buildCheckstyle(checkstyle, codeStyle.getAnnotations());
        CheckstyleImportsWriter.buildCheckstyle(checkstyle, codeStyle.getImports());
        CheckstyleDocumentationWriter.buildCheckstyle(checkstyle, codeStyle.getDocumentation());

        return checkstyle;
    }
}