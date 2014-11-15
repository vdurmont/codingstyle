package org.codingstyle.core.processor;

import org.codingstyle.core.model.Style;

public interface Reader<T> {
    Style read(T input);
}