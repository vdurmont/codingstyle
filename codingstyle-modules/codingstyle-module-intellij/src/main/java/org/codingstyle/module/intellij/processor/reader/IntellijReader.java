package org.codingstyle.module.intellij.processor.reader;

import org.apache.log4j.Logger;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.core.model.Style;
import org.codingstyle.core.processor.Reader;
import org.codingstyle.module.intellij.model.CodeScheme;

public class IntellijReader implements Reader<CodeScheme> {
    private static final Logger LOGGER = Logger.getLogger(IntellijReader.class);

    @Override
    public Style read(CodeScheme scheme) {
        LOGGER.trace("Converting " + scheme + " to Style");
        Style style = new Style();
        style.setProjectName(scheme.getName());
        Indentation indentation = IntellijIndentationReader.toIndentation(scheme);
        style.setIndentation(indentation);
        return style;
    }
}
