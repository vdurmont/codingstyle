package com.vdurmont.codestyle.core.model;

public class Indentation {
    private IndentCharacter indentCharacter;
    private Integer indentSize;
    private Boolean smartTabs;
    private Boolean reindentComments;

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

    @Override public String toString() {
        return "Indentation{" +
                "indentCharacter=" + indentCharacter +
                ", indentSize=" + indentSize +
                ", smartTabs=" + smartTabs +
                ", reindentComments=" + reindentComments +
                '}';
    }
}
