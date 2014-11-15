package org.codingstyle.core.processor;

import org.codingstyle.core.model.Style;

public interface Writer<T> {
    T write(Style style);
}