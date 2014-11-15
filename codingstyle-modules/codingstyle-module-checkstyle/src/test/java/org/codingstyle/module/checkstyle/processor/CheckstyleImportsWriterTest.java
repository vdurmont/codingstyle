package org.codingstyle.module.checkstyle.processor;

import org.codingstyle.core.model.Imports;
import org.codingstyle.core.model.Style;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;
import static org.codingstyle.module.checkstyle.CheckStyleTestUtils.generateStyle;

@RunWith(JUnit4.class)
public class CheckstyleImportsWriterTest {
    private Style style;

    @Before
    public void setUp() {
        this.style = generateStyle();
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(true);
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutStarImports");
        assertNumCheckstyleErrors(1, this.style, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(false);
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutStarImports");
        assertNoCheckstyleErrors(this.style, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_undefined() {
        // GIVEN
        Imports imports = new Imports();
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutStarImports");
        assertNoCheckstyleErrors(this.style, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidUnusedImports(true);
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutUnusedImports");
        assertNumCheckstyleErrors(1, this.style, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidUnusedImports(false);
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutUnusedImports");
        assertNoCheckstyleErrors(this.style, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_undefined() {
        // GIVEN
        Imports imports = new Imports();
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutUnusedImports");
        assertNoCheckstyleErrors(this.style, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidRedundantImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidRedundantImports(true);
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutRedundantImports");
        assertNumCheckstyleErrors(1, this.style, "FileWithRedundantJavaLangImports");
        assertNumCheckstyleErrors(1, this.style, "FileWithRedundantRepeatedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidRedundantImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidRedundantImports(false);
        this.style.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.style, "FileWithoutRedundantImports");
        assertNoCheckstyleErrors(this.style, "FileWithRedundantJavaLangImports");
        assertNoCheckstyleErrors(this.style, "FileWithRedundantRepeatedImports");
    }
}