package org.codingstyle.api.controller;

import org.apache.log4j.Logger;
import org.codingstyle.api.dto.ProjectDTO;
import org.codingstyle.api.mapper.ProjectMapper;
import org.codingstyle.api.service.ProjectService;
import org.codingstyle.core.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@RequestMapping("projects")
public class ProjectController {
    private static final Logger LOGGER = Logger.getLogger(ProjectController.class);

    @Inject private ProjectMapper projectMapper;
    @Inject private ProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ProjectDTO create(@RequestBody ProjectDTO dto) {
        LOGGER.trace("Creating project");
        Project project = this.projectService.create(dto.getName());
        return this.projectMapper.generate(project);
    }

    @RequestMapping(value = "{externId}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectDTO get(@PathVariable String externId) {
        LOGGER.trace("Getting project with externId='" + externId + "'");
        Project project = this.projectService.getByExternId(externId);
        return this.projectMapper.generate(project);
    }
}
