package com.vdurmont.codestyle.intellij.processor.reader;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.intellij.IntellijTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class IntellijReaderTest {
    @Test
    public void read_with_no_name_doesnt_set_a_name() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("ConfigWithoutName");

        // THEN
        assertNull(style.getProjectName());
    }

    @Test
    public void read_with_a_name_sets_the_projectName() {
        // GIVEN

        // WHEN
        CodeStyle style = IntellijTestUtils.readCodeStyle("ConfigWithName");

        // THEN
        assertEquals("MyProject", style.getProjectName());
    }
}