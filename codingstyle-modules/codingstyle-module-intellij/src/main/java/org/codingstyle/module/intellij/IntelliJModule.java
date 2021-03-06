package org.codingstyle.module.intellij;

import org.codingstyle.core.Module;
import org.codingstyle.core.processor.ConfigProcessor;
import org.codingstyle.core.processor.Reader;
import org.codingstyle.core.processor.Writer;
import org.codingstyle.module.intellij.model.CodeScheme;
import org.codingstyle.module.intellij.processor.IntellijConfigProcessor;
import org.codingstyle.module.intellij.processor.reader.IntellijReader;
import org.codingstyle.module.intellij.processor.writer.IntellijWriter;

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
