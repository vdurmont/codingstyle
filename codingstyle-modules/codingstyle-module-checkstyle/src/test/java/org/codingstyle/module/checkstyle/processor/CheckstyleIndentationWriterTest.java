package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.IndentCharacter;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.core.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertHasCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.generateStyle;

@RunWith(JUnit4.class)
public class CheckstyleIndentationWriterTest {
    private Project project;

    @Before
    public void setUp() {
        this.project = generateStyle();
    }

    @Test
    public void buildCheckstyle_with_SPACE_fails_if_the_file_has_tabs() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        this.project.setIndentation(indentation);

        // THEN
        assertNumCheckstyleErrors(1, this.project, "FileWithTabs");
    }

    @Test
    public void buildCheckstyle_with_SPACE_is_ok_if_the_file_has_only_spaces() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        this.project.setIndentation(indentation);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithSpaces");
    }

    @Test
    public void buildCheckstyle_with_TABS_fails_if_the_file_has_spaces() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.TAB);
        this.project.setIndentation(indentation);

        // THEN
        assertHasCheckstyleErrors(this.project, "FileWithSpaces");
    }

    @Test
    public void buildCheckstyle_with_TAB_is_ok_if_the_file_has_only_tabs() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.TAB);
        this.project.setIndentation(indentation);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithTabs");
    }

    @Test
    public void buildCheckstyle_with_SPACE_and_indentSize_2_is_ok_if_the_file_has_a_2_spaces_indent() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        indentation.setIndentSize(2);
        this.project.setIndentation(indentation);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWith2Spaces");
    }

    @Test
    public void buildCheckstyle_with_SPACE_and_indentSize_2_fails_if_the_file_has_a_4_spaces_indent() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        indentation.setIndentSize(2);
        this.project.setIndentation(indentation);

        // THEN
        assertHasCheckstyleErrors(this.project, "FileWithSpaces");
    }
}