package org.codingstyle.core.model;

public class Indentation {
    private IndentCharacter indentCharacter;
    private Integer indentSize;
    private Integer continuationIndentSize;
    private Integer tabSize;
    private Integer labelIndentSize;
    private Boolean labelIndentAbsolute;
    private Boolean smartTabs;
    private Boolean reindentComments;
    private Boolean relativeIndents;

    public IndentCharacter getIndentCharacter() {
        return indentCharacter;
    }

    public void setIndentCharacter(IndentCharacter indentCharacter) {
        this.indentCharacter = indentCharacter;
    }

    public Integer getIndentSize() {
        return indentSize;
    }

    public void setIndentSize(Integer indentSize) {
        this.indentSize = indentSize;
    }

    public Integer getContinuationIndentSize() {
        return continuationIndentSize;
    }

    public void setContinuationIndentSize(Integer continuationIndentSize) {
        this.continuationIndentSize = continuationIndentSize;
    }

    public Integer getTabSize() {
        return tabSize;
    }

    public void setTabSize(Integer tabSize) {
        this.tabSize = tabSize;
    }

    public Integer getLabelIndentSize() {
        return labelIndentSize;
    }

    public void setLabelIndentSize(Integer labelIndentSize) {
        this.labelIndentSize = labelIndentSize;
    }

    public Boolean getLabelIndentAbsolute() {
        return labelIndentAbsolute;
    }

    public void setLabelIndentAbsolute(Boolean labelIndentAbsolute) {
        this.labelIndentAbsolute = labelIndentAbsolute;
    }

    public Boolean getSmartTabs() {
        return smartTabs;
    }

    public void setSmartTabs(Boolean smartTabs) {
        this.smartTabs = smartTabs;
    }

    public Boolean getReindentComments() {
        return reindentComments;
    }

    public void setReindentComments(Boolean reindentComments) {
        this.reindentComments = reindentComments;
    }

    public Boolean getRelativeIndents() {
        return relativeIndents;
    }

    public void setRelativeIndents(Boolean relativeIndents) {
        this.relativeIndents = relativeIndents;
    }
}
