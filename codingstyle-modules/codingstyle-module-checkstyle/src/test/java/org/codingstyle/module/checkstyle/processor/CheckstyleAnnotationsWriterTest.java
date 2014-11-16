package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Annotations;
import org.codingstyle.core.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.generateStyle;


@RunWith(JUnit4.class)
public class CheckstyleAnnotationsWriterTest {
    private Project project;

    @Before
    public void setUp() {
        this.project = generateStyle();
    }

    @Test
    public void buildCheckstyle_with_FORCE_OVERRIDE_true() {
        // GIVEN
        Annotations annotations = new Annotations();
        annotations.setForceOverride(true);
        this.project.setAnnotations(annotations);

        // THEN
        assertNumCheckstyleErrors(1, this.project, "FileWithMissingOverride");
        assertNoCheckstyleErrors(this.project, "FileWithNoMissingOverride");
    }

    @Test
    public void buildCheckstyle_with_FORCE_OVERRIDE_false() {
        // GIVEN
        Annotations annotations = new Annotations();
        annotations.setForceOverride(false);
        this.project.setAnnotations(annotations);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithMissingOverride");
        assertNoCheckstyleErrors(this.project, "FileWithNoMissingOverride");
    }
}