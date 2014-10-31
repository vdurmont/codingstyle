package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.TestUtils;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.Imports;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;

@RunWith(JUnit4.class)
public class CheckstyleImportsWriterTest {
    private CodeStyle codeStyle;

    @Before
    public void setUp() {
        this.codeStyle = TestUtils.generateCodeStyle();
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(true);
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutStarImports");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(false);
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutStarImports");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_undefined() {
        // GIVEN
        Imports imports = new Imports();
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutStarImports");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithStarImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidUnusedImports(true);
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutUnusedImports");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidUnusedImports(false);
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutUnusedImports");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidUnusedImports_undefined() {
        // GIVEN
        Imports imports = new Imports();
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutUnusedImports");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithUnusedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidRedundantImports_true() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidRedundantImports(true);
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutRedundantImports");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithRedundantJavaLangImports");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithRedundantRepeatedImports");
    }

    @Test
    public void buildCheckstyle_with_AvoidRedundantImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidRedundantImports(false);
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutRedundantImports");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithRedundantJavaLangImports");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithRedundantRepeatedImports");
    }
}