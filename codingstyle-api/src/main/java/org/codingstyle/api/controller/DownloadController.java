package org.codingstyle.api.controller;

import org.apache.log4j.Logger;
import org.codingstyle.api.service.DownloadService;
import org.codingstyle.api.service.ProjectService;
import org.codingstyle.core.model.Project;
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

    @RequestMapping(value = "intellij", method = RequestMethod.GET)
    public void create(@PathVariable String externId, HttpServletResponse response) throws IOException {
        LOGGER.trace("Downloading the IntelliJ config for project with externId='" + externId + "'");
        Project project = this.projectService.getByExternId(externId);
        response.setCharacterEncoding(UTF8);
        response.setContentType(XML_CONTENT_TYPE);
        String fileName = getFileName("intellij", project.getName(), "xml");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        this.downloadService.writeIntelliJConfigForProject(project, response.getOutputStream());
    }

    private static String getFileName(String moduleName, String projectName, String extension) {
        String cleanedName = projectName.replaceAll("[^0-9a-zA-Z_-]", "_");
        return cleanedName + "-" + moduleName + "." + extension;
    }
}
