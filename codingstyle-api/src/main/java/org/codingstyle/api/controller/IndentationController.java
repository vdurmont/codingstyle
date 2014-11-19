package org.codingstyle.api.controller;

import org.apache.log4j.Logger;
import org.codingstyle.api.dto.IndentationDTO;
import org.codingstyle.api.mapper.IndentationMapper;
import org.codingstyle.api.service.IndentationService;
import org.codingstyle.api.service.ProjectService;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.core.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@RequestMapping("projects/{externId}/indentation")
public class IndentationController {
    private static final Logger LOGGER = Logger.getLogger(IndentationController.class);

    @Inject private IndentationMapper indentationMapper;
    @Inject private IndentationService indentationService;
    @Inject private ProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public IndentationDTO create(@PathVariable String externId, @RequestBody IndentationDTO dto) {
        LOGGER.trace("Updating indentation of Project with externId '" + externId + "'");
        Indentation indentation = this.indentationService.updateByProjectExternId(
                externId,
                dto.getIndentCharacter(),
                dto.getTabSize(),
                dto.getIndentSize(),
                dto.getContinuationIndentSize()
        );
        return this.indentationMapper.generate(indentation);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public IndentationDTO get(@PathVariable String externId) {
        LOGGER.trace("Getting the indentation of Project with externId '" + externId + "'");
        Project project = this.projectService.getByExternId(externId);
        return this.indentationMapper.generate(project.getIndentation());
    }
}
