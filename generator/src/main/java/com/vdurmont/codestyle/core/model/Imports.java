package com.vdurmont.codestyle.core.model;

public class Imports {
    private Boolean avoidStarImport;
    private Boolean avoidUnusedImports;

    public Boolean getAvoidStarImport() {
        return avoidStarImport;
    }

    public void setAvoidStarImport(Boolean avoidStarImport) {
        this.avoidStarImport = avoidStarImport;
    }

    public Boolean getAvoidUnusedImports() {
        return avoidUnusedImports;
    }

    public void setAvoidUnusedImports(Boolean avoidUnusedImports) {
        this.avoidUnusedImports = avoidUnusedImports;
    }
}
