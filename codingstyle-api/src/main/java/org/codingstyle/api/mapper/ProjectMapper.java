package org.codingstyle.api.mapper;

import org.codingstyle.api.dto.ProjectDTO;
import org.codingstyle.core.model.Project;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProjectMapper {
    @Inject private IndentationMapper indentationMapper;

    public ProjectDTO generate(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getExternId());
        dto.setName(project.getName());

        if (project.getIndentation() != null) {
            dto.setIndentation(this.indentationMapper.generate(project.getIndentation()));
        }

        return dto;
    }
}
