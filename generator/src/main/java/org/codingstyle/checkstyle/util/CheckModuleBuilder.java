package org.codingstyle.checkstyle.util;

import org.codingstyle.checkstyle.model.CheckModule;
import org.codingstyle.checkstyle.model.CheckProperty;

public class CheckModuleBuilder {
    private final CheckModule module;

    private CheckModuleBuilder(String name) {
        this.module = new CheckModule(name);
    }

    public CheckModuleBuilder withProperty(String name, Object value) {
        String strValue = value == null ? null : value.toString();
        CheckProperty property = new CheckProperty(name, strValue);
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
