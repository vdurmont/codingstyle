package org.codingstyle.checkstyle;

import org.codingstyle.checkstyle.model.Checkstyle;
import org.codingstyle.checkstyle.processor.CheckstyleConfigProcessor;
import org.codingstyle.checkstyle.processor.CheckstyleReader;
import org.codingstyle.checkstyle.processor.CheckstyleWriter;
import org.codingstyle.core.Module;
import org.codingstyle.core.processor.ConfigProcessor;
import org.codingstyle.core.processor.Reader;
import org.codingstyle.core.processor.Writer;

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
