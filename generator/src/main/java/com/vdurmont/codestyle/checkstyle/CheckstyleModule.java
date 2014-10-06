package com.vdurmont.codestyle.checkstyle;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleConfigProcessor;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleConverter;
import com.vdurmont.codestyle.core.Module;
import com.vdurmont.codestyle.core.processor.ConfigProcessor;
import com.vdurmont.codestyle.core.processor.Converter;

public class CheckstyleModule implements Module<Checkstyle> {
    private final CheckstyleConfigProcessor processor;

    public CheckstyleModule() {
        this.processor = new CheckstyleConfigProcessor();
    }

    @Override public Class<Checkstyle> getTargetClass() {
        return Checkstyle.class;
    }

    @Override public ConfigProcessor<Checkstyle> getConfigProcessor() {
        return this.processor;
    }

    @Override public Converter<Checkstyle> getConverter() {
        return new CheckstyleConverter();
    }
}
