package com.vdurmont.codestyle.intellij.processor;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.Indentation;
import com.vdurmont.codestyle.core.processor.Reader;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import org.apache.log4j.Logger;

public class IntelliJReader implements Reader<CodeScheme> {
    private static final Logger LOGGER = Logger.getLogger(IntelliJReader.class);

    @Override
    public CodeStyle read(CodeScheme scheme) {
        LOGGER.trace("Converting " + scheme + " to CodeStyle");
        CodeStyle style = new CodeStyle();
        style.setProjectName(scheme.getName());
        Indentation indentation = IntelliJIndentationConverter.toIndentation(scheme);
        style.setIndentation(indentation);
        return style;
    }
}