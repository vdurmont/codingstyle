package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.TestUtils;
import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.CheckProperty;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.util.List;

import static com.vdurmont.codestyle.checkstyle.CheckStyleTestUtils.assertNoCheckstyleError;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CheckstyleIndentationWriterTest {
    private Checkstyle checkstyle;
    private CodeStyle codeStyle;

    @Before
    public void setUp() {
        this.checkstyle = new Checkstyle();
        this.codeStyle = TestUtils.generateCodeStyle();
    }

    @Test
    public void buildCheckstyle_with_SPACE_adds_the_FileTabCharacter_module() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);

        // WHEN
        CheckstyleIndentationWriter.buildCheckstyle(this.checkstyle, indentation);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules("FileTabCharacter");
        assertEquals(1, modules.size());
    }

    @Test
    public void buildCheckstyle_with_TAB_adds_a_RegexpSinglelineJava_module() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.TAB);

        // WHEN
        CheckstyleIndentationWriter.buildCheckstyle(this.checkstyle, indentation);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules("RegexpSinglelineJava");
        assertEquals(1, modules.size());
        CheckProperty format = modules.get(0).getProperty("format");
        assertEquals("^\\t* +\\t*\\S", format.getValue());
    }

    @Test
    public void experimentation() throws FileNotFoundException {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);
        this.codeStyle.setIndentation(indentation);

        // WHEN
        assertNoCheckstyleError(this.codeStyle, "File1.java");
    }
}