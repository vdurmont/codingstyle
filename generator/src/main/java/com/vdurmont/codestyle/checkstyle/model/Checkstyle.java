package com.vdurmont.codestyle.checkstyle.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "module")
public class Checkstyle extends CheckModule {
    public Checkstyle() {
        super("Checker");
    }
}