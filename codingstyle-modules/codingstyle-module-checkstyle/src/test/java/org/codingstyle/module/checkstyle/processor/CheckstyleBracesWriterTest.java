package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Braces;
import org.codingstyle.core.model.BracesPlacement;
import org.codingstyle.core.model.Style;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.generateStyle;

@RunWith(JUnit4.class)
public class CheckstyleBracesWriterTest {
    private Style style;

    @Before
    public void setUp() {
        this.style = generateStyle();
    }

    @Test
    public void buildCheckstyle_with_CLASS_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.CLASS, BracesPlacement.END_OF_LINE);
        this.style.setBraces(braces);

        // THEN
        assertNumCheckstyleErrors(1, this.style, "FileWithClassLeftCurlyNewLine");
        assertNoCheckstyleErrors(this.style, "FileWithClassLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_CLASS_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.CLASS, BracesPlacement.NEW_LINE);
        this.style.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithClassLeftCurlyNewLine");
        assertNumCheckstyleErrors(1, this.style, "FileWithClassLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_METHOD_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.METHOD, BracesPlacement.END_OF_LINE);
        this.style.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithMethodLeftCurlyEndOfLine");
        assertNumCheckstyleErrors(1, this.style, "FileWithMethodLeftCurlyNewLine");
    }

    @Test
    public void buildCheckstyle_with_OTHER_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.OTHER, BracesPlacement.NEW_LINE);
        this.style.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithOtherLeftCurlyNewLine");
        assertNumCheckstyleErrors(4, this.style, "FileWithOtherLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_OTHER_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.OTHER, BracesPlacement.END_OF_LINE);
        this.style.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithOtherLeftCurlyEndOfLine");
        assertNumCheckstyleErrors(4, this.style, "FileWithOtherLeftCurlyNewLine");
    }

    @Test
    public void buildCheckstyle_with_METHOD_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.METHOD, BracesPlacement.NEW_LINE);
        this.style.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithMethodLeftCurlyNewLine");
        assertNumCheckstyleErrors(1, this.style, "FileWithMethodLeftCurlyEndOfLine");
    }
}