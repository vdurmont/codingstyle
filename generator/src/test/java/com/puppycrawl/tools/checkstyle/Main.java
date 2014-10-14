package com.puppycrawl.tools.checkstyle;

import com.google.common.collect.Lists;
import com.puppycrawl.tools.checkstyle.api.AuditListener;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

public final class Main {
    private Main() {
    }

    public static void launchAudit(InputStream configStream, String testFilename) throws FileNotFoundException {
        final Properties props = System.getProperties();
        final Configuration config = loadConfig(configStream, props);
        final AuditListener listener = createListener(System.out, false);
        File file = new File(testFilename);
        final List<File> files = Lists.newArrayList(file);
        final Checker c = createChecker(config, listener);
        final int numErrs = c.process(files);
        c.destroy();
        if (numErrs > 0)
            throw new RuntimeException();
    }

    private static Checker createChecker(Configuration aConfig,
                                         AuditListener aNosy) {
        Checker c = null;
        try {
            c = new Checker();

            final ClassLoader moduleClassLoader =
                    Checker.class.getClassLoader();
            c.setModuleClassLoader(moduleClassLoader);
            c.configure(aConfig);
            c.addListener(aNosy);
        } catch (final Exception e) {
            System.out.println("Unable to create Checker: "
                    + e.getMessage());
            e.printStackTrace(System.out);
            System.exit(1);
        }
        return c;
    }

    private static AuditListener createListener(OutputStream aOut,
                                                boolean aCloseOut) {
        return new DefaultLogger(aOut, aCloseOut);
    }

    private static Configuration loadConfig(InputStream stream,
                                            Properties aProps) {
        try {
            return ConfigurationLoader.loadConfiguration(stream, new PropertiesExpander(aProps), false);
        } catch (final CheckstyleException e) {
            System.out.println("Error loading configuration file");
            e.printStackTrace(System.out);
            System.exit(1);
            return null; // can never get here
        }
    }
}