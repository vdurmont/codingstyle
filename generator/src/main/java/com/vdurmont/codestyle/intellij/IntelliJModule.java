package com.vdurmont.codestyle.intellij;

import com.vdurmont.codestyle.core.Module;
import com.vdurmont.codestyle.core.processor.ConfigProcessor;
import com.vdurmont.codestyle.core.processor.Converter;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.processor.IntelliJConfigProcessor;
import com.vdurmont.codestyle.intellij.processor.IntelliJConverter;

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

    @Override public Converter<CodeScheme> getConverter() {
        return new IntelliJConverter();
    }
}
