package com.vdurmont.codestyle.checkstyle;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleConfigProcessor;
import com.vdurmont.codestyle.checkstyle.processor.CheckstyleWriter;
import com.vdurmont.codestyle.core.Module;
import com.vdurmont.codestyle.core.processor.ConfigProcessor;
import com.vdurmont.codestyle.core.processor.Reader;
import com.vdurmont.codestyle.core.processor.Writer;

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

    @Override public Reader<Checkstyle> getReader() {
        return new CheckstyleReader();
    }

    @Override public Writer<Checkstyle> getWriter() {
        return new CheckstyleWriter();
    }
}
