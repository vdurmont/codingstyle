package org.codingstyle.core.processor;

import org.codingstyle.core.model.Project;

public interface Writer<T> {
    T write(Project project);
}