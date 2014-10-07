package com.vdurmont.codestyle.core.processor;

import com.vdurmont.codestyle.core.model.CodeStyle;

public interface Writer<T> {
    T write(CodeStyle codeStyle);
}