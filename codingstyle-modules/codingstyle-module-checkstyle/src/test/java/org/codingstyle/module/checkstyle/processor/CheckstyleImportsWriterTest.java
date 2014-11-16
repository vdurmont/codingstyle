package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Imports;
import org.codingstyle.core.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.generateStyle;

@RunWith(JUnit4.class)
public class CheckstyleImportsWriterTest {
    private Project project;

    @Before
    public void setUp() {
        this.project = generateStyle();
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(true);
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutStarImports");
        assertNumCheckstyleErrors(1, this.project, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(false);
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutStarImports");
        assertNoCheckstyleErrors(this.project, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_undefined() {
        // GIVEN
        Imports imports = new Imports();
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutStarImports");
        assertNoCheckstyleErrors(this.project, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidUnusedImports(true);
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutUnusedImports");
        assertNumCheckstyleErrors(1, this.project, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidUnusedImports(false);
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutUnusedImports");
        assertNoCheckstyleErrors(this.project, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_undefined() {
        // GIVEN
        Imports imports = new Imports();
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutUnusedImports");
        assertNoCheckstyleErrors(this.project, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidRedundantImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidRedundantImports(true);
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutRedundantImports");
        assertNumCheckstyleErrors(1, this.project, "FileWithRedundantJavaLangImports");
        assertNumCheckstyleErrors(1, this.project, "FileWithRedundantRepeatedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidRedundantImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidRedundantImports(false);
        this.project.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.project, "FileWithoutRedundantImports");
        assertNoCheckstyleErrors(this.project, "FileWithRedundantJavaLangImports");
        assertNoCheckstyleErrors(this.project, "FileWithRedundantRepeatedImports");
    }
}