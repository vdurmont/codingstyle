package org.codingstyle.core.processor;

import java.io.InputStream;
import java.io.OutputStream;

public interface ConfigProcessor<T> {
    T readFromStream(InputStream stream);

    void writeToStream(T input, OutputStream stream);
}
