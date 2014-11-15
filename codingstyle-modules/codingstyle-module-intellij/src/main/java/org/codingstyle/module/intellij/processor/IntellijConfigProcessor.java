package org.codingstyle.module.intellij.processor;


import org.codingstyle.core.processor.JaxbConfigProcessor;
import org.codingstyle.module.intellij.model.CodeScheme;

public class IntellijConfigProcessor extends JaxbConfigProcessor<CodeScheme> {
    public IntellijConfigProcessor() {
        super(CodeScheme.class);
    }
}
