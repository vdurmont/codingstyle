package com.vdurmont.codestyle.core;

import com.vdurmont.codestyle.core.processor.ConfigProcessor;
import com.vdurmont.codestyle.core.processor.Converter;

public interface Module<T> {
    Class<T> getTargetClass();

    ConfigProcessor<T> getConfigProcessor();

    Converter<T> getConverter();
}
