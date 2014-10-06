package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.processor.JaxbConfigProcessor;

public class CheckstyleConfigProcessor extends JaxbConfigProcessor<Checkstyle> {
    public CheckstyleConfigProcessor() {
        super(Checkstyle.class);
    }
}
