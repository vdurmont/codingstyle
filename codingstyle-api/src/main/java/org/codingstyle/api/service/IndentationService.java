package org.codingstyle.api.service;

import org.codingstyle.api.repository.IndentationRepository;
import org.codingstyle.core.model.IndentCharacter;
import org.codingstyle.core.model.Indentation;
import org.codingstyle.core.model.Project;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class IndentationService {
    @Inject private IndentationRepository indentationRepository;
    @Inject private ProjectService projectService;

    public Indentation updateByProjectExternId(String externId,
                                               IndentCharacter indentCharacter,
                                               Integer tabSize,
                                               Integer indentSize,
                                               Integer continuationIndentSize) {
        Project project = this.projectService.getByExternId(externId);
        Indentation indentation = project.getIndentation();
        if (indentation == null) {
            indentation = new Indentation();
            indentation.setProject(project);
        }
        indentation.setIndentCharacter(indentCharacter);
        indentation.setTabSize(tabSize);
        indentation.setIndentSize(indentSize);
        indentation.setContinuationIndentSize(continuationIndentSize);
        return this.indentationRepository.save(indentation);
    }
}
