package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.TestUtils;
import com.vdurmont.codestyle.core.model.Braces;
import com.vdurmont.codestyle.core.model.BracesPlacement;
import com.vdurmont.codestyle.core.model.CodeStyle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;

@RunWith(JUnit4.class)
public class CheckstyleBracesWriterTest {
    private CodeStyle codeStyle;

    @Before
    public void setUp() {
        this.codeStyle = TestUtils.generateCodeStyle();
    }

    @Test
    public void buildCheckstyle_with_CLASS_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.CLASS, BracesPlacement.END_OF_LINE);
        this.codeStyle.setBraces(braces);

        // THEN
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithClassLeftCurlyNewLine");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithClassLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_CLASS_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.CLASS, BracesPlacement.NEW_LINE);
        this.codeStyle.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithClassLeftCurlyNewLine");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithClassLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_METHOD_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.METHOD, BracesPlacement.END_OF_LINE);
        this.codeStyle.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithMethodLeftCurlyEndOfLine");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithMethodLeftCurlyNewLine");
    }

    @Test
    public void buildCheckstyle_with_OTHER_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.OTHER, BracesPlacement.NEW_LINE);
        this.codeStyle.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithOtherLeftCurlyNewLine");
        assertNumCheckstyleErrors(4, this.codeStyle, "FileWithOtherLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_OTHER_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.OTHER, BracesPlacement.END_OF_LINE);
        this.codeStyle.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithOtherLeftCurlyEndOfLine");
        assertNumCheckstyleErrors(4, this.codeStyle, "FileWithOtherLeftCurlyNewLine");
    }

    @Test
    public void buildCheckstyle_with_METHOD_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.METHOD, BracesPlacement.NEW_LINE);
        this.codeStyle.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithMethodLeftCurlyNewLine");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithMethodLeftCurlyEndOfLine");
    }
}