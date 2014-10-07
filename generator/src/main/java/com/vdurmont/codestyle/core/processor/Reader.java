package com.vdurmont.codestyle.core.processor;

import com.vdurmont.codestyle.core.model.CodeStyle;

public interface Reader<T> {
    CodeStyle read(T input);
}