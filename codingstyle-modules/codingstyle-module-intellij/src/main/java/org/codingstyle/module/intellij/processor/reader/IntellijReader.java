package org.codingstyle.module.intellij.processor.reader;

import org.apache.log4j.Logger;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.core.model.Project;
import org.codingstyle.core.processor.Reader;
import org.codingstyle.module.intellij.model.CodeScheme;

public class IntellijReader implements Reader<CodeScheme> {
    private static final Logger LOGGER = Logger.getLogger(IntellijReader.class);

    @Override
    public Project read(CodeScheme scheme) {
        LOGGER.trace("Converting " + scheme + " to Style");
        Project project = new Project();
        project.setName(scheme.getName());
        Indentation indentation = IntellijIndentationReader.toIndentation(scheme);
        project.setIndentation(indentation);
        return project;
    }
}
