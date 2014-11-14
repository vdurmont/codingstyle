package org.codingstyle.checkstyle.processor;

import org.codingstyle.core.model.Annotations;
import org.codingstyle.core.model.Style;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingstyle.TestUtils.generateStyle;
import static org.codingstyle.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static org.codingstyle.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;

@RunWith(JUnit4.class)
public class CheckstyleAnnotationsWriterTest {
    private Style style;

    @Before
    public void setUp() {
        this.style = generateStyle();
    }

    @Test
    public void buildCheckstyle_with_FORCE_OVERRIDE_true() {
        // GIVEN
        Annotations annotations = new Annotations();
        annotations.setForceOverride(true);
        this.style.setAnnotations(annotations);

        // THEN
        assertNumCheckstyleErrors(1, this.style, "FileWithMissingOverride");
        assertNoCheckstyleErrors(this.style, "FileWithNoMissingOverride");
    }

    @Test
    public void buildCheckstyle_with_FORCE_OVERRIDE_false() {
        // GIVEN
        Annotations annotations = new Annotations();
        annotations.setForceOverride(false);
        this.style.setAnnotations(annotations);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithMissingOverride");
        assertNoCheckstyleErrors(this.style, "FileWithNoMissingOverride");
    }
}