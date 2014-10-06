package com.vdurmont.codestyle.intellij.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "option")
@XmlAccessorType(XmlAccessType.FIELD)
public class Option {
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "value")
    private String stringValue;
    @XmlElement(name = "value")
    private Value valueTag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Boolean getBooleanValue() {
        if (stringValue == null) {
            return null;
        }
        return Boolean.valueOf(stringValue);
    }

    public Integer getIntegerValue() {
        if (stringValue == null) {
            return null;
        }
        return Integer.valueOf(stringValue);
    }

    public Value getValueTag() {
        return valueTag;
    }

    public void setValueTag(Value valueTag) {
        this.valueTag = valueTag;
    }

    @Override public String toString() {
        return "Option{" +
                "name='" + name + '\'' +
                ", stringValue='" + stringValue + '\'' +
                ", valueTag=" + valueTag +
                '}';
    }
}
