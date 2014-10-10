package com.vdurmont.codestyle.core.model;

import java.util.HashMap;
import java.util.Map;

public class Braces {
    private final Map<LeftBracesBlock, BracesPlacement> leftBracesPlacements;
    private final Map<RightBracesBlock, BracesPlacement> rightBracesPlacements;
    private final Map<ForcedBracesBlock, Boolean> forcedBraces;

    public Braces() {
        this.leftBracesPlacements = new HashMap<>();
        this.rightBracesPlacements = new HashMap<>();
        this.forcedBraces = new HashMap<>();
    }

    public Map<LeftBracesBlock, BracesPlacement> getLeftBracesPlacements() {
        return leftBracesPlacements;
    }

    public void addLeftBracesPlacement(LeftBracesBlock block, BracesPlacement placement) {
        this.leftBracesPlacements.put(block, placement);
    }

    public Map<RightBracesBlock, BracesPlacement> getRightBracesPlacements() {
        return rightBracesPlacements;
    }

    public void addRightBracesPlacement(RightBracesBlock block, BracesPlacement placement) {
        this.rightBracesPlacements.put(block, placement);
    }

    public Map<ForcedBracesBlock, Boolean> getForcedBraces() {
        return forcedBraces;
    }

    public void addForcedBraces(ForcedBracesBlock block, boolean value) {
        this.forcedBraces.put(block, value);
    }

    public enum LeftBracesBlock {
        CLASS, METHOD, OTHER
    }

    public enum RightBracesBlock {
        IF, ELSE, TRY, CATCH, FINALLY, DO
    }

    public enum ForcedBracesBlock {
        IF, FOR, WHILE, DO_WHILE
    }
}
