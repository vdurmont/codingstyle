package com.vdurmont.codestyle.core.model;

public class Braces {
    private BracesPlacement classAndMethodsBraces;
    private BracesPlacement otherBraces;
    private Wrapping extendsAndImplementsAndThrowsWrapping;
    private Wrapping methodsDeclarationParametersWrapping;
    private Wrapping methodsCallArgumentsWrapping;
    private Wrapping chainedMethodCallsWrapping;
    private Boolean forceControlStatementsBraces;
    private Boolean forceControlStatementsNewLine;
    private Wrapping binaryExpressionsWrapping;
    private Wrapping ternaryExpressionsWrapping;
    private Wrapping assignementsWrapping;
    private Wrapping annotationsWrapping;
    private Wrapping enumConstantsWrapping;

    public BracesPlacement getClassAndMethodsBraces() {
        return classAndMethodsBraces;
    }

    public void setClassAndMethodsBraces(BracesPlacement classAndMethodsBraces) {
        this.classAndMethodsBraces = classAndMethodsBraces;
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

    public Boolean getForceControlStatementsBraces() {
        return forceControlStatementsBraces;
    }

    public void setForceControlStatementsBraces(Boolean forceControlStatementsBraces) {
        this.forceControlStatementsBraces = forceControlStatementsBraces;
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

    @Override public String toString() {
        return "Braces{" +
                "classAndMethodsBraces=" + classAndMethodsBraces +
                ", otherBraces=" + otherBraces +
                ", extendsAndImplementsAndThrowsWrapping=" + extendsAndImplementsAndThrowsWrapping +
                ", methodsDeclarationParametersWrapping=" + methodsDeclarationParametersWrapping +
                ", methodsCallArgumentsWrapping=" + methodsCallArgumentsWrapping +
                ", chainedMethodCallsWrapping=" + chainedMethodCallsWrapping +
                ", forceControlStatementsBraces=" + forceControlStatementsBraces +
                ", forceControlStatementsNewLine=" + forceControlStatementsNewLine +
                ", binaryExpressionsWrapping=" + binaryExpressionsWrapping +
                ", ternaryExpressionsWrapping=" + ternaryExpressionsWrapping +
                ", assignementsWrapping=" + assignementsWrapping +
                ", annotationsWrapping=" + annotationsWrapping +
                ", enumConstantsWrapping=" + enumConstantsWrapping +
                '}';
    }
}
