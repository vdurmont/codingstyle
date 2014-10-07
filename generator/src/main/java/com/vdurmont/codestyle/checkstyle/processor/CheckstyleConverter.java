package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.processor.Converter;

public class CheckstyleConverter implements Converter<Checkstyle> {
    @Override public CodeStyle toCodeStyle(Checkstyle input) {
        // TODO code
        return new CodeStyle();
    }

    @Override public Checkstyle fromCodeStyle(CodeStyle codeStyle) {
        // TODO code
        Checkstyle checkstyle = new Checkstyle();
        checkstyle.setName("Test");

        CheckstyleIndentationConverter.buildCheckstyle(checkstyle, codeStyle.getIndentation());

        return checkstyle;
    }
}
