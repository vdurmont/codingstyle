package com.vdurmont.codestyle;

import com.vdurmont.codestyle.checkstyle.CheckstyleModule;
import com.vdurmont.codestyle.checkstyle.model.Checkstyle;
import com.vdurmont.codestyle.core.StyleManager;
import com.vdurmont.codestyle.intellij.IntelliJModule;
import com.vdurmont.codestyle.intellij.model.CodeScheme;
import org.apache.log4j.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        LOGGER.info("Starting app.");
        String intelliJConfig = args[0];
        String checkstyleConfig = args[1];
        LOGGER.info("\tInput: " + intelliJConfig);
        LOGGER.info("\tOutput: " + checkstyleConfig);

        StyleManager manager = new StyleManager();
        manager.registerModule(new IntelliJModule());
        manager.registerModule(new CheckstyleModule());

        manager.writeToFile(CodeScheme.class, intelliJConfig, Checkstyle.class, checkstyleConfig);
    }
}
