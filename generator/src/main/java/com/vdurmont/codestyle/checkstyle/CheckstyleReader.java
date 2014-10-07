package com.vdurmont.codestyle.checkstyle;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.processor.Reader;

public class CheckstyleReader implements Reader<Checkstyle> {
    @Override public CodeStyle read(Checkstyle input) {
        throw new RuntimeException("Not implemented.");
    }
}
