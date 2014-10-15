package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.processor.JaxbConfigProcessor;

public class CheckstyleConfigProcessor extends JaxbConfigProcessor<Checkstyle> {
    private static final String XML_HEADERS = "<!DOCTYPE module PUBLIC\n"
            + "    \"-//Puppy Crawl//DTD Check Configuration 1.2//EN\"\n"
            + "    \"http://www.puppycrawl.com/dtds/configuration_1_2.dtd\">";

    public CheckstyleConfigProcessor() {
        super(Checkstyle.class);
        this.addProperty("com.sun.xml.internal.bind.xmlHeaders", XML_HEADERS);
    }
}
