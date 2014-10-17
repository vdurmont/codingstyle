package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.processor.JaxbConfigProcessor;

import javax.xml.bind.Marshaller;

public class CheckstyleConfigProcessor extends JaxbConfigProcessor<Checkstyle> {
    private static final String XML_HEADERS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n"
            + "<!DOCTYPE module PUBLIC\n"
            + "    \"-//Puppy Crawl//DTD Check Configuration 1.2//EN\"\n"
            + "    \"http://www.puppycrawl.com/dtds/configuration_1_2.dtd\">\n";

    public CheckstyleConfigProcessor() {
        super(Checkstyle.class);
        this.addProperty(Marshaller.JAXB_FRAGMENT, true);
        this.addProperty("com.sun.xml.internal.bind.xmlHeaders", XML_HEADERS);
        this.addProperty("com.sun.xml.internal.bind.indentString", "\t");
    }
}
