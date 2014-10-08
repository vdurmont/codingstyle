package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Annotations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CheckstyleAnnotationsWriterTest {
    private Checkstyle checkstyle;

    @Before
    public void setUp() {
        this.checkstyle = new Checkstyle();
    }

    @Test
    public void buildCheckstyle_with_forceOverride_adds_the_MissingOverride_module() {
        // GIVEN
        Annotations annotations = new Annotations();
        annotations.setForceOverride(true);

        // WHEN
        CheckstyleAnnotationsWriter.buildCheckstyle(this.checkstyle, annotations);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules("MissingOverride");
        assertEquals(1, modules.size());
    }
}