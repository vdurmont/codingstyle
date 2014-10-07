package com.vdurmont.codestyle.checkstyle.util;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.CheckProperty;

public class CheckModuleBuilder {
    private final CheckModule module;

    private CheckModuleBuilder(String name) {
        this.module = new CheckModule(name);
    }

    public CheckModuleBuilder withProperty(String name, String value) {
        CheckProperty property = new CheckProperty(name, value);
        this.module.getProperties().add(property);
        return this;
    }

    public CheckModule build() {
        return this.module;
    }

    public static CheckModuleBuilder withName(String name) {
        return new CheckModuleBuilder(name);
    }
}
