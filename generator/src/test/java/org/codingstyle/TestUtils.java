package org.codingstyle;

import org.codingstyle.core.model.Annotations;
import org.codingstyle.core.model.Braces;
import org.codingstyle.core.model.Style;
import org.codingstyle.core.model.Documentation;
import org.codingstyle.core.model.Imports;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.core.model.Page;
import org.codingstyle.core.model.Spaces;

public class TestUtils {
    // TODO maybe the writers should handle null properties
    public static Style generateStyle() {
        Style style = new Style();
        style.setProjectName("My project");
        style.setIndentation(new Indentation());
        style.setAnnotations(new Annotations());
        style.setBraces(new Braces());
        style.setDocumentation(new Documentation());
        style.setPage(new Page());
        style.setImports(new Imports());
        style.setSpaces(new Spaces());
        return style;
    }
}