package org.codingstyle.module.intellij.writer;

import org.codingstyle.core.model.Project;
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
        Project project = new Project();

        // WHEN
        CodeScheme scheme = new IntellijWriter().write(project);

        // THEN
        assertNull(scheme.getName());
    }

    @Test
    public void write_with_a_name_sets_the_code_scheme_name() {
        // GIVEN
        String projectName = "My project";

        Project project = new Project();
        project.setName(projectName);

        // WHEN
        CodeScheme scheme = new IntellijWriter().write(project);

        // THEN
        assertEquals(projectName, scheme.getName());
    }
}