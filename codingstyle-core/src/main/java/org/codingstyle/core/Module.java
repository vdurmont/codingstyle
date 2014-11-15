package org.codingstyle.core;

import org.codingstyle.core.processor.ConfigProcessor;
import org.codingstyle.core.processor.Reader;
import org.codingstyle.core.processor.Writer;

public interface Module<T> {
    Class<T> getTargetClass();

    ConfigProcessor<T> getConfigProcessor();

    Reader<T> getReader();

    Writer<T> getWriter();
}
