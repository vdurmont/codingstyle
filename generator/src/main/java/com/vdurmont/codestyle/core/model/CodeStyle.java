package com.vdurmont.codestyle.core.model;

/**
 * This is the main object representing a code style.
 * Each config is gonna be converted to this one before being converted to another config.
 */
public class CodeStyle {
    private String projectName;
    private Indentation indentation;
    private Annotations annotations;
    private Page page;
    private Spaces spaces;
    private Braces braces;
    private Imports imports;

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

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
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

    public Imports getImports() {
        return imports;
    }

    public void setImports(Imports imports) {
        this.imports = imports;
    }
}
