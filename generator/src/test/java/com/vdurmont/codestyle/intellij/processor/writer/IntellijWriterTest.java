package com.vdurmont.codestyle.intellij.processor.writer;

import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class IntellijWriterTest {
    @Test
    public void write_with_no_name_doesnt_set_a_name() {
        // GIVEN
        CodeStyle style = new CodeStyle();

        // WHEN
        CodeScheme scheme = new IntellijWriter().write(style);

        // THEN
        assertNull(scheme.getName());
    }

    @Test
    public void write_with_a_name_sets_the_code_scheme_name() {
        // GIVEN
        String projectName = "My project";

        CodeStyle style = new CodeStyle();
        style.setProjectName(projectName);

        // WHEN
        CodeScheme scheme = new IntellijWriter().write(style);

        // THEN
        assertEquals(projectName, scheme.getName());
    }
}