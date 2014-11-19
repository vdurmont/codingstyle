package org.codingstyle.api.dto;

import org.codingstyle.core.model.IndentCharacter;

public class IndentationDTO {
    private IndentCharacter indentCharacter;
    private Integer tabSize;
    private Integer indentSize;
    private Integer continuationIndentSize;

    public IndentCharacter getIndentCharacter() {
        return indentCharacter;
    }

    public void setIndentCharacter(IndentCharacter indentCharacter) {
        this.indentCharacter = indentCharacter;
    }

    public Integer getTabSize() {
        return tabSize;
    }

    public void setTabSize(Integer tabSize) {
        this.tabSize = tabSize;
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
}
