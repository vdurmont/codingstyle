package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.CheckProperty;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CheckstyleIndentationConverterTest {
    private Checkstyle checkstyle;

    @Before
    public void setUp() {
        this.checkstyle = new Checkstyle();
    }

    @Test
    public void buildCheckstyle_with_SPACE_adds_the_FileTabCharacter_module() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.SPACE);

        // WHEN
        CheckstyleIndentationConverter.buildCheckstyle(this.checkstyle, indentation);

        // THEN
        CheckModule module = this.checkstyle.getModule("FileTabCharacter");
        assertNotNull(module);
    }

    @Test
    public void buildCheckstyle_with_TAB_adds_a_RegexpSinglelineJava_module() {
        // GIVEN
        Indentation indentation = new Indentation();
        indentation.setIndentCharacter(IndentCharacter.TAB);

        // WHEN
        CheckstyleIndentationConverter.buildCheckstyle(this.checkstyle, indentation);

        // THEN
        CheckModule module = this.checkstyle.getModule("RegexpSinglelineJava");
        assertNotNull(module);
        CheckProperty format = module.getProperty("format");
        assertEquals("^\\t* +\\t*\\S", format.getValue());
    }
}