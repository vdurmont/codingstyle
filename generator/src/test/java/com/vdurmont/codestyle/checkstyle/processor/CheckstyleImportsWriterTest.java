package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Imports;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CheckstyleImportsWriterTest {
    private Checkstyle checkstyle;

    @Before
    public void setUp() {
        this.checkstyle = new Checkstyle();
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImport_false_doesnt_add_a_module() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(false);

        // WHEN
        CheckstyleImportsWriter.buildCheckstyle(this.checkstyle, imports);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules();
        assertEquals(0, modules.size());
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImport_adds_a_module() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(true);

        // WHEN
        CheckstyleImportsWriter.buildCheckstyle(this.checkstyle, imports);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules("AvoidStarImport");
        assertEquals(1, modules.size());
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_adds_a_module() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidUnusedImports(true);

        // WHEN
        CheckstyleImportsWriter.buildCheckstyle(this.checkstyle, imports);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules("UnusedImports");
        assertEquals(1, modules.size());
    }
}