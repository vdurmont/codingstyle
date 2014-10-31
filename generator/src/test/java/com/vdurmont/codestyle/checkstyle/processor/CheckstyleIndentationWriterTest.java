package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.TestUtils;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertHasCheckstyleErrors;
import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;

@RunWith(JUnit4.class)
public class CheckstyleIndentationWriterTest {
    private CodeStyle codeStyle;

    @Before
    public void setUp() {
        this.codeStyle = TestUtils.generateCodeStyle();
    }

    @Test
    public void buildCheckstyle_with_SPACE_fails_if_the_file_has_tabs() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        this.codeStyle.setIndentation(indentation);

        // THEN
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithTabs");
    }

    @Test
    public void buildCheckstyle_with_SPACE_is_ok_if_the_file_has_only_spaces() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        this.codeStyle.setIndentation(indentation);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithSpaces");
    }

    @Test
    public void buildCheckstyle_with_TABS_fails_if_the_file_has_spaces() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.TAB);
        this.codeStyle.setIndentation(indentation);

        // THEN
        assertHasCheckstyleErrors(this.codeStyle, "FileWithSpaces");
    }

    @Test
    public void buildCheckstyle_with_TAB_is_ok_if_the_file_has_only_tabs() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.TAB);
        this.codeStyle.setIndentation(indentation);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithTabs");
    }

    @Test
    public void buildCheckstyle_with_SPACE_and_indentSize_2_is_ok_if_the_file_has_a_2_spaces_indent() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        indentation.setIndentSize(2);
        this.codeStyle.setIndentation(indentation);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWith2Spaces");
    }

    @Test
    public void buildCheckstyle_with_SPACE_and_indentSize_2_fails_if_the_file_has_a_4_spaces_indent() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        indentation.setIndentSize(2);
        this.codeStyle.setIndentation(indentation);

        // THEN
        assertHasCheckstyleErrors(this.codeStyle, "FileWithSpaces");
    }
}