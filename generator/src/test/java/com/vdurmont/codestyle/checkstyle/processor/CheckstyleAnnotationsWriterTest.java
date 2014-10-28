package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.core.model.Annotations;
import com.vdurmont.codestyle.core.model.CodeStyle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.vdurmont.TestUtils.generateCodeStyle;
import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;

@RunWith(JUnit4.class)
public class CheckstyleAnnotationsWriterTest {
    private CodeStyle codeStyle;

    @Before
    public void setUp() {
        this.codeStyle = generateCodeStyle();
    }

    @Test
    public void buildCheckstyle_with_FORCE_OVERRIDE_true() {
        // GIVEN
        Annotations annotations = new Annotations();
        annotations.setForceOverride(true);
        this.codeStyle.setAnnotations(annotations);

        // THEN
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithMissingOverride.java");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithNoMissingOverride.java");
    }

    @Test
    public void buildCheckstyle_with_FORCE_OVERRIDE_false() {
        // GIVEN
        Annotations annotations = new Annotations();
        annotations.setForceOverride(false);
        this.codeStyle.setAnnotations(annotations);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithMissingOverride.java");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithNoMissingOverride.java");
    }
}