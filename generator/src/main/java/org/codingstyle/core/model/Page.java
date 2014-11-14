package org.codingstyle.core.model;

public class Page {
    private Integer maximumLineLength;
    private Boolean wrapIfExceeded;
    private Boolean keepLineBreaks;

    public Integer getMaximumLineLength() {
        return maximumLineLength;
    }

    public void setMaximumLineLength(Integer maximumLineLength) {
        this.maximumLineLength = maximumLineLength;
    }

    public Boolean getWrapIfExceeded() {
        return wrapIfExceeded;
    }

    public void setWrapIfExceeded(Boolean wrapIfExceeded) {
        this.wrapIfExceeded = wrapIfExceeded;
    }

    public Boolean getKeepLineBreaks() {
        return keepLineBreaks;
    }

    public void setKeepLineBreaks(Boolean keepLineBreaks) {
        this.keepLineBreaks = keepLineBreaks;
    }

    @Override public String toString() {
        return "Page{" +
                "maximumLineLength=" + maximumLineLength +
                ", wrapIfExceeded=" + wrapIfExceeded +
                ", keepLineBreaks=" + keepLineBreaks +
                '}';
    }
}
