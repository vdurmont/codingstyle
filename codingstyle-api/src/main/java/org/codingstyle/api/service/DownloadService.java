package org.codingstyle.api.service;

import org.codingstyle.core.Module;
import org.codingstyle.core.StyleManager;
import org.codingstyle.core.model.Project;
import org.codingstyle.module.intellij.IntelliJModule;
import org.codingstyle.module.intellij.model.CodeScheme;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.OutputStream;

@Service
public class DownloadService extends StyleManager {
    @PostConstruct
    public void setUp() {
        this.registerModule(new IntelliJModule());
    }

    public void writeIntelliJConfigForProject(Project project, OutputStream outputStream) {
        Module<CodeScheme> module = this.getModule(CodeScheme.class);
        CodeScheme codeScheme = module.getWriter().write(project);
        module.getConfigProcessor().writeToStream(codeScheme, outputStream);
    }
}
