package org.codingstyle.api.service;

import org.codingstyle.api.exception.CodingStyleAPIException;
import org.codingstyle.api.exception.ResourceNotFoundException;
import org.codingstyle.api.repository.ProjectRepository;
import org.codingstyle.core.model.Project;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

import static org.codingstyle.api.util.Preconditions.checkMaxLength;
import static org.codingstyle.api.util.Preconditions.checkNotEmpty;
import static org.codingstyle.api.util.Preconditions.checkNotNull;

@Service
public class ProjectService {
    @Inject private ProjectRepository projectRepository;

    public Project create(String name) {
        checkNotNull("Missing project name", name);
        checkNotEmpty("Invalid project name: must not be empty", name);
        checkMaxLength("Invalid project name: must be shorter than 128 characters", 128, name);

        Project project = new Project();
        project.setExternId(this.generateExternId());
        project.setName(name);
        return this.projectRepository.save(project);
    }

    private String generateExternId() {
        String externId;
        Project project;
        int retries = 0;
        do {
            externId = UUID.randomUUID().toString().replace("-", "");
            project = this.projectRepository.findByExternId(externId);
            retries++;
        } while (externId == null && (project != null || retries < 3));
        if (project != null) {
            throw new CodingStyleAPIException("Unable to generate a unique id for the project.");
        }
        return externId;
    }

    public Project getByExternId(String externId) {
        checkNotNull("Invalid identifier", externId);
        Project project = this.projectRepository.findByExternId(externId);
        if (project == null) {
            throw new ResourceNotFoundException("The project with id '" + externId + "' cannot be found.");
        }
        return project;
    }
}
