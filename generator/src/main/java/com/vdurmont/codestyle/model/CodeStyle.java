package com.vdurmont.codestyle.model;

public class CodeStyle {
    private String projectName;
    private Indentation indentation;
    private Page page;
    private Spaces spaces;
    private Braces braces;

    // TODO imports, blank lines

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Indentation getIndentation() {
        return indentation;
    }

    public void setIndentation(Indentation indentation) {
        this.indentation = indentation;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Spaces getSpaces() {
        return spaces;
    }

    public void setSpaces(Spaces spaces) {
        this.spaces = spaces;
    }

    public Braces getBraces() {
        return braces;
    }

    public void setBraces(Braces braces) {
        this.braces = braces;
    }
}
