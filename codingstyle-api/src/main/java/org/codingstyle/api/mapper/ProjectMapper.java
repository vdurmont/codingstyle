package org.codingstyle.api.mapper;

import org.codingstyle.api.dto.ProjectDTO;
import org.codingstyle.core.model.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {
    public ProjectDTO generate(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getExternId());
        dto.setName(project.getName());
        return dto;
    }
}
