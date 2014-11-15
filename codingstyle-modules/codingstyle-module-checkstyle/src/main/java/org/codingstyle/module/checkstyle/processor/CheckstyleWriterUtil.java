package org.codingstyle.module.checkstyle.processor;


import org.codingstyle.module.checkstyle.model.CheckModule;
import org.codingstyle.module.checkstyle.model.CheckModuleHolder;
import org.codingstyle.module.checkstyle.util.CheckModuleBuilder;

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
