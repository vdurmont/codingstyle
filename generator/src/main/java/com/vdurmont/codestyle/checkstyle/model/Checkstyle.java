package com.vdurmont.codestyle.checkstyle.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "module")
@XmlAccessorType(XmlAccessType.FIELD)
public class Checkstyle {
    @XmlAttribute
    private final String name = "Checker";
    @XmlElement(name = "module")
    private List<CheckModule> modules = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<CheckModule> getModules(String name) {
        return this.modules.stream()
                .filter(m -> m.getName().equals(name))
                .collect(Collectors.toList());
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
