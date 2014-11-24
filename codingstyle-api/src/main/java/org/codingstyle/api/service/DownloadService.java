package org.codingstyle.api.service;

import org.codingstyle.core.Module;
import org.codingstyle.core.StyleManager;
import org.codingstyle.core.model.Project;
import org.codingstyle.module.checkstyle.CheckstyleModule;
import org.codingstyle.module.intellij.IntelliJModule;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.OutputStream;

@Service
public class DownloadService extends StyleManager {
    @PostConstruct
    public void setUp() {
        this.registerModule(new IntelliJModule());
        this.registerModule(new CheckstyleModule());
    }

    public <T> void writeConfigForProject(Class<T> cls, Project project, OutputStream outputStream) {
        Module<T> module = this.getModule(cls);
        T config = module.getWriter().write(project);
        module.getConfigProcessor().writeToStream(config, outputStream);
    }
}
