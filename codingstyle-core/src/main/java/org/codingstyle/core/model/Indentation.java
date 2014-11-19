package org.codingstyle.core.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name = "cs_indentation")
public class Indentation extends Entity {
    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
    @Transient private IndentCharacter indentCharacter;
    @Column(name = "indent_size")
    private Integer indentSize;
    @Transient private Integer continuationIndentSize;
    @Transient private Integer tabSize;
    @Transient private Integer labelIndentSize;
    @Transient private Boolean labelIndentAbsolute;
    @Transient private Boolean smartTabs;
    @Transient private Boolean reindentComments;
    @Transient private Boolean relativeIndents;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

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
