package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.TestUtils;
import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Braces;
import com.vdurmont.codestyle.core.model.BracesPlacement;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.Imports;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNoCheckstyleErrors;
import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNumCheckstyleErrors;
import static org.junit.Assert.assertEquals;

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
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutStarImports.java");
        assertNumCheckstyleErrors(1, this.codeStyle, "FileWithStarImports.java");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_false() {
        // GIVEN
        Imports imports = new Imports();
        imports.setAvoidStarImport(false);
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutStarImports.java");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithStarImports.java");
    }

    @Test
    public void buildCheckstyle_with_AvoidStarImports_undefined() {
        // GIVEN
        Imports imports = new Imports();
        this.codeStyle.setImports(imports);

        // THEN
        assertNoCheckstyleErrors(this.codeStyle, "FileWithoutStarImports.java");
        assertNoCheckstyleErrors(this.codeStyle, "FileWithStarImports.java");
    }
}