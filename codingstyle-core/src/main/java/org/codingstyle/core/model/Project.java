package org.codingstyle.core.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * This is the main object representing a coding style.
 * Each config is gonna be converted to this one before being converted to another config.
 */
@javax.persistence.Entity
@Table(name = "cs_project")
public class Project extends Entity {
    @NotEmpty
    @Column(name = "extern_id", nullable = false, unique = true, length = 32)
    private String externId;
    @NotEmpty
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @Transient private Indentation indentation;
    @Transient private Annotations annotations;
    @Transient private Page page;
    @Transient private Spaces spaces;
    @Transient private Braces braces;
    @Transient private Imports imports;
    @Transient private Documentation documentation;

    public String getExternId() {
        return externId;
    }

    public void setExternId(String externId) {
        this.externId = externId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Documentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(Documentation documentation) {
        this.documentation = documentation;
    }
}
