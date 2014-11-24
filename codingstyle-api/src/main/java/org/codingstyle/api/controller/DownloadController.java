package org.codingstyle.api.controller;

import org.apache.log4j.Logger;
import org.codingstyle.api.exception.IllegalInputException;
import org.codingstyle.api.service.DownloadService;
import org.codingstyle.api.service.ProjectService;
import org.codingstyle.core.model.Project;
import org.codingstyle.module.checkstyle.model.Checkstyle;
import org.codingstyle.module.intellij.model.CodeScheme;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("projects/{externId}/downloads")
public class DownloadController {
    private static final Logger LOGGER = Logger.getLogger(DownloadController.class);

    private static final String XML_CONTENT_TYPE = "application/xml";
    private static final String UTF8 = "UTF-8";

    @Inject private DownloadService downloadService;
    @Inject private ProjectService projectService;

    @RequestMapping(value = "{moduleName}", method = RequestMethod.GET)
    public void create(@PathVariable String externId, @PathVariable String moduleName, HttpServletResponse response) throws IOException {
        String cleanedModuleName = moduleName.toLowerCase().trim();
        LOGGER.trace("Downloading the config for project with externId='" + externId + "' and type=" + cleanedModuleName);
        Project project = this.projectService.getByExternId(externId);
        response.setCharacterEncoding(UTF8);
        response.setContentType(XML_CONTENT_TYPE);
        String fileName = getFileName(cleanedModuleName, project.getName(), "xml");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        switch (cleanedModuleName) {
            case "intellij":
                this.downloadService.writeConfigForProject(CodeScheme.class, project, response.getOutputStream());
                break;
            case "checkstyle":
                this.downloadService.writeConfigForProject(Checkstyle.class, project, response.getOutputStream());
                break;
            default:
                throw new IllegalInputException("Unknown module name: " + moduleName);
        }
    }

    private static String getFileName(String moduleName, String projectName, String extension) {
        String cleanedName = projectName.replaceAll("[^0-9a-zA-Z_-]", "_");
        return cleanedName + "-" + moduleName + "." + extension;
    }
}
