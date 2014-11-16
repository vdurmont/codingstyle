package org.codingstyle.core.processor;

import org.codingstyle.core.model.Project;

public interface Reader<T> {
    Project read(T input);
}