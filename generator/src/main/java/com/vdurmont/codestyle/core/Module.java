package com.vdurmont.codestyle.core;

import com.vdurmont.codestyle.core.processor.ConfigProcessor;
import com.vdurmont.codestyle.core.processor.Reader;
import com.vdurmont.codestyle.core.processor.Writer;

public interface Module<T> {
    Class<T> getTargetClass();

    ConfigProcessor<T> getConfigProcessor();

    Reader<T> getReader();

    Writer<T> getWriter();
}
