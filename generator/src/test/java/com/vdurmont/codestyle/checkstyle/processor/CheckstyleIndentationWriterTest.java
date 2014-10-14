package com.vdurmont.codestyle.checkstyle.processor;

import com.puppycrawl.tools.checkstyle.Main;
import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.CheckProperty;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CheckstyleIndentationWriterTest {
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
        indentation.setIndentCharacter(IndentCharacter.TAB);

        // WHEN
        CheckstyleIndentationWriter.buildCheckstyle(this.checkstyle, indentation);

        CheckstyleConfigProcessor processor = new CheckstyleConfigProcessor();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        processor.writeToStream(checkstyle, os);

        InputStream stream = new ByteArrayInputStream(os.toByteArray());
        Main.launchAudit(stream, "/tmp/File1.java");
    }
}