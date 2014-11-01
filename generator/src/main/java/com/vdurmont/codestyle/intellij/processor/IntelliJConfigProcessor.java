package com.vdurmont.codestyle.intellij.processor;

import com.vdurmont.codestyle.core.processor.JaxbConfigProcessor;
import com.vdurmont.codestyle.intellij.model.CodeScheme;

public class IntellijConfigProcessor extends JaxbConfigProcessor<CodeScheme> {
    public IntellijConfigProcessor() {
        super(CodeScheme.class);
    }
}
