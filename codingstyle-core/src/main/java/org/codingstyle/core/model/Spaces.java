package org.codingstyle.core.model;

public class Spaces {
    private Boolean beforeMethodParentheses;
    private Boolean beforeControlStatementParentheses;
    private Boolean aroundAssignmentOperators;
    private Boolean aroundLogicalAndComparisonOperators;
    private Boolean aroundBitwiseOperators;
    private Boolean aroundMathOperators;
    private Boolean aroundUnaryOperators;
    private Boolean aroundTernaryOperators;
    private Boolean aroundLambdaArrow;
    private Boolean beforeLeftBrace;
    private Boolean beforeKeywords;
    private Boolean withinGroups;
    private Boolean afterCommaAndSemicolon;
    private Boolean afterCast;

    public Boolean getBeforeMethodParentheses() {
        return beforeMethodParentheses;
    }

    public void setBeforeMethodParentheses(Boolean beforeMethodParentheses) {
        this.beforeMethodParentheses = beforeMethodParentheses;
    }

    public Boolean getBeforeControlStatementParentheses() {
        return beforeControlStatementParentheses;
    }

    public void setBeforeControlStatementParentheses(Boolean beforeControlStatementParentheses) {
        this.beforeControlStatementParentheses = beforeControlStatementParentheses;
    }

    public Boolean getAroundAssignmentOperators() {
        return aroundAssignmentOperators;
    }

    public void setAroundAssignmentOperators(Boolean aroundAssignmentOperators) {
        this.aroundAssignmentOperators = aroundAssignmentOperators;
    }

    public Boolean getAroundLogicalAndComparisonOperators() {
        return aroundLogicalAndComparisonOperators;
    }

    public void setAroundLogicalAndComparisonOperators(Boolean aroundLogicalAndComparisonOperators) {
        this.aroundLogicalAndComparisonOperators = aroundLogicalAndComparisonOperators;
    }

    public Boolean getAroundBitwiseOperators() {
        return aroundBitwiseOperators;
    }

    public void setAroundBitwiseOperators(Boolean aroundBitwiseOperators) {
        this.aroundBitwiseOperators = aroundBitwiseOperators;
    }

    public Boolean getAroundMathOperators() {
        return aroundMathOperators;
    }

    public void setAroundMathOperators(Boolean aroundMathOperators) {
        this.aroundMathOperators = aroundMathOperators;
    }

    public Boolean getAroundUnaryOperators() {
        return aroundUnaryOperators;
    }

    public void setAroundUnaryOperators(Boolean aroundUnaryOperators) {
        this.aroundUnaryOperators = aroundUnaryOperators;
    }

    public Boolean getAroundTernaryOperators() {
        return aroundTernaryOperators;
    }

    public void setAroundTernaryOperators(Boolean aroundTernaryOperators) {
        this.aroundTernaryOperators = aroundTernaryOperators;
    }

    public Boolean getAroundLambdaArrow() {
        return aroundLambdaArrow;
    }

    public void setAroundLambdaArrow(Boolean aroundLambdaArrow) {
        this.aroundLambdaArrow = aroundLambdaArrow;
    }

    public Boolean getBeforeLeftBrace() {
        return beforeLeftBrace;
    }

    public void setBeforeLeftBrace(Boolean beforeLeftBrace) {
        this.beforeLeftBrace = beforeLeftBrace;
    }

    public Boolean getBeforeKeywords() {
        return beforeKeywords;
    }

    public void setBeforeKeywords(Boolean beforeKeywords) {
        this.beforeKeywords = beforeKeywords;
    }

    public Boolean getWithinGroups() {
        return withinGroups;
    }

    public void setWithinGroups(Boolean withinGroups) {
        this.withinGroups = withinGroups;
    }

    public Boolean getAfterCommaAndSemicolon() {
        return afterCommaAndSemicolon;
    }

    public void setAfterCommaAndSemicolon(Boolean afterCommaAndSemicolon) {
        this.afterCommaAndSemicolon = afterCommaAndSemicolon;
    }

    public Boolean getAfterCast() {
        return afterCast;
    }

    public void setAfterCast(Boolean afterCast) {
        this.afterCast = afterCast;
    }

    @Override public String toString() {
        return "Spaces{" +
                "beforeMethodParentheses=" + beforeMethodParentheses +
                ", beforeControlStatementParentheses=" + beforeControlStatementParentheses +
                ", aroundAssignmentOperators=" + aroundAssignmentOperators +
                ", aroundLogicalAndComparisonOperators=" + aroundLogicalAndComparisonOperators +
                ", aroundBitwiseOperators=" + aroundBitwiseOperators +
                ", aroundMathOperators=" + aroundMathOperators +
                ", aroundUnaryOperators=" + aroundUnaryOperators +
                ", aroundTernaryOperators=" + aroundTernaryOperators +
                ", aroundLambdaArrow=" + aroundLambdaArrow +
                ", beforeLeftBrace=" + beforeLeftBrace +
                ", beforeKeywords=" + beforeKeywords +
                ", withinGroups=" + withinGroups +
                ", afterCommaAndSemicolon=" + afterCommaAndSemicolon +
                ", afterCast=" + afterCast +
                '}';
    }
}
