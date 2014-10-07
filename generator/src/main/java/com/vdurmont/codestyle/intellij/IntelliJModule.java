package com.vdurmont.codestyle.intellij;

import com.vdurmont.codestyle.core.Module;
import com.vdurmont.codestyle.core.processor.ConfigProcessor;
import com.vdurmont.codestyle.core.processor.Reader;
import com.vdurmont.codestyle.core.processor.Writer;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.processor.IntelliJConfigProcessor;
import com.vdurmont.codestyle.intellij.processor.IntelliJReader;

public class IntelliJModule implements Module<CodeScheme> {
    private final IntelliJConfigProcessor processor;

    public IntelliJModule() {
        this.processor = new IntelliJConfigProcessor();
    }

    @Override public Class<CodeScheme> getTargetClass() {
        return CodeScheme.class;
    }

    @Override public ConfigProcessor<CodeScheme> getConfigProcessor() {
        return this.processor;
    }

    @Override public Reader<CodeScheme> getReader() {
        return new IntelliJReader();
    }

    @Override public Writer<CodeScheme> getWriter() {
        return new IntelliJWriter();
    }
}
