package com.vdurmont;

import com.vdurmont.codestyle.core.model.Annotations;
import com.vdurmont.codestyle.core.model.Braces;
import com.vdurmont.codestyle.core.model.CodeStyle;
import com.vdurmont.codestyle.core.model.Documentation;
import com.vdurmont.codestyle.core.model.Imports;
import com.vdurmont.codestyle.core.model.Indentation;
import com.vdurmont.codestyle.core.model.Page;
import com.vdurmont.codestyle.core.model.Spaces;

public class TestUtils {
    // TODO maybe the writers should handle null properties
    public static CodeStyle generateCodeStyle() {
        CodeStyle codeStyle = new CodeStyle();
        codeStyle.setProjectName("My project");
        codeStyle.setIndentation(new Indentation());
        codeStyle.setAnnotations(new Annotations());
        codeStyle.setBraces(new Braces());
        codeStyle.setDocumentation(new Documentation());
        codeStyle.setPage(new Page());
        codeStyle.setImports(new Imports());
        codeStyle.setSpaces(new Spaces());
        return codeStyle;
    }
}