package com.vdurmont.codestyle.intellij.processor;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.Indentation;
import com.vdurmont.codestyle.core.processor.Converter;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import org.apache.log4j.Logger;

public class IntelliJConverter implements Converter<CodeScheme> {
    private static final Logger LOGGER = Logger.getLogger(IntelliJConverter.class);

    @Override
    public CodeStyle toCodeStyle(CodeScheme scheme) {
        LOGGER.trace("Converting " + scheme + " to CodeStyle");
        CodeStyle style = new CodeStyle();
        style.setProjectName(scheme.getName());
        Indentation indentation = IntelliJIndentationConverter.toIndentation(scheme);
        style.setIndentation(indentation);
        return style;
    }

    @Override
    public CodeScheme fromCodeStyle(CodeStyle codeStyle) {
        return null;
    }
}
