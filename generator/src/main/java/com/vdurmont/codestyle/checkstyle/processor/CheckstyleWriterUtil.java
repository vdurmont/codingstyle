package com.vdurmont.codestyle.checkstyle.processor;

import com.vdurmont.codestyle.checkstyle.model.CheckModule;
import com.vdurmont.codestyle.checkstyle.model.CheckModuleHolder;
import com.vdurmont.codestyle.checkstyle.util.CheckModuleBuilder;

import static com.vdurmont.codestyle.core.util.ValueReader.isTrue;

public class CheckstyleWriterUtil {
    public static void addModuleIfTrue(CheckModuleHolder holder, String name, Boolean condition) {
        if (isTrue(condition)) {
            CheckModule module = CheckModuleBuilder.withName(name)
                    .build();
            holder.addModule(module);
        }
    }
}
