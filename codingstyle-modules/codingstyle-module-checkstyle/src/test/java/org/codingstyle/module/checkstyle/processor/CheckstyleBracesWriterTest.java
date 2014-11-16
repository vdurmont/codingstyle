package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Braces;
import org.codingstyle.core.model.BracesPlacement;
import org.codingstyle.core.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.generateStyle;

@RunWith(JUnit4.class)
public class CheckstyleBracesWriterTest {
    private Project project;

    @Before
    public void setUp() {
        this.project = generateStyle();
    }

    @Test
    public void buildCheckstyle_with_CLASS_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.CLASS, BracesPlacement.END_OF_LINE);
        this.project.setBraces(braces);

        // THEN
        assertNumCheckstyleErrors(1, this.project, "FileWithClassLeftCurlyNewLine");
        assertNoCheckstyleErrors(this.project, "FileWithClassLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_CLASS_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.CLASS, BracesPlacement.NEW_LINE);
        this.project.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithClassLeftCurlyNewLine");
        assertNumCheckstyleErrors(1, this.project, "FileWithClassLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_METHOD_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.METHOD, BracesPlacement.END_OF_LINE);
        this.project.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithMethodLeftCurlyEndOfLine");
        assertNumCheckstyleErrors(1, this.project, "FileWithMethodLeftCurlyNewLine");
    }

    @Test
    public void buildCheckstyle_with_OTHER_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.OTHER, BracesPlacement.NEW_LINE);
        this.project.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithOtherLeftCurlyNewLine");
        assertNumCheckstyleErrors(4, this.project, "FileWithOtherLeftCurlyEndOfLine");
    }

    @Test
    public void buildCheckstyle_with_OTHER_LeftCurly_END_OF_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.OTHER, BracesPlacement.END_OF_LINE);
        this.project.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithOtherLeftCurlyEndOfLine");
        assertNumCheckstyleErrors(4, this.project, "FileWithOtherLeftCurlyNewLine");
    }

    @Test
    public void buildCheckstyle_with_METHOD_LeftCurly_NEW_LINE() {
        // GIVEN
        Braces braces = new Braces();
        braces.addLeftBracesPlacement(Braces.LeftBracesBlock.METHOD, BracesPlacement.NEW_LINE);
        this.project.setBraces(braces);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithMethodLeftCurlyNewLine");
        assertNumCheckstyleErrors(1, this.project, "FileWithMethodLeftCurlyEndOfLine");
    }
}