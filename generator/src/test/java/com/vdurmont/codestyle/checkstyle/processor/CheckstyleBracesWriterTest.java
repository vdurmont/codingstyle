package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.Braces;
import com.vdurmont.codestyle.core.model.BracesPlacement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CheckstyleBracesWriterTest {
    private Checkstyle checkstyle;

    @Before
    public void setUp() {
        this.checkstyle = new Checkstyle();
    }

    @Test
    public void buildCheckstyle_with_classBraces_adds_a_leftCurly_module() {
        // GIVEN
        Braces braces = new Braces();
        braces.setClassBraces(BracesPlacement.END_OF_LINE);

        // WHEN
        CheckstyleBracesWriter.buildCheckstyle(this.checkstyle, braces);

        // THEN
        List<CheckModule> modules = this.checkstyle.getModules("LeftCurly");
        assertEquals(1, modules.size());
    }
}