package com.vdurmont.codestyle.intellij;

import com.vdurmont.codestyle.core.Module;
import com.vdurmont.codestyle.core.processor.ConfigProcessor;
import com.vdurmont.codestyle.core.processor.Reader;
import com.vdurmont.codestyle.core.processor.Writer;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.processor.IntellijConfigProcessor;
import com.vdurmont.codestyle.intellij.processor.IntellijReader;
import com.vdurmont.codestyle.intellij.processor.IntellijWriter;

public class IntelliJModule implements Module<CodeScheme> {
    private final IntellijConfigProcessor processor;

    public IntelliJModule() {
        this.processor = new IntellijConfigProcessor();
    }

    @Override public Class<CodeScheme> getTargetClass() {
        return CodeScheme.class;
    }

    @Override public ConfigProcessor<CodeScheme> getConfigProcessor() {
        return this.processor;
    }

    @Override public Reader<CodeScheme> getReader() {
        return new IntellijReader();
    }

    @Override public Writer<CodeScheme> getWriter() {
        return new IntellijWriter();
    }
}
