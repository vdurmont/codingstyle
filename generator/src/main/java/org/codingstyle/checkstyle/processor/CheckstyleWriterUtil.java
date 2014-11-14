package org.codingstyle.checkstyle.processor;

import org.codingstyle.checkstyle.model.CheckModule;
import org.codingstyle.checkstyle.model.CheckModuleHolder;
import org.codingstyle.checkstyle.util.CheckModuleBuilder;

import static org.codingstyle.core.util.ValueReader.isTrue;

public class CheckstyleWriterUtil {
    public static void addModuleIfTrue(CheckModuleHolder holder, String name, Boolean condition) {
        if (isTrue(condition)) {
            CheckModule module = CheckModuleBuilder.withName(name)
                    .build();
            holder.addModule(module);
        }
    }
}
