package org.codingstyle.core;

import org.apache.log4j.Logger;
import org.codingstyle.core.exception.CodingStyleException;
import org.codingstyle.core.model.Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class StyleManager {
    private static final Logger LOGGER = Logger.getLogger(StyleManager.class);
    private final Map<Class<?>, Module<?>> modules;

    public StyleManager() {
        this.modules = new HashMap<>();
    }

    public <T> void registerModule(Module<T> module) {
        LOGGER.trace("Registering module for target class=" + module.getTargetClass());
        this.modules.put(module.getTargetClass(), module);
    }

    public <T, K> void writeToFile(Class<T> inputClass, String inputFilePath, Class<K> outputClass, String outputFilePath) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        this.writeToFile(inputClass, inputFile, outputClass, outputFile);
    }

    public <T, K> void writeToFile(Class<T> inputClass, File inputFile, Class<K> outputClass, File outputFile) {
        try {
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
            this.writeToStream(inputClass, inputStream, outputClass, outputStream);
        } catch (FileNotFoundException e) {
            throw new CodingStyleException(e);
        }
    }

    public <T, K> void writeToStream(Class<T> inputClass, InputStream inputStream, Class<K> outputClass, OutputStream outputStream) {
        Module<T> inputModule = this.getModule(inputClass);
        Module<K> outputModule = this.getModule(outputClass);
        T input = inputModule.getConfigProcessor().readFromStream(inputStream);
        Project project = inputModule.getReader().read(input);
        K output = outputModule.getWriter().write(project);
        outputModule.getConfigProcessor().writeToStream(output, outputStream);
    }

    @SuppressWarnings("unchecked")
    private <T> Module<T> getModule(Class<T> targetClass) {
        Module<T> module = (Module<T>) this.modules.get(targetClass);
        if (module == null) {
            throw new CodingStyleException("Unable to find module for class: " + targetClass);
        }
        return module;
    }
}
