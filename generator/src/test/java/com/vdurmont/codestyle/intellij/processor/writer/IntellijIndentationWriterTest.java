package com.vdurmont.codestyle.intellij.processor.writer;

import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import com.vdurmont.codestyle.intellij.model.Value;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class IntellijIndentationWriterTest {
    private CodeScheme scheme;

    @Before
    public void setUp() {
        this.scheme = new CodeScheme();
    }

    @Test
    public void write_with_IndentCharacter_TAB_sets_the_USE_TAB_CHARACTER_to_true() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.TAB);


        // WHEN
        IntellijIndentationWriter.write(scheme, indentation);

        // THEN
        Value indentOptions = this.scheme.getOption("OTHER_INDENT_OPTIONS").getValueTag();
        boolean tab = indentOptions.getOption("USE_TAB_CHARACTER").getBooleanValue();
        assertTrue(tab);
    }

    @Test
    public void write_with_IndentCharacter_SPACE_sets_the_USE_TAB_CHARACTER_to_false() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);


        // WHEN
        IntellijIndentationWriter.write(scheme, indentation);

        // THEN
        Value indentOptions = this.scheme.getOption("OTHER_INDENT_OPTIONS").getValueTag();
        boolean tab = indentOptions.getOption("USE_TAB_CHARACTER").getBooleanValue();
        assertFalse(tab);
    }

    @Test
    public void write_with_TabSize_sets_the_TAB_SIZE() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setTabSize(4);


        // WHEN
        IntellijIndentationWriter.write(scheme, indentation);

        // THEN
        Value indentOptions = this.scheme.getOption("OTHER_INDENT_OPTIONS").getValueTag();
        int tabSize = indentOptions.getOption("TAB_SIZE").getIntegerValue();
        assertEquals(4, tabSize);
    }

    @Test
    public void write_with_IndentSize_sets_the_INDENT_SIZE() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentSize(4);


        // WHEN
        IntellijIndentationWriter.write(scheme, indentation);

        // THEN
        Value indentOptions = this.scheme.getOption("OTHER_INDENT_OPTIONS").getValueTag();
        int indentSize = indentOptions.getOption("INDENT_SIZE").getIntegerValue();
        assertEquals(4, indentSize);
    }

    @Test
    public void write_with_ContinuationIndentSize_sets_the_CONTINUATION_INDENT_SIZE() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setContinuationIndentSize(4);


        // WHEN
        IntellijIndentationWriter.write(scheme, indentation);

        // THEN
        Value indentOptions = this.scheme.getOption("OTHER_INDENT_OPTIONS").getValueTag();
        int indentSize = indentOptions.getOption("CONTINUATION_INDENT_SIZE").getIntegerValue();
        assertEquals(4, indentSize);
    }

    @Test
    public void write_with_LabelIndentAbsolute_sets_the_LABEL_INDENT_ABSOLUTE() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setLabelIndentAbsolute(true);


        // WHEN
        IntellijIndentationWriter.write(scheme, indentation);

        // THEN
        Value indentOptions = this.scheme.getOption("OTHER_INDENT_OPTIONS").getValueTag();
        boolean indentAbsolute = indentOptions.getOption("LABEL_INDENT_ABSOLUTE").getBooleanValue();
        assertTrue(indentAbsolute);
    }

    @Test
    public void write_with_LabelIndentSize_sets_the_LABEL_INDENT_SIZE() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setLabelIndentSize(4);


        // WHEN
        IntellijIndentationWriter.write(scheme, indentation);

        // THEN
        Value indentOptions = this.scheme.getOption("OTHER_INDENT_OPTIONS").getValueTag();
        int size = indentOptions.getOption("LABEL_INDENT_SIZE").getIntegerValue();
        assertEquals(4, size);
    }
}