package org.codingstyle.api.dto;

public class ProjectDTO {
    private String id;
    private String name;
    private IndentationDTO indentation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IndentationDTO getIndentation() {
        return indentation;
    }

    public void setIndentation(IndentationDTO indentation) {
        this.indentation = indentation;
    }
}
