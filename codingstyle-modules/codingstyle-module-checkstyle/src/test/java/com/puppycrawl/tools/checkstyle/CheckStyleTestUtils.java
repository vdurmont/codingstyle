package com.puppycrawl.tools.checkstyle;

import com.google.common.collect.Lists;
import com.puppycrawl.tools.checkstyle.api.AuditListener;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public final class CheckStyleTestUtils {
    private CheckStyleTestUtils() {
    }

    public static int getNumErrors(InputStream configFileStream, String testFilePath) {
        Checker checker = null;
        try {
            final Properties props = System.getProperties();
            final Configuration config = loadConfig(configFileStream, props);
            final AuditListener listener = new DefaultLogger(System.out, false);
            checker = createChecker(config, listener);
            final File testFile = new File(testFilePath);
            return checker.process(Lists.newArrayList(testFile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (checker != null) {
                checker.destroy();
            }
        }
    }

    private static Checker createChecker(Configuration aConfig, AuditListener aNosy) throws CheckstyleException {
        Checker checker = new Checker();
        final ClassLoader moduleClassLoader = Checker.class.getClassLoader();
        checker.setModuleClassLoader(moduleClassLoader);
        checker.configure(aConfig);
        checker.addListener(aNosy);
        return checker;
    }

    private static Configuration loadConfig(InputStream configFileStream, Properties properties) throws CheckstyleException {
        PropertiesExpander expander = new PropertiesExpander(properties);
        return ConfigurationLoader.loadConfiguration(configFileStream, expander, false);
    }
}