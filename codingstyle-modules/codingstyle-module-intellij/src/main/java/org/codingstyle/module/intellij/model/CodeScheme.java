package org.codingstyle.module.intellij.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "code_scheme")
@XmlAccessorType(XmlAccessType.FIELD)
public class CodeScheme extends OptionsHolder {
    @XmlAttribute
    private String name;
    @XmlElement(name = "codeStyleSettings")
    private List<CodeStyleSetting> codeStyleSettings;
    @XmlTransient
    private Map<String, CodeStyleSetting> codeStyleSettingsByName;

    public CodeScheme() {
        this.codeStyleSettingsByName = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CodeStyleSetting> getCodeStyleSettings() {
        return codeStyleSettings;
    }

    public void setCodeStyleSettings(List<CodeStyleSetting> codeStyleSettings) {
        this.codeStyleSettings = codeStyleSettings;
    }

    public CodeStyleSetting getCodeStyleSetting(String language) {
        if (this.codeStyleSettingsByName == null) {
            this.codeStyleSettingsByName = new HashMap<>();
            this.codeStyleSettings.forEach(o -> this.codeStyleSettingsByName.put(o.getLanguage().toLowerCase(), o));
        }
        return this.codeStyleSettingsByName.get(language.toLowerCase());
    }
}
