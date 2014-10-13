package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Documentation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CheckstyleDocumentationWriterTest {
    private Checkstyle checkstyle;

    @Before
    public void setUp() {
        this.checkstyle = new Checkstyle();
    }

    @Test
    public void buildCheckstyle_with_forcePackageJavadoc_false_doesnt_add_a_module() {
        // GIVEN
        Documentation documentation = new Documentation();
        documentation.setForcePackageJavadoc(false);

        // WHEN
        CheckstyleDocumentationWriter.buildCheckstyle(this.checkstyle, documentation);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules();
        assertEquals(0, modules.size());
    }

    @Test
    public void buildCheckstyle_with_forcePackageJavadoc_true_adds_a_module() {
        // GIVEN
        Documentation documentation = new Documentation();
        documentation.setForcePackageJavadoc(true);

        // WHEN
        CheckstyleDocumentationWriter.buildCheckstyle(this.checkstyle, documentation);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules("JavadocPackage");
        assertEquals(1, modules.size());
    }
}