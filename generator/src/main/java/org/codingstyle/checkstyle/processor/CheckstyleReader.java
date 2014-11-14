package org.codingstyle.checkstyle.processor;

import org.codingstyle.checkstyle.model.Checkstyle;
import org.codingstyle.core.model.Style;
import org.codingstyle.core.processor.Reader;

public class CheckstyleReader implements Reader<Checkstyle> {
    @Override public Style read(Checkstyle input) {
        throw new RuntimeException("Not implemented.");
    }
}
