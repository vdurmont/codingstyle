package org.codingstyle.module.intellij.writer;

import org.codingstyle.core.model.Style;
import org.codingstyle.module.intellij.model.CodeScheme;
import org.codingstyle.module.intellij.processor.writer.IntellijWriter;
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
        Style style = new Style();

        // WHEN
        CodeScheme scheme = new IntellijWriter().write(style);

        // THEN
        assertNull(scheme.getName());
    }

    @Test
    public void write_with_a_name_sets_the_code_scheme_name() {
        // GIVEN
        String projectName = "My project";

        Style style = new Style();
        style.setProjectName(projectName);

        // WHEN
        CodeScheme scheme = new IntellijWriter().write(style);

        // THEN
        assertEquals(projectName, scheme.getName());
    }
}