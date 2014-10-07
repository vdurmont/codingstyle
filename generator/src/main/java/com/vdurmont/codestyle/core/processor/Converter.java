package com.vdurmont.codestyle.core.processor;

import com.vdurmont.codestyle.core.model.CodeStyle;

public interface Converter<T> {
    CodeStyle toCodeStyle(T input);

    T fromCodeStyle(CodeStyle codeStyle);
}
