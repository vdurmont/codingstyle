package com.vdurmont.codestyle.core.model;

public class Braces {
    private BracesPlacement classBraces;
    private BracesPlacement methodBraces;
    private BracesPlacement otherBraces;
    private Wrapping extendsAndImplementsAndThrowsWrapping;
    private Wrapping methodsDeclarationParametersWrapping;
    private Wrapping methodsCallArgumentsWrapping;
    private Wrapping chainedMethodCallsWrapping;
    private Boolean forceBracesOnIf;
    private Boolean forceBracesOnFor;
    private Boolean forceBracesOnWhile;
    private Boolean forceBracesOnDoWhile;
    private Boolean forceControlStatementsNewLine;
    private Wrapping binaryExpressionsWrapping;
    private Wrapping ternaryExpressionsWrapping;
    private Wrapping assignementsWrapping;
    private Wrapping annotationsWrapping;
    private Wrapping enumConstantsWrapping;

    public BracesPlacement getClassBraces() {
        return classBraces;
    }

    public void setClassBraces(BracesPlacement classBraces) {
        this.classBraces = classBraces;
    }

    public BracesPlacement getMethodBraces() {
        return methodBraces;
    }

    public void setMethodBraces(BracesPlacement methodBraces) {
        this.methodBraces = methodBraces;
    }

    public BracesPlacement getOtherBraces() {
        return otherBraces;
    }

    public void setOtherBraces(BracesPlacement otherBraces) {
        this.otherBraces = otherBraces;
    }

    public Wrapping getExtendsAndImplementsAndThrowsWrapping() {
        return extendsAndImplementsAndThrowsWrapping;
    }

    public void setExtendsAndImplementsAndThrowsWrapping(Wrapping extendsAndImplementsAndThrowsWrapping) {
        this.extendsAndImplementsAndThrowsWrapping = extendsAndImplementsAndThrowsWrapping;
    }

    public Wrapping getMethodsDeclarationParametersWrapping() {
        return methodsDeclarationParametersWrapping;
    }

    public void setMethodsDeclarationParametersWrapping(Wrapping methodsDeclarationParametersWrapping) {
        this.methodsDeclarationParametersWrapping = methodsDeclarationParametersWrapping;
    }

    public Wrapping getMethodsCallArgumentsWrapping() {
        return methodsCallArgumentsWrapping;
    }

    public void setMethodsCallArgumentsWrapping(Wrapping methodsCallArgumentsWrapping) {
        this.methodsCallArgumentsWrapping = methodsCallArgumentsWrapping;
    }

    public Wrapping getChainedMethodCallsWrapping() {
        return chainedMethodCallsWrapping;
    }

    public void setChainedMethodCallsWrapping(Wrapping chainedMethodCallsWrapping) {
        this.chainedMethodCallsWrapping = chainedMethodCallsWrapping;
    }

    public Boolean getForceBracesOnIf() {
        return forceBracesOnIf;
    }

    public void setForceBracesOnIf(Boolean forceBracesOnIf) {
        this.forceBracesOnIf = forceBracesOnIf;
    }

    public Boolean getForceBracesOnFor() {
        return forceBracesOnFor;
    }

    public void setForceBracesOnFor(Boolean forceBracesOnFor) {
        this.forceBracesOnFor = forceBracesOnFor;
    }

    public Boolean getForceBracesOnWhile() {
        return forceBracesOnWhile;
    }

    public void setForceBracesOnWhile(Boolean forceBracesOnWhile) {
        this.forceBracesOnWhile = forceBracesOnWhile;
    }

    public Boolean getForceBracesOnDoWhile() {
        return forceBracesOnDoWhile;
    }

    public void setForceBracesOnDoWhile(Boolean forceBracesOnDoWhile) {
        this.forceBracesOnDoWhile = forceBracesOnDoWhile;
    }

    public Boolean getForceControlStatementsNewLine() {
        return forceControlStatementsNewLine;
    }

    public void setForceControlStatementsNewLine(Boolean forceControlStatementsNewLine) {
        this.forceControlStatementsNewLine = forceControlStatementsNewLine;
    }

    public Wrapping getBinaryExpressionsWrapping() {
        return binaryExpressionsWrapping;
    }

    public void setBinaryExpressionsWrapping(Wrapping binaryExpressionsWrapping) {
        this.binaryExpressionsWrapping = binaryExpressionsWrapping;
    }

    public Wrapping getTernaryExpressionsWrapping() {
        return ternaryExpressionsWrapping;
    }

    public void setTernaryExpressionsWrapping(Wrapping ternaryExpressionsWrapping) {
        this.ternaryExpressionsWrapping = ternaryExpressionsWrapping;
    }

    public Wrapping getAssignementsWrapping() {
        return assignementsWrapping;
    }

    public void setAssignementsWrapping(Wrapping assignementsWrapping) {
        this.assignementsWrapping = assignementsWrapping;
    }

    public Wrapping getAnnotationsWrapping() {
        return annotationsWrapping;
    }

    public void setAnnotationsWrapping(Wrapping annotationsWrapping) {
        this.annotationsWrapping = annotationsWrapping;
    }

    public Wrapping getEnumConstantsWrapping() {
        return enumConstantsWrapping;
    }

    public void setEnumConstantsWrapping(Wrapping enumConstantsWrapping) {
        this.enumConstantsWrapping = enumConstantsWrapping;
    }
}
