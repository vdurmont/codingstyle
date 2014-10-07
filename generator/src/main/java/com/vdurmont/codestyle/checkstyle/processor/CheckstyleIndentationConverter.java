package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.CheckProperty;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.model.IndentCharacter;
import com.vdurmont.codestyle.core.model.Indentation;

public class CheckstyleIndentationConverter {
    public static void buildCheckstyle(Checkstyle checkstyle, Indentation indentation) {
        if (indentation.getIndentCharacter() == IndentCharacter.TAB) {
            CheckModule module = new CheckModule();
            module.setName("RegexpSinglelineJava");
            module.addProperties(
                    new CheckProperty("format", "^\\t* +\\t*\\S"),
                    new CheckProperty("message", "Line has leading space characters."),
                    new CheckProperty("ignoreComments", "true")
            );
            checkstyle.addModule(module);
        } else {
            checkstyle.addModule(new CheckModule("FileTabCharacter"));
        }
    }
}
