package org.codingstyle.module.intellij.reader;

import org.codingstyle.core.model.Project;
import org.codingstyle.module.intellij.IntellijTestUtils;
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
        Project project = IntellijTestUtils.readCodeStyle("ConfigWithoutName");

        // THEN
        assertNull(project.getName());
    }

    @Test
    public void read_with_a_name_sets_the_projectName() {
        // GIVEN

        // WHEN
        Project project = IntellijTestUtils.readCodeStyle("ConfigWithName");

        // THEN
        assertEquals("MyProject", project.getName());
    }
}