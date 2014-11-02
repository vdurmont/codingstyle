package com.vdurmont.codestyle.intellij.processor.reader;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import com.vdurmont.codestyle.intellij.IntellijTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class IntellijIndentationReaderTest {
    @Test
    public void toIndentation_with_no_character_sets_the_IndentCharacter_to_null() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("EmptyConfig");

        // THEN
        Indentation indentation = style.getIndentation();
        assertNull(indentation.getIndentCharacter());
    }

    @Test
    public void toIndentation_with_USE_TAB_CHARACTER_true_character_sets_the_IndentCharacter_to_TAB() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("ConfigWithTabCharacter");

        // THEN
        Indentation indentation = style.getIndentation();
        assertEquals(IndentCharacter.TAB, indentation.getIndentCharacter());
    }

    @Test
    public void toIndentation_with_USE_TAB_CHARACTER_false_character_sets_the_IndentCharacter_to_SPACE() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("ConfigWithSpaceCharacter");

        // THEN
        Indentation indentation = style.getIndentation();
        assertEquals(IndentCharacter.SPACE, indentation.getIndentCharacter());
    }

    @Test
    public void toIndentation_with_no_TAB_SIZE_sets_the_TabSize_to_null() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("EmptyConfig");

        // THEN
        Indentation indentation = style.getIndentation();
        assertNull(indentation.getTabSize());
    }

    @Test
    public void toIndentation_with_a_TAB_SIZE_sets_the_TabSize() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("ConfigWithTabSize");

        // THEN
        Indentation indentation = style.getIndentation();
        assertEquals(2, (int) indentation.getTabSize());
    }

    @Test
    public void toIndentation_with_no_INDENT_SIZE_sets_the_IndentSize_to_null() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("EmptyConfig");

        // THEN
        Indentation indentation = style.getIndentation();
        assertNull(indentation.getIndentSize());
    }

    @Test
    public void toIndentation_with_a_INDENT_SIZE_sets_the_IndentSize() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("ConfigWithIndentSize");

        // THEN
        Indentation indentation = style.getIndentation();
        assertEquals(2, (int) indentation.getIndentSize());
    }

    @Test
    public void toIndentation_with_no_CONTINUATION_INDENT_SIZE_sets_the_ContinuationIndentSize_to_null() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("EmptyConfig");

        // THEN
        Indentation indentation = style.getIndentation();
        assertNull(indentation.getContinuationIndentSize());
    }

    @Test
    public void toIndentation_with_a_CONTINUATION_INDENT_SIZE_sets_the_ContinuationIndentSize() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("ConfigWithContinuationIndentSize");

        // THEN
        Indentation indentation = style.getIndentation();
        assertEquals(4, (int) indentation.getContinuationIndentSize());
    }
}