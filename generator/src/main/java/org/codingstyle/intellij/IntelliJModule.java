package org.codingstyle.intellij;

import org.codingstyle.core.Module;
import org.codingstyle.core.processor.ConfigProcessor;
import org.codingstyle.core.processor.Reader;
import org.codingstyle.core.processor.Writer;
import org.codingstyle.intellij.model.CodeScheme;
import org.codingstyle.intellij.processor.IntellijConfigProcessor;
import org.codingstyle.intellij.processor.reader.IntellijReader;
import org.codingstyle.intellij.processor.writer.IntellijWriter;

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
