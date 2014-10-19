package com.vdurmont.codestyle.checkstyle.model;

import com.vdurmont.codestyle.core.exception.CodeStyleException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "module")
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckModule {
    @XmlAttribute
    private String name;
    @XmlElement(name = "property")
    private List<CheckProperty> properties = new ArrayList<>();
    @XmlElement(name = "module")
    private List<CheckModule> modules = new ArrayList<>();

    public CheckModule() {
    }

    public CheckModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckProperty getProperty(String name) {
        List<CheckProperty> properties = this.properties.stream()
                .filter(m -> m.getName().equals(name))
                .collect(Collectors.toList());
        return properties.size() == 0 ? null : properties.get(0);
    }

    public List<CheckProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<CheckProperty> properties) {
        this.properties = properties;
    }

    public void addProperty(CheckProperty property) {
        this.properties.add(property);
    }

    public void addProperties(CheckProperty... property) {
        Arrays.stream(property).forEach(this::addProperty);
    }

    public List<CheckModule> getModules(String name) {
        return this.modules.stream()
                .filter(m -> m.getName().equals(name))
                .collect(Collectors.toList());
    }

    public CheckModule getModule(String name) {
        List<CheckModule> modules = this.getModules(name);
        if (modules.size() == 0) {
            return null;
        } else if (modules.size() == 1) {
            return modules.get(0);
        } else {
            throw new CodeStyleException("Cannot get a single module with name \"" + name + "\": found " + modules.size());
        }
    }

    public List<CheckModule> getModules() {
        return modules;
    }

    public void setModules(List<CheckModule> modules) {
        this.modules = modules;
    }

    public void addModule(CheckModule module) {
        this.modules.add(module);
    }
}
