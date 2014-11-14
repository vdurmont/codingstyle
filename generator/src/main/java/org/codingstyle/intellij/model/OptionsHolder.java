package org.codingstyle.intellij.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class OptionsHolder {
    @XmlElement(name = "option")
    private List<Option> options;
    private Map<String, Option> optionsByName;

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Option getOption(String optionName) {
        if (this.optionsByName == null) {
            this.optionsByName = new HashMap<>();
            if (this.options != null) {
                this.options.forEach(o -> this.optionsByName.put(o.getName().toLowerCase(), o));
            } else {
                this.options = new ArrayList<>();
            }
        }
        return this.optionsByName.get(optionName.toLowerCase());
    }

    public Boolean getBooleanOption(String optionName) {
        Option option = this.getOption(optionName);
        if (option == null) {
            return null;
        }
        return option.getBooleanValue();
    }

    public Integer getIntegerOption(String optionName) {
        Option option = this.getOption(optionName);
        if (option == null) {
            return null;
        }
        return option.getIntegerValue();
    }

    public Option getOrCreateOption(String optionName) {
        Option option = this.getOption(optionName);
        if (option == null) {
            option = new Option();
            option.setName(optionName);
            this.options.add(option);
            this.optionsByName.put(optionName.toLowerCase(), option);
        }
        return option;
    }
}
