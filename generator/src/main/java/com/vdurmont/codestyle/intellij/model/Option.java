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

    public void setValue(Object value) {
        this.stringValue = value.toString();
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

    public Value getOrCreateValueTag() {
        Value value = this.getValueTag();
        if (value == null) {
            value = new Value();
            this.setValueTag(value);
        }
        return value;
    }
}
