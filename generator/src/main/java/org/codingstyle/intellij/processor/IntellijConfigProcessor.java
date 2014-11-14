package org.codingstyle.intellij.processor;

import org.codingstyle.core.processor.JaxbConfigProcessor;
import org.codingstyle.intellij.model.CodeScheme;

public class IntellijConfigProcessor extends JaxbConfigProcessor<CodeScheme> {
    public IntellijConfigProcessor() {
        super(CodeScheme.class);
    }
}
