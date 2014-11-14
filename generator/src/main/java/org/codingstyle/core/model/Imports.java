package org.codingstyle.core.model;

public class Imports {
    private Boolean avoidStarImport;
    private Boolean avoidUnusedImports;
    private Boolean avoidRedundantImports;

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

    public Boolean getAvoidRedundantImports() {
        return avoidRedundantImports;
    }

    public void setAvoidRedundantImports(Boolean avoidRedundantImports) {
        this.avoidRedundantImports = avoidRedundantImports;
    }
}
