package com.vdurmont.codestyle.intellij.processor;

import com.vdurmont.codestyle.core.processor.JaxbConfigProcessor;
import com.vdurmont.codestyle.intellij.model.CodeScheme;

public class IntelliJConfigProcessor extends JaxbConfigProcessor<CodeScheme> {
    public IntelliJConfigProcessor() {
        super(CodeScheme.class);
    }
}
